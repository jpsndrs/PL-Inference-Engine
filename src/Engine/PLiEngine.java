/**
 * 
 */
package Engine;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import COS30019.Block;

/**
 * @author jmsps
 *
 */
public class PLiEngine {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try
		{
			FileReader fReader = new FileReader(args[0]);
			BufferedReader fFileData = new BufferedReader(fReader);
			String myString = fFileData.readLine();
			
			switch(myString) {
			case "TELL":
				myString = fFileData.readLine();
				String[] str = myString.split(";");
				for(String subStr:str) 
					System.out.println(subStr);
				
				//start of test code
				List<Token> fToken = new ArrayList<Token>();
				
				int symbol[] = new int[myString.length()];
				Reader stread = new StringReader(myString);
				
				for(int i = 0; i < myString.length(); i++) {
					symbol[i] = stread.read();
					System.out.print((char)symbol[i]);
					
					
					/*if((char)symbol[i] == '(') {
						fToken.add(new Token(symbol[i], "(", i));
					}else if((char)symbol[i] == ')') {
						fToken.add(new Token(symbol[i], ")", i));
					}else if ((char)symbol[i] == '')*/
					
				}
				/*for(Token lToken:fToken) {

					
				}*/
				
				
				
				//end of test code
				
				//function PL-RESOLUTION(KB,a) returns true or false
				//inputs: KB, the knowledge base, a sentence in propositional logic
				//a, the query, a sentence in propositional logic
				//clauses =the set of clauses in the CNF representation of KB & ¬a
				//new ={ }
				//while true do
				//for each pair of clauses Ci, Cj in clauses do
				//resolvents =PL-RESOLVE(Ci,Cj )
				//if resolvents contains the empty clause then return true
				//new =new u resolvents
				//if new =c clauses then return false
				//clauses =clauses unew
				
				
				break;
			case "ASK":
				break;
			default:
				break;
			}
		}
        catch(FileNotFoundException ex)
        {
            //The file didn't exist, show an error
            System.out.println("Error: File \"" + args[0] + "\" not found.");
            System.out.println("Please check the path to the file.");
            System.exit(1);
        }
        catch(IOException ex)
        {
            //There was an IO error, show and error message
            System.out.println("Error in reading \"" + args[0] + "\". Try closing it and programs that may be accessing it.");
            System.out.println("If you're accessing this file over a network, try making a local copy.");
            System.exit(1);
        }
	}

}
