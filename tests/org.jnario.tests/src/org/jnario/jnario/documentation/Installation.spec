package org.jnario.jnario.documentation

/*
 * Jnario is fully integrated into Eclipse. There are editors with syntax highlighting, 
 * code completion, validation and debugger for each of Jnario's languages together with 
 * an incremental compiler. However, Jnario is **not** restricted to Eclipse. Specs can 
 *  be compiled and executed standalone, for example, using Maven.
 */
describe "Installing Jnario"{

	/*
	 * Jnario requires Eclipse 3.5 or higher and a Java SDK 5 or higher. You can install Jnario runtime and tooling
	 * via the [Eclipse Marketplact](http://marketplace.eclipse.org/content/jnario)
	 * or via the following update sites: 
	 * 
	 * <p align="center"><code>http://www.jnario.org/updates/releases/</code></p>
	 * 
	 * The most recent snapshot builds can be installed via:
	 * 
	 * <p align="center"><code>http://www.jnario.org/updates/snapshot/</code></p>
	 * 
	 *  If you do not yet have an Eclipse on your machine, you can download one of the pre-packaged 
	 * [Xtend distributions](http://www.eclipse.org/xtend/download.html). 
	 */
	describe "Installing the Eclipse Tooling"{
		
	}
	
	describe "Using Jnario with Maven"{
		
		/*
		 * The runtime library as well as a plug-in to run the compiler in a 
		 * Maven build can be be obtained from the following Maven repository: 
		 * http://build.eclipse.org/common/xtend/maven/.
		 * 
		 *     <repositories>
		 *       <repository>
		 *         <id>xtend</id>
		 *           <url>http://build.eclipse.org/common/xtend/maven/</url>
		 *      	</repository>
		 *     </repositories>
		 *     <pluginRepositories>
		 *       <pluginRepository>
		 *         <id>xtend</id>
		 *         <url>http://build.eclipse.org/common/xtend/maven/</url>
		 *       </pluginRepository>
		 *     </pluginRepositories>
		 * 
		 * @filter(.*)
		 */
		fact "Jnario Dependencies"{
			"not yet implemented"
		}
		
		/*
		 * The XML for the dependency is:
		 * 
		 *     <dependency>
		 *       <groupId>org.jnario</groupId>
		 *       <artifactId>org.jnario.lib</artifactId>
		 *       <version>0.1.0</version>
		 *     </dependency>
		 * 
		 *  @filter(.*)
		 */
		fact "Jnario Runtime"{
			"not yet implemented"
		}
		
		/* You should also configure Surefire to execute specs and features:
		 * 
		 *	      <plugin>
		 *	        <groupId>org.apache.maven.plugins</groupId>
		 *	        <artifactId>maven-surefire-plugin</artifactId>
		 *	        <version>2.12</version>
		 *	        <configuration>
		 *	          <includes>
		 *	            <include>**\/*Spec*.java</include>
		 *	            <include>**\/*Feature.java</include>
		 *	            <include>**\/*Test.java</include>
		 *	            <include>**\/*TestCase.java</include>
		 *	          </includes>
		 *	        </configuration>
		 *	      </plugin>
		 *	    </plugins>
		 * 
		 *  @filter(.*)
		 */
		fact "Executing specs"{
			"not yet implemented"
		}
		
		/*
		 * You can use the Jnario plugin to compile specs from Maven:
		 *
		 *		<plugins>
		 *	      <plugin>
		 *         <groupId>org.jnario</groupId>
		 *	        <artifactId>jnario-maven-plugin</artifactId>
		 *	        <version>0.1.0</version>
		 *	        <executions>
		 *	          <execution>
		 *	            <goals>
		 *	              <goal>testCompile</goal>
		 *	            </goals>
		 *              <!-- optionally you can configure a different target folder -->
         *              <!--
         *              <configuration>
         *                <outputDirectory>xtend-gen</outputDirectory>
         *              </configuration>
         *              -->
		 *	          </execution>
		 *	        </executions>
		 *	      </plugin>
		 * 
		 * @filter(.*)
		 * 
		 */
		fact "Jnario Compiler"{
			"not yet implemented"
		}
		
		/*
		 * The outputDirectory can be specified to match the default of 
		 * the Eclipse plug-in (xtend-gen). You can also change the 
		 * configuration in Eclipse to match the Maven default (generated-sources). 
		 * To do so right-click on the project and select Properties or if you prefer 
		 * a global setting choose **Eclipse->Preferences**. In the category **Jnario/Compiler** enter
		 *  the directory name (see screenshot). It is interpreted as a relative 
		 * path to the parent of the source folder, which includes the to-be-compiled Xtend file.
		 * 
		 * <p align="center"><img width="500px" src="/img/tutorial/project_compiler_settings.png" alt="Configuring project specific compiler settings."/></p>
		 * 
		 * @filter(.*)
		 */
		fact "Configuring Eclipse"{
			"not yet implemented"
		}
		
	}

}