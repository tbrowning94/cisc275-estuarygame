package cisc275.game.controller;
import java.awt.Point;

import cisc275.game.model.Level;
public interface Action<L extends Level> {
	boolean isValid(Level l);
	void update(Level l);
	boolean equals(Object obj);
}
