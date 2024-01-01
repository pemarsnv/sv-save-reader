package pages;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;

import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class homePage extends JFrame {
	
	public static void main(String[] args) {
	    java.awt.EventQueue.invokeLater(new Runnable() {
	          public void run() {
	               homePage frame = new homePage();
	               frame.setVisible(true);
	          }
	    });
	}
	
	public homePage() {
		setSize(new Dimension(450, 400));
		setResizable(false);
		getContentPane().setMaximumSize(new Dimension(500, 500));
		getContentPane().setMinimumSize(new Dimension(500, 500));
		getContentPane().setPreferredSize(new Dimension(500, 500));
		getContentPane().setSize(new Dimension(500, 500));
		
		Font textFont = null;
		Font titleFont = null;
		try {
			
			textFont = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("fonts/Stardew_Valley.ttf"));
			titleFont = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("fonts/Stardew Valley ALL CAPS.ttf"));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setTitle("Home page");
		getContentPane().setBackground(new Color(234, 240, 206));
		
		JPanel panelTitre = new JPanel();
		panelTitre.setBorder(new EmptyBorder(20, 20, 20, 20));
		panelTitre.setBackground(new Color(244,202,128));
		getContentPane().add(panelTitre, BorderLayout.NORTH);
		
		JLabel lbTitre = new JLabel("<html> <center> STARDEW VALLEY <br>\r\n PROGRESSION TRACKER </center>");
		lbTitre.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitre.setForeground(new Color(90,23,13));
		lbTitre.setFont(titleFont.deriveFont(30f));
		panelTitre.add(lbTitre);
		
		JPanel panelButtons = new JPanel();
		panelButtons.setBorder(new EmptyBorder(20, 50, 20, 50));
		panelButtons.setBackground(new Color(244,202,128));
		getContentPane().add(panelButtons, BorderLayout.CENTER);
		panelButtons.setLayout(new GridLayout(3, 3, 10, 5));
		
		JButton btnFarm = new JButton("Your farm");
		panelButtons.add(btnFarm);
		
		JButton btnFishing = new JButton("");
		btnFishing.setIcon(new ImageIcon("icons\\home\\fishing.png"));
		btnFishing.setBackground(new Color(244,202,128));
		btnFishing.setFont(textFont.deriveFont(15f));
		btnFishing.setForeground(new Color(90,23,13));
		btnFishing.setBorder(BorderFactory.createEmptyBorder());
		btnFishing.setToolTipText("Your progression as the best fisherman of the whole valley!");
		panelButtons.add(btnFishing);
		
		JButton btnMuseum = new JButton("Your museum");
		panelButtons.add(btnMuseum);
		
		JButton btnStardrop = new JButton("Your stardrops");
		panelButtons.add(btnStardrop);
		
		JButton btnCooking = new JButton("Your cooking");
		panelButtons.add(btnCooking);
		
		JButton btnFriendships = new JButton("Your friendships");
		panelButtons.add(btnFriendships);
		
		JButton btnCrops = new JButton("Your crops");
		panelButtons.add(btnCrops);
		
		JButton btnCrafting = new JButton("Your crafts");
		panelButtons.add(btnCrafting);
		
		JButton btnExploration = new JButton("Your exploration");
		panelButtons.add(btnExploration);
	}

}
