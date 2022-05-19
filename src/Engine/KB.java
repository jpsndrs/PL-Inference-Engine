package Engine;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import aima.core.logic.propositional.inference.TTEntails;
import aima.core.logic.propositional.parsing.PLParser;
import aima.core.logic.propositional.parsing.ast.Sentence;


/**
 * @author James Sanders
 * @author Riley Underwood
 */
public class KB {

	private List<HornClause> fKB;
	//Add the symbols
	private ArrayList<String> symbols = new ArrayList<String>();
	
	KB() {
		fKB = new ArrayList<>();
		
	}

	public void tell(String aSentence) throws IOException {
		
		//string array to temporarily hold each horn clause
		String[] lData = aSentence.split(";");
		//string array to temporarily hold each side of horn clause.
		String[] lHornClause;
		//loop over each horn clause.
		for(String dataElement:lData) {
			//check length, if it's not bigger than two, if true it has no body.
			//implication only.
			if(dataElement.strip().contains("=>")) {
				lHornClause = dataElement.split("=>");
				fKB.add(new HornClause(lHornClause[0].strip(), lHornClause[1].strip()));	
				
				//Add the symbols of the lhs & rhs of HornClause
				addSymbol(lHornClause[0].strip());
				addSymbol(lHornClause[1].strip());
			}else {
				//else set to head.
				fKB.add(new HornClause(dataElement.strip()));	
				//Add the symbols of the dataElement
				addSymbol(dataElement.strip());
			}
			
		
		}
		
//		//Add to symbols if there is a new symbol. 
//		add
	}
	
	//Attempts to add new symbol to the KB
	public void addSymbol(String symbolString) {
	
		String[] symbolStringSymbols = null;
		//Single Symbol
		if(!symbolString.contains("&") && !symbolString.contains("||") && !symbolString.contains("&")) {
			symbolStringSymbols = new String[1];
			symbolStringSymbols[0] = symbolString;
		}
		else {
			//Multiple symbols within symbol string
			//Symbol string may contain negation ~ conjunction & or disjunction ||
			//If that is the case then there is multiple symbols in symbolString
			if(symbolString.contains("||")) {
				symbolStringSymbols = symbolString.split("||"); 
			}
			if(symbolString.contains("~")) {
				symbolStringSymbols = symbolString.split("~"); 
			}
			if(symbolString.contains("&")) {
				symbolStringSymbols = symbolString.split("&"); 
			}
		}
		//Add the symbols only if they don't already exist
		for(String symbol: symbolStringSymbols) {
			if(!symbols.contains(symbol)) {
				symbols.add(symbol);
			}
		}
	}
		
	
	public List<HornClause> getKB() {
		return fKB;
	}
	
	public List<String> getSymbols(){
		return symbols;
		
	}
	
	
	/**
	 * Returns the answer to the specified question using the TT-Entails
	 * algorithm.
	 * 
	 * @param queryString
	 *            a question to ASK the knowledge base
	 * 
	 * @return the answer to the specified question using the TT-Entails
	 *         algorithm.
	 */
	public boolean askWithTTEntails(String aQueryString) {

		return new TTEntails().isEntailed(this, aQueryString);
	}
	
}
