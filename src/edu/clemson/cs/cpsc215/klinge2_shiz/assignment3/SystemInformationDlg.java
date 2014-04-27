package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.AbstractDlg;

/**
 * System information dialog. Display program information.
 * 
 * @author shiz
 * @since 4/24/14
 */
@SuppressWarnings("serial")
public class SystemInformationDlg extends AbstractDlg implements ActionListener {

	public SystemInformationDlg(Frame owner) {
	    super(owner, "About");
	    addComponents();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		dispose();
	}

    @Override
    protected void addComponents() {
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
        setIconImage(image);
        setSize(200,300);
        setAlwaysOnTop(true);
        
        JPanel messagePane = new JPanel();
        messagePane.add(new JLabel(line));
        
        JPanel buttonPane = new JPanel();
        JButton button = new JButton("OK");
        button.addActionListener(this);
        buttonPane.add(button);
        
        this.getContentPane().add(messagePane);
        this.getContentPane().add(buttonPane, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.pack();
        this.setLocationByPlatform(true);
    }

}
