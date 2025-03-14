package jsp.LibraryManagement.service;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jsp.LibraryManagement.dao.AuthorDao;
import jsp.LibraryManagement.dao.BookDao;
import jsp.LibraryManagement.dto.ResponseStructure;
import jsp.LibraryManagement.entity.Author;
import jsp.LibraryManagement.entity.Book;
import jsp.LibraryManagement.exception.NoBookFoundException;

@Service
public class BookService {
	@Autowired
	private BookDao bookDao;
	@Autowired
	private AuthorDao authorDao;
	
	public ResponseEntity<ResponseStructure<Book>> saveBook(Book book){
		Book savedBook=bookDao.saveBook(book);
		Optional<Author> author=authorDao.getAuthor(book.getAuthor().getId());
		if(author.isPresent()) {
			book.setAuthor(author.get());
		}
		ResponseStructure<Book> structure=new ResponseStructure<Book>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("Success");
		structure.setData(savedBook);
		return new ResponseEntity<ResponseStructure<Book>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<List<Book>>> fetchAllBooks(){
		ResponseStructure<List<Book>> structure=new ResponseStructure<List<Book>>();
		List<Book> books=bookDao.fetchAllBooks();
		if(books.isEmpty()) {
			throw new NoBookFoundException();
		}
		else {
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Ok");
			structure.setData(books);
			return new ResponseEntity<ResponseStructure<List<Book>>>(structure,HttpStatus.OK);
		}
	}
	
	public ResponseEntity<ResponseStructure<Book>> fetchBookById(int id){
		ResponseStructure<Book> structure=new ResponseStructure<Book>();
		Optional<Book> opt=bookDao.fetchBookById(id);
		if(opt.isEmpty()) {
			throw new NoBookFoundException();
		}
		else {
			Book book=opt.get();
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("OK");
			structure.setData(book);
			return new ResponseEntity<ResponseStructure<Book>>(structure,HttpStatus.OK);
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Book>>> fetchBookByGenre(String genre){
		ResponseStructure<List<Book>> structure=new ResponseStructure<List<Book>>();
		List<Book> books=bookDao.fetchBookByGenre(genre);
		if(books.isEmpty()) {
			throw new NoBookFoundException();
		}
		else {
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Ok");
			structure.setData(books);
			return new ResponseEntity<ResponseStructure<List<Book>>>(structure,HttpStatus.OK);
		}
	}
	
	public ResponseEntity<ResponseStructure<Book>> updateBook(Book book,int id){
		ResponseStructure<Book> structure=new ResponseStructure<Book>();
		Optional<Book> opt=bookDao.fetchBookById(id);
		if(opt.isEmpty()) {
			throw new NoBookFoundException();
		}
		else {
			Book updatedbook= bookDao.updateBook(book);
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Ok");
			structure.setData(updatedbook);
			return new ResponseEntity<ResponseStructure<Book>>(structure,HttpStatus.OK);
		}
	}
	
	public ResponseEntity<ResponseStructure<Book>> deleteBook(int id){
		ResponseStructure<Book> structure=new ResponseStructure<Book>();
		Optional<Book> opt=bookDao.fetchBookById(id);
		if(opt.isEmpty()) {
			throw new NoBookFoundException();
		}
		else {
			bookDao.deleteBook(id);
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Ok");
			structure.setData(null);
			return new ResponseEntity<ResponseStructure<Book>>(structure,HttpStatus.OK);
		}
	}
}
