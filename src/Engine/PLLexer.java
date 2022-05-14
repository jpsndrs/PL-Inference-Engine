/**
 * 
 */
package Engine;

import java.io.Reader;
import java.io.StringReader;

/**
 * @author Nero64
 *
 */
public class PLLexer {
	
	private Reader fInputString;
	private int fPosition = -1;
	private int fStringLength;
	
	public PLLexer() {}

	public PLLexer(String aInputString) {
		this.fInputString = new StringReader(aInputString);
		this.fStringLength = aInputString.length();
	}
	
	public Token nextToken() {
		
		try {
			fPosition++;
			int lSymbol = fInputString.read();
			if((char)lSymbol == '(') {
				return  new Token(lSymbol, "(", fPosition);
			}else if((char)lSymbol == ')') {
				return new Token(lSymbol, ")", fPosition);
			} else if (Character.isWhitespace(lSymbol)) {
				return nextToken();
			}else if (connectiveDetected((char)lSymbol)) {
				return connective();
			} else if (symbolDetected((char)lSymbol)) {
				return symbol();
			} else if (lookAhead(1) == (char) -1) {
				return new Token(LogicTokenTypes.EOI, "EOI", startPosition);
			} else {
				throw new LexerException("Lexing error on character " + lookAhead(1) + " at position " + getCurrentPositionInInput(), getCurrentPositionInInput());
			}
		
		}catch(Exception aEx) {
			System.out.println(aEx);
		}
	}
	
	private boolean connectiveDetected(char leadingChar) {
		return Connective.isConnectiveIdentifierStart(leadingChar);
	}
	
	private boolean symbolDetected(char leadingChar) {
		return Character.isJavaIdentifierStart(leadingChar);
	}
	
	private boolean isConnective(String aSymbol) {
		return Connective.isConnective(aSymbol);
	}
	
	private Token connective() throws Exception {
		Reader lSubReader = fInputString;
		StringBuffer sbuf = new StringBuffer();
		// Ensure pull out just one connective at a time, the isConnective(...)
		// test ensures we handle chained expressions like the following:
		// ~~P
		int lSymbol = lSubReader.read();
		int lType = 0;
		while (Connective.isConnectiveIdentifierPart((char)lSymbol) && !isConnective(sbuf.toString())) {
			sbuf.append(lSymbol);
			lType += lSymbol;
			lSymbol = lSubReader.read();
		}
		
		String lWholeSymbol = sbuf.toString();
		if (isConnective(lWholeSymbol)) {
			return new Token(lType, sbuf.toString(), fPosition);
		}
		throw new Exception("Lexing error on symbol " + lWholeSymbol + " at position " + fPosition);
	}
	

}
