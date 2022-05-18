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

	public void tell(BufferedReader aFileData) throws IOException {
		String lSentence = aFileData.readLine();
		String[] lClause = lSentence.split(";");
		for(String subStr:lClause)
			fClause.add(subStr.strip());
	}
}
