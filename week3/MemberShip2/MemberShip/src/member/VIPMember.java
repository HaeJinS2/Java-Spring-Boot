package member;

public class VIPMember extends Member{
	   // To-do VIPMember는 Member에서 상속을 받습니다.
	   // To-do 전담 상담원 아이디 속성을 추가합니다
		private int agentID;
	   
	   public VIPMember (int memberID, String memberName, int agentID) {
	      // To-do 등급을 VIP로 설정해 줍니다.
		   super(memberID, memberName);
		
		   memberGrade = "VIP";
		   this.agentID=agentID;
	   }
	   
	   public String showMemberInfo() {
	      // To-do VIP 정보를 보여주는 showMemberInfo 메서드를 재정의하고, 상담원 정보도 보여주도록 합니다      
	      return super.showMemberInfo()+"담당 상담원 번호는"+agentID+"입니다";
	   }
	   
	    public int getagentID() {
	    	return agentID;
	    }
}