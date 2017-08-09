package model.calculation;

import java.util.ArrayList;
import java.util.List;

import static model.calculation.Discrition.*;

/**
 * Created by myasnikov
 * on 26.07.2017.
 */
public class WorkType {
    private Volume<Float> cableInPipeMeters; //В трубе
    private Volume<Float> cableInSoilMeters; //В траншее в земле

    public WorkType(float cableInPipeMeters, float cableInSoilMeters) {
        setCableInPipeMeters(cableInPipeMeters);
        setCableInSoilMeters(cableInSoilMeters);
    }

    public Volume<Float> getCableInPipeMeters() {
        return cableInPipeMeters;
    }

    public final void setCableInPipeMeters(float cableInPipeMeters) {
        this.cableInPipeMeters = new Volume<>(CABLE_IN_PIPE, METERS, cableInPipeMeters);
    }

    public Volume<Float> getCableInSoilMeters() {
        return cableInSoilMeters;
    }

    public final void setCableInSoilMeters(float cableInSoilMeters) {
        this.cableInSoilMeters = new Volume<>(CABLE_IN_SOIL, METERS, cableInSoilMeters);
    }
    public String[][] formating() {
        List<Volume> volumeList = new ArrayList<>();
        volumeList.add(cableInPipeMeters);
        volumeList.add(cableInSoilMeters);
        String[][] form = new String[volumeList.size()][3];
        int i = 0;
        for (Volume volume : volumeList) {
            form[i][0] = volume.getDescription();
            form[i][1] = String.valueOf(volume.getValue());
            form[i][2] = volume.getUnit();
            i++;
        }
        return form;
    }
}
