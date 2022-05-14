package Engine;

import java.util.ArrayList;
import java.util.List;



public class KB {
	private List<Sentence> fSentences = new ArrayList<>();
	
	public void tell(String aSentence) {
		tell((Sentence) parser.parse(aSentence));
		
	}
	
	public void tell(Sentence aSentence) {
		if (!(fSentences.contains(aSentence))) {
			fSentences.add(aSentence);
			asCNF = asCNF.extend(ConvertToConjunctionOfClauses.apply(aSentence).getClauses());
			symbols.addAll(SymbolCollector.getSymbolsFrom(aSentence));
		}
	}

}
