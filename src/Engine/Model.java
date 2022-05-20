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

	private HashMap<String, Boolean> fAssignments;

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
		fAssignments.putAll(aValues);
	}

	/**
	 * @return boolean
	 * */
	public boolean isTrue(String aSymbol) {
		//TODO
		//return true if symbol is true
		return bool;
	}

	/**
	 * @return boolean
	 * */
	public boolean isTrue(List<String> aSymbols) {
		//TODO
		//return true if symbols are true
		return true;
	}

	public Model union(String aSymbol, Boolean aBool) {
		Model lModel = new Model();
		lModel.fAssignments.putAll(this.fAssignments);
		lModel.fAssignments.put(aSymbol, aBool);
		return lModel;
	}

}
