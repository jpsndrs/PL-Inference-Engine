package Engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TruthTableColumn {
	
	private ArrayList<Boolean> values; 
	private String symbol;
	
	public TruthTableColumn(String vSymbol) {
		symbol = vSymbol;
		values = new ArrayList<Boolean>();	
	}
	
	public void putValue(Boolean value) {
		values.add(value); 
	}
	
	public ArrayList<Boolean> getValues() {
		return values; 
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public void printValues() {
		for(Boolean value: getValues()) {
			System.out.print(value);
		}
	}
	
	
	//Returns indexes of True values
	public ArrayList<Integer> getTrueValues(){
		ArrayList<Integer> valueIndexes = new ArrayList<>();
		
		for(int valueIndex=0; valueIndex<values.size();valueIndex++) {
			if(values.get(valueIndex) == true) {
				valueIndexes.add(valueIndex);
			}
		}
		
		return valueIndexes; 
	}
	
	
	//Returns indexes of True values
	public ArrayList<Integer> getFalseValues(){
		ArrayList<Integer> valueIndexes = new ArrayList<>();
		
		for(int valueIndex=0; valueIndex<values.size();valueIndex++) {
			if(values.get(valueIndex) == false) {
				valueIndexes.add(valueIndex);
			}
		}
		return valueIndexes; 
	}
}


