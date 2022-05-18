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

/**
 * @author James Sanders
 * @author Riley Underwood
 * /
public class PLiEngine {

	/**
	 * @param args[0] <method>
	 * @param args[1] <filename>
	 */
	public static void main(String[] args) {
		
		try
		{
			
			KB fKB = new KB();
			FileReader fReader = new FileReader(args[0]);
			BufferedReader fFileData = new BufferedReader(fReader);
			String fData = fFileData.readLine();
			
			if(fData.matches("TELL")) {
				fData = fFileData.readLine();
				fKB.tell(fData);
			}
			fData = fFileData.readLine();
			if(fData.matches("ASK")) {
				//debug
				System.out.println(fData);
				fData = fFileData.readLine();
				System.out.println(fData);
				//debug end
			}
			
			//debug start
			for(HornClause element : fKB.getKB()) {
				System.out.println(element.getBody() + "=>" + element.getHead());
			}
			
			//debug end

			/*
			//start of test code
			List<Token> lToken = new ArrayList<Token>();
			
			int symbol[] = new int[myString.length()];
			Reader stread = new StringReader(myString);
			
			for(int i = 0; i < myString.length(); i++) {
				symbol[i] = stread.read();
				System.out.print((char)symbol[i]);
				*/
				
			//main
			  /*if (args.length != 3) {
			        System.out.println("Arguments missing.");
			        System.out.println("iengine <method> <filename>");
			
			        exit(1);
			    }
			
			    switch (args[0]) {
			    
			    }
			    if (lMethod == "TT")
			    {
			        TruthTable TT(lFile.GetClauses(), lFile.GetQuery(), lFile.GetSymbols(), lFile.GetSubClauses());
			    }
			    else if (lMethod == "FC")
			    {
			        ForwardChaining FC(lFile.GetClauses(), lFile.GetQuery());
			    }
			    else if (lMethod == "BC")
			    {
			        BackwardChaining BC(lFile.GetClauses(), lFile.GetQuery());
			    }*/
			    
				

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
