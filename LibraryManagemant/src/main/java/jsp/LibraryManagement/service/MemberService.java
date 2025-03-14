package jsp.LibraryManagement.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jsp.LibraryManagement.dao.MemberDao;
import jsp.LibraryManagement.dto.ResponseStructure;
import jsp.LibraryManagement.entity.Member;
import jsp.LibraryManagement.exception.NoMemberFoundException;

@Service
public class MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
	public ResponseEntity<ResponseStructure<Member>> saveMember(Member member){
		memberDao.saveMember(member);
		ResponseStructure<Member> structure =new ResponseStructure<Member>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("Ok");
		structure.setData(member);
		return new ResponseEntity<ResponseStructure<Member>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<List<Member>>> fetchAllMembers(){
		List<Member> members=memberDao.fetchAllMembers();
		
		if(members.isEmpty()) {
			throw new NoMemberFoundException();
		}
		else {
			ResponseStructure<List<Member>>structure =new ResponseStructure<List<Member>>();
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Ok");
			structure.setData(members);
			return new ResponseEntity<ResponseStructure<List<Member>>>(structure,HttpStatus.OK);
		}
		
	}
	
	public ResponseEntity<ResponseStructure<Member>> fetchMemberById(int id){
		Optional<Member> opt=memberDao.fetchMemberById(id);
		if(opt.isEmpty()) {
			throw new NoMemberFoundException();
		}
		else {
			ResponseStructure<Member> structure =new ResponseStructure<Member>();
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Ok");
			structure.setData(opt.get());
			return new ResponseEntity<ResponseStructure<Member>>(structure,HttpStatus.OK);
		}
		
	}
	
	public ResponseEntity<ResponseStructure<Member>> updateMember(Member member,int id){
		Optional<Member> opt=memberDao.fetchMemberById(id);
		if(opt.isEmpty()) {
			throw new NoMemberFoundException();
		}
		else {
		memberDao.updateMember(member);
		ResponseStructure<Member> structure =new ResponseStructure<Member>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("Ok");
		structure.setData(member);
		return new ResponseEntity<ResponseStructure<Member>>(structure,HttpStatus.OK);
		}
	}
	
	
	public ResponseEntity<ResponseStructure<Member>> deleteMemberById(int id){
		ResponseStructure<Member> structure=new ResponseStructure<Member>();
		Optional<Member> opt=memberDao.fetchMemberById(id);
		if(opt.isEmpty()) {
			throw new NoMemberFoundException();
		}
		else {
			memberDao.deleteMember(id);
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Ok");
			structure.setData(null);
			return new ResponseEntity<ResponseStructure<Member>>(structure,HttpStatus.OK);
		}
	}

}
