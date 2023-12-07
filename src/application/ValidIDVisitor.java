package application;

// I've already implemented no duplicate names but i'll still add the check

import java.util.ArrayList;

public class ValidIDVisitor implements ElementVisitor{
	
	String validationMessage = "All users are valid";
	ArrayList<String> list = new ArrayList<String>();

	@Override
	public void visitUser(UserElement user) {
		String temp = user.getID();
		if (list.contains(temp)) {
			validationMessage = "There are duplicate user IDs";
		}
		else if (temp.contains(" ")) {
			validationMessage = "There are whitespaces in user IDs";
		}
	}
		

	@Override
	public void visitGroup(GroupElement group) {
		System.out.println("No validation for groups");
	}
	
	public String getValidationMessage() {
		return validationMessage;
	}
	
	
}
