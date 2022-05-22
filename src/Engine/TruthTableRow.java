package Engine;

import java.util.ArrayList;
import java.util.HashMap;


public class TruthTableRow {
	
	private HashMap<Clause,Boolean> items; 
	
	public TruthTableRow() {
		items = new HashMap<Clause,Boolean>();
	}
	
	public void addRowItem(Clause name, Boolean value) {
		
		items.put(name, value);
	
	}
	
	public ArrayList<HashMap<Clause,Boolean>> getRowItems() {
		return items;
	}
	
	
	
	
	
}
