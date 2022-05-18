package Engine;

import java.util.ArrayList;
import java.util.HashMap;


public class TruthTableRow {
	
	private ArrayList<HashMap<Clause,Boolean>> items; 
	
	public void addRowItem(Clause name, Boolean value) {
		HashMap<Clause,Boolean> item = new HashMap<Clause,Boolean>();
		item.put(name, value);
		
		items.add(item);
	}
	
	public ArrayList<HashMap<Clause,Boolean>> getRowItems() {
		return items;
	}
	
	
	
	
}
