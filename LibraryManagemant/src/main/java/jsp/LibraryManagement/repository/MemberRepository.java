package jsp.LibraryManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jsp.LibraryManagement.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Integer>{

}
