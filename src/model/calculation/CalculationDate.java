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
        sb.append("Рытье траншеи: ").append(excavation.getDiggingTrenchInCube().getValue()).append(" куб.м")
                .append("\n")
                .append("Устройство постели из песка: ").append(excavation.getSandInCube().getValue()).append(" куб.м")
                .append("\n")
                .append("Обратная засыпка траншеи грунтом: ").append(excavation.getBackfillingCube().getValue()).append(" куб.м")
                .append("\n")
                .append("Вывоз мусора: ").append(excavation.getGarbageRemovalCube().getValue()).append(" куб.м")
                .append("\n")
                .append("Устройство прослойки из нетканого синтетиче-ского материала: ")
                .append(fabric.getSyntheticMaterialInSquare().getValue()).append(" кв.м")
                .append("\n")
                .append("Прокладка трубы: ").append(fabric.getPipesMeters().getValue()).append(" .м")
                .append("\n")
                .append("Прокладка кабеля штук/веток: ").append(fabric.getQuantityCable().getValue()).append(" .шт")
                .append("\n")
                .append("Общая длинна кабеля: ").append(fabric.getGeneralLongCableMeters().getValue()).append(" .м")
                .append("\n")
                .append("Запас кабеля: ").append(fabric.getСableStockMeters().getValue()).append(" .шт")
                .append("\n")
                .append("Укладка плит ПЗК 480х480 мм: ").append(fabric.getPlatesPieces().getValue()).append(" .шт")
                .append("\n")
                .append("Укладка сигнальной ленты: ").append(fabric.getAlarmTape().getValue()).append(" .м")
                .append("\n")
                .append("Кабель в трубе: ").append(workType.getCableInPipeMeters().getValue()).append(" .м")
                .append("\n")
                .append("Кабель в траншее: ").append(workType.getCableInSoilMeters().getValue()).append(" .м");
        return String.valueOf(sb);
    }
}
