package fishing;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBConnection;
import enums.*;

public class InsertFish {

	public static void main(String[] args) {
		
		String file = "\"128\": \"Pufferfish/80/floater/1/36/1200 1600/summer/sunny/690 .4 685 .1/4/.3/.5/0\",\r\n"
		+ "        \"129\": \"Anchovy/30/dart/1/16/600 2600/spring fall/both/682 .2/1/.25/.3/0\",\r\n"
		+ "        \"130\": \"Tuna/70/smooth/12/60/600 1900/summer winter/both/689 .35 681 .1/3/.15/.55/0\",\r\n"
		+ "        \"131\": \"Sardine/30/dart/1/12/600 1900/spring summer fall winter/both/683 .3/1/.65/.1/0\",\r\n"
		+ "        \"132\": \"Bream/35/smooth/12/30/1800 2600/spring summer fall winter/both/684 .35/1/.45/.1/0\",\r\n"
		+ "        \"136\": \"Largemouth Bass/50/mixed/11/30/600 1900/spring summer fall winter/both/685 .35/3/.4/.2/0\",\r\n"
		+ "        \"137\": \"Smallmouth Bass/28/mixed/12/24/600 2600/spring fall/both/682 .2/1/.45/.1/0\",\r\n"
		+ "        \"138\": \"Rainbow Trout/45/mixed/10/25/600 1900/summer/sunny/684 .35/2/.35/.3/0\",\r\n"
		+ "        \"139\": \"Salmon/50/mixed/24/65/600 1900/fall/both/684 .35/3/.4/.2/0\",\r\n"
		+ "        \"140\": \"Walleye/45/smooth/10/40/1200 2600/fall winter/rainy/680 .35/2/.4/.15/0\",\r\n"
		+ "        \"141\": \"Perch/35/dart/10/24/600 2600/winter/both/683 .2/1/.45/.1/0\",\r\n"
		+ "        \"142\": \"Carp/15/mixed/15/50/600 2600/spring summer fall/both/682 .2/1/.45/.1/0\",\r\n"
		+ "        \"143\": \"Catfish/75/mixed/12/72/600 2400/spring fall winter/rainy/689 .4 680 .1/4/.4/.1/0\",\r\n"
		+ "        \"144\": \"Pike/60/dart/15/60/600 2600/summer winter/both/690 .3 681 .1/3/.4/.15/0\",\r\n"
		+ "        \"145\": \"Sunfish/30/mixed/5/15/600 1900/spring summer/sunny/683 .2/1/.45/.1/0\",\r\n"
		+ "        \"146\": \"Red Mullet/55/smooth/8/22/600 1900/summer winter/both/680 .25/2/.4/.15/0\",\r\n"
		+ "        \"147\": \"Herring/25/dart/8/20/600 2600/spring winter/both/685 .2/1/.45/.1/0\",\r\n"
		+ "        \"148\": \"Eel/70/smooth/12/80/1600 2600/spring fall/rainy/689 .35 680 .1/3/.55/.1/0\",\r\n"
		+ "        \"149\": \"Octopus/95/sinker/12/48/600 1300/summer/both/688 .6 684 .1/5/.1/.08/0\",\r\n"
		+ "        \"150\": \"Red Snapper/40/mixed/8/25/600 1900/summer fall winter/rainy/682 .25/2/.45/.1/0\",\r\n"
		+ "        \"151\": \"Squid/75/sinker/12/48/1800 2600/winter/both/690 .35 680 .1/3/.35/.3/0\",\r\n"
		+ "        \"152\": \"Seaweed/5/floater/5/30/600 2600/spring summer fall winter/both/-1/0/.3/0/0\",\r\n"
		+ "        \"153\": \"Green Algae/5/floater/5/30/600 2600/spring summer fall winter/both/-1/0/.3/0/0\",\r\n"
		+ "        \"154\": \"Sea Cucumber/40/sinker/3/20/600 1900/fall winter/both/683 .2 689 .4/3/.25/.25/0\",\r\n"
		+ "        \"155\": \"Super Cucumber/80/sinker/12/36/1800 2600/summer winter/both/683 .2 689 .4/4/.1/.25/0\",\r\n"
		+ "        \"156\": \"Ghostfish/50/mixed/10/35/600 2600/spring summer fall winter/both/684 .35/2/.3/.3/0\",\r\n"
		+ "        \"157\": \"White Algae/5/floater/5/30/600 2600/spring summer fall winter/both/-1/0/.3/0/0\",\r\n"
		+ "        \"158\": \"Stonefish/65/sinker/15/15/600 2600/spring summer fall winter/both/689 .2/2/.1/.1/3\",\r\n"
		+ "        \"159\": \"Crimsonfish/95/mixed/20/20/600 2000/winter/both/690 .15/4/.1/.1/5\",\r\n"
		+ "        \"160\": \"Angler/85/smooth/18/18/600 2600/spring summer fall winter/both/690 .1/4/.05/.1/3\",\r\n"
		+ "        \"161\": \"Ice Pip/85/dart/8/8/600 2600/spring summer fall winter/both/682 .1/2/.05/.1/5\",\r\n"
		+ "        \"162\": \"Lava Eel/90/mixed/32/32/600 2600/spring summer fall winter/both/684 .1/2/.05/.1/7\",\r\n"
		+ "        \"163\": \"Legend/110/mixed/50/50/600 2000/spring summer fall winter/rainy/688 .05/5/0/.1/10\",\r\n"
		+ "        \"164\": \"Sandfish/65/mixed/8/24/600 2000/spring summer fall winter/both/682 .2/1/.65/.1/0\",\r\n"
		+ "        \"165\": \"Scorpion Carp/90/dart/12/32/600 2000/spring summer fall winter/both/683 .4/2/.15/.1/4\",\r\n"
		+ "        \"267\": \"Flounder/50/sinker/4/16/600 2000/spring summer/both/680 .25/2/.15/.05/0\",\r\n"
		+ "        \"269\": \"Midnight Carp/55/mixed/12/52/2200 2600/fall winter/both/682 .2/1/.33/.1/0\",\r\n"
		+ "        \"372\": \"Clam/trap/.15/681 .35/ocean/1/5\",\r\n"
		+ "        \"682\": \"Mutant Carp/80/dart/36/36/600 2600/spring summer fall winter/both/688 .1/5/0/.02/0\",\r\n"
		+ "        \"698\": \"Sturgeon/78/mixed/12/60/600 1900/summer winter/both/689 .35 682 .1/3/.35/.2/0\",\r\n"
		+ "        \"699\": \"Tiger Trout/60/dart/10/20/600 1900/spring summer fall winter/both/688 .45 685 .2/3/.2/.1/0\",\r\n"
		+ "        \"700\": \"Bullhead/46/smooth/12/30/600 2600/spring summer fall winter/both/681 .25/2/.35/.2/0\",\r\n"
		+ "        \"701\": \"Tilapia/50/mixed/11/30/600 1400/summer fall/both/683 .35/3/.4/.2/0\",\r\n"
		+ "        \"702\": \"Chub/35/dart/12/24/600 2600/spring summer fall winter/both/684 .35/1/.45/.1/0\",\r\n"
		+ "        \"704\": \"Dorado/78/mixed/24/32/600 1900/summer/both/689 .35 681 .1/3/.15/.1/0\",\r\n"
		+ "        \"705\": \"Albacore/60/mixed/20/40/600 1100 1800 2600/fall winter/both/685 .35/3/.3/.15/0\",\r\n"
		+ "        \"706\": \"Shad/45/smooth/20/48/900 2600/spring summer fall/rainy/684 .35/2/.35/.2/0\",\r\n"
		+ "        \"707\": \"Lingcod/85/mixed/30/50/600 2600/winter/both/690 .4 685 .2/3/.3/.05/0\",\r\n"
		+ "        \"708\": \"Halibut/50/sinker/10/33/600 1100 1900 2600/spring summer winter/both/681 .35/3/.4/.2/0\",\r\n"
		+ "        \"715\": \"Lobster/trap/.05/688 .45 689 .35 690 .35/ocean/2/20\",\r\n"
		+ "        \"716\": \"Crayfish/trap/.35/682 .4/freshwater/1/8\",\r\n"
		+ "        \"717\": \"Crab/trap/.1/684 .45/ocean/1/20\",\r\n"
		+ "        \"718\": \"Cockle/trap/.3/680 .2/ocean/1/5\",\r\n"
		+ "        \"719\": \"Mussel/trap/.35/683 .15/ocean/1/5\",\r\n"
		+ "        \"720\": \"Shrimp/trap/.2/681 .35/ocean/1/3\",\r\n"
		+ "        \"721\": \"Snail/trap/.25/680 .35/freshwater/1/5\",\r\n"
		+ "        \"722\": \"Periwinkle/trap/.55/681 .35/freshwater/1/3\",\r\n"
		+ "        \"723\": \"Oyster/trap/.15/682 .35/ocean/1/5\",\r\n"
		+ "        \"734\": \"Woodskip/50/mixed/11/30/600 2600/spring summer fall winter/both/685 .35/3/.2/.1/0\",\r\n"
		+ "        \"775\": \"Glacierfish/100/mixed/27/27/600 2000/winter/sunny/688 .1/5/0/.02/7\",\r\n"
		+ "        \"795\": \"Void Salmon/80/mixed/24/65/600 2600/spring summer fall winter/both/685 .35/2/.33/.1/0\",\r\n"
		+ "        \"796\": \"Slimejack/55/dart/8/25/600 2600/spring summer fall winter/both/685 .35/3/.4/.1/0\",\r\n"
		+ "        \"798\": \"Midnight Squid/55/sinker/8/25/600 2600/spring summer fall winter/both/685 .35/3/.4/.1/0\",\r\n"
		+ "        \"799\": \"Spook Fish/60/dart/8/25/600 2600/spring summer fall winter/both/685 .35/3/.4/.1/0\",\r\n"
		+ "        \"800\": \"Blobfish/75/floater/8/25/600 2600/spring summer fall winter/both/685 .35/3/.4/.1/0\",\r\n"
		+ "        \"836\": \"Stingray/80/sinker/18/60/600 2600/spring summer fall winter/both/685 .35/4/.2/.1/0\",\r\n"
		+ "        \"837\": \"Lionfish/50/smooth/3/12/600 2600/spring summer fall winter/both/685 .35/3/.4/.1/0\",\r\n"
		+ "        \"838\": \"Blue Discus/60/dart/2/9/600 2600/spring summer fall winter/both/685 .35/1/.25/.1/0\",\r\n"
		+ "        \"898\": \"Son of Crimsonfish/95/mixed/20/20/600 2000/winter/both/690 .15/4/.1/.1/5\",\r\n"
		+ "        \"899\": \"Ms. Angler/85/smooth/18/18/600 2600/spring summer fall winter/both/690 .1/4/.05/.1/3\",\r\n"
		+ "        \"900\": \"Legend II/110/mixed/50/50/600 2000/spring summer fall winter/rainy/688 .05/5/0/.1/10\",\r\n"
		+ "        \"901\": \"Radioactive Carp/80/dart/36/36/600 2600/spring summer fall winter/both/688 .1/5/0/.02/0\",\r\n"
		+ "        \"902\": \"Glacierfish Jr./100/mixed/27/27/600 2000/winter/sunny/688 .1/5/0/.02/7\"\r\n";
		
		String fishDescription = "";
		Fish fish;
		
		while (!file.equals("")) {
			fishDescription = file.substring(0, file.indexOf("\n"));
			file = file.substring(file.indexOf("\n")+1);
			if (isThisAFish(fishDescription)) {
				getFishFromDescription(fishDescription);
			} else {
				System.out.println("pas un poisson");
			}
		}
	}
	
	public static boolean isThisAFish(String description) {
		System.out.println("isthisafish");
		String fish = description;
		System.out.println(fish);
		//+ "        \"717\": \"Crab/trap/.1/684 .45/ocean/1/20\",\r\n"
		fish = fish.substring(fish.indexOf("/")+1);
		fish = fish.substring(0, fish.indexOf("/"));
		System.out.println(fish);
		return !fish.equals("trap");
	}
	
	public static Fish getFishFromDescription(String description) {
		System.out.println(description);
		Fish fish;
		
		//fetching the fish id 
		int begin = description.indexOf('"')+1; int end = description.indexOf('"', begin+1);
		int id = Integer.valueOf(description.substring(begin, end));
		description = description.substring(end+1);
		System.out.println(id); System.out.println(description);
		
		//fetching the fish name
		begin = description.indexOf('"')+1; end = description.indexOf("/");
		String name = description.substring(begin, end);
		description = description.substring(end+1);
		System.out.println(name); System.out.println(description);
		
		//fetching the fish start and end type 
		for (int i = 0; i<4; i++) {
			description = description.substring(description.indexOf("/")+1);
		}
		
		begin = 0; end = description.indexOf(" ");
		int startTime = Integer.valueOf(description.substring(begin, end));
		begin = end+1; end = description.indexOf("/");
		int endTime = Integer.valueOf(description.substring(begin, end));
		System.out.println(startTime+" "+endTime);
		
		System.out.println(description);
		
		//fetching all the seasons when the fish is catchable
		begin = description.indexOf("/")+1; end = description.indexOf("/", begin);
		String season = description.substring(begin, end);
		System.out.println(season);
		Season[] seasons = new Season[season.length() - season.replace(" ", "").length() + 1];
		int indice = 0;
		while (season.contains(" ")){
			String seasonString = season.substring(0, season.indexOf(" "));
			Season s = Season.valueOf(seasonString.toUpperCase());
			season = season.substring(season.indexOf(" ")+1);
			seasons[indice] = s; indice++;
			System.out.println("AAAAA"+s);
		}
		seasons[indice] = Season.valueOf(season.toUpperCase());
		
		description = description.substring(description.indexOf('/')+1);
		
		System.out.println(seasons); System.out.println(description);
		
		//fetching all the weathers when the fish is catchable
		begin = description.indexOf("/")+1; end = description.indexOf("/", begin);
		String weatherString = description.substring(begin, end);
		System.out.println(weatherString);
		Weather weather = Weather.valueOf(weatherString.toUpperCase());
		
		description = description.substring(description.indexOf('/')+1);
		
		System.out.println(weather); System.out.println(description);
		
		fish = new Fish(id, name, seasons, weather, null, startTime, endTime, 0);
		
		System.out.println(fish);
		return fish;
	}
	
	public boolean insertFish(Fish fish) {
		
		
		//fetching the new available id for the new fish to be inserted with 
		try {
			
			PreparedStatement stIdFish = DBConnection.getInstance().prepareStatement("SELECT NEXT VALUE FOR seqIdAdmin FROM admin");
			ResultSet rsIdFish = stIdFish.executeQuery();
			int id = 0;
			if (rsIdFish.next()) id = rsIdFish.getInt(1);
			fish.setId(id);	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		//inserting the fish in the db
		int rowcount = 0;
		try {
			String reqInsertFish = "INSERT INTO fish VALUES (?, ?, ?, ?, ?, ?, ?, 0)";
			PreparedStatement stInsertFish = DBConnection.getInstance().prepareStatement(reqInsertFish);
			stInsertFish.setInt(1, fish.getId()); stInsertFish.setString(2, fish.getName());
			stInsertFish.setString(3, fish.getSeasons().toString());
			stInsertFish.setString(4, fish.getWeather().toString());
			stInsertFish.setString(5, fish.getLocation().toString());
			stInsertFish.setInt(6, fish.getStartTime()); stInsertFish.setInt(7, fish.getEndTime());
			rowcount = stInsertFish.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rowcount > 0;
		
	}

}

