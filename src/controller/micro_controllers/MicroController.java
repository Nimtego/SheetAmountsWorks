package controller.micro_controllers;

import controller.WindowController;

/**
 * Created by myasnikov
 * on 11.08.2017.
 */
public abstract class MicroController {
    protected WindowController owner;
    public abstract void owner(WindowController owner);
}
