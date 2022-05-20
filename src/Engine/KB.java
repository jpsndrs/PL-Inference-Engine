package Engine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author James Sanders
 * @author Riley Underwood
 */
public class KB {

	//Add  the knowledge base
	private List<HornClause> fKB;
	//Add the symbols
	private ArrayList<String> fSymbols;

	KB() {
		fKB = new ArrayList<>();
		fSymbols = new ArrayList<>();
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

	/**
	 * get symbols
	 * @return symbols
	 * */
	public ArrayList<String> getSymbols(){
		return fSymbols;
	}

	//Attempts to add new symbol to the KB
	private void addSymbol(String aSymbolString) {

		String[] lSymbolStringSymbols = null;
		//Single Symbol
		if(!aSymbolString.contains("&") && !aSymbolString.contains("||") && !aSymbolString.contains("&")) {
			lSymbolStringSymbols = new String[1];
			lSymbolStringSymbols[0] = aSymbolString;
		}
		else {
			//Multiple symbols within symbol string
			//Symbol string may contain negation ~ conjunction & or disjunction ||
			//If that is the case then there is multiple symbols in symbolString
			if(aSymbolString.contains("||")) {
				lSymbolStringSymbols = aSymbolString.split("||");
			}
			if(aSymbolString.contains("~")) {
				lSymbolStringSymbols = aSymbolString.split("~");
			}
			if(aSymbolString.contains("&")) {
				lSymbolStringSymbols = aSymbolString.split("&");
			}
		}
		//Add the symbols only if they don't already exist
		for(String symbol: lSymbolStringSymbols) {
			if(!fSymbols.contains(symbol)) {
				fSymbols.add(symbol);
			}
		}
	}


	public List<HornClause> getKB() {
		return fKB;
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
