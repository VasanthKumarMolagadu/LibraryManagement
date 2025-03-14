package jsp.LibraryManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jsp.LibraryManagement.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer>{

}
