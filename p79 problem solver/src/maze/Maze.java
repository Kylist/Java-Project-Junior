/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Maze extends JFrame {

	public Maze() {
		
		this.add(new MazeGridPanel(5,5));
		this.setSize(800, 800);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	
        }
	
	public static void main(String[] args) {
			new Maze();
                      
	}
}