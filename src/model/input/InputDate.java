package model.input;

import model.calculation.Volume;

/**
 * Created by myasnikov
 * on 26.07.2017.
 */
public class InputDate {
    private Volume<Float> lineLong;
    private SizeTrench sizeTrench;
    private Volume<Integer> numberOfCrossings;

    public InputDate(float lineLong, SizeTrench sizeTrench, int numberOfCrossings) {
        this.lineLong = new Volume<>("Длинна", "м.", lineLong);
        this.sizeTrench = sizeTrench;
        this.numberOfCrossings = new Volume<>("Количество пересечений", "шт.", numberOfCrossings);
    }

    public float getLineLong() {
        return lineLong.getValue();
    }

    public void setLineLong(float lineLong) {
        this.lineLong = new Volume<>("Длинна", "м.", lineLong);
    }

    public SizeTrench getSizeTrench() {
        return sizeTrench;
    }

    public void setSizeTrench(SizeTrench sizeTrench) {
        this.sizeTrench = sizeTrench;
    }

    public int getNumberOfCrossings() {
        return numberOfCrossings.getValue();
    }

    public void setNumberOfCrossings(int numberOfCrossings) {
        this.numberOfCrossings = new Volume<>("Количество пересечений", "шт.", numberOfCrossings);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n")
                .append(lineLong.getDescription()).append(" ")
                .append(lineLong.getValue()).append(" ")
                .append(lineLong.getUnit())
                .append("\n");
                return String.valueOf(sb);
    }
}
