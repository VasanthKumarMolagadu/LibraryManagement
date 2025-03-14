package jsp.LibraryManagement.exception;

public class NoBookFoundException extends RuntimeException{
	@Override
	public String getMessage() {
		return "No Book Found";
	}

}
