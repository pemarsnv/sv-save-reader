package savefile;

public class SaveFile {
	
	private static String PATH;
	
	public static String getSave() {
		return PATH;
	}
	
	public static synchronized void setSave(String path) {
		PATH = path;
	}
	
	public static boolean isPresent() {
		return PATH != null;
	}

}
