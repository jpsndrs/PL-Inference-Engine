package Engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class TruthTable {

	private ArrayList<Model> models; 
	private Integer numberOfModels; 
	private ArrayList<TruthTableColumn> symbolColumns;
	private ArrayList<TruthTableColumn> hornClauseColumns;
	
	
	public TruthTable(KB fKB) {
	
		//Total Models 
		numberOfModels = (int) Math.pow(2, fKB.getSymbols().size());
		symbolColumns = new ArrayList<TruthTableColumn>();
		hornClauseColumns = new ArrayList<TruthTableColumn>();
		models = new ArrayList<Model>();
		
		//Generate the Horn Clause Column
		constructSymbolColumns(fKB);
		constructHornClauseColumns(fKB);
		constructHornClauseColumns(fKB);
		constructModels();
//		ttEntails("d");
		
		System.out.println("ENTAILS :: " + ttEntails("iawidaiwd",fKB));
		//Columns are made now models should be made. 
		
		
		
	}
	
	
	//Construct Model (rows) of the truth table using the columns that were previously created. 
	public void constructModels(){
	
		for(int modelIndex=0; modelIndex<numberOfModels; modelIndex++) {
			
			HashMap<String, Boolean> newModelValues = new HashMap<String,Boolean>();	
			//Symbol 
			for(TruthTableColumn sColumn: symbolColumns) {
				newModelValues.put(sColumn.getSymbol(), sColumn.getValues().get(modelIndex));
			}
		
			//HornClause Columns
			for(TruthTableColumn hcColumn: hornClauseColumns) {
				newModelValues.put(hcColumn.getSymbol(), hcColumn.getValues().get(modelIndex));
			}
			
			Model newModel = new Model(newModelValues);
			models.add(newModel);
		}
		
		System.out.println("Number Of Models ::: " +  models.size());
		
		
		
		//Map<boolean, String> a
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

	
	public TruthTableColumn getColumn(String fSymbol) {
		
		//First Look through the symbol column and then look through the hornClauseColumns
		for(TruthTableColumn column: symbolColumns) {
			
			//System.out.println("symbol column.getSymbol() "+ column.getSymbol() + " : "+fSymbol);
			if(column.getSymbol() == fSymbol) {
				return column;
			}
		}
		for(TruthTableColumn hcColumn: hornClauseColumns) {
			
			//System.out.println("horn column.getSymbol() "+ hcColumn.getSymbol() + " : "+fSymbol);
			if(hcColumn.getSymbol() == fSymbol) {
				return hcColumn;
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
						headAccessSymbolColumns.add(getColumn(symbol));
					}
					else if(hornClause.getBody().contains(symbol)) {
						bodyAccessSymbolColumns.add(getColumn(symbol));
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
		
					//System.out.println("\n\n"+hornClause.getBody()+"=>"+hornClause.getHead());
					for(TruthTableColumn headAccessSymbol: headAccessSymbolColumns){
						//Get Value; 
						
						//Head value // Check if already set by previous headAccessSymbol 
						
						//System.out.println("HEAD "+headAccessSymbol.getSymbol() + " "+headAccessSymbol.getValues().get(accessValueIndex));

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
						
						//System.out.println("BODY "+ bodyAccessSymbol.getSymbol() + " "+bodyAccessSymbol.getValues().get(accessValueIndex));
					
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
					
					//System.out.println("CLAUSE "+ clauseValue);
					
					
					//Add hornClause Column value; 
					hornClauseColumn.putValue(clauseValue);
				}
				
				
				
				// headValue 
				
				
				hornClauseColumns.add(hornClauseColumn);
			
			}

		}
		
	
		
	}
	
	
	public boolean ttEntails(String alpha, KB fKB) {
		
		
		
		for(Model model: models) {
			
			System.out.println("model.isTrue(alpha)"+model.isTrue(alpha));
		
			if(model.isTrue(alpha) && !model.isTrue(fKB.getKB())) {
			
				//Does not entail alpha
				return true;
			}
			
			
		}
		
		
		return true;
		
		
	}
	


	

}

