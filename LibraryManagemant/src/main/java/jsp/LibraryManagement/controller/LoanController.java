package jsp.LibraryManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jsp.LibraryManagement.dto.ResponseStructure;
import jsp.LibraryManagement.entity.Loan;
import jsp.LibraryManagement.service.LoanService;

@RestController
@RequestMapping("/Loan")
public class LoanController {
	@Autowired
	private LoanService loanService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Loan>> saveLoan(@RequestBody Loan loan){
		return loanService.saveLoan(loan);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Loan>>> fetchAllLoan(){
		return loanService.fetchAllLoan();
	}
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Loan>> fetchLoanById(@PathVariable int id){
		return loanService.fetchBookById(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ResponseStructure<Loan>> updateLoan(@RequestBody Loan loan,@PathVariable int id){
		return loanService.updateLoan(loan, id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Loan>> deleteLoan(@PathVariable int id){
		return loanService.deleteLoan(id);
	}

}
