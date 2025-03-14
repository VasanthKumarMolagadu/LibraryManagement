package jsp.LibraryManagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jsp.LibraryManagement.dto.ResponseStructure;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(AuthorNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleAuthorNotFoundException(AuthorNotFoundException e){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setMessage("AuthorNotFound");
		structure.setData(null);
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoBookFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleNoBookFoundException(NoBookFoundException e){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setMessage("NoBookFound");
		structure.setData(null);
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoMemberFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleNoMemberFoundException(NoMemberFoundException e){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setMessage("NoMemberFound");
		structure.setData(null);
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public  ResponseEntity<ResponseStructure<String>> handleNoLoansFoundException(NoLoanFoundException e){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setMessage("NoLoanFound");
		structure.setData(null);
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
}
