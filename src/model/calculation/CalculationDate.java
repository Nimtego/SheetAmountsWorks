package model.calculation;

/**
 * Created by myasnikov
 * on 26.07.2017.
 */
public class CalculationDate {
    private Excavation excavation;
    private Fabric fabric;
    private WorkType workType;

    public CalculationDate(Excavation excavation, Fabric fabric, WorkType workType) {
        this.excavation = excavation;
        this.fabric = fabric;
        this.workType = workType;
    }

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Рытье траншеи: ").append(excavation.getDiggingTrenchInCube()).append(" куб.м")
                .append("\n")
                .append("Устройство постели из песка: ").append(excavation.getSandInCube()).append(" куб.м")
                .append("\n")
                .append("Обратная засыпка траншеи грунтом: ").append(excavation.getBackfillingCube()).append(" куб.м")
                .append("\n")
                .append("Вывоз мусора: ").append(excavation.getGarbageRemovalCube()).append(" куб.м")
                .append("\n")
                .append("Устройство прослойки из нетканого синтетиче-ского материала: ")
                .append(fabric.getSyntheticMaterialInSquare()).append(" кв.м")
                .append("\n")
                .append("Прокладка трубы: ").append(fabric.getPipesMeters()).append(" .м")
                .append("\n")
                .append("Прокладка кабеля штук/веток: ").append(fabric.getQuantityCable()).append(" .шт")
                .append("\n")
                .append("Общая длинна кабеля: ").append(fabric.getGeneralLongCableMeters()).append(" .м")
                .append("\n")
                .append("Запас кабеля: ").append(fabric.getСableStockMeters()).append(" .шт")
                .append("\n")
                .append("Укладка плит ПЗК 480х480 мм: ").append(fabric.getPlatesPieces()).append(" .шт")
                .append("\n")
                .append("Кабель в трубе: ").append(workType.getCableInPipeMeters()).append(" .м")
                .append("\n")
                .append("Кабель в траншее: ").append(workType.getCableInSoilMeters()).append(" .м");
        return String.valueOf(sb);
    }
}
