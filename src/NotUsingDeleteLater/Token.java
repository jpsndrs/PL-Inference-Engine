/**
 * 
 */
package NotUsingDeleteLater;

/**
 * @author James Sanders
 *
 */
public class Token {
	
	private int    fType;
	private String fText;
	private int    fStartPosition;

	public Token(int aType, String aText, int aStartPosition) {
		this.fType = aType;
		this.fText = aText;
		this.fStartPosition = aStartPosition;
	}
	
	public int getType() {
		return fType;
	}
	
	public char getText() {
		return fText;
	}	

	public int getCharPosition() {
		return fStartPosition;
	}

	@Override
	public boolean equals(Object aObject) {

		if (this == aObject) {
			return true;
		}
		if ((aObject == null) || (this.getClass() != aObject.getClass())) {
			return false;
		}
		
		Token lOther = (Token) aObject;
		return ((lOther.fType == fType) && (lOther.fText.equals(fText)) && (lOther.fStartPosition == fStartPosition));
	}
	
}
