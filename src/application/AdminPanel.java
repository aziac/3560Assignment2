package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class AdminPanel {
	
	private static AdminPanel instance;
	private TreeView<TreeNode> treeview;
	private Image folderIcon;
	GroupElement rootGroup;
	
	private AdminPanel() {
		folderIcon = new Image(getClass().getResourceAsStream("folder.png"));
		rootGroup = new GroupElement("Root");
	}
	
	public static AdminPanel getInstance() {
		if (instance == null) {
			instance = new AdminPanel();
		}
		return instance;
	}
	
	public void setTreeView(TreeView<TreeNode> treeview) {
		this.treeview = treeview;
		
		TreeItem<TreeNode> rootItem = new TreeItem<>(rootGroup, new ImageView(folderIcon));
		treeview.setRoot(rootItem);
	}
	
	public void addUser(String userID, TreeItem<TreeNode> selected) {
        if(rootGroup.containsUser(userID)){
        }
        else{
            UserElement temp = new UserElement(userID);
            ((GroupElement) selected.getValue()).addGroupUsers(temp);
            selected.getChildren().add(new TreeItem<>(temp));
        }
	}

	public void addGroup(String groupID, TreeItem<TreeNode> selected) {
        if(rootGroup.containsGroup(groupID)){
        }
        else{
        	GroupElement temp=new GroupElement(groupID);
            ((GroupElement) selected.getValue()).addGroupUsers(temp);
            selected.getChildren().add(new TreeItem<>(temp, new ImageView(folderIcon)));
        }
	}
	
	public void openUserView(TreeItem<TreeNode> selected) {
		if(selected.getValue() instanceof UserElement) {
			UserElement user = (UserElement) selected.getValue();
			
			Stage stage=new Stage();
			Parent root;
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/UserMain.fxml"));
				root = loader.load();

				UserController userController = loader.getController();
				userController.setUser(user);
				userController.setGroup(rootGroup);
				
				Scene scene = new Scene(root);
				
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

				stage.setTitle(user.getID()+ "'s Account");
				stage.setScene(scene);

				stage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void showUserTotal(Label visitorLabel) {
		UserTotalVisitor visitor = new UserTotalVisitor();
		rootGroup.accept(visitor);
		visitorLabel.setText("User total: " + visitor.getUserTotal());
	}

	public void showGroupTotal(Label visitorLabel) {
		GroupTotalVisitor visitor = new GroupTotalVisitor();
		rootGroup.accept(visitor);
		visitorLabel.setText("Group total: " + visitor.getGroupTotal());
	}

	public void showPositivePercentage(Label visitorLabel) {
		PositivityVisitor visitor = new PositivityVisitor();
		rootGroup.accept(visitor);
		visitorLabel.setText("Positivity percent: " + visitor.getPositivePercent());
	}

	public void showMessagesTotal(Label visitorLabel) {
		MessagesTotalVisitor visitor = new MessagesTotalVisitor();
		rootGroup.accept(visitor);
		visitorLabel.setText("Messages total: " + visitor.getMessageTotal());
	}
}
