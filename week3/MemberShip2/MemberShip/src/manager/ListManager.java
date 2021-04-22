package manager;

import java.util.ArrayList;
import java.util.Arrays;

import member.Member;

public class ListManager {

	private ArrayList<Member> memberList;
	   //To-do 회원 관리를 위해 ArrayList를 활용하고, 회원을 추가,삭제, 모든회원을 보여주는 세가지 기능을 제공합니다.
	
	   //To-do 생성자를 통해 새로운 멤버리스트를 만듭니다.
		public ListManager() {
			memberList = new ArrayList<Member>();
		}
	   //To-do 회원을 추가하는 메서드를 만듭니다.
		public void addMember(Member member) {
			memberList.add(member);
		}
	   //To-do 회원을 삭제하는 메서드를 만듭니다.
		public void removeMember(Member memberName) {
			memberList.remove(memberName);
		}	   
	   //To-do 모든 회원을 보여주는 메서드를 구현 합니다.
		public void showAllMember() {	
			for(Member memberListi : memberList) {
				System.out.println(memberListi);
			}
		}
		
	   //To-do 회원정보를 가져오는 getter를 제공합니다.
		public ArrayList<Member> getMemberList() {
			return memberList;
		}
		
}
