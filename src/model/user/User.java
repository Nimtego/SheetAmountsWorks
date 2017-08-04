package model.user;

/**
 * Created by myasnikov
 * on 01.08.2017.
 */
public class User {
    private Long id;
    private String logIn;
    private String password;
//    private List<District> districtList;

    public User(String logIn, String password) {
        this.logIn = logIn;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogIn() {
        return logIn;
    }

    public void setLogIn(String logIn) {
        this.logIn = logIn;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
/*    public void setDistrict(List<District> districtList) {
        this.districtList = districtList;
    }*/

/*    public String[] getDistrictListString() {
        String[] strings = new String[districtList.size()];
        for (int i = 0; i < districtList.size(); i++) {
            strings[i] = districtList.get(i).getName();
        }
        return strings;
    }

    public List<District> getDistrictList() {
        return districtList;
    }*/
}
