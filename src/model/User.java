package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by myasnikov
 * on 26.05.2017.
 */
public class User {
    private String projectName;
    private List<CalculationData> calculationData;

    public User(String projectName) {
        this.projectName = projectName;
        this.calculationData = new ArrayList<>();
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<CalculationData> getCalculationData() {
        return calculationData;
    }

    public void setCalculationData(List<CalculationData> calculationData) {
        this.calculationData = calculationData;
    }
    public boolean putDate(final CalculationData calculationData) {
       return this.calculationData.add(calculationData);
    }

}
