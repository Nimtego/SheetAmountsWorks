package view;

import controller.Header;
import model.User;

/**
 * Created by myasnikov
 * on 26.05.2017.
 */
public class TestMain {
    public static void main(String[] args) {
        Header header = new Header(new User("First"));
        header.start();
    }
}
