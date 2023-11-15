package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UserElement extends Subject implements Observer, TreeNode{

	private String userID;
	private List<UserElement> following = new ArrayList<>();
	private ObservableList<UserElement> followingList = FXCollections.observableList(following);
	private List<String> myTweets = new ArrayList<>();
	private List<String> newsFeed = new ArrayList<>(Arrays.asList());

	private ObservableList<String> newsFeedList = FXCollections.observableList(newsFeed);
	
	public UserElement(String userID) {
		this.userID = userID;
	}
	
	@Override
	public String toString() {
		return userID;
	}
	
	@Override
	public void update(Subject subject, String message) {
		if (subject instanceof UserElement) {
			this.newsFeedList.add("- " + ((UserElement) subject).getID() + ": " + message);
		}
	}
	
	public void addFollowingList(UserElement user) {
		followingList.add(user);
	}
	
	public List<String> getTweets(){
		return myTweets;
	}
	
	public ObservableList<String> getNewsFeedList(){
		return newsFeedList;
	}
	
    public ObservableList<UserElement> getFollowingList() {
        return followingList;
    }
	
	public void tweet (String message) {
		
		myTweets.add(message);

        newsFeedList.add("-" + this.userID + " : " + message);

		notifyObservers(message);
	}

	@Override
	public String getID() {
		return userID;
	}

	@Override
	public void accept(ElementVisitor visitor) {
		visitor.visitUser(this);
	}

}
