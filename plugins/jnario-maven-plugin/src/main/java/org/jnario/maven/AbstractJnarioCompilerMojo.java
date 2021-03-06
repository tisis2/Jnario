package org.jnario.maven;

import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Lists.newArrayList;
import static org.eclipse.xtext.util.Strings.concat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.maven.artifact.Artifact;
import org.apache.maven.execution.MavenSession;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.toolchain.Toolchain;
import org.apache.maven.toolchain.ToolchainManager;
import org.apache.maven.toolchain.java.DefaultJavaToolChain;
import org.codehaus.plexus.util.DirectoryScanner;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.jnario.compiler.AbstractBatchCompiler;
import org.jnario.compiler.JnarioStandaloneCompiler;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Michael Clay - Initial contribution and API
 */
public abstract class AbstractJnarioCompilerMojo extends AbstractJnarioMojo {
	protected static final Predicate<String> FILE_EXISTS = new Predicate<String>() {

		public boolean apply(String filePath) {
			return new File(filePath).exists();
		}
	};

	/**
	 * Create Java Source Code that is compatible to this Java version.
	 * 
	 * Supported values: 1.5, 1.6, 1.7, and 1.8
	 */
	@Parameter(property = "maven.compiler.source", defaultValue = "1.6")
	private String javaSourceVersion;

	@Component
	private ToolchainManager toolchainManager;

	/**
	 * The current build session instance. This is used for toolchain manager API calls.
	 */
	@Parameter(property = "session", required = true, readonly = true)
	private MavenSession session;

	/**
	 * Jnario-File encoding argument for the compiler.
	 * 
	 */
	@Parameter(property = "encoding", defaultValue = "${project.build.sourceEncoding}")
	private String encoding;

	/**
	 * Set this to false to suppress the creation of *._trace files.
	 */
	@Parameter(property = "writeTraceFiles", defaultValue = "true")
	private boolean writeTraceFiles;

	/**
	 * Location of the Jnario settings file.
	 */
	@Parameter(defaultValue = "${basedir}/.settings/org.jnario.Jnario.prefs", readonly = true)
	private String propertiesFileLocation;

	/**
	 * Whether <code>@SuppressWarnings</code> shall be generated for non-nested types.
	 */
	@Parameter(defaultValue = "true")
	private boolean generateSyntheticSuppressWarnings;

	/**
	 * Whether <code>@Generated</code> shall be generated for non-nested types.
	 */
	@Parameter(defaultValue = "false")
	private boolean generateGeneratedAnnotation;

	/**
	 * Whether the current time shall be added to <code>@Generated</code> annotations.
	 */
	@Parameter(defaultValue = "false")
	private boolean includeDateInGeneratedAnnotation;

	/**
	 * The comment that is added to <code>@Generated</code> annotations, also supports variables:
	 * <ul>
	 * <li><code>${sourcefile}</code></li>
	 * </ul>
	 */
	@Parameter
	private String generatedAnnotationComment;

	@Inject
	private Provider<JnarioStandaloneCompiler> jnarioStandaloneCompiler;
	
	protected AbstractBatchCompiler getBatchCompiler() {
		JnarioStandaloneCompiler compiler = jnarioStandaloneCompiler.get();
		compiler.initWithInjectors(getInjectors());
		return compiler;
	}
	
	protected void compile(AbstractBatchCompiler compiler, String classPath, List<String> sourcePaths, String outputPath) throws MojoExecutionException {
		Log log = getLog();
		compiler.setResourceSetProvider(getResourceSet());
		Iterable<String> filtered = filter(sourcePaths, FILE_EXISTS);
		if (Iterables.isEmpty(filtered)) {
			String dir = Iterables.toString(sourcePaths);
			log.info("skip compiling sources because the configured directory '" + dir + "' does not exists.");
			return;
		}
		String baseDir = project.getBasedir().getAbsolutePath();
		log.debug("Set Java Compliance Level: " + javaSourceVersion);
		compiler.setJavaSourceVersion(javaSourceVersion);
		log.debug("Set generateSyntheticSuppressWarnings: " + generateSyntheticSuppressWarnings);
		compiler.setGenerateSyntheticSuppressWarnings(generateSyntheticSuppressWarnings);
		log.debug("Set generateGeneratedAnnotation: " + generateGeneratedAnnotation);
		compiler.setGenerateGeneratedAnnotation(generateGeneratedAnnotation);
		log.debug("Set includeDateInGeneratedAnnotation: " + includeDateInGeneratedAnnotation);
		compiler.setIncludeDateInGeneratedAnnotation(includeDateInGeneratedAnnotation);
		log.debug("Set generatedAnnotationComment: " + generatedAnnotationComment);
		compiler.setGeneratedAnnotationComment(generatedAnnotationComment);
		log.debug("Set baseDir: " + baseDir);
		compiler.setBasePath(baseDir);
		log.debug("Set temp directory: " + getTempDirectory());
		compiler.setTempDirectory(getTempDirectory());
		log.debug("Set DeleteTempDirectory: " + false);
		compiler.setDeleteTempDirectory(false);
		log.debug("Set classpath: " + classPath);
		compiler.setClassPath(classPath);
		String bootClassPath = getBootClassPath();
		log.debug("Set bootClasspath: " + bootClassPath);
		compiler.setBootClassPath(bootClassPath);
		log.debug("Set source path: " + concat(File.pathSeparator, newArrayList(filtered)));
		compiler.setSourcePath(concat(File.pathSeparator, newArrayList(filtered)));
		log.debug("Set output path: " + outputPath);
		compiler.setOutputPath(outputPath);
		log.debug("Set encoding: " + encoding);
		compiler.setFileEncoding(encoding);
		log.debug("Set writeTraceFiles: " + writeTraceFiles);
		compiler.setWriteTraceFiles(writeTraceFiles);
		if (!compiler.compile()) {
			String dir = concat(File.pathSeparator, newArrayList(filtered));
			throw new MojoExecutionException("Error compiling Jnario sources in '" + dir + "'.");
		}
	}

	protected Provider<ResourceSet> getResourceSet() {
		return new MavenProjectResourceSetProvider(project);
	}

	private String getBootClassPath() {
		Toolchain toolchain = toolchainManager.getToolchainFromBuildContext("jdk", session);
		if (toolchain instanceof DefaultJavaToolChain) {
			DefaultJavaToolChain javaToolChain = (DefaultJavaToolChain) toolchain;
			getLog().info("Using toolchain " + javaToolChain);

			String[] includes = { "jre/lib/*", "jre/lib/ext/*", "jre/lib/endorsed/*" };
			String[] excludes = new String[0];
			Xpp3Dom config = (Xpp3Dom) javaToolChain.getModel().getConfiguration();
			if (config != null) {
				Xpp3Dom bootClassPath = config.getChild("bootClassPath");
				if (bootClassPath != null) {
					Xpp3Dom includeParent = bootClassPath.getChild("includes");
					if (includeParent != null) {
						includes = getValues(includeParent.getChildren("include"));
					}
					Xpp3Dom excludeParent = bootClassPath.getChild("excludes");
					if (excludeParent != null) {
						excludes = getValues(excludeParent.getChildren("exclude"));
					}
				}
			}

			return scanBootclasspath(javaToolChain.getJavaHome(), includes, excludes);
		}
		return "";
	}

	private String scanBootclasspath(String javaHome, String[] includes, String[] excludes) {
		getLog().debug(
				"Scanning bootClassPath:\n" + "\tjavaHome = " + javaHome + "\n" + "\tincludes = "
						+ Arrays.toString(includes) + "\n" + "\texcludes = " + Arrays.toString(excludes));
		DirectoryScanner scanner = new DirectoryScanner();
		scanner.setBasedir(new File(javaHome));
		scanner.setIncludes(includes);
		scanner.setExcludes(excludes);
		scanner.scan();

		StringBuilder bootClassPath = new StringBuilder();
		String[] includedFiles = scanner.getIncludedFiles();
		for (int i = 0; i < includedFiles.length; i++) {
			if (i > 0) {
				bootClassPath.append(File.pathSeparator);
			}
			bootClassPath.append(new File(javaHome, includedFiles[i]).getAbsolutePath());
		}
		return bootClassPath.toString();
	}

	private String[] getValues(Xpp3Dom[] children) {
		String[] values = new String[children.length];
		for (int i = 0; i < values.length; i++) {
			values[i] = children[i].getValue();
		}
		return values;
	}

	protected abstract String getTempDirectory();

	protected void addDependencies(Set<String> classPath, List<Artifact> dependencies) {
		for (Artifact artifact : dependencies) {
			classPath.add(artifact.getFile().getAbsolutePath());
		}
	}

	protected void readJnarioEclipseSetting(String sourceDirectory, Procedure1<String> fieldSetter) {
		if (propertiesFileLocation != null) {
			File f = new File(propertiesFileLocation);
			if (f.canRead()) {
				Properties jnarioSettings = new Properties();
				try {
					jnarioSettings.load(new FileInputStream(f));
					// TODO read Jnario setup to compute the properties file loc and property name
					String jnarioOutputDirProp = jnarioSettings.getProperty("outlet.DEFAULT_OUTPUT.directory", null);
					if (jnarioOutputDirProp != null) {
						File srcDir = new File(sourceDirectory);
						getLog().debug("Source dir : " + srcDir.getPath() + " exists " + srcDir.exists());
						if (srcDir.exists() && srcDir.getParent() != null) {
							String path = new File(srcDir.getParent(), jnarioOutputDirProp).getPath();
							getLog().debug("Applying Jnario property: " + jnarioOutputDirProp);
							fieldSetter.apply(path);
						}
					}
				} catch (FileNotFoundException e) {
					getLog().warn(e);
				} catch (IOException e) {
					getLog().warn(e);
				}
			} else {
				getLog().info(
						"Can't find Jnario properties under " + propertiesFileLocation + ", maven defaults are used.");
			}
		}
	}

	protected String resolveToBaseDir(final String directory) throws MojoExecutionException {
		File outDir = new File(directory);
		if (!outDir.isAbsolute()) {
			outDir = new File(project.getBasedir(), directory);
		}
		return outDir.getAbsolutePath();
	}
}
