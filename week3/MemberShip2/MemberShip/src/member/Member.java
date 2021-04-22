package member;

public class Member implements Comparable<Member> {
	   //To-do 일반 회원 클래스의 속성은 아이디, 이름, 등급(FAMILY) 세가지 입니다.
	   protected int memberID;
	   protected String memberName;
	   protected String memberGrade;
	   
	   public Member() {
	   //To-do 일반 멤버의 기본 등급을 FAMILY로 만들어 줍니다.
		   initMember();
	   }
	   
		public Member(int memberID, String memberName) {
			// To-do 일반 회원 클래스의 각 속성에 getter/setter를 제공합니다.
			this.memberID=memberID;
			this.memberName=memberName;	
			 initMember();
		   }
		private void initMember() {
			   memberGrade = "FAMILY";
		   }
		   
		public int getMemberID() {
			return memberID;
		}
		public void setMemberID(int memberID) {
			this.memberID = memberID;
		}

		public void setMemberName(String memberName) {
			this.memberName = memberName;
		}

		public String getMemberName() {
			return memberName;
		}


	public String showMemberInfo() {
	      // To-do 회원 정보를 보여주는 showMemberInfo 메서드를 구현합니다.
	      return memberID + " 님의 등급은 " + memberGrade + "입니다.";
	}
	   
	   //To-do 회원을 이름 순으로 정렬하기 위해 Comparable 메서드를 구현합니다.
	@Override
	public int compareTo(Member member) {
		return this.memberName.compareTo(member.getMemberName());	
	}
	@Override
	public String toString() { 
		// TODO Auto-generated method stub 
		return memberName + "회원님의 아이디는" +memberID+"입니다."; 
		}
}