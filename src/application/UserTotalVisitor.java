package application;


public class UserTotalVisitor implements ElementVisitor{

	private int totalUsers = 0;
	
	@Override
	public void visitUser(UserElement user) {
		totalUsers += 1;
	}

	@Override
	public void visitGroup(GroupElement group) {
		System.out.println("Visit Group Pass");
		
	}
	
	public int getUserTotal() {
		return totalUsers;
	}

}
