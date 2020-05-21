package common.util;

public class MessageUtil {
	private String string;
	private String separator;
	private int separatorIndex;
	
	public String FirstWord;
	public String SecondWord;
	
	
	public MessageUtil(String string, String separator) {
		this.string=string;
		this.separator=separator;
		
		if(string != null) {
			proceed();
		}
	}
	
	private void proceed() {
		getSeparatorIndex();
		getFirstWord();
		getSecondWord();
	}
	
    private void getFirstWord() {    	
    	//if space is present at the message
    	//get string from beginning to index of space
    	if(separatorIndex > 0) {
    		FirstWord = string.substring(0, separatorIndex);  
    		return;
    	}
    	
    	FirstWord = string;
    }
    
    //get last word of string(from first space to end)
    private void getSecondWord() {    	
    	if(separatorIndex > 0) {
        	SecondWord = string.substring(separatorIndex + 1, string.length());
    	}
    }
    
    private void getSeparatorIndex() {
    		separatorIndex = string.indexOf(separator);
    }
}
