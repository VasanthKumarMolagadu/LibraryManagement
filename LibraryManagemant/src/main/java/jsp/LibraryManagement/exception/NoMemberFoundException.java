package jsp.LibraryManagement.exception;

public class NoMemberFoundException extends RuntimeException{
	
	@Override
	public String getMessage() {
		return "No Member Found";
	}

}
