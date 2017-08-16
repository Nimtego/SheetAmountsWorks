package model.input;

import model.calculation.Volume;

/**
 * Created by myasnikov
 * on 26.07.2017.
 */
public class SizeTrench {
    private String description;
    private Volume<Float> height;
    private Volume<Float> width;

    public SizeTrench() {
    }

    public SizeTrench(float height, float width) {
        this.height = new Volume<>("Высота", "мм", height);
        this.width = new Volume<>("Ширина", "мм", width);
    }


    public float getHeight() {
        return (Float) height.getValue();
    }

    public void setHeight(float height) {
        this.height = new Volume<>("Высота", "мм", height);;
    }

    public float getWidth() {
        return (Float) width.getValue();
    }

    public void setWidth(float width) {
        this.width = new Volume<>("Ширина", "мм", width);
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Глубина ").append(height.getValue()).append(" м.")
                .append("Ширина ").append(width.getValue()).append(" м.");
        return String.valueOf(sb);
    }
}
