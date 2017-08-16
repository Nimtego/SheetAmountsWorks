package controller;

import model.constant.KeyWorks;
import model.constant.TypeTrench;
import model.district.District;
import model.exceptions.SimpleMessageException;
import model.input.Additional;
import model.input.InputDateExpanded;
import model.input.SizeTrench;
import model.user.User;
import model.user.UserContainer;

import java.util.List;
import java.util.Map;

import static model.constant.KeyWorks.*;

/**
 * Created by myasnikov
 * on 01.08.2017.
 */
public class DataController {

    public DataController(){

    }

    public boolean putDistrict(User user, District district) throws SimpleMessageException {
        List<District> districtList = UserContainer.getInstance().getDistrictByUserName(user.getLogIn());
        String nameDistrict = district.getName();
        if (nameDistrict.isEmpty())
            throw new SimpleMessageException("Отсутствует имя участка");
        for (District dis : districtList) {
            if (dis.getName().equals(nameDistrict))
                throw new SimpleMessageException("Имя проекта уже существует");
        }
        checkDistrict(district);
        return UserContainer.getInstance().putDistrict(user, district);
    }
    
    public void checkDistrict(District district) throws SimpleMessageException {
        if (district.getInputDate().getLineLong() < 1)
            throw new SimpleMessageException("Длинна должна быть больше 0");
        if (district.getInputDate().getNumberOfCrossings() < 0)
            throw new SimpleMessageException("Количество пересений не может быть отрецательным");
        if (district.getInputDate().getSizeTrench() == null)
            throw new SimpleMessageException("Траншея не задана");
    }
    private boolean checkNameDistrict(final String name, final List<District> districtList) {
        boolean check = true;
        for (District dis : districtList) {
            if (dis.getName().equals(name)) {
                check = false;
            }
        }
        return check;
    }
    private void checkEmptyField(final Map<KeyWorks, String> worksStringMap) throws SimpleMessageException {
        for (KeyWorks keyWorks : worksStringMap.keySet()) {
            if (worksStringMap.get(keyWorks).isEmpty() &&
                    !keyWorks.equals(QUANTITY_SUPPORT) &&
                    !keyWorks.equals(HEIGHT_SUPPORT)) {
                String value = keyWorks.getValue();
                throw new SimpleMessageException("Графа \"" +value +"\"" +" не должна быть пустой");
            }
        }
    }
    private InputDateExpanded generateInputDate(Map<KeyWorks, String> worksMap,
                                                Map<KeyWorks, Boolean> additionalMap) throws SimpleMessageException {
        String tmp = "";
        float lineLong = 0;
        int branches = 0;
        float longCrossing = 0;
        int pipeStock = 0;
        int quantitySupport = 0;
        int heightSupport = 0;
        String pipeType = worksMap.get(PIPE_TYPE);

        try {
            tmp = worksMap.get(LINE_LONG);
            lineLong = Float.parseFloat(tmp);
            tmp = worksMap.get(QUANTITY_BRANCHES);
            branches = Integer.parseInt(tmp);
            tmp = worksMap.get(LONG_CROSSING);
            longCrossing = Float.parseFloat(tmp);
            if (longCrossing > lineLong)
                throw new SimpleMessageException("Пересечения не могут быть больше длинны линии");
            tmp = worksMap.get(PIPE_STOCK);
            pipeStock = Integer.parseInt(tmp);
            if (!worksMap.get(QUANTITY_SUPPORT).isEmpty() &&
                    !worksMap.get(HEIGHT_SUPPORT).isEmpty()) {
                tmp = worksMap.get(QUANTITY_SUPPORT);
                quantitySupport = Integer.parseInt(tmp);
                tmp = worksMap.get(HEIGHT_SUPPORT);
                heightSupport = Integer.parseInt(tmp);
            }
        } catch (NumberFormatException e) {
            throw new SimpleMessageException("Значение \"" +tmp +"\"" +" не число");
        }
        SizeTrench sizeTrench = TypeTrench.size(worksMap.get(TRENCH_TYPE));
        InputDateExpanded inputDateExpanded =
                new InputDateExpanded(lineLong, sizeTrench, 1); // TODO: 15.08.2017 кол пересечек не нужн
        inputDateExpanded.setQuantityBranches(branches);
        inputDateExpanded.setLongCrossing(longCrossing);
        inputDateExpanded.setPipeStock(pipeStock);
        inputDateExpanded.setQuantitySupport(quantitySupport);
        inputDateExpanded.setHeightSupport(heightSupport);
        System.out.println(additionalMap.get(SYNTHETIC_BOOL));
        Additional additional = Additional.additionalBuilder()
                .synthetic(additionalMap.get(SYNTHETIC_BOOL))
                .plates(additionalMap.get(PLATES_BOOL))
                .alarmTape(additionalMap.get(ALARM_TAPE_BOOL))
                .board(additionalMap.get(BOARD_BOOL))
                .crushedStone(additionalMap.get(CRUSHED_STONE_BOOL))
                .build();

        inputDateExpanded.setAdditional(additional);
        return inputDateExpanded;
    }
    public boolean putDistrict(User user,
                               Map<KeyWorks, String> worksMap,
                               Map<KeyWorks, Boolean> additionalMap) throws SimpleMessageException {
        System.out.println("Works sheet amount");
        String name = worksMap.get(NAME_DISTRICT);
        List<District> districtList = UserContainer.getInstance().getDistrictByUserName(user.getLogIn());
        if (name.isEmpty()) {
            throw new SimpleMessageException("Не введено имя участка");
        }
        if (!checkNameDistrict(name, districtList)) {
            throw new SimpleMessageException("Имя участка \"" +name +"\" существует");
        }
        checkEmptyField(worksMap);

        InputDateExpanded inputDateExpanded = generateInputDate(worksMap, additionalMap);

        District district = new District(name, inputDateExpanded);
        UserContainer.getInstance().putDistrict(user, district);
        return true;
    }


}
