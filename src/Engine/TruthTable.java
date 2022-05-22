package Engine;

import java.util.ArrayList;
import java.util.HashMap;

public class TruthTable {

	private ArrayList<Clause> clauses; 
	private Integer numberOfModels; 
	private ArrayList<TruthTableSymbolColumn> models;
	
	private ArrayList<TruthTableColumn> symbolColumns;
	private ArrayList<TruthTableColumn> hornClauseColumns;
	
	public TruthTable(KB fKB) {
		

		//Total Models 
		numberOfModels = (int) Math.pow(2, fKB.getSymbols().size());
		
		symbolColumns = new ArrayList<TruthTableColumn>();
		
		hornClauseColumns = new ArrayList<TruthTableColumn>();
		
		constructSymbolColumns(fKB);
	
		//Generate the Horn Clause Column; 
		constructHornClauseColumns(fKB);
		constructHornClauseColumns(fKB);
		
		
		for(TruthTableColumn column : hornClauseColumns) {
			System.out.println(column.getSymbol());
			column.printValues();
			
			System.out.println("\n");
			
		}
//		
	
		
		
	}

	public void constructSymbolColumns(KB fKB){
		
		//True and False alternation from the start to the end over numberOfModels
		int tfAlternation = numberOfModels / 2;
		
		for(String symbol : fKB.getSymbols()) {
			
			//New Column 
			TruthTableColumn symbolColumn = new TruthTableColumn(symbol);
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
			
			
			symbolColumns.add(symbolColumn);
			
			tfAlternation/=2;
		}
		
	}

	
	public TruthTableColumn getSymbolColumn(String fSymbol) {
		
		for(TruthTableColumn column: symbolColumns) {
			if(column.getSymbol() == fSymbol) {
				return column;
			}
		}
		
		return null;
	}
	
	

	public void constructHornClauseColumns(KB fKB){
		
		for(HornClause hornClause: fKB.getKB()) {
			
			//Only generate a column if the body of the HornClause is !== TRUE
		
			if(hornClause.getBody() != "TRUE") {
				
				//Need to know the symbols that the hornClause Contains so the correct hornClauseColumns can be accessded. 
				ArrayList<TruthTableColumn> headAccessSymbolColumns = new ArrayList<TruthTableColumn>();
				ArrayList<TruthTableColumn> bodyAccessSymbolColumns = new ArrayList<TruthTableColumn>();
				
				for(String symbol: fKB.getSymbols()) {
					if(hornClause.getHead().contains(symbol)) {
						headAccessSymbolColumns.add(getSymbolColumn(symbol));
					}
					else if(hornClause.getBody().contains(symbol)) {
						bodyAccessSymbolColumns.add(getSymbolColumn(symbol));
					}
				}
				
				
				TruthTableColumn hornClauseColumn = new TruthTableColumn(hornClause.getBody()+"=>"+hornClause.getHead());
				//Rules //Rules //Rules
				//Implication 
				// TT = T TF = F FT = T
				
				//Set the head value at current row. 
				
				//Need to generate the same number values to the hornClauseColumn as numberOfModels
				for(int accessValueIndex=0; accessValueIndex< numberOfModels; accessValueIndex++) {
					
					boolean headValue = true;
					boolean bodyValue = true;
					boolean clauseValue;
					boolean newValue = false;
					
			
					for(TruthTableColumn headAccessSymbol: headAccessSymbolColumns){
						//Get Value; 
						
						//Head value // Check if already set by previous headAccessSymbol 
					
						if(headValue == true || headValue == false) {
							newValue = headAccessSymbol.getValues().get(accessValueIndex);
							//Check TT = T else F
							//This works for the & for example adding f&g
							if(newValue == true && headValue == true) {
								headValue = true;
							}else {
								headValue = false; 
							}
						}
					}
					
					//Could be multiple bodyAccessSymbolColumns such as f&g
					//There would be two what need to be indexed to get the bodyValue calculated		
					for(TruthTableColumn bodyAccessSymbol: bodyAccessSymbolColumns){
						//Get Value; 
						
						//Head value // Check if already set by previous headAccessSymbol 
					
						if(headValue == true || headValue == false) {
							newValue = bodyAccessSymbol.getValues().get(accessValueIndex);
							//Check TT = T else F
							//This works for the & for example adding f&g
							if(newValue == true && bodyValue == true) {
								bodyValue = true;
							}else {
								bodyValue = false; 
							}
						}
					}
					
					//Set the clauseValue
					if((bodyValue == true && headValue == true) 
							|| (bodyValue == false && headValue == false) 
							|| (bodyValue == false && headValue == true)  ) {
						clauseValue = true;
					}else {
						clauseValue = false; 
					}
					
					//Add hornClause Column value; 
					hornClauseColumn.putValue(clauseValue);
					
					
				}
				
				
				// headValue 
				
				
				hornClauseColumns.add(hornClauseColumn);
				System.out.println(hornClauseColumn);
			}

		}
		
	
		
	}
	


	

}

