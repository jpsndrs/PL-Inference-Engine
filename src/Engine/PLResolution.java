package Engine;

public class PLResolution {
	
	private boolean discardTautologies = true;
	
	public PLResolution() {
		this(true);
	}
	
	boolean isEntailed(KnowledgeBase kb, Sentence alpha);

}
