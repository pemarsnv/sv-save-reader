import java.util.Optional;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

enum GoldAchievements {

	
	GREENHORN(15000), COWPOKE(50000), HOMESTEADER(250000), MILLIONAIRE(1000000), LEGEND(10000000);
	
	private int goal;
	
	private GoldAchievements(int goal) {
		this.goal = goal;
	}
	
	public int getGoal() {
		return this.goal;
	}
	
}

public class goldAchievementsViewer {
	
	static String file = "Roseraie_346494448";

	public static void main(String[] args) {
		
		try {
			
			DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = db.parse(file);
			doc.getDocumentElement().normalize();
			
			int moneyEarned = Integer.valueOf(doc.getElementsByTagName("totalMoneyEarned").item(0).getFirstChild().getNodeValue());
			
			System.out.println("So far, you have earned a total "+moneyEarned+"g.");
			if (!nextAchievement(moneyEarned).isPresent()) {
				System.out.println("You have therefore unlocked every single gold related achievement!");
			} else {
				System.out.println("The next gold related achievement you need to reach is "
						+nextAchievement(moneyEarned).get().toString()+", you will therefore "
						+"need to earn "+(nextAchievement(moneyEarned).get().getGoal()-moneyEarned)
						+"g to unlock it!");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private static Optional<GoldAchievements> nextAchievement(int moneyEarned) {
		
		for (GoldAchievements g : GoldAchievements.values()) {
			if (g.getGoal() > moneyEarned) {
				return Optional.of(g);
			}
		}
		return Optional.empty();
		
	}

}
