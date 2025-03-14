package jsp.LibraryManagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jsp.LibraryManagement.entity.Member;
import jsp.LibraryManagement.repository.MemberRepository;

@Repository
public class MemberDao {
	@Autowired
	private MemberRepository memberRepository;
	
	public Member saveMember(Member member) {
		return memberRepository.save(member);
	}
	
	public List<Member> fetchAllMembers() {
		return memberRepository.findAll();
	}

	public Optional<Member> fetchMemberById(int id){
		return memberRepository.findById(id);
	}
	
	public Member updateMember(Member member) {
		return memberRepository.save(member);
	}
	
	public void deleteMember(int id) {
		memberRepository.deleteById(id);
	}
}
