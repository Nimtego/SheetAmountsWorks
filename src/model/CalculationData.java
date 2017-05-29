package model;

import controller.IdCreate;

/**
 * Created by myasnikov
 * on 26.05.2017.
 */
public class CalculationData {
    private District district;
    private InputData inputData;
    private SheetAmounts sheetAmounts;

    public CalculationData(District district) {
        if (district.getId() == null) {
            district.setId(IdCreate.createID());
        }
        this.district = new District(district);
        this.inputData = InputData.inputDataBuilder().build();
        this.sheetAmounts = SheetAmounts.sheetAmountsBuilder().build();
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public InputData getInputData() {
        return inputData;
    }

    public void setInputData(InputData inputData) {
        this.inputData = inputData;
    }

    public SheetAmounts getSheetAmounts() {
        return sheetAmounts;
    }

    public void setSheetAmounts(SheetAmounts sheetAmounts) {
        this.sheetAmounts = sheetAmounts;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(district).append(inputData).append(sheetAmounts);
        return String.valueOf(sb);
    }
}
