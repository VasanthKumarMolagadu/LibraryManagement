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
import jsp.LibraryManagement.entity.Member;
import jsp.LibraryManagement.service.MemberService;

@RestController
@RequestMapping("/Member")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Member>> saveMember(@RequestBody Member member){
		return memberService.saveMember(member);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Member>>> fetchAllMember(){
		return memberService.fetchAllMembers();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Member>> fetchMemberById(@PathVariable int id){
		return memberService.fetchMemberById(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ResponseStructure<Member>> updateMember(@RequestBody Member member,@PathVariable int id){
		return memberService.updateMember(member,id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Member>> deleteMember(@PathVariable int id){
		return memberService.deleteMemberById(id);
	}
}
