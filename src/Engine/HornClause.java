package Engine;

import java.util.ArrayList;
import java.util.List;

public class HornClause {
	
	private static String fBody;
	private static String fHead;
	
	public HornClause(String aBody, String aHead) {
		this.fBody = aBody;
		this.fHead = aHead;
	}
	
	public HornClause(String aHead) {
		this.fBody = new String();
		this.fHead = aHead;
	}

	/**
	 * @return the fBody
	 */
	public static String getBody() {
		return fBody;
	}

	/**
	 * @param fBody the fBody to set
	 */
	public static void setBody(String fBody) {
		HornClause.fBody = fBody;
	}

	/**
	 * @return the fHead
	 */
	public static String getHead() {
		return fHead;
	}

	/**
	 * @param fHead the fHead to set
	 */
	public static void setHead(String fHead) {
		HornClause.fHead = fHead;
	}
	

}
