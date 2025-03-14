package jsp.LibraryManagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jsp.LibraryManagement.entity.Author;
import jsp.LibraryManagement.repository.AuthorRepository;

@Repository
public class AuthorDao {
	
	@Autowired
	private AuthorRepository authorRepository;
	
	public Author saveAuthor(Author author) {
		return authorRepository.save(author);
	}
	
	public Optional<Author> getAuthor(int id) {
		return authorRepository.findById(id);
	}
	
	public List<Author> fetchALl(){
		return authorRepository.findAll();
	}
	
	public void removeAuthor(int id) {
		authorRepository.deleteById(id);
	}
	
	public Author updateAuthor(Author author) {
		return authorRepository.save(author);
	}
}
