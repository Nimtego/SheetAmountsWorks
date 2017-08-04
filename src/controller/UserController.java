package controller;

import model.exceptions.SimpleMessageException;
import model.user.User;
import model.user.UserContainer;

/**
 * Created by myasnikov
 * on 01.08.2017.
 */
public class UserController {
    private UserContainer userContainer;

    public UserController(UserContainer userContainer) {
        this.userContainer = userContainer;
    }

    public void logIn(String nameUser, String password) throws SimpleMessageException {
        checkValidUserLog(nameUser, password);
        User user = userContainer.getUserByName(nameUser);
        System.out.println(user);
        if (user == null) {
            throw new SimpleMessageException("Пользователя с таким именем не существует");
        }
        if(!user.getPassword().equals(password)) {
            throw new SimpleMessageException("Неверный пароль");
        }
    }

    public void singIn(String nameUser, String password) throws SimpleMessageException {
        checkValidUserLog(nameUser, password);
        if (nameUser.length() > 10) {
            throw new SimpleMessageException("Имя не более 10 знаков");
        }
        if (userContainer.checkName(nameUser)) {
            throw new SimpleMessageException("Имя существует");
        }
        userContainer.putUser(new User(nameUser, password));
    }
    private void checkValidUserLog(String nameUser, String password) throws SimpleMessageException {
        if (nameUser == null || password == null) {
            if (nameUser == null) {
                throw new SimpleMessageException("Не введено имя");
            }
            throw new SimpleMessageException("Не введен пароль");
        }
    }
}
