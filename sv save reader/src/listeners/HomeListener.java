package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import pages.HomePage;
import savefile.SaveFile;

public class HomeListener implements ActionListener {
	
	private HomePage vue;
	
	public HomeListener(HomePage vue) {
		this.vue = vue;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton btn = (JButton) e.getSource();
		if (!SaveFile.isPresent()) {
			vue.lblChosenFarm.setText("You still haven't chosen a save file!");
		} else {
			switch (btn.getName()) {
				case("fishing"):
					System.out.println("a");
					break;
			}
		}
 	}

}
