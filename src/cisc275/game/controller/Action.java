package cisc275.game.controller;
import java.awt.Point;
public interface Action {
	boolean isValid();
	void update();
	boolean equals();
}
