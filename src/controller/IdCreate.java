package controller;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by myasnikov
 * on 26.05.2017.
 */
public class IdCreate {
    private static AtomicLong idCounter = new AtomicLong();
    public static Long createID() {
        return idCounter.getAndIncrement();
    }
}
