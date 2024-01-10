package pages;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.BorderLayout;

import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileFilter;

import listeners.HomeListener;
import savefile.SaveFile;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import java.awt.FlowLayout;

public class HomePage extends JFrame {
	
	private static final long serialVersionUID = 2447056399695361718L;
	public static ImageIcon stardewIcon = new ImageIcon("icons\\stardew.png");
	public JLabel lblChosenFarm; 
	
	public static void main(String[] args) {
	    java.awt.EventQueue.invokeLater(new Runnable() {
	          public void run() {
	               HomePage frame = new HomePage();
	               frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	               frame.setVisible(true);
	          }
	    });
	}
	
	public HomePage() {
		
		HomeListener controleur = new HomeListener(this);
		
		setSize(new Dimension(450, 400));
		setResizable(false);
		getContentPane().setMaximumSize(new Dimension(500, 500));
		getContentPane().setMinimumSize(new Dimension(500, 500));
		getContentPane().setPreferredSize(new Dimension(500, 500));
		getContentPane().setSize(new Dimension(500, 500));
		getContentPane().setBackground(new Color(234, 240, 206));
		
		setTitle("Home page");
		setIconImage(stardewIcon.getImage());
		
		JPanel panelTitre = new JPanel();
		panelTitre.setBorder(new EmptyBorder(20, 20, 20, 20));
		panelTitre.setBackground(StyleValues.getInstance().BACKGROUND);
		getContentPane().add(panelTitre, BorderLayout.NORTH);
		
		JLabel lbTitre = new JLabel("<html> <center> STARDEW VALLEY <br>\r\n PROGRESSION TRACKER </center>");
		lbTitre.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitre.setForeground(StyleValues.getInstance().FONT);
		lbTitre.setFont(StyleValues.getInstance().TITLEFONT.deriveFont(30f));
		panelTitre.add(lbTitre);
		
		JPanel panelButtons = new JPanel();
		panelButtons.setFocusable(false);
		panelButtons.setBorder(new EmptyBorder(20, 50, 20, 50));
		panelButtons.setBackground(StyleValues.getInstance().BACKGROUND);
		getContentPane().add(panelButtons, BorderLayout.CENTER);
		panelButtons.setLayout(new GridLayout(3, 3, 50, 7));
		
		JButton btnFarm = new JButton("");
		btnFarm.setName("farm");
		btnFarm.addActionListener(controleur);
		btnFarm.setFocusable(false);
		btnFarm.setIcon(new ImageIcon("icons\\home\\farm.png"));
		btnFarm.setBackground(StyleValues.getInstance().BACKGROUND);
		btnFarm.setBorder(BorderFactory.createEmptyBorder());
		btnFarm.setToolTipText("All the informations regarding your beloved farm's growth.");
		panelButtons.add(btnFarm);
		
		JButton btnFishing = new JButton("");
		btnFishing.setName("fishing");
		btnFishing.addActionListener(controleur);
		btnFishing.setFocusable(false);
		btnFishing.setIcon(new ImageIcon("icons\\home\\fishing.png"));
		btnFishing.setBackground(StyleValues.getInstance().BACKGROUND);
		btnFishing.setBorder(BorderFactory.createEmptyBorder());
		btnFishing.setToolTipText("The catches under your belt as the best fisherman of the whole valley!");
		panelButtons.add(btnFishing);
		
		JButton btnMuseum = new JButton("");
		btnMuseum.setName("museum");
		btnMuseum.addActionListener(controleur);
		btnMuseum.setFocusable(false);
		btnMuseum.setIcon(new ImageIcon("icons\\home\\museum.png"));
		btnMuseum.setBackground(StyleValues.getInstance().BACKGROUND);
		btnMuseum.setBorder(BorderFactory.createEmptyBorder());
		btnMuseum.setToolTipText("Hoo hoot! Let's see what Pelican Town's museum's collection looks like.");
		panelButtons.add(btnMuseum);
		
		JButton btnStardrop = new JButton("");
		btnStardrop.setName("stardrop");
		btnStardrop.addActionListener(controleur);
		btnStardrop.setFocusable(false);
		btnStardrop.setIcon(new ImageIcon("icons\\home\\stardrops.png"));
		btnStardrop.setBackground(StyleValues.getInstance().BACKGROUND);
		btnStardrop.setBorder(BorderFactory.createEmptyBorder());
		btnStardrop.setToolTipText("Will you ever taste your favourite thing again?");
		panelButtons.add(btnStardrop);
		
		JButton btnCooking = new JButton("");
		btnCooking.setName("cooking");
		btnCooking.addActionListener(controleur);
		btnCooking.setFocusable(false);
		btnCooking.setIcon(new ImageIcon("icons\\home\\cooking.png"));
		btnCooking.setBackground(StyleValues.getInstance().BACKGROUND);
		btnCooking.setBorder(BorderFactory.createEmptyBorder());
		btnCooking.setToolTipText("Does the Queen of Sauce have anything left to teach you?");
		panelButtons.add(btnCooking);
		
		JButton btnFriendships = new JButton("");
		btnFriendships.setName("friendship");
		btnFriendships.addActionListener(controleur);
		btnFriendships.setFocusable(false);
		btnFriendships.setIcon(new ImageIcon("icons\\home\\relationships.png"));
		btnFriendships.setBackground(StyleValues.getInstance().BACKGROUND);
		btnFriendships.setBorder(BorderFactory.createEmptyBorder());
		btnFriendships.setToolTipText("Do you get along with all of your neighbours?");
		panelButtons.add(btnFriendships);
		
		JButton btnCrops = new JButton("");
		btnCrops.setName("crops");
		btnCrops.addActionListener(controleur);
		btnCrops.setFocusable(false);
		btnCrops.setIcon(new ImageIcon("icons\\home\\crops.png"));
		btnCrops.setBackground(StyleValues.getInstance().BACKGROUND);
		btnCrops.setBorder(BorderFactory.createEmptyBorder());
		btnCrops.setToolTipText("Make Grandpa proud: harvest your veggies!");
		panelButtons.add(btnCrops);
		
		JButton btnCrafting = new JButton("");
		btnCrafting.setName("crafting");
		btnCrafting.addActionListener(controleur);
		btnCrafting.setFocusable(false);
		btnCrafting.setIcon(new ImageIcon("icons\\home\\crafting.png"));
		btnCrafting.setBackground(StyleValues.getInstance().BACKGROUND);
		btnCrafting.setBorder(BorderFactory.createEmptyBorder());
		btnCrafting.setToolTipText("[insert a joke about crafting]");
		panelButtons.add(btnCrafting);
		
		JButton btnExploration = new JButton("");
		btnExploration.setFocusable(false);
		btnExploration.setName("exploration");
		btnExploration.addActionListener(controleur);
		btnExploration.setIcon(new ImageIcon("icons\\home\\exploration.png"));
		btnExploration.setBackground(StyleValues.getInstance().BACKGROUND);
		btnExploration.setBorder(BorderFactory.createEmptyBorder());
		btnExploration.setToolTipText("To Pelican Town and beyond!");
		panelButtons.add(btnExploration);
		
		JPanel panelFile = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelFile.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panelFile.setBackground(new Color(255, 210, 132));
		getContentPane().add(panelFile, BorderLayout.SOUTH);
		
		lblChosenFarm = new JLabel("No farm selected yet");
		lblChosenFarm.setHorizontalAlignment(SwingConstants.RIGHT);
		lblChosenFarm.setPreferredSize(new Dimension(300, 15));
		lblChosenFarm.setForeground(StyleValues.getInstance().FONT);
		lblChosenFarm.setFont(StyleValues.getInstance().TEXTFONT.deriveFont(15f));
		panelFile.add(lblChosenFarm);
		
		JButton btnSaveChooser = new JButton("");
		btnSaveChooser.setBorder(new LineBorder(StyleValues.getInstance().BORDER, 2, true));
		btnSaveChooser.setBackground(StyleValues.getInstance().BACKGROUND);
		btnSaveChooser.setIcon(new ImageIcon("icons\\home\\file.png"));
		btnSaveChooser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser jFile = new JFileChooser();
				jFile.setAcceptAllFileFilterUsed(false);
				jFile.setFileFilter(new FileFilter() {

					@Override
					public boolean accept(File f) {
						return !(f.getName().contains("."));
					}

					@Override
					public String getDescription() {
						return ("FILE (no extension)");
					}
					
				});
				int returnval = jFile.showOpenDialog(null);
				if (returnval == JFileChooser.APPROVE_OPTION) {
					SaveFile.setSave(jFile.getSelectedFile().getAbsolutePath());
					String farmName = jFile.getSelectedFile().getName();
					int index = farmName.lastIndexOf('_');
					farmName = farmName.substring(0, index)+" farm selected";
					System.out.println(farmName);
					lblChosenFarm.setText(farmName);
				}
			}
			
		});
		
		panelFile.add(btnSaveChooser);
		
	}

}
