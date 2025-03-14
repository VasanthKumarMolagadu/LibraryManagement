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
import jsp.LibraryManagement.entity.Book;
import jsp.LibraryManagement.service.BookService;

@RestController
@RequestMapping("/Book")
public class BookController {
	@Autowired
	private BookService bookService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Book>> saveBook(@RequestBody Book book){
		return bookService.saveBook(book);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Book>>> fetchAllBooks(){
		return bookService.fetchAllBooks();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Book>> fetchBookById(@PathVariable int id){
		return bookService.fetchBookById(id);
	}
	
	@GetMapping("/by/{genre}")
	public ResponseEntity<ResponseStructure<List<Book>>> fetchBookByGenre(@PathVariable String genre){
		return bookService.fetchBookByGenre(genre);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ResponseStructure<Book>> updateBook(@RequestBody Book book,@PathVariable int id){
		return bookService.updateBook(book, id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Book>> deleteBook(@PathVariable int id){
		return bookService.deleteBook(id);
	}
}

