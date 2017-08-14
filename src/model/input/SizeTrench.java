package model.input;

import model.calculation.Volume;

/**
 * Created by myasnikov
 * on 26.07.2017.
 */
public class SizeTrench {
    private String description;
    private Volume<? extends Number> height;
    private Volume<? extends Number> width;

    public SizeTrench() {
    }

    public SizeTrench(Number height, Number width) {
        this.height = new Volume<>("Высота", "мм", height);
        this.width = new Volume<>("Ширина", "мм", width);
    }


    public float getHeight() {
        return (Float) height.getValue();
    }

    public void setHeight(int height) {
        this.height = new Volume<>("Высота", "мм", height);;
    }

    public float getWidth() {
        return (Float) width.getValue();
    }

    public void setWidth(int width) {
        this.width = new Volume<>("Ширина", "мм", width);
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
}
