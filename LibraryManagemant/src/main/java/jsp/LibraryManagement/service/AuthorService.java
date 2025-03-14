package jsp.LibraryManagement.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jsp.LibraryManagement.dao.AuthorDao;
import jsp.LibraryManagement.dto.ResponseStructure;
import jsp.LibraryManagement.entity.Author;
import jsp.LibraryManagement.exception.AuthorNotFoundException;

@Service
public class AuthorService {
	@Autowired
	private AuthorDao authorDao;
	
	public ResponseEntity<ResponseStructure<Author>> saveAuthor(Author author){
		Author recievedAuthor= authorDao.saveAuthor(author);
		
		ResponseStructure<Author> structure=new ResponseStructure<Author>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("success");
		structure.setData(recievedAuthor);
		
		return new ResponseEntity<ResponseStructure<Author>>(structure,HttpStatus.CREATED);
	}
	
	
	public ResponseEntity<ResponseStructure<Author>> getAuthorById(int id){
		Optional<Author> opt=authorDao.getAuthor(id);
		ResponseStructure<Author> structure=new ResponseStructure<Author>();
		if(opt.isEmpty()) {
			throw new AuthorNotFoundException();
		}
		else {
			Author author=opt.get();
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("OK");
			structure.setData(author);
			return new ResponseEntity<ResponseStructure<Author>>(structure,HttpStatus.OK);
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Author>>> getAllAuthor(){
		List<Author> authors=authorDao.fetchALl();
		ResponseStructure<List<Author>> structure=new ResponseStructure<List<Author>>();
		if(authors.isEmpty()) {
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			structure.setMessage("Not Found");
			structure.setData(null);
			return new ResponseEntity<ResponseStructure<List<Author>>>(structure,HttpStatus.NOT_FOUND);
		}
		else {
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Ok");
			structure.setData(authors);
			return new ResponseEntity<ResponseStructure<List<Author>>>(structure,HttpStatus.OK);
		}
	}
	
	public ResponseEntity<ResponseStructure<Author>> dleteAuthorById(int id){
		ResponseStructure<Author> structure=new ResponseStructure<Author>();
		Optional<Author> opt= authorDao.getAuthor(id);
		if(opt.isEmpty()) {
			throw new AuthorNotFoundException();
		}
		else {
			authorDao.removeAuthor(id);
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Author with id "+id+" deleted");
			structure.setData(null);
			return new ResponseEntity<ResponseStructure<Author>>(structure,HttpStatus.OK);
		}
	}
	
	public ResponseEntity<ResponseStructure<Author>> updateAuthor(Author author,int id){
		ResponseStructure<Author> structure=new ResponseStructure<Author>();
		Optional<Author> opt= authorDao.getAuthor(id);
		if(opt.isEmpty()) {
			throw new AuthorNotFoundException();
		}
		else {
			Author updatedAuthor=authorDao.saveAuthor(author);
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("OK");
			structure.setData(updatedAuthor);
			return new ResponseEntity<ResponseStructure<Author>>(structure,HttpStatus.OK);
		}
		
	}

}
