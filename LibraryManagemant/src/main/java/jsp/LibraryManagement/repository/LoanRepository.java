package jsp.LibraryManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jsp.LibraryManagement.entity.Loan;

public interface LoanRepository extends JpaRepository<Loan, Integer>{

}
