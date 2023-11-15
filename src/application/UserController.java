package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UserController {
	
	@FXML
	TextField tweetInput;
	
	@FXML
	TextField followUserID;
	
	@FXML
	ListView<UserElement> currentlyFollowing;

	@FXML
	ListView<String> newsFeed;
	
	private UserElement user;
	private GroupElement group;
	
	public void setUser(UserElement user) {
		this.user = user;
		currentlyFollowing.setItems(user.getFollowingList());
		newsFeed.setItems(user.getNewsFeedList());
		System.out.println(user);
	}

	public void setGroup(GroupElement group) {
		this.group = group;
		System.out.println(group);
	}
	
	public void followUser(ActionEvent e) {
		String userFollow = followUserID.getText();
		UserElement followRequest = group.getUser(userFollow);
        if(followRequest == user){
        	System.out.println("Yourself");
        }
        else if(followRequest == null){
        	System.out.println("Doesn't exist");
        }
        else if(user.getFollowingList().contains(followRequest)){
        	System.out.println("ALready Following");
        }
        else{ 
            followRequest.attach(user);
            user.addFollowingList(followRequest);
        }	
    }
	
	
	
	
	public void postTweet() {
		String tweet = tweetInput.getText();
		user.tweet(tweet);
	}

}
