package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;

public class DoubleClick extends MouseAdapter {
	
	public void mousePressed(MouseEvent e) {
		JTable table = (JTable)e.getSource();
		Point p = e.getPoint();
		int row = table.rowAtPoint(p);
		if(e.getClickCount() == 2){
			System.out.println("click");
		}
	}

}
