package model.constant;

import java.awt.*;

/**
 * Created by myasnikov
 * on 01.08.2017.
 */
public class WindowConstant {
    private static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int SIZE_WIDTH = SCREEN_SIZE.width; // TODO: 01.08.2017  
    public static final int SIZE_HEIGHT = SCREEN_SIZE.height;
    public static final int CENTER_LOCATION_X = (SCREEN_SIZE.width) / 2;
    public static final int CENTER_LOCATION_Y = (SCREEN_SIZE.height) / 2;
}
