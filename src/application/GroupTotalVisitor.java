package application;

public class GroupTotalVisitor implements ElementVisitor{

	private int totalGroups = 0;
	
	@Override
	public void visitUser(UserElement user) {
		System.out.println("Visit User Pass");
	}

	@Override
	public void visitGroup(GroupElement group) {
		totalGroups += 1;
	}
	
	public int getGroupTotal() {
		return totalGroups;
	}

}
