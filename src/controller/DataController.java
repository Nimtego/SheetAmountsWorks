package controller;

import model.district.District;
import model.exceptions.SimpleMessageException;
import model.user.User;
import model.user.UserContainer;

import java.util.List;

/**
 * Created by myasnikov
 * on 01.08.2017.
 */
public class DataController {
    private UserContainer userContainer;

    public DataController(UserContainer userContainer) {
        this.userContainer = userContainer;
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
}
