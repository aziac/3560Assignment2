package application;

public interface TreeNode {
	String getID();
	
	String toString();
	
	public void accept(ElementVisitor visitor);
}
