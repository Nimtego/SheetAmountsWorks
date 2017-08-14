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

    public InputDateExpanded(long lineLong, SizeTrench sizeTrench, int numberOfCrossings) {
        super(lineLong, sizeTrench, numberOfCrossings);
    }
}
