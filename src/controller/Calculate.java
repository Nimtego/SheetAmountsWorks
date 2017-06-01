package controller;

import model.InputData;
import model.SheetAmounts;
import model.TypeTrench;
import model.dom.DomGenerate;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.*;

import static model.constant.StandardData.COEFFICIENTS_QUANTITY_CABLE;
import static model.constant.StandardData.COOPER_LONG_CURRENT;
import static model.constant.StandardData.TRENCH_TYPE;
import static model.constant.Tags.*;

/**
 * Created by myasnikov
 * on 29.05.2017.
 */
public class Calculate {
    private static float sectionFlag;
    public static SheetAmounts calculateSheet(final InputData inputData) throws IOException, SAXException {
        Map<String, String> admissibleLongCurrentCopper =
                DomGenerate.extraction(COOPER_LONG_CURRENT, SECTION, THREE_CORE_IN_EARTH);
        float power = inputData.getPower();
        float lineLong = inputData.getLinesLong();
        float voltage = inputData.getVoltage();
        float current = designCurrent(power, voltage);
        int quantityCable;
        float section;
        String externalDiameter;
        List<Float> tmpCurrent = new ArrayList<>();
        for (String currentData : admissibleLongCurrentCopper.values()) {
            tmpCurrent.add(Float.parseFloat(currentData));
        }
        quantityCable = settlementQuantityCable(current, tmpCurrent);
        section = sectionFlag;
        Map<String, String> mapExternalDiameter =
                DomGenerate.extraction(COOPER_LONG_CURRENT, SECTION, EXTERNAL_DIAMETER);
        externalDiameter = generateExternalDiameter(sectionFlag, mapExternalDiameter);
        generateTypeTrench(quantityCable, externalDiameter);

        return null;
    }

    private static String generateExternalDiameter(float sectionFlag, Map<String, String> mapExternalDiameter) {
        String tmp = String.valueOf(sectionFlag);
        return mapExternalDiameter.get(tmp);
    }

    private static float designCurrent(float power, float voltage) {
        float current = 0;
        if (voltage >= 380) {
            current = (float) (power / (Math.sqrt(3) * (voltage / 1000)));
        }
        if (voltage < 380 && voltage > 0) {
            current = (power / (voltage / 1000));
        }
        return current;
    }
    private static int settlementQuantityCable(final float current,
                                               final List<Float> currentCopper){
    //    Collections.sort(currentCopper);
        int count = 1;
        while (true) {
            for (Float currentData : currentCopper) {
                sectionFlag = currentData;
                if ((current / COEFFICIENTS_QUANTITY_CABLE[count - 1] +
                                (current / 10)) < currentData * count) {
                    return count;
                }
            }
            count++;
        }
    }
    private static TypeTrench generateTypeTrench(final int quantityCable, final String externalDiameter) throws IOException, SAXException {
        Map<String, String> type = DomGenerate.extraction(TRENCH_TYPE, SECTION_EQUIVALENT, QUANTITY_CABLE);
        StringBuilder section = new StringBuilder();
        TypeTrench typeTrench = null;
        int count = 0;
        for (String key : type.keySet()) {
            Map<String, String> tmp = sectionAndQuantity(key, type.get(key));
            for (String tmpKey : tmp.keySet()) {
                if (Integer.parseInt(tmpKey) >= Integer.parseInt(externalDiameter) &&
                        Integer.parseInt(tmp.get(tmpKey)) >= quantityCable) {
                    typeTrench = DomGenerate.generateTypeTrench(key, type.get(key));
                }
            }
        }
        return typeTrench;
    }
    private static Map<String, String> sectionAndQuantity(final String section, final String quantity) {
        Map<String, String> total = new HashMap<>();
        int j = 0;
        int i = 0;
        String key = "";
        String value = "";
        while (true) {
            for (; section.charAt(i) != '/' && i < section.length(); i++) {
                key = key + section.charAt(i);
            }
            for (; quantity.charAt(j) != '/' && j < quantity.length(); j++) {
                value = value + quantity.charAt(j);
            }
            j++;
            i++;
            total.put(key, value);
            key = "";
            value = "";
            if (!(i < section.length()) || !(j < quantity.length()))
                break;
        }
        return total;
    }
}
