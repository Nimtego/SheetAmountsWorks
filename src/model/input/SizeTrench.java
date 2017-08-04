package model.input;

/**
 * Created by myasnikov
 * on 26.07.2017.
 */
public class SizeTrench {
    private int height;
    private int width;

    public SizeTrench() {
    }

    public SizeTrench(int height, int width) {
        this.height = height;
        this.width = width;
    }


    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
