package jsp.LibraryManagement.exception;

public class NoLoanFoundException extends RuntimeException{
	@Override
	public String getMessage() {
		return "No Loans Found";
	}
}
