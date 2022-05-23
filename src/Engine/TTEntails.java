package Engine;

import java.util.List;

/**
 * @author James Sanders
 * @author Riley Underwood
 */

public class TTEntails {

	public boolean isEntailed(KB aKB, String aAlpha) {
		// symbols <- a list of proposition symbols in KB and &alpha
		List<String> lSymbols = aKB.getSymbols();

		// return TT-CHECK-ALL(KB, &alpha; symbols, {})
		return ttCheckAll(aKB, aAlpha, lSymbols, new Model());
	}

	public boolean ttCheckAll(KB aKB, String aAlpha, List<String> aSymbols, Model aModel) {
		
		
		// if EMPTY?(symbols) then
		if (aSymbols.isEmpty()) {
			// if PL-TRUE?(KB, model) then return PL-TRUE?(&alpha;, model)
			if (aModel.isTrue(aKB.getKB())) {
				return aModel.isTrue(aAlpha);
			} else {
				// else return true // when KB is false, always return true
				return true;
			}
		}

		// else do
		// P <- FIRST(symbols)
		String lP = aSymbols.get(0);
		// rest <- REST(symbols)
		List<String> lRest = aSymbols.subList(1, aSymbols.size());
		// return (TT-CHECK-ALL(KB, &alpha;, rest, model &cup; { P = true })
		// and
		// TT-CHECK-ALL(KB, &alpha;, rest, model U { P = false }))
		return ttCheckAll(aKB, aAlpha, lRest, aModel.union(lP, true))
				&& ttCheckAll(aKB, aAlpha, lRest, aModel.union(lP, false));
		
		
	}
	
	
}