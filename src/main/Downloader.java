package main;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class Downloader {
	private URL url;
	private BufferedImage image;
	
	public Downloader(String target, String fullName) {
		try {
			url = new URL(target);
			image = ImageIO.read(url);
			if(image != null){
				ImageIO.write(image, "jpg", new File("./Resources/" + fullName));
				System.out.println(target);
			} else {
				System.out.println("does not link to image");				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * 
	 * @return image or null if did not retrieve
	 */
	public Image getImage() {
		return image;
	}
}
