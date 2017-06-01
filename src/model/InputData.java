package model;

import model.constant.CableType;

import java.util.List;

/**
 * Created by myasnikov
 * on 26.05.2017.
 */
public class InputData {
    private float linesLong; //длинна кабельной линии
    private float power; //мощность
    private float voltage; //напряжение
    private int numberCrossings; //количество пересечений
    private List<Integer> rapprochements; //длины участков сближения (для определения количества труб)
    private CableType cableType;

    private InputData() {}

    public static InputDataBuilder inputDataBuilder() {
        return new InputData().new InputDataBuilder();
    }
    //Builder iner
    public class InputDataBuilder {
        private InputDataBuilder() {
        }
        public InputDataBuilder linesLong(final float linesLong) {
            InputData.this.linesLong = linesLong;
            return this;
        }
        public InputDataBuilder power(final float power) {
            InputData.this.power = power;
            return this;
        }
        public InputDataBuilder voltage(final float voltage) {
            InputData.this.voltage = voltage;
            return this;
        }
        public InputDataBuilder numberCrossings(final int numberCrossings) {
            InputData.this.numberCrossings = numberCrossings;
            return this;
        }
        public InputDataBuilder rapprochements(final List<Integer> rapprochements) {
            InputData.this.rapprochements = rapprochements;
            return this;
        }
        public InputDataBuilder cableType(CableType cableType) {
            InputData.this.cableType = cableType;
            return this;
        }
        public InputData build() {
            InputData inputData = new InputData();
            inputData.linesLong = InputData.this.linesLong;
            inputData.power = InputData.this.power;
            inputData.voltage = InputData.this.voltage;
            inputData.numberCrossings = InputData.this.numberCrossings;
            inputData.rapprochements = InputData.this.rapprochements;
            inputData.cableType = InputData.this.cableType;
            return inputData;
        }

    }

    public float getLinesLong() {
        return linesLong;
    }

    public void setLinesLong(float linesLong) {
        this.linesLong = linesLong;
    }

    public float getPower() {
        return power;
    }

    public void setPower(float power) {
        this.power = power;
    }

    public float getVoltage() {
        return voltage;
    }

    public void setVoltage(float voltage) {
        this.voltage = voltage;
    }

    public int getNumberCrossings() {
        return numberCrossings;
    }

    public void setNumberCrossings(int numberCrossings) {
        this.numberCrossings = numberCrossings;
    }

    public List<Integer> getRapprochements() {
        return rapprochements;
    }

    public void setRapprochements(List<Integer> rapprochements) {
        this.rapprochements = rapprochements;
    }

    public CableType getCableType() {
        return cableType;
    }

    public void setCableType(CableType cableType) {
        this.cableType = cableType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n").append("TO DO");
        return String.valueOf(sb);
    }
}
