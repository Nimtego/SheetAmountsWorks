package model.constant;

import model.input.SizeTrench;

/**
 * Created by myasnikov
 * on 26.07.2017.
 */
public class TypeTrench{
    public static final String[] TYPE_TRENCH = {"T1  h = 200;  w = 900",
                                                "T2  h = 300;  w = 900",
                                                "T3  h = 400;  w = 900",
                                                "T4  h = 500;  w = 900",
                                                "T5  h = 600;  w = 900",
                                                "T6  h = 700;  w = 900",
                                                "T7  h = 800;  w = 900",
                                                "T8  h = 900;  w = 900",
                                                "T9  h = 1000; w = 900",
                                                "T10 h = 300;  w = 1250",
                                                "T11 h = 500;  w = 1250",
                                                "T12 h = 600;  w = 1250",
                                                "T13 h = 800;  w = 1250",
                                                "T14 h = 900;  w = 1250",
                                                "T15 h = 1000; w = 1250"};

    private static final int[][] TRENCH_SIZE = {{200,900},
                                                {300,900},
                                                {400,900},
                                                {500,900},
                                                {600,900},
                                                {700,900},
                                                {800,900},
                                                {900,900},
                                                {1000,900},
                                                {300,1250},
                                                {500,1250},
                                                {600,1250},
                                                {800,1250},
                                                {900,1250},
                                                {1000,1250}};

    public static SizeTrench size(String type) {
        SizeTrench sizeTrench = new SizeTrench();
        for (int i = 0; i < TYPE_TRENCH.length; i++) {
            if (TYPE_TRENCH[i].equals(type)) {
                sizeTrench.setHeight(TRENCH_SIZE[i][0]);
                sizeTrench.setWidth(TRENCH_SIZE[i][1]);
            }
        }
        return sizeTrench;
    }
}
