package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * System information dialog. Display program information.
 * 
 * @author shiz
 * @since 4/24/14
 */
public class SystemInformationDlg extends JDialog implements ActionListener {
	
	private static final long serialVersionUID = -2344693703681850081L;

	public SystemInformationDlg() {
		//scan text data
		File file = new File("about.txt");
		Scanner fileStream = null;
		try {
			fileStream = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File cannot be found.");
			e.printStackTrace();
		}
		
		String line  = "<HTML>";
		while (fileStream.hasNextLine()) {
			line += fileStream.nextLine();
			line += "<BR>";
		}
		line.endsWith("<HTML>");
		
		//grab icon image
		File sourceImage = new File("res/about_icon.png");
		Image image = null;
		try {
			image = ImageIO.read(sourceImage);
		} catch (IOException e) {
			System.out.println("Invalid IO");
			e.printStackTrace();
		}
		
		//Set layout, display message.
		setTitle("About");
		setIconImage(image);
		setSize(200,300);
		setAlwaysOnTop(true);
		JPanel messagePane = new JPanel();
		messagePane.add(new JLabel(line));
		JPanel buttonPane = new JPanel();
		JButton button = new JButton("OK");
		buttonPane.add(button);
		button.addActionListener(this);
		getContentPane().add(messagePane);
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		dispose();
	}

}
