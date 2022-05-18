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
			if(dataElement.strip().length() > 2) {
				lHornClause = dataElement.split("=>");
				fKB.add(new HornClause(lHornClause[0].strip(), lHornClause[1].strip()));				
			}else {
				//else set to head.
				fKB.add(new HornClause(dataElement.strip()));	
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
