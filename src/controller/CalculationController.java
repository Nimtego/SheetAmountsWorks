package controller;

import model.calculation.CalculationDate;
import model.calculation.Excavation;
import model.calculation.Fabric;
import model.calculation.WorkType;
import model.district.District;
import model.input.InputDate;
import model.input.InputDateExpanded;
import model.input.SizeTrench;

/**
 * Created by myasnikov
 * on 31.07.2017.
 */
public class CalculationController {
    private District district;

    public CalculationDate calculate(District district) {
        this.district = district;
        InputDate inputDate = district.getInputDate();
        if (inputDate instanceof InputDateExpanded) {
            InputDateExpanded inputDateExpanded = (InputDateExpanded) inputDate;

            SizeTrench sizeTrench = inputDateExpanded.getSizeTrench();
            float width = sizeTrench.getWidth(); // TODO: 14.08.2017 FLOAT!!!!
            float height = sizeTrench.getHeight();
            float lineLong = inputDateExpanded.getLineLong();
            float crossing = inputDateExpanded.getLongCrossing().getValue();
            Excavation excavation = calculateExcavation(width, height, lineLong);
            Fabric fabric = calculateFabric(width, lineLong, crossing);
            WorkType workType = calculateWorkType(fabric.getGeneralLongCableMeters().getValue(),
                    fabric.getPipesMeters().getValue()); // TODO: 16.08.2017 кабель в трубе не корректно считает
            return new CalculationDate(excavation, fabric, workType);
        }
        return null; // TODO: 16.08.2017
    }

    private Excavation calculateExcavation(final float width, final float height, final float lineLong) {
        float diggingTrenchInCube; //Рытье траншеи
        float sandInCube; //Устройство постели из песка для траншеи
        float backfillingCube; //Обратная засыпка траншеи грунтом.
        float garbageRemovalCube; //Вывоз мусора
        diggingTrenchInCube = (width / 1000) * (height / 1000) * lineLong;
        diggingTrenchInCube = (float) (Math.rint(100.0 * diggingTrenchInCube) / 100.0);
        sandInCube = (300F / 1000) * (width / 1000) * lineLong;
        sandInCube = (float) (Math.rint(100.0 * sandInCube) / 100.0);
        backfillingCube = (float) (Math.rint(100.0 * (diggingTrenchInCube - sandInCube)) / 100.0);
        garbageRemovalCube = sandInCube;
        return Excavation.excavationBuilder().
                diggingTrenchInCube(diggingTrenchInCube).
                sandInCube(sandInCube).
                backfillingCube(backfillingCube).
                garbageRemovalCube(garbageRemovalCube).
                build();
    }

    private Fabric calculateFabric(final float width, final float lineLong, final float crossing) {
        float syntheticMaterialInSquare = 0; //Устройство прослойки из нетканого синтетиче-ского материала
        float pipesMeters; //Прокладка трубы
        int quantityCable; //Прокладка кабеля при весе 1м до 10кг штук/веток
        float generalLongCableMeters; //Общая длинна кабеля
        float cableStockMeters; //Запас кабеля под укладку
        int platesPieces = 0; //Укладка плит ПЗК
        float alarmTape = 0;
        /*плита ПЗК 240х480х16 мм
          плита ПЗК 360х480х16 мм
          плита ПЗК 480х480х16 мм*/
        InputDateExpanded inputDateExpanded = (InputDateExpanded) district.getInputDate();
        if (inputDateExpanded.getAdditional().getSynthetic())
            syntheticMaterialInSquare = (width + 200 * 2) / 1000 * lineLong;
        int branches = inputDateExpanded.getQuantityBranches().getValue();
        if (inputDateExpanded.getAdditional().getAlarmTape())
            alarmTape = (lineLong - crossing) * branches;
        int pipeStock = inputDateExpanded.getPipeStock().getValue();
        pipesMeters = crossing * (branches * pipeStock);
        quantityCable = branches;
        cableStockMeters = lineLong * 0.1F;
        generalLongCableMeters = (lineLong + cableStockMeters) * quantityCable;
        float lineWithoutCrossing = lineLong - pipesMeters;
        System.out.println("PLATE     " +inputDateExpanded.getAdditional().getPlates());
        if (inputDateExpanded.getAdditional().getPlates())
            platesPieces = choicePlate(lineWithoutCrossing, branches);
        return Fabric.fabricBuilder()
                .syntheticMaterialInSquare(syntheticMaterialInSquare)
                .pipesMeters(pipesMeters)
                .quantityCable(quantityCable)
                .cableStockMeters(cableStockMeters)
                .generalLongCableMeters(generalLongCableMeters)
                .platesPieces(platesPieces)
                .alarmTape(alarmTape)
                .build();
    }

    private WorkType calculateWorkType(final float lineLong, final float pipeLong) {
        float cableInSoilMeters = lineLong - pipeLong; //В траншее в земле
        return new WorkType(pipeLong, cableInSoilMeters);
    }

    private int choicePlate(final float lineLong, final int branches) {
/*                    *//*плита ПЗК 240х480х16 мм
          плита ПЗК 360х480х16 мм
          плита ПЗК 480х480х16 мм*//*
        int plate24 = 240;
        int plate36 = 360;*/
        int plate48 = 480;
        int wight = 50 * branches + ((branches - 1) * 100);
        int plateInWeght = wight / plate48 + 1;
        int count = (int) ((int)lineLong / (0.48F) * plateInWeght);
        System.out.println("               Plate " +count);
        return count;
    }
}
