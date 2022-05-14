/**
 * 
 */
package Engine;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author James Sanders
 *
 */
public enum Connective {
	// i.e. highest to lowest precedence.
	NEGATION("~", 10),  //~ for negation
	CONJUNCTON("&", 8), //& for conjunction
	DISJUNCTION("||", 6), //|| for disjunction
	IMPLICATION("=>", 4), //=> for implication
	BICONDITIONAL("<=>", 2);//<=> for biconditional

	private final String fSymbol;
	private final int fPrecedence;

	Connective(String symbol, int precedence) {
		this.fSymbol = symbol;
		this.fPrecedence = precedence;
	}
	
	public String getSymbol() {
		return fSymbol;
	}

	public int getPrecedence() {
		return fPrecedence;
	}

	@Override
	public String toString() {
		return getSymbol();
	}	

	public static boolean isConnective(String symbol) {
		if (NEGATION.getSymbol().equals(symbol)) {
			return true;
		} else if (CONJUNCTON.getSymbol().equals(symbol)) {
			return true;
		} else if (DISJUNCTION.getSymbol().equals(symbol)) {
			return true;
		} else if (IMPLICATION.getSymbol().equals(symbol)) {
			return true;
		} else if (BICONDITIONAL.getSymbol().equals(symbol)) {
			return true;
		}
		return false;
	}
	
	public static Connective get(String aSymbol) {
		if (NEGATION.getSymbol().equals(aSymbol)) {
			return NEGATION;
		} else if (CONJUNCTON.getSymbol().equals(aSymbol)) {
			return CONJUNCTON;
		} else if (DISJUNCTION.getSymbol().equals(aSymbol)) {
			return DISJUNCTION;
		} else if (IMPLICATION.getSymbol().equals(aSymbol)) {
			return IMPLICATION;
		} else if (BICONDITIONAL.getSymbol().equals(aSymbol)) {
			return BICONDITIONAL;
		}

		throw new IllegalArgumentException(
				"Not a valid symbol for a connective: " + aSymbol);
	}
	
	public static boolean isConnectiveIdentifierStart(char aChar) {
		return fLeadingChars.contains(aChar);
	}

	public static boolean isConnectiveIdentifierPart(char aChar) {
		return fChars.contains(aChar);
	}
	
	@SafeVarargs
	private static <Character> Set<Character> createSet(Character... aValues) {
		Set<Character> lSet = new LinkedHashSet<>();
		Collections.addAll(lSet, aValues);
		return lSet;
	}
	private static final Set<Character> fLeadingChars = Connective.createSet('~', '&', '|', '=', '<');
	private static final Set<Character> fChars        = Connective.createSet('~', '&', '|', '=', '<', '>');
}
