package jsp.LibraryManagement.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jsp.LibraryManagement.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
	
	List<Book> findByGenre(String genre);
}
