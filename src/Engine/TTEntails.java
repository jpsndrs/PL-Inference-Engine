package Engine;

import java.util.ArrayList;
import java.util.List;

import aima.core.logic.propositional.kb.KnowledgeBase;
import aima.core.logic.propositional.kb.data.Model;
import aima.core.logic.propositional.parsing.ast.PropositionSymbol;
import aima.core.logic.propositional.parsing.ast.Sentence;
import aima.core.logic.propositional.transformations.SymbolCollector;
import aima.core.util.Util;

/**
 * @author James Sanders
 * @author Riley Underwood
 */
public class TTEntails {

	public boolean isEntailed(KB aKB, String aAlpha) {
		// symbols <- a list of proposition symbols in KB and &alpha
		List<String> lSymbols = new ArrayList<String>( PropositionCollector.getSymbolsFrom( aKB ) );

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
		PropositionSymbol p = Util.first(symbols);
		// rest <- REST(symbols)
		List<PropositionSymbol> rest = Util.rest(symbols);
		// return (TT-CHECK-ALL(KB, &alpha;, rest, model &cup; { P = true })
		// and
		// TT-CHECK-ALL(KB, &alpha;, rest, model U { P = false }))
		return ttCheckAll(kb, alpha, rest, model.union(p, true))
				&& ttCheckAll(kb, alpha, rest, model.union(p, false));
	}
}