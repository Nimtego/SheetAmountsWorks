package controller;

import model.calculation.CalculationDate;
import model.calculation.Excavation;
import model.calculation.Fabric;
import model.calculation.WorkType;
import model.district.District;
import model.input.InputDate;
import model.input.SizeTrench;

/**
 * Created by myasnikov
 * on 31.07.2017.
 */
public class CalculationController {
    public CalculationDate calculate(District district) {
        InputDate inputDate = district.getInputDate();
        SizeTrench sizeTrench = inputDate.getSizeTrench();
        int width = (int) sizeTrench.getWidth(); // TODO: 14.08.2017 FLOAT!!!! 
        int height = (int) sizeTrench.getHeight();
        float lineLong = inputDate.getLineLong();
        int crossing = inputDate.getNumberOfCrossings();
        Excavation excavation = calculateExcavation(width, height, lineLong);
        Fabric fabric = calculateFabric(width, lineLong, crossing);
        WorkType workType = calculateWorkType(fabric.getGeneralLongCableMeters().getValue(),
                                                fabric.getPipesMeters().getValue());
        return new CalculationDate(excavation, fabric, workType);
    }
    private Excavation calculateExcavation(final int width, final int height, final float lineLong) {
        float diggingTrenchInCube; //Рытье траншеи
        float sandInCube; //Устройство постели из песка для траншеи
        float backfillingCube; //Обратная засыпка траншеи грунтом.
        float garbageRemovalCube; //Вывоз мусора
        diggingTrenchInCube = ((float)width / 1000) * ((float)height / 1000) * lineLong;
        diggingTrenchInCube = (float) (Math.rint(100.0 * diggingTrenchInCube) / 100.0);
        sandInCube = (300F / 1000) * ((float)width / 1000) * lineLong;
        sandInCube = (float) (Math.rint(100.0 * sandInCube) / 100.0);
        backfillingCube = (float) (Math.rint(100.0 *(diggingTrenchInCube - sandInCube)) / 100.0);
        garbageRemovalCube = sandInCube;
        return Excavation.excavationBuilder().
                                diggingTrenchInCube(diggingTrenchInCube).
                                sandInCube(sandInCube).
                                backfillingCube(backfillingCube).
                                garbageRemovalCube(garbageRemovalCube).
                                build();
    }
    private Fabric calculateFabric(final int width, float lineLong, int crossing) {
        float syntheticMaterialInSquare; //Устройство прослойки из нетканого синтетиче-ского материала
        float pipesMeters; //Прокладка трубы
        int quantityCable; //Прокладка кабеля при весе 1м до 10кг штук/веток
        float generalLongCableMeters; //Общая длинна кабеля
        float cableStockMeters; //Запас кабеля под укладку
        int platesPieces; //Укладка плит ПЗК
        /*плита ПЗК 240х480х16 мм
          плита ПЗК 360х480х16 мм
          плита ПЗК 480х480х16 мм*/

        syntheticMaterialInSquare = (float)(width + 200 * 2) / 1000 * lineLong;
        pipesMeters = crossing * 5;
        quantityCable = 1;
        cableStockMeters = lineLong * 0.1F;
        generalLongCableMeters = lineLong + cableStockMeters * quantityCable;
        platesPieces = (int) (2 * (lineLong / 0.48F));
        return Fabric.FabricBuilder()
                        .syntheticMaterialInSquare(syntheticMaterialInSquare)
                        .pipesMeters(pipesMeters)
                        .quantityCable(quantityCable)
                        .cableStockMeters(cableStockMeters)
                        .generalLongCableMeters(generalLongCableMeters)
                        .platesPieces(platesPieces)
                        .build();
    }
    private WorkType calculateWorkType(final float lineLong, final float pipeLong) {
        float cableInSoilMeters = lineLong - pipeLong; //В траншее в земле
        return new WorkType(pipeLong, cableInSoilMeters);
    }
}
