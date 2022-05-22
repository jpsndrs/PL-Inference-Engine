package Engine;

import java.util.ArrayList;
import java.util.HashMap;

public class TruthTable {

	private ArrayList<Clause> clauses; 
	private Integer numberOfModels; 
	private ArrayList<TruthTableSymbolColumn> models;
	

	
	public TruthTable(KB fKB) {
		
		models = new ArrayList<TruthTableSymbolColumn>();
		//
		//Number of models. == number of symbols + number of horn clauses that have (=>)
		System.out.println("Models ::" + fKB.getSymbols());
		//Construct symbols truth table.
		numberOfModels = (int) Math.pow(2, fKB.getSymbols().size());
		System.out.println("Number of Models ::" + numberOfModels);
		
		
		constructTruthTable(fKB);
		for(TruthTableSymbolColumn column : models) {
			System.out.println(column.getSymbol());
			column.printValues();
			
			System.out.println("\n");
			
			
		}
		
		//Generate the Horn Clause Column; 
		
	}

	public void constructTruthTable(KB fKB){
		
		//True and False alternation from the start to the end over numberOfModels
		int tfAlternation = numberOfModels / 2;
		
		for(String symbol : fKB.getSymbols()) {
			
			//New Column 
			TruthTableSymbolColumn symbolColumn = new TruthTableSymbolColumn(symbol);
			int itemNumber = 0; 
			
			while(itemNumber < numberOfModels) {
				
				for(int truthIndex=0; truthIndex < tfAlternation; truthIndex++) {
					symbolColumn.putValue(true);
					itemNumber+=1; 
				}
				
				for(int falseIndex=0; falseIndex < tfAlternation; falseIndex++) {
					symbolColumn.putValue(false);
					itemNumber+=1; 
				}
				
			}
			models.add(symbolColumn);
			
			tfAlternation/=2;
		}
		
	}
	

	

}

