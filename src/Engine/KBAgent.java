package Engine;
/**
 * @author James P. Sanders
 * @author Riley J. Underwood
 * @since 03/05/2022
 * @version 0.1
 * */

/**
 * This is the Knowledge-Based (KB) Agent Class
 * Which contains two private fields, and one public method.
 * */
public class KBAgent {
	
	/***
	 * Private fields.
	 * @param fKB the knowledge base
	 * @param fT the counter indicating time, starting from zero
	 * */
	static private KB fKB;
	static private int fT;
	
	
	/**
	 * Class Constructor
	 * @param none, this is the default constructor.
	 * */
	public KBAgent() {
		fKB = new KB();
		fT = 0;
	}
	
	pubilc AgentAction runKBAgent(AgentPercept aPercept) {
		
		tell(fKB, makePerceptSentence(aPercept, fT));
		AgentAction lAction = ask(fKB, makeActionQuery(fT));
		tell(fKB, makeActionSentence(lAction, fT));
		fT++;
		return lAction;
	}
	
	private void makePerceptSentence(AgentPercept aPercept, int aT) {
		
	}
	
	private void makeActionSentence(AgentAction aAction, int aT) {
		
	}
	
	private void tell(KB aKB, PerceptSentence aSentence) {
		
	}
	
	private void tell(KB aKB, ActionSentence aSentence) {
		
	}
	
	private ActionQuery makeActionQuery(int aT) {
		
	}
	
	private AgentAction ask(KB aKB, ActionQuery aSentence) {
		
	}
}
