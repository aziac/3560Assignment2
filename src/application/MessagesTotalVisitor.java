package application;

public class MessagesTotalVisitor implements ElementVisitor{
	private int totalMessages = 0;

	@Override
	public void visitUser(UserElement user) {
		totalMessages += user.getTweets().size();
	}

	@Override
	public void visitGroup(GroupElement group) {
		System.out.println("Visit Group Pass");
	}
	
	public int getMessageTotal() {
		return totalMessages;
	}
	
	
}
