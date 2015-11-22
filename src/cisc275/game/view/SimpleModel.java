package cisc275.game.view;

import java.beans.PropertyChangeListener;

import javax.swing.event.SwingPropertyChangeSupport;

public class SimpleModel {
	private SwingPropertyChangeSupport pcSupport = new SwingPropertyChangeSupport(this);
	public static final String ACTION_TEXT = "action text";
	private String aState;

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcSupport.addPropertyChangeListener(listener);
	}
	
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		pcSupport.removePropertyChangeListener(listener);
	}
	
	public void setAction(String click) {
		System.out.println("click: "+click);
		String oldValue = this.aState;
		String newValue = click;
		this.aState = click;
		pcSupport.firePropertyChange(ACTION_TEXT, oldValue, newValue);
	}
	
	public String getAction() {
		return this.aState;
	}
	
}
