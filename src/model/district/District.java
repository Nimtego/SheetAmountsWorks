package model.district;

import model.calculation.CalculationDate;
import model.input.InputDate;

/**
 * Created by myasnikov
 * on 26.07.2017.
 */
public class District {
    private String name;
    private InputDate inputDate;
    private CalculationDate calculationDate = null;

    public District(String name, InputDate inputDate) {
        this.name = name;
        this.inputDate = inputDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InputDate getInputDate() {
        return inputDate;
    }

    public void setInputDate(InputDate inputDate) {
        this.inputDate = inputDate;
    }

    public CalculationDate getCalculationDate() {
        return calculationDate;
    }

    public void setCalculationDate(CalculationDate calculationDate) {
        this.calculationDate = calculationDate;
    }
}
