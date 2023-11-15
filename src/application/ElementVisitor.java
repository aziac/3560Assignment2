package application;

public interface ElementVisitor {
	public void visitUser(UserElement user);
	public void visitGroup(GroupElement group);
}
