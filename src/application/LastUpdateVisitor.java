package application;

public class LastUpdateVisitor implements ElementVisitor{
	
	String lastUpdatedUser = "None";
	long mostUpdatedTime = 0;

	@Override
	public void visitUser(UserElement user) {
		
		if (user.getLastUpdateTime() > mostUpdatedTime) {
			mostUpdatedTime = user.getLastUpdateTime();
			lastUpdatedUser = user.getID();
		}
		
	}

	@Override
	public void visitGroup(GroupElement group) {
		System.out.println("Nothing done");
	}
	
	public String getLastUpdateUser() {
		return lastUpdatedUser;
	}
	

}
