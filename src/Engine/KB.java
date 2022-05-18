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

	private List<String> fClause = new ArrayList<>();

	public void tell(String aSentence) throws IOException {
		
		String[] lClause = aSentence.split(";");
		for(String subStr:lClause) {
			fClause.add(subStr.strip());
			//debug
			System.out.println("Knowledgebase:");
			System.out.println(subStr.strip());
			System.out.println("");
			//debug end
		}
	}
	
	
}
