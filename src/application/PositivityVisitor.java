package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PositivityVisitor implements ElementVisitor{
	
	private double positiveMsgs = 0;
	private double totalMsgs = 0;
	private double positivePercent = 0;
	private List<String> positiveWords = new ArrayList<>(Arrays.asList("good",
			"great", "awesome"));

	@Override
	public void visitUser(UserElement user) {
        for (String message : user.getTweets()){
            totalMsgs +=1;
            for (String positive : positiveWords){
                if (message.toLowerCase().contains(positive.toLowerCase())){
                    positiveMsgs +=1;
                    break;
                }
            }
        }		
	}

	@Override
	public void visitGroup(GroupElement group) {
		System.out.println("Nothing done");
	}
	
	public double getPositivePercent() {
		positivePercent = ((positiveMsgs/totalMsgs) * 100);
		return positivePercent;
	}

}
