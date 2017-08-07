package model.calculation;

/**
 * Created by myasnikov
 * on 26.07.2017.
 */
public class WorkType {
    private float cableInPipeMeters; //В трубе
    private float cableInSoilMeters; //В траншее в земле

    public WorkType(float cableInPipeMeters, float cableInSoilMeters) {
        this.cableInPipeMeters = cableInPipeMeters;
        this.cableInSoilMeters = cableInSoilMeters;
    }

    public float getCableInPipeMeters() {
        return cableInPipeMeters;
    }

    public void setCableInPipeMeters(float cableInPipeMeters) {
        this.cableInPipeMeters = cableInPipeMeters;
    }

    public float getCableInSoilMeters() {
        return cableInSoilMeters;
    }

    public void setCableInSoilMeters(float cableInSoilMeters) {
        this.cableInSoilMeters = cableInSoilMeters;
    }


}
