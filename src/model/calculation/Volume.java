package model.calculation;

/**
 * Created by myasnikov
 * on 09.08.2017.
 */
public class Volume<T extends Number> {
    private String description;
    private String unit;
    private T value;

    public Volume(String description, String unit, T value) {
        this.description = description;
        this.unit = unit;
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
