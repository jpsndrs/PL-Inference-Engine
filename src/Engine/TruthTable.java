package Engine;

import java.util.ArrayList;

public class TruthTable {

	private ArrayList<Clause> clauses; 
	private Integer numberOfModels; 
	
	private ArrayList<TruthTableRow> models;

	public void setNumberOfModels() {		
		
		//Clauses and rhs/lhs individual variables are needed to calculate the total model.
		
		numberOfModels = (int) Math.pow(clauses.size(), 3);
		//Number of letters 
		
		//Loop through
	}

	public ArrayList<TruthTableRow> constructTruthTable(){
		return models; 
	}
	
	public generateVariablesFromClauses() {
	
	}
	

}

