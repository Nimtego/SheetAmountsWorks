package view;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static model.constant.StandardData.TRENCH_TYPE;

/**
 * Created by myasnikov
 * on 26.05.2017.
 */
public class TestMain {
    public static void main(String[] args) throws IOException, SAXException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        assert documentBuilder != null;
        Document document = documentBuilder.parse(TRENCH_TYPE);
        NodeList nameTagList = document.getElementsByTagName("Trench_type");
        for (int i = 0; i < nameTagList.getLength(); i++) {
            // Выводим информацию по каждому из найденных элементов
            Node node = nameTagList.item(i);
            System.out.println();
            System.out.println("Текущий элемент: " + node.getNodeName());
            NodeList n = node.getChildNodes();
            System.out.println("Текущий элемент: " + ((Element)n.item(i)).getAttribute("type"));
        }

/*        try {
            Map<String, String> f = DomGenerate.extraction("CuCurrent.xml", "Section", "Three_core_earth");
            System.out.println(f);
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
        Header header = new Header(new User("First"));
        header.start();*/
    }
}
