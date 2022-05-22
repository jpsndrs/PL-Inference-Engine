/**
 * 
 */
package Engine;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author James Sanders
 * @author Riley Underwood
 */
public class PropositionCollector {	
	
	/**
	 * Collect a set of propositional symbols from a list of given sentences.
	 * 
	 * @param sentences
	 *            a list of sentences from which to collect symbols.
	 * @return a set of all the proposition symbols that are not always true or
	 *         false contained within the input sentences.
	 */
	public static Map<String, Boolean> getSymbolsFrom(KB aKB){
		Map<String, Boolean> lResult = new LinkedHashMap<String, Boolean>();
		for(HornClause element : aKB.getKB()) {
			String[] lFact = element.getBody().split("&");
			lResult.put(lFact[0], true);
			lResult.put(lFact[1], true);
			lResult.put(element.getHead(), true);
		}
		return lResult;
	}
	
	//

}
