package jsp.LibraryManagement.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jsp.LibraryManagement.entity.Book;
import jsp.LibraryManagement.repository.BookRepository;

@Repository
public class BookDao {
	@Autowired
	private BookRepository bookRepository;
	
	public Book saveBook(Book book){
		return bookRepository.save(book);
	}
	
	public List<Book> fetchAllBooks(){
		return bookRepository.findAll();
	}

	public Optional<Book> fetchBookById(int id) {
		return bookRepository.findById(id);
	}
	
	public List<Book> fetchBookByGenre(String genre)
	{
		return bookRepository.findByGenre(genre);
	}
	
	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}
	
	public void deleteBook(int id) {
		bookRepository.deleteById(id);
	}
}
