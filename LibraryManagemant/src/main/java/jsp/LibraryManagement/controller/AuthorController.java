package jsp.LibraryManagement.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jsp.LibraryManagement.entity.Author;
import jsp.LibraryManagement.service.AuthorService;
import jsp.LibraryManagement.dto.ResponseStructure;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/Author")
public class AuthorController {
	@Autowired
	private AuthorService authorService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Author>> saveAuthor(@RequestBody Author author){
		return authorService.saveAuthor(author);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Author>> getAuthorById(@PathVariable int id){
		return authorService.getAuthorById(id);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Author>>> getALlAuthors(){
		return authorService.getAllAuthor();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Author>> deleteAuthor(@PathVariable int id){
		return authorService.dleteAuthorById(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ResponseStructure<Author>> updateAuthor(@RequestBody Author author,@PathVariable int id){
		return authorService.updateAuthor(author, id);
	}
}
