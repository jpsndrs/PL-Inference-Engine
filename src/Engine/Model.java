/**
 *
 */
package Engine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * @author Nero64
 *
 */
public class Model {

	private	Map<String, Boolean> fAssignments;

	/**
	 * Default Constructor.
	 */
	public Model() {
		fAssignments = new HashMap<>();
	}

	/**
	 * Builds model using hash map.
	 * */
	public Model(Map<String, Boolean> aValues) {
		fAssignments = new  HashMap<String, Boolean>();
		
		fAssignments.putAll(aValues);
		
		
		
	}

	/**
	 * @return boolean
	 * */
	public boolean isTrue(String aSymbol) {

		//return true if symbol is true
		for (Map.Entry<String, Boolean> assignment: fAssignments.entrySet()) {	
		

			
	
			if(assignment.getKey().strip().equals(aSymbol.strip()) && assignment.getValue() == true) {
				//Is true
				System.out.println(" aw");
				return true;
			}
		}
		//Is not true.
		return false;
		
	}

	/**
	 * @return boolean
	 * */
	public boolean isTrue(List<HornClause> aKB) {
		//TODO
		for(HornClause hornClause : aKB) {
			if(hornClause.getBody().matches("TRUE")) {
				//
				//Use head  of the horn clause to check in the model eg "a"
		
				//return true if true
				for (Map.Entry<String, Boolean> assignment: fAssignments.entrySet()) {	
					if(assignment.getKey().strip().equals(hornClause.getHead().strip()) && assignment.getValue() == true) {
						//Is true
						return true;
					}
				}
				
			}
			else {
				//Use the head and body of the horn clause to check in the model. eg "p3&p2=>2"
				//return true if true
				for (Map.Entry<String, Boolean> assignment: fAssignments.entrySet()) {	
					if(assignment.getKey().strip().equals(((hornClause.getBody()+"=>"+hornClause.getHead())).strip()) && assignment.getValue() == true) {
						//Is true
						return true;
					}
				}
			}	
		}
		//return true if symbols are true
		//return bool;
		return false; 
	}
	

	public Model union(String aSymbol, Boolean aBool) {
		Model lModel = new Model();
		lModel.fAssignments.putAll(this.fAssignments);
		lModel.fAssignments.put(aSymbol, aBool);
		return lModel;
	}
	
	
	

}
