package model.dom;

import model.TypeTrench;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import static model.constant.StandardData.TRENCH_TYPE;

/**
 * Created by myasnikov
 * on 01.06.2017.
 */
public class DomGenerate {
    public static Map<String, String> extraction(final String direct,
                                                 final String nameTag,
                                                 final String tag)
                                                 throws IOException, SAXException {
        Map<String, String> data = new TreeMap<>();
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        assert documentBuilder != null;
        Document document = documentBuilder.parse(direct);
        NodeList nameTagList = document.getElementsByTagName(nameTag);
        NodeList tagList = document.getElementsByTagName(tag);
        for (int i = 0; i < tagList.getLength(); i++) {
            data.put(nameTagList.item(i).getTextContent(), tagList.item(i).getTextContent());
        }
        return data;
    }

    public static TypeTrench generateTypeTrench(String tmpKey, String value) throws IOException, SAXException {
        /*<Basis_width>200</Basis_width>
        <Depth>900</Depth>*/
        String diggingTrench;
        String backfilling;
        String sandVolume;

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        assert documentBuilder != null;
        Document document = documentBuilder.parse(TRENCH_TYPE);
/*        NodeList nameTagList = document.getElementsByTagName(nameTag);
        NodeList tagList = document.getElementsByTagName(tag);*/
        return null;
    }
}
