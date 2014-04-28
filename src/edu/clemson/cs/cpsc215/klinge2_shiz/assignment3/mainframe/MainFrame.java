package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.mainframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.Contact;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.DataStore;

/**
 * Main window of the simple mail program. User Interface
 * 
 * @author shiz
 * @author klinge2
 * @since 4/25/14
 */
@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	public static void main(String [] args) {
		try {
			UIManager.setLookAndFeel(
					UIManager.getSystemLookAndFeelClassName());
//			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
//				if ("Nimbus".equals(info.getName())) {
//					UIManager.setLookAndFeel(info.getClassName());
//					break;
//				}
//			}
		} catch (Exception e) {
			System.out.println("Unable to modify look and feel.");
		}
		
		List<Contact> contacts = DataStore.getInstance().getContacts();
		if (contacts.size() == 0) {
		    contacts.add(new Contact("Adam Klingenberger", "106 Saddlehorn Ct.",
		            "919-414-3589", "klinge3@g.clemson.edu"));
		    contacts.add(new Contact("Donald Medlin", "123 Pine St.",
		            "911-455-3483", "dmedlin@g.clemson.edu"));
		}
		
		//set up frame
		MainFrame frame = new MainFrame();
		frame.addComponents();
		frame.setVisible(true);
	}
	
	public void addComponents() {
	    Color color = Color.gray;

	    //grab icon image from file
	    File sourceimage = new File("res/email.png");
	    Image image = null;
	    try {
	        image = ImageIO.read(sourceimage);
	    } catch (IOException e) {
	        System.out.println("Invalid image");
	        e.printStackTrace();
	    }
	    
	    this.setTitle("SimpleMail");
	    this.setIconImage(image);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setSize(400, 500);
	    this.setLayout(new BorderLayout());
	    this.getContentPane().setSize(350, 500);

	    MainFrameMediator med = new MainFrameMediator();
	    med.registerFrame(this);

	    JMenuBar menuBar = new JMenuBar();
	    //menuBar.setOpaque(true);
	    //menuBar.setBackground(color);

	    JMenu fileMenu = new JMenu("File");
	    JMenuItem exit = new MenuItemExit(med);
	    fileMenu.add(exit);

	    JMenu configMenu = new JMenu("Configuration");
	    JMenuItem config = new MenuItemConfig(med);
	    configMenu.add(config);

	    JMenu helpMenu = new JMenu("Help");
	    JMenuItem about = new MenuItemAbout(med);
	    helpMenu.add(about);

	    menuBar.add(fileMenu);
	    menuBar.add(configMenu);
	    menuBar.add(helpMenu);

        ContactTable table = new ContactTable(new TableModel(), med);
	    this.getContentPane().add(new JScrollPane(table, 
	            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS));

	    this.setJMenuBar(menuBar);
	    menuBar.validate();
	    this.pack();
	    this.setLocationByPlatform(true);
	}
}
