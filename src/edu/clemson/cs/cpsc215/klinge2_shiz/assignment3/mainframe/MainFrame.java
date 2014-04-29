package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.mainframe;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

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
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

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
		
		//save information at system exit
	    Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
	        public void run() {
				DataStore storage = DataStore.getInstance();
				try {
					storage.storeConf();
				} catch (Exception ex) {
					System.out.println("Error saving config file.");
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
	    
	    
		// UIManager for Nimbus look
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("Unable to modify look and feel.");
		}
		
		//set up frame
		MainFrame frame = new MainFrame();
		frame.addComponents();
		frame.setVisible(true);
	}
	
	/**
	 * 
	 */
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
	    
	    
	    //set up window
	    this.setTitle("SimpleMail");
	    this.setIconImage(image);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setSize(400, 500);
	    this.setLayout(new BorderLayout());
	    this.getContentPane().setSize(350, 500);

	    MainFrameMediator med = new MainFrameMediator();
	    med.registerFrame(this);

	    //set up menu bar
	    JMenuBar menuBar = new JMenuBar();

	    //set up menu for File with New and Exit menu items
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

	    //set up menu for Edit with Clear and Configure menu items
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

	    //set up menu for Help with About menu item
	    JMenu helpMenu = new JMenu("Help");
	    JMenuItem about = new MenuItemAbout(med);
	    about.setIcon(new ImageIcon(aboutIcon));
	    helpMenu.add(about);

	    //finalize menu bar
	    menuBar.add(fileMenu);
	    menuBar.add(editMenu);
	    menuBar.add(helpMenu);

	    JTabbedPane tabPane = new JTabbedPane();

	    // Contacts panel
	    
	    JPanel contactsPanel = new JPanel();
	    contactsPanel.setLayout(new BorderLayout());
	    
        ContactTable contactTable = new ContactTable(new ContactTableModel(), med);
	    contactsPanel.add(new JScrollPane(contactTable, 
	            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS));
	    
	    JPanel buttonPane = new JPanel();
	    buttonPane.setLayout(new GridBagLayout());
	    GridBagConstraints c;
	    
	    JButton button;
	    
	    int x = 0;
	    
	    // Buttons contact table
	    
	    button = new ButtonContactAdd(med);
	    c = new GridBagConstraints();
	    c.gridx = x++;
	    c.gridwidth = 1;
	    c.weightx = 2;
	    c.anchor = GridBagConstraints.WEST;
	    c.fill = GridBagConstraints.HORIZONTAL;
	    buttonPane.add(button,c);
	    
	    button = new ButtonContactEdit(med);
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
	    
	    button = new ButtonContactDelete(med);
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
	    
	    // Drafts panel
	    
	    JPanel draftsPanel = new JPanel();
	    draftsPanel.setLayout(new BorderLayout());
	    
	    DraftTable draftTable = new DraftTable(new DraftTableModel(), med);
	    draftsPanel.add(new JScrollPane(draftTable, 
	            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS));
	    
	    buttonPane = new JPanel();
	    buttonPane.setLayout(new GridBagLayout());
	    
	    x = 0;
	    
	    // Buttons for draft table
	    
	    button = new ButtonDraftEdit(med);
	    c = new GridBagConstraints();
	    c.gridx = x++;
	    c.gridwidth = 1;
	    c.weightx = 2;
	    c.anchor = GridBagConstraints.CENTER;
	    c.fill = GridBagConstraints.HORIZONTAL;
	    button.setEnabled(false);
	    draftTable.getSelectionModel().addListSelectionListener(
	    		new SelectionChangedListener(button));
	    buttonPane.add(button, c);
	    
	    button = new ButtonDraftDelete(med);
	    c = new GridBagConstraints();
	    c.gridx = x++;
	    c.gridwidth = 1;
	    c.weightx = 2;
	    c.anchor = GridBagConstraints.EAST;
	    c.fill = GridBagConstraints.HORIZONTAL;
	    button.setEnabled(false);
	    draftTable.getSelectionModel().addListSelectionListener(
	    		new SelectionChangedListener(button));
	    buttonPane.add(button, c);
	    
	    draftsPanel.add(buttonPane, BorderLayout.SOUTH);
	    
	    tabPane.add("Contacts", contactsPanel);
	    tabPane.add("Drafts", draftsPanel);
	    
	    this.add(tabPane);
	    
	    this.setJMenuBar(menuBar);
	    this.pack();
	    this.setLocationByPlatform(true);
	}
}
