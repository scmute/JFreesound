package org.tecnonucleo;

public class JFS2Exception extends Exception{

	private static final long serialVersionUID = 1L;
	private Throwable cause;
	
	public JFS2Exception(String message) {
		super(message);
	}
	
	public JFS2Exception(Throwable cause) {
        super(cause.getMessage());
        this.cause = cause;
    }
	
	public Throwable getCause() {
        return this.cause;
    }

}
