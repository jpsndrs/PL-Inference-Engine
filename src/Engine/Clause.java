package Engine;

import java.util.ArrayList;

import NotUsingDeleteLater.Connective;

public class Clause {
	
	ArrayList<Connective> connectives = null; 
	ArrayList<String> symbols = null; 
	
	Clause(ArrayList<Connective> connective, ArrayList<String> symbols){
		this.symbols = symbols;
		this.connectives = connective;
	}
	public ArrayList<Connective> getConnectives() {
		return this.connectives;
	}
	public ArrayList<String> getSymbols(){
		return this.symbols;
	}
	
	
	
	
	
	
	//Complex 
	//Simple
//	public String complexSentence() {
//		return "";
//	}
//	
//	public String simpleSentence() {
//		return "";
//	}
	
	//Simple sentence is true with two propositions
	//Complex sentence is always true. 
	//Calculate
	
	
	
}
