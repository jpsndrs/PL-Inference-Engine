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

	public boolean isEntailed(KB aKb, String aAlpha) {
		// symbols <- a list of proposition symbols in KB and &alpha
		List<PropositionSymbol> symbols = new ArrayList<PropositionSymbol>(
				SymbolCollector.getSymbolsFrom(kb.asSentence(), alpha));

		// return TT-CHECK-ALL(KB, &alpha; symbols, {})
		return ttCheckAll(kb, alpha, symbols, new Model());
	}

	public boolean ttCheckAll(KB aKb, Sentence aAlpha, List<PropositionSymbol> symbols, Model model) {
		// if EMPTY?(symbols) then
		if (symbols.isEmpty()) {
			// if PL-TRUE?(KB, model) then return PL-TRUE?(&alpha;, model)
			if (model.isTrue(kb.asSentence())) {
				return model.isTrue(alpha);
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