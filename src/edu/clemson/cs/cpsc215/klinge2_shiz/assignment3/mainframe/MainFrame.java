package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.mainframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JViewport;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.Contact;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.CryptographyException;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.DataStore;

/**
 * Main window of the simple mail program. User Interface
 * 
 * @author shiz
 * @author klinge2
 * @since 4/25/14
 */
@SuppressWarnings("serial")
public class MainFrame extends JFrame  {
	
	public static void main(String [] args) {
	    Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
	        public void run() {
				DataStore storage = DataStore.getInstance();
				try {
					storage.storeConf();
				} catch (Exception ex) {
					System.out.println("Error aving config file.");
					System.out.println(ex.getMessage());
				}
				try {
					storage.storeContacts();
				} catch (Exception ex) {
					System.out.println("Error saving contacts.");
					System.out.println(ex.getMessage());
				}
				try {
					storage.storeDrafts();
				} catch (Exception ex) {
					System.out.println("Error saving drafts.");
					System.out.println(ex.getMessage());
				}
	        }
	    }, "Shutdown-thread"));
		
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
	    JMenu fileNewMenu = new JMenu("New");
	    JMenuItem compose = new MenuItemCompose(med);
	    JMenuItem exit = new MenuItemExit(med);
	    fileNewMenu.add(compose);
	    fileMenu.add(fileNewMenu);
	    fileMenu.add(exit);

	    JMenu editMenu = new JMenu("Edit");
	    JMenu editClearMenu = new JMenu("Clear");
	    JMenuItem clearContacts = new MenuItemClearContacts(med);
	    JMenuItem clearDrafts = new MenuItemClearDrafts(med);
	    JMenuItem config = new MenuItemConfig(med);
	    editClearMenu.add(clearContacts);
	    editClearMenu.add(clearDrafts);
	    editMenu.add(editClearMenu);
	    editMenu.add(config);

	    JMenu helpMenu = new JMenu("Help");
	    JMenuItem about = new MenuItemAbout(med);
	    helpMenu.add(about);

	    menuBar.add(fileMenu);
	    menuBar.add(editMenu);
	    menuBar.add(helpMenu);

	    JTabbedPane tabPane = new JTabbedPane();

        ContactTable contactTable = new ContactTable(new ContactTableModel(), med);
	    tabPane.add("Contacts", new JScrollPane(contactTable, 
	            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS));
	    
	    DraftTable draftTable = new DraftTable(new DraftTableModel(), med);
	    tabPane.add("Drafts", new JScrollPane(draftTable, 
	            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS));
	    
	    this.add(tabPane);

	    this.setJMenuBar(menuBar);
	    this.pack();
	    this.setLocationByPlatform(true);
	}
}
