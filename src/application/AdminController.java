package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AdminController implements Initializable{ 
	
	@FXML
	private TreeView treeview;
	
	@FXML
	private TextField userInputID;
	
	@FXML
	private TextField groupInputID;
	
	@FXML
	private Label visitorLabel;

	private AdminPanel adminPanel = AdminPanel.getInstance();
		
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		adminPanel.setTreeView(treeview);
	}
	
	public void addUser(ActionEvent e) {
        TreeItem<TreeNode> selectedUser = (TreeItem<TreeNode>) treeview.getSelectionModel().getSelectedItem();
		String userID = userInputID.getText();
		adminPanel.addUser(userID, selectedUser);
		System.out.println("Add User");
	}
	
	public void addGroup(ActionEvent e) {
		String groupID = groupInputID.getText();
        TreeItem<TreeNode> selectedGroup = (TreeItem<TreeNode>) treeview.getSelectionModel().getSelectedItem();
		adminPanel.addGroup(groupID, selectedGroup);
		System.out.println("Add Group");
	}

	public void selectItem() {
		TreeItem<TreeNode> item = (TreeItem<TreeNode>) treeview.getSelectionModel().getSelectedItem();
		if(item != null) {
			System.out.println(item.getValue());
		}
	}
	
	public void openUserView(ActionEvent e) {
        TreeItem<TreeNode> selectedUser = (TreeItem<TreeNode>) treeview.getSelectionModel().getSelectedItem();
        adminPanel.openUserView(selectedUser);
	}
	
	public void showGroupTotal(ActionEvent e) {
		adminPanel.showGroupTotal(visitorLabel);
		System.out.println("Show Group Total");
	}

	public void showUserTotal(ActionEvent e) {
		adminPanel.showUserTotal(visitorLabel);
		System.out.println("Show User Total");
	}
	
	public void showMessagesTotal() {
		adminPanel.showMessagesTotal(visitorLabel);
		System.out.println("Show Messages Total");
	}
	
	public void showPositivePercentage() {
		adminPanel.showPositivePercentage(visitorLabel);
		System.out.println("Show positive Total");
	}

	public void showLastUpdate() {
		adminPanel.showLastUpdate(visitorLabel);
		System.out.println("Show last update");
	}

	public void verifyUsers() {
		adminPanel.verifyUsers(visitorLabel);
		System.out.println("Verify Users");
	}
}
