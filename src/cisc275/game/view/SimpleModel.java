package cisc275.game.view;

import java.beans.PropertyChangeListener;

import javax.swing.event.SwingPropertyChangeSupport;

public class SimpleModel {
	private SwingPropertyChangeSupport pcSupport = new SwingPropertyChangeSupport(this);
	private enum click {
		plant1, plant2, plant3, gC1, gC2, gC3
	}
	private String eState;
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcSupport.addPropertyChangeListener(listener);
	}
	
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		pcSupport.removePropertyChangeListener(listener);
	}
	
	public void setEnum(String click) {
		String oldValue = this.eState;
		String newValue = click;
		this.eState = click;
		pcSupport.firePropertyChange(click, oldValue, newValue);
	}
	
	public String getEnum() {
		return this.eState;
	}
	
}
