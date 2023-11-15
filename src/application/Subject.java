package application;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
	
	private List<Observer> observers = new ArrayList<>();
	
	public void attach(Observer observer) {
		observers.add(observer);
	}
	
	public void notifyObservers(String message) {
		for(Observer ob : this.observers) {
			ob.update(this, message);
		}
	}
}
