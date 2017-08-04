package model.calculation;

/**
 * Created by myasnikov
 * on 26.07.2017.
 */
public class CalculationDate {
    private Excavation excavation;
    private Fabric fabric;
    private WorkType workType;

    public Excavation getExcavation() {
        return excavation;
    }

    public void setExcavation(Excavation excavation) {
        this.excavation = excavation;
    }

    public Fabric getFabric() {
        return fabric;
    }

    public void setFabric(Fabric fabric) {
        this.fabric = fabric;
    }

    public WorkType getWorkType() {
        return workType;
    }

    public void setWorkType(WorkType workType) {
        this.workType = workType;
    }
}
