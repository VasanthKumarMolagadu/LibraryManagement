package jsp.LibraryManagement.service;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jsp.LibraryManagement.dao.BookDao;
import jsp.LibraryManagement.dao.LoanDao;
import jsp.LibraryManagement.dto.ResponseStructure;
import jsp.LibraryManagement.entity.Book;
import jsp.LibraryManagement.entity.Loan;
import jsp.LibraryManagement.entity.Member;
import jsp.LibraryManagement.exception.NoLoanFoundException;
import jsp.LibraryManagement.repository.MemberRepository;

@Service
public class LoanService {
	@Autowired
	private LoanDao loanDao;
	@Autowired
	private BookDao bookDao;
	@Autowired
	private MemberRepository memberRepository;
	
	public ResponseEntity<ResponseStructure<Loan>> saveLoan(Loan loan){
		Loan receivedLoan=loanDao.saveLoan(loan);
		Optional<Book> book=bookDao.fetchBookById(loan.getBook().getId());
		Optional<Member> member=memberRepository.findById(loan.getMember().getId());
		if(book.isPresent()) {
			loan.setBook(book.get());
		}
		if(member.isPresent()) {
			loan.setMember(member.get());
		}
		ResponseStructure<Loan> structure =new ResponseStructure<Loan>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("OK");
		structure.setData(receivedLoan);
		return new ResponseEntity<ResponseStructure<Loan>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<List<Loan>>> fetchAllLoan(){
		List<Loan> loans=loanDao.fetchAllLoans();
		if(loans.isEmpty()) {
			throw new NoLoanFoundException();
		}
		else {
			ResponseStructure<List<Loan>> structure=new ResponseStructure<List<Loan>>();
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Ok");
			structure.setData(loans);
			return new ResponseEntity<ResponseStructure<List<Loan>>>(structure,HttpStatus.OK);
		}
	}
	
	public ResponseEntity<ResponseStructure<Loan>> fetchBookById(int id){
		Optional<Loan> opt=loanDao.fetchLoanById(id);
		if(opt.isEmpty()) {
			throw new NoLoanFoundException();
		}
		else {
			ResponseStructure<Loan> structure=new ResponseStructure<Loan>();
			Loan loan=opt.get();
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("OK");
			structure.setData(loan);
			return new ResponseEntity<ResponseStructure<Loan>>(structure,HttpStatus.OK);
		}
		
	}
	
	public ResponseEntity<ResponseStructure<Loan>> updateLoan(Loan loan,int id){
		Optional<Loan> opt=loanDao.fetchLoanById(id);
		if(opt.isEmpty()) {
			throw new NoLoanFoundException();
		}
		else {
			ResponseStructure<Loan> structure=new ResponseStructure<Loan>();
			Loan updatedLoan= loanDao.updateLoan(loan);
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Ok");
			structure.setData(updatedLoan);
			return new ResponseEntity<ResponseStructure<Loan>>(structure,HttpStatus.OK);
		}
	}
	
	public ResponseEntity<ResponseStructure<Loan>> deleteLoan(int id){
		Optional<Loan> opt=loanDao.fetchLoanById(id);
		if(opt.isEmpty()) {
			throw new NoLoanFoundException();
		}
		else {
			ResponseStructure<Loan> structure=new ResponseStructure<Loan>();
			loanDao.deleteLoan(id);
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Ok");
			structure.setData(null);
			return new ResponseEntity<ResponseStructure<Loan>>(structure,HttpStatus.OK);
		}
	}
}
