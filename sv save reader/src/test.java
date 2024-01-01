import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class test {

	public static void main(String[] args) {

		  String file = "Roseraie_346494448";
		  
		  try {
			  
			DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = db.parse(file);
			doc.getDocumentElement().normalize();
			System.out.println("Node:"+doc.getDocumentElement().getNodeName());
			NodeList nodelist = doc.getElementsByTagName("player");
			
			NodeList playerNodes = doc.getChildNodes().item(0).getChildNodes().item(0).getChildNodes();
			for (int i = 0; i<playerNodes.getLength();i++) {
				System.out.println("Node "+i+": "+playerNodes.item(i).getNodeName());
			}

			System.out.println(playerNodes.item(169).getFirstChild().getNodeValue());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
