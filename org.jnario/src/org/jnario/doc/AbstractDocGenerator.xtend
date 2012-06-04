/*******************************************************************************
 * Copyright (c) 2012 BMW Car IT and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.jnario.doc

import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.XExpression
import org.pegdown.PegDownProcessor

import static extension org.eclipse.xtext.util.Strings.*
import org.eclipse.xtext.EcoreUtil2
import org.jnario.ExampleTable

class AbstractDocGenerator implements IGenerator {
	
	@Inject extension WhiteSpaceNormalizer
	@Inject extension PegDownProcessor
	@Inject extension HtmlFileBuilder

	override doGenerate(Resource input, IFileSystemAccess fsa) {
		for(file : input.contents.filter(typeof(XtendFile))){
			file.xtendClasses.forEach[
				val htmlFile = it.createHtmlFile()
				it.generate(fsa, htmlFile)
			]
		}
	}
	
	def HtmlFile createHtmlFile(XtendClass xtendClass){
		throw new UnsupportedOperationException
	}

	def convertToTitle(String string){
		string.convertToText.toFirstUpper
	}
	
	def convertToText(String string){
		try{
			string.convertFromJavaString(true)
		}catch(java.lang.IllegalArgumentException e){
			e.printStackTrace
			string
		}
	}
	
	def markdown2Html(String string){
		if(string == null){
			return ""
		}
		string.normalize.markdownToHtml
				.replaceAll("<pre><code>", '<pre class="prettyprint">')
				.replaceAll("</pre></code>", '</pre>')
	}
	
	def dispatch toXtendCode(XExpression expr, List<Filter> filters){
		return expr.serialize.normalize.toHtml.trim
	}
	
	def dispatch toXtendCode(XBlockExpression expr, List<Filter> filters){
		var code = expr.serialize.trim
		code = filters.apply(code)
		if(code.length == 0){
			return ""
		}
		code = code.substring(1, code.length-1) 
		return code.normalize.toHtml
	}
	
	def codeToHtml(String code){
		code.normalize.toHtml
	}
	
	def toHtml(String input){
		input.replaceAll("<", "&lt;").replaceAll(">", "&gt;")
	}
	
	def serialize(EObject obj){
		val node = NodeModelUtils::getNode(obj)
		if(node == null) return ""
		return node.text
	}
	
	def id(String id){
		return ' id="' + id?.replaceAll("\\W", "_") + '"'
	}
	
	def apply(List<Filter> filters, String input){
		var result = input
		for(filter : filters){
			result = filter.apply(result)
		}
		return result
	}
	
	
	def root(XtendClass xtendClass){
		val specFile = EcoreUtil2::getContainerOfType(xtendClass, typeof(XtendFile))
		val packageName= specFile.^package
		if(packageName == null){
			return ""
		}
		val fragments = packageName.split("\\.")
		val path = fragments.map(s | "../")
		return path.join("")
	}
	
	def generate(ExampleTable table)'''
		<table class="table table-striped table-bordered table-condensed">
			<thead>
				<tr>
				�FOR headingCell : table.columns�
					<th>�headingCell.name�</th>
				�ENDFOR�
				</tr>
			</thead>
			<tbody>
			�FOR row : table.rows�
			<tr>
				�FOR cell : row.cells�
				<td>�toXtendCode(cell, emptyList)�</td>
				�ENDFOR�
			</tr>
		  	�ENDFOR�
			</tbody>
		</table>
	'''

}