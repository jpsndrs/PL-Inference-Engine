package Engine;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author James Sanders
 * @author Riley Underwood
 * */
public class KB {

	private List<HornClause> fKB;
	
	KB() {
		fKB = new ArrayList<>();
	}

	public void tell(String aSentence) throws IOException {
		
		//string array to temporarily hold each horn clause
		String[] lData = aSentence.split(";");
		//string array to temporarily hold each side of horn clause.
		String[] lHornClause;
		//loop over each horn clause.
		for(String dataElement:lData) {
			//check length, if it's not bigger than two, if true it has no body.
			//implication only.
			if(dataElement.length() > 2) {
				lHornClause = dataElement.split("=>");
				
			}else {
				//else set to head.
			}
		}
		
		/*String[] lClause = aSentence.split(";");
		for(String subStr:lClause) {
			fClause.add(subStr.strip());
			//debug
			System.out.println("Knowledgebase:");
			System.out.println(subStr.strip());
			System.out.println("");
			//debug end
		}*/
	}
	
	
}
