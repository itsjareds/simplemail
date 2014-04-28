package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.mainframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ListSelectionModel;
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
//			UIManager.setLookAndFeel(
//					UIManager.getSystemLookAndFeelClassName());
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
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
	    //grab icon images from file
	    File sourceImage = new File("res/email.png");
	    Image image = null;
	    File aboutImage = new File("res/about.png");
	    Image aboutIcon = null;
	    File configImage = new File("res/setting.png");
	    Image configIcon = null;
	    File exitImage = new File("res/exit.png");
	    Image exitIcon = null;
	    try {
	        image = ImageIO.read(sourceImage);
	    	aboutIcon = ImageIO.read(aboutImage);
	    	configIcon = ImageIO.read(configImage);
	    	exitIcon = ImageIO.read(exitImage);
	    } catch (IOException e){
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
	    JMenuItem newContact = new MenuItemNewContact(med);
	    JMenuItem exit = new MenuItemExit(med);
	    exit.setIcon(new ImageIcon(exitIcon));
	    fileNewMenu.add(compose);
	    fileNewMenu.add(newContact);
	    fileMenu.add(fileNewMenu);
	    fileMenu.add(exit);

	    JMenu editMenu = new JMenu("Edit");
	    JMenu editClearMenu = new JMenu("Clear");
	    JMenuItem clearContacts = new MenuItemClearContacts(med);
	    JMenuItem clearDrafts = new MenuItemClearDrafts(med);
	    JMenuItem config = new MenuItemConfig(med);
	    config.setIcon(new ImageIcon(configIcon));
	    editClearMenu.add(clearContacts);
	    editClearMenu.add(clearDrafts);
	    editMenu.add(editClearMenu);
	    editMenu.add(config);

	    JMenu helpMenu = new JMenu("Help");
	    JMenuItem about = new MenuItemAbout(med);
	    about.setIcon(new ImageIcon(aboutIcon));
	    helpMenu.add(about);

	    menuBar.add(fileMenu);
	    menuBar.add(editMenu);
	    menuBar.add(helpMenu);

	    JTabbedPane tabPane = new JTabbedPane();

	    JPanel contactsPanel = new JPanel();
	    contactsPanel.setLayout(new BorderLayout());
	    
        ContactTable contactTable = new ContactTable(new ContactTableModel(), med);
	    contactsPanel.add(new JScrollPane(contactTable, 
	            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS), BorderLayout.NORTH);

	    JPanel buttonPane = new JPanel();
	    buttonPane.setLayout(new GridBagLayout());
	    GridBagConstraints c;
	    
	    JButton button;
	    
	    int x = 0;
	    
	    // Buttons
	    
	    button = new ButtonAdd(med);
	    c = new GridBagConstraints();
	    c.gridx = x++;
	    c.gridwidth = 1;
	    c.weightx = 2;
	    c.anchor = GridBagConstraints.WEST;
	    c.fill = GridBagConstraints.HORIZONTAL;
	    buttonPane.add(button,c);
	    
	    button = new ButtonEdit(med);
	    c = new GridBagConstraints();
	    c.gridx = x++;
	    c.gridwidth = 1;
	    c.weightx = 2;
	    c.anchor = GridBagConstraints.CENTER;
	    c.fill = GridBagConstraints.HORIZONTAL;
	    button.setEnabled(false);
	    contactTable.getSelectionModel().addListSelectionListener(
	    		new SelectionChangedListener(button));
	    buttonPane.add(button, c);
	    
	    button = new ButtonDelete(med);
	    c = new GridBagConstraints();
	    c.gridx = x++;
	    c.gridwidth = 1;
	    c.weightx = 2;
	    c.anchor = GridBagConstraints.EAST;
	    c.fill = GridBagConstraints.HORIZONTAL;
	    button.setEnabled(false);
	    contactTable.getSelectionModel().addListSelectionListener(
	    		new SelectionChangedListener(button));
	    buttonPane.add(button, c);
	    
	    contactsPanel.add(buttonPane, BorderLayout.SOUTH);
	    
	    tabPane.add("Contacts", contactsPanel);
	    
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
