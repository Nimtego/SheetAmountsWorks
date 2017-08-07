package model.input;

/**
 * Created by myasnikov
 * on 26.07.2017.
 */
public class InputDate {
    private long lineLong;
    private SizeTrench sizeTrench;
    private int numberOfCrossings;

    public InputDate(long lineLong, SizeTrench sizeTrench, int numberOfCrossings) {
        this.lineLong = lineLong;
        this.sizeTrench = sizeTrench;
        this.numberOfCrossings = numberOfCrossings;
    }

    public long getLineLong() {
        return lineLong;
    }

    public void setLineLong(long lineLong) {
        this.lineLong = lineLong;
    }

    public SizeTrench getSizeTrench() {
        return sizeTrench;
    }

    public void setSizeTrench(SizeTrench sizeTrench) {
        this.sizeTrench = sizeTrench;
    }

    public int getNumberOfCrossings() {
        return numberOfCrossings;
    }

    public void setNumberOfCrossings(int numberOfCrossings) {
        this.numberOfCrossings = numberOfCrossings;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n")
                .append("Длина линии: ").append(lineLong).append("\n");
                return String.valueOf(sb);
    }
}
