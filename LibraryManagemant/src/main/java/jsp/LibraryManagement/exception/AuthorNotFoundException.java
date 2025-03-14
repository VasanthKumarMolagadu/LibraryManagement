package jsp.LibraryManagement.exception;

public class AuthorNotFoundException extends RuntimeException{
	@Override
	public String getMessage() {
		return "Author Not Found";
	}
}
