package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.ClickableActionListener;
/**
 * Main window of the simple mail program. User Interface
 * 
 * @author shiz
 * @author klinge2
 * @since 4/25/14
 */
public class MainFrame extends JFrame {

	private static final long serialVersionUID = -6203227608826654258L;

	public static void main(String [] args) {
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
		
		DataStore.getInstance().loadConf();
		DataStore.getInstance().loadContacts();
//		List<Contact> contacts = DataStore.getInstance().getContacts();
//		contacts.add(new Contact("Alice", "125 Pine St.",
//		        "435-385-2348", "allycakes@g.clemson.edu"));
//		contacts.add(new Contact("Bob", "123 Pine St.",
//		        "911-455-3483", "bobert@g.clemson.edu"));
		
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
	    
	    this.setIconImage(image);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setSize(400, 500);
	    this.setLayout(new BorderLayout());
	    this.getContentPane().setSize(350, 500);

	    MainFrameMediator med = new MainFrameMediator();
	    med.registerFrame(this);

	    JMenuBar menuBar = new JMenuBar();
	    menuBar.setOpaque(true);
	    menuBar.setBackground(color);

	    JMenu fileMenu = new JMenu("File");
	    JMenuItem exit = new MenuItemExit(new ClickableActionListener(),
	            med);
	    fileMenu.add(exit);

	    JMenu configMenu = new JMenu("Configuration");
	    JMenuItem config = new MenuItemConfig(new ClickableActionListener(),
	            med);
	    configMenu.add(config);

	    JMenu helpMenu = new JMenu("Help");
	    JMenuItem about = new MenuItemAbout(new ClickableActionListener(),
	            med);
	    helpMenu.add(about);

	    menuBar.add(fileMenu);
	    menuBar.add(configMenu);
	    menuBar.add(helpMenu);

	    JTable table = new JTable(new TableModel()) {
	        private static final long serialVersionUID = -3897893453518570667L;

	        public boolean getScrollableTracksViewportWidth(){
	            return getPreferredSize().width < getParent().getWidth();
	        }
	    };
	    this.getContentPane().add(new JScrollPane(table, 
	            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS));
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

	    table.addMouseListener(new DoubleClick());

	    this.setJMenuBar(menuBar);
	    this.pack();
	}
}
