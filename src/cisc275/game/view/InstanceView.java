package cisc275.game.view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class InstanceView {

	public InstanceView() {
		
	}
	protected static BufferedImage createImage(String file) {
        BufferedImage bufferedImage;
        try {
        	bufferedImage=ImageIO.read(new File(file));
            return bufferedImage;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
