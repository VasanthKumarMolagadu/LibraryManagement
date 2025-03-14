package jsp.LibraryManagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jsp.LibraryManagement.entity.Loan;
import jsp.LibraryManagement.repository.LoanRepository;

@Repository
public class LoanDao {
	@Autowired
	private LoanRepository loanRepository;
	
	public Loan saveLoan(Loan loan) {
		return loanRepository.save(loan);
	}
	
	public List<Loan> fetchAllLoans(){
		return loanRepository.findAll();
	}
	
	public Optional<Loan> fetchLoanById(int id) {
		return loanRepository.findById(id);
	}
	
	public Loan updateLoan(Loan loan) {
		return loanRepository.save(loan);
	}
	
	public void deleteLoan(int id) {
		loanRepository.deleteById(id);
	}

}
