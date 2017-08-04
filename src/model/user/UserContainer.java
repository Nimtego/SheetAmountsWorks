package model.user;

import model.district.District;
import model.utilits.IdCreator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by myasnikov
 * on 01.08.2017.
 */
public class UserContainer {
    private static volatile UserContainer instance;
    private Map<User, List<District>> userListMap;

    private UserContainer() {
        userListMap = new HashMap<>();
        this.putUser(new User("Guest", "12345"));
    }

    public static UserContainer getInstance() {
        if (instance == null)
            synchronized (UserContainer.class) {
                if (instance == null)
                    instance = new UserContainer();
            }
        return instance;
    }

    public boolean putUser(User user) {
        if (!userListMap.containsKey(user)) {
            user.setId(IdCreator.createID());
            List<District> districtList = new ArrayList<>();
            userListMap.put(user, districtList);

            return true;
        }
        return false;
    }

    public boolean putDistrict(User user, District district) {
        if (!userListMap.containsKey(user)) {
            putUser(user);
        }
        return userListMap.get(user).add(district);
    }

    public boolean checkName(String nameUser) {
        for (User user : userListMap.keySet()) {
            if (user.getLogIn().equals(nameUser)) {
                return true;
            }
        }
        return false;
    }

    public User getUserByName(String name) {
        for (User user : userListMap.keySet()) {
            if (user.getLogIn().equals(name)) {
                return user;
            }
        }
        return null;
    }

    public List<District> getDistrictByUserName(String nameUser) {
        for (User user : userListMap.keySet()) {
            if (user.getLogIn().equals(nameUser)) {
                return userListMap.get(user);
            }
        }
        return null;
    }
}
