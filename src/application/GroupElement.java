package application;

import java.util.ArrayList;
import java.util.List;

public class GroupElement implements TreeNode{

	private List<TreeNode> groupUsers = new ArrayList<>();
	private String groupID;
	private long creationTime;
	
	public GroupElement(String groupID) {
		this.groupID = groupID;
		this.setCreationTime(System.currentTimeMillis());
	}
	
	
	@Override
	public String getID() {
		return this.groupID;
	}

	@Override
	public String toString() {
		return groupID;
	}

	@Override
	public void accept(ElementVisitor visitor) {
		visitor.visitGroup(this);
		for(TreeNode elements : groupUsers) {
			if (elements instanceof UserElement) {
				elements.accept(visitor);
			}
			
			else if (elements instanceof GroupElement) {
				elements.accept(visitor);
			}
		}
	}
	
	public void addGroup(TreeNode newGroup) {
		this.groupUsers.add(newGroup);
	}
	
    public void addGroupUsers(TreeNode newGroup){
        this.groupUsers.add(newGroup);
    }
	
	//Verify a group contain a user ID
    public Boolean containsUser(String UserID){
        for (TreeNode elements : groupUsers) {
            if (elements instanceof UserElement) {
                if (elements.getID().equals(UserID)) {
                    return true;
                }
            }
            else if (elements instanceof GroupElement) {
                if (((GroupElement) elements).containsUser(UserID)) {
                    return true;
                }
            }
        }
        return false;
    }
    
  //Check if group already contain a group ID/Name
    public Boolean containsGroup(String elementID){
        for (TreeNode elements : groupUsers) {
            if (elements instanceof UserElement) {
                continue;
            }
            // check for a group in this.groupMembers
            else if (elements instanceof GroupElement) {
                if (elements.getID().equals(elementID)){
                    return true;
                }
                //check ID of groups within groups
                else {
                    if(((GroupElement) elements).containsGroup(elementID)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    //return user in a group of a group within a group
    public UserElement getUser(String userID){
        for (TreeNode elements : groupUsers) {
            if (elements instanceof UserElement) {
                if (elements.getID().equals(userID)){
                    return (UserElement) elements;
                }
            }
            else if (elements instanceof GroupElement) {
                // iterate through all groups in group and check if the 
                //user id exist there
                if (((GroupElement) elements).containsUser(userID)) {
                    return ((GroupElement) elements).getUser(userID);
                }
            }
        }
        return null;
    }


	public long getCreationTime() {
		return creationTime;
	}


	public void setCreationTime(long creationTime) {
		this.creationTime = creationTime;
	} 

}
