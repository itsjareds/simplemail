package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class MainFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String args[]){
		Color color = Color.gray;
		
		URL imageUrl = null;
		try {
			imageUrl = new URL("http://tourbusradiosupply.com/images/email.png");
		} catch (MalformedURLException e) {
			System.out.println("Invalid URL");
			e.printStackTrace();
		}
		
		Image image = null;
		try {
			image = ImageIO.read(imageUrl);
		} catch (IOException e) {
			System.out.println("Invalid Image");
			e.printStackTrace();
		}

		JFrame frame = new JFrame("Email");
		frame.setIconImage(image);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 500);
		frame.setLayout(new BorderLayout());
		frame.getContentPane().setSize(350, 500);
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setOpaque(true);
		menuBar.setBackground(color);
		
		JMenu fileMenu = new JMenu("File");
		fileMenu.add("Exit");
		JMenu configMenu = new JMenu("Configuration");
		configMenu.add("Configure");
		JMenu helpMenu = new JMenu("Help");
		helpMenu.add("About");

		menuBar.add(fileMenu);
		menuBar.add(configMenu);
		menuBar.add(helpMenu);
		frame.setJMenuBar(menuBar);
		frame.pack();
		frame.setVisible(true);
		
	}
	
}