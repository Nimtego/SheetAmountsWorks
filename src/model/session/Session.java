package model.session;

import model.user.UserContainer;

/**
 * Created by myasnikov
 * on 01.08.2017.
 */
public class Session {
    private UserContainer userContainer;

    public Session() {
        userContainer = UserContainer.getInstance();
    }

    public UserContainer getUserContainer() {
        return userContainer;
    }

    public void setUserContainer(UserContainer userContainer) {
        this.userContainer = userContainer;
    }
}
