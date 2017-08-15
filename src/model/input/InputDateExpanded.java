package model.input;

import model.calculation.Volume;

/**
 * Created by myasnikov
 * on 11.08.2017.
 */
public class InputDateExpanded extends InputDate {
    private Volume<Integer> quantityBranches;
    private Volume<Float> longCrossing;
    private Volume<Integer> pipeStock;
    private String pipeType;
    private Volume<Integer> quantitySupport;
    private Volume<Integer> heightSupport;

    public InputDateExpanded(float lineLong, SizeTrench sizeTrench, int numberOfCrossings) {
        super(lineLong, sizeTrench, numberOfCrossings);
    }

    public Volume<Integer> getQuantityBranches() {
        return quantityBranches;
    }

    public void setQuantityBranches(int quantityBranches) {
        this.quantityBranches = new Volume<>("Количество веток", "шт.", quantityBranches);
    }

    public Volume<Float> getLongCrossing() {
        return longCrossing;
    }

    public void setLongCrossing(float longCrossing) {
        this.longCrossing = new Volume<>("Длинна участков пересечения", "м.", longCrossing);
    }

    public Volume<Integer> getPipeStock() {
        return pipeStock;
    }

    public void setPipeStock(int pipeStock) {
        this.pipeStock = new Volume<>("Резерв труб", "шт.", pipeStock);
    }

    public String getPipeType() {
        return pipeType;
    }

    public void setPipeType(String pipeType) {
        this.pipeType = pipeType;
    }

    public Volume<Integer> getQuantitySupport() {
        return quantitySupport;
    }

    public void setQuantitySupport(int quantitySupport) {
        this.quantitySupport = new Volume<>("Количество опор освещения", "шт.", quantitySupport);
    }

    public Volume<Integer> getHeightSupport() {
        return heightSupport;
    }

    public void setHeightSupport(int heightSupport) {
        this.heightSupport = new Volume<>("Высота опор освещения", "м.", heightSupport);
    }
}
