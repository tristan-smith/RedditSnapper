package main;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;

public class TestGUI extends JFrame {
	Image img;
	JPanel j;
	
	public TestGUI(Image i, String title){
		setSize(250, 250);
		setTitle(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		img = i;
		setVisible(true);
		j = new JPanel() {
			@Override
			public void paintComponent(Graphics g){
				super.paintComponent(g);
				g.drawImage(img, 0, 0, null);
			}
		};
		this.add(j);
	}
}
