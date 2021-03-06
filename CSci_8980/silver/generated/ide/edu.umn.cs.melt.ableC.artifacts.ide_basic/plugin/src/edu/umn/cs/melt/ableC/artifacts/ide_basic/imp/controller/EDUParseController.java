/**
 * PKG_NAME
 * START_NONTERMINAL_CLASS
 * LANG_NAME
 */
package edu.umn.cs.melt.ableC.artifacts.ide_basic.imp.controller;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.imp.parser.ISourcePositionLocator;
import org.eclipse.imp.parser.ParseControllerBase;
import org.eclipse.imp.parser.SimpleAnnotationTypeInfo;
import org.eclipse.imp.services.IAnnotationTypeInfo;
import org.eclipse.imp.services.ILanguageSyntaxProperties;

import edu.umn.cs.melt.copper.runtime.logging.CopperParserException;
import edu.umn.cs.melt.ide.copper.AdaptiveEnhancedParseTreeInnerNode;
import edu.umn.cs.melt.ide.copper.EnhancedCopperParserException;
import edu.umn.cs.melt.ide.copper.IEnhancedParseTreeNode;
import edu.umn.cs.melt.ide.copper.IToken;
import edu.umn.cs.melt.ide.copper.SourcePositionLocator;

import edu.umn.cs.melt.ableC.artifacts.ide_basic.copper.engine.EnhancedSilverParser;
import edu.umn.cs.melt.ableC.artifacts.ide_basic.imp.EDUPlugin;
import edu.umn.cs.melt.ableC.artifacts.ide_basic.EDUInitializer;

/**
 * Extends ParseControllerBase to use the default implementation of several
 * interface methods. The following variables are inherited:<br>
 * 	 protected ISourceProject fProject;<br>
 * 	 protected IPath fFilePath;<br>
 * 	 protected IMessageHandler handler;<br>
 * 	 protected Object fCurrentAst;<br>
 */
public class EDUParseController extends ParseControllerBase {
	
	private static DateFormat DATE_FORMAT = new SimpleDateFormat();
	
	/** Construct an instance of the parser. */
	private EnhancedSilverParser parser = new EnhancedSilverParser();

	private final SimpleAnnotationTypeInfo fSimpleAnnotationTypeInfo
		= new SimpleAnnotationTypeInfo();

	private SourcePositionLocator<IEnhancedParseTreeNode, IToken> locator;
	
	static {
		EDUInitializer.initialize();
	}
	
	public EDUParseController() {
		super(EDUPlugin.kLanguageID);
		locator = new SourcePositionLocator<IEnhancedParseTreeNode, IToken>(this);
	}
	
	/**
	 * Return an instance of SimpleAnnotationTypeInfo
	 */
	@Override
	public IAnnotationTypeInfo getAnnotationTypeInfo() {
		return fSimpleAnnotationTypeInfo;
	}
	
	@Override
	public ISourcePositionLocator getSourcePositionLocator() {
		return locator;
	}

	@Override
	public ILanguageSyntaxProperties getSyntaxProperties() {
		return null;//TODO
	}
	
	@Override
	public Object parse(String input, IProgressMonitor monitor) {
		AdaptiveEnhancedParseTreeInnerNode<edu.umn.cs.melt.ableC.concretesyntax.NRoot> result = null;
		boolean parsed = false;
		handler.clearMessages();
		
		try {
			parser.reset();
			Reader reader = new StringReader(input);
			result = parser.parse(reader, getPath().toFile().getName());
		    parsed = (result==null)?false:true;
		} catch (EnhancedCopperParserException e) {
			//System.err.println("ERROR EnhancedCopperParserException");
			//System.err.println(e);
			handler.handleSimpleMessage(
				e.getMessage(), (int)e.getOffset(), (int)e.getOffset(), e.getColumn(), e.getColumn(), e.getLine(), e.getLine());
		} catch (CopperParserException e) {
			//System.err.println("ERROR CopperParserException");
			//e.printStackTrace();
			handler.handleSimpleMessage(//TODO: S-R error
				e.getMessage(), 0, 0, 0, 0, 1, 1);
		} catch (IOException e) {
			//System.err.println("ERROR IOException");
			e.printStackTrace();
		}
		
		String date = DATE_FORMAT.format(new Date()).toString();
		if(parsed){
			System.out.println(date + ": Parsed correctly.");
		} else {
			System.err.println(date + ": Parsing failed.");
		}
		
		fCurrentAst = result;
		return fCurrentAst;
	}

	//Delegate to auto-generated (enhanced) parser
	@Override
	public Iterator getTokenIterator(org.eclipse.jface.text.IRegion region) {
		return parser.getTokenIterator(region);
	}
	
}
