package Engine;

import java.util.ArrayList;
import java.util.List;

public class HornClause {
	
	private String fBody;
	private String fHead;
	
	public HornClause(String aBody, String aHead) {
		this.fBody = aBody;
		this.fHead = aHead;
	}
	
	public HornClause(String aHead) {
		this.fBody = new String();
		this.fHead = aHead;
	}

	/**
	 * @return the Body
	 */
	public String getBody() {
		return fBody;
	}

	/**
	 * @param Body the Body to set
	 */
	public void setBody(String fBody) {
		this.fBody = fBody;
	}

	/**
	 * @return the Head
	 */
	public String getHead() {
		return fHead;
	}

	/**
	 * @param Head the fHead to set
	 */
	public void setHead(String fHead) {
		this.fHead = fHead;
	}
	
	//@Override
	//public String toString() {}

}
