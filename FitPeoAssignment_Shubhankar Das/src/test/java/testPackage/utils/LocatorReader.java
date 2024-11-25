package testPackage.utils;

import org.w3c.dom.*;
import javax.xml.parsers.*;


public class LocatorReader {
    private static Document doc;

    public LocatorReader(String filePath) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            doc = builder.parse(filePath);
            doc.getDocumentElement().normalize();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getLocator(String name, String type) {
        NodeList nodeList = doc.getElementsByTagName("locator");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                if (element.getAttribute("name").equals(name) && element.getAttribute("type").equals(type)) {
                    return element.getTextContent();
                }
            }
        }
        return null;
    }


}