package model.calculation;

import java.util.ArrayList;
import java.util.List;

import static model.calculation.Discrition.*;

/**
 * Created by myasnikov
 * on 26.07.2017.
 */
public class Fabric {
    private Volume<Float> syntheticMaterialInSquare; //Устройство прослойки из нетканого синтетиче-ского материала
    private Volume<Float> pipesMeters; //Прокладка трубы
    private Volume<Integer> quantityCable; //Прокладка кабеля при весе 1м до 10кг штук/веток
    private Volume<Float> generalLongCableMeters; //Общая длинна кабеля
    private Volume<Float> cableStockMeters; //Запас кабеля под укладку
    private Volume<Integer> platesPieces; //Укладка плит ПЗК 480х480 мм
    private Volume<Float> alarmTape;

    private Fabric(){}
    public static FabricBuilder fabricBuilder() {
        return new Fabric().new FabricBuilder();
    }

    public Volume<Float> getGeneralLongCableMeters() {
        return generalLongCableMeters;
    }

    public Volume<Float> getPipesMeters() {
        return pipesMeters;
    }

    public Volume<Float> getSyntheticMaterialInSquare() {
        return syntheticMaterialInSquare;
    }

    public Volume<Integer> getQuantityCable() {
        return quantityCable;
    }

    public Volume<Float> getСableStockMeters() {
        return cableStockMeters;
    }

    public Volume<Integer> getPlatesPieces() {
        return platesPieces;
    }
    public Volume<Float> getAlarmTape() {
        return alarmTape;
    }
    public void setAlarmTape(Volume<Float> alarmTape) {
        this.alarmTape = alarmTape;
    }
    public String[][] formating() {
        List<Volume> volumeList = new ArrayList<>();
        volumeList.add(syntheticMaterialInSquare);
        volumeList.add(pipesMeters);
        volumeList.add(quantityCable);
        volumeList.add(generalLongCableMeters);
        volumeList.add(cableStockMeters);
        volumeList.add(platesPieces);
        volumeList.add(alarmTape);
        String[][] form = new String[volumeList.size()][3];
        int i = 0;
        for (Volume volume : volumeList) {
            System.out.println(volume.getDescription());
                form[i][0] = volume.getDescription();
                form[i][1] = String.valueOf(volume.getValue());
                form[i][2] = volume.getUnit();
                i++;
        }
        for (String[] str : form) {
            for (String string : str) {
                System.out.print(string);
            }
            System.out.println();
        }

        return form;
    }
    //Builder iner
    public class FabricBuilder {

        private FabricBuilder() {
        }

        public FabricBuilder syntheticMaterialInSquare(final float syntheticMaterialInSquare) {
            Fabric.this.syntheticMaterialInSquare =
                    new Volume<>(SYNTHETIC, VOLUME_SQUARE, syntheticMaterialInSquare);
            return this;
        }

        public FabricBuilder pipesMeters(final float pipesMeters) {
            Fabric.this.pipesMeters =
                    new Volume<>(PIPES, METERS, pipesMeters);
            return this;
        }

        public FabricBuilder quantityCable(final int quantityCable) {
            Fabric.this.quantityCable =
                    new Volume<>(QUANTITY, PIECES, quantityCable);
            return this;
        }

        public FabricBuilder generalLongCableMeters(final float generalLongCableMeters) {
            Fabric.this.generalLongCableMeters =
                    new Volume<>(GENERAL_LONG, METERS, generalLongCableMeters);
            return this;
        }
        public FabricBuilder cableStockMeters(final float cableStockMeters) {
            Fabric.this.cableStockMeters =
                    new Volume<>(CABLE_STOCK, METERS, cableStockMeters);
            return this;
        }
        public FabricBuilder platesPieces(final int platesPieces) {
            Fabric.this.platesPieces =
                    new Volume<>(PLATES, PIECES, platesPieces);
            return this;
        }

        public FabricBuilder alarmTape(final float alarmTape) {
            Fabric.this.alarmTape =
                    new Volume<>(ALARM_TAPE, METERS, alarmTape);
            return this;
        }
        public Fabric build() {
            Fabric fabric = new Fabric();
            fabric.syntheticMaterialInSquare = Fabric.this.syntheticMaterialInSquare;
            fabric.pipesMeters = Fabric.this.pipesMeters;
            fabric.quantityCable = Fabric.this.quantityCable;
            fabric.generalLongCableMeters = Fabric.this.generalLongCableMeters;
            fabric.cableStockMeters = Fabric.this.cableStockMeters;
            fabric.platesPieces = Fabric.this.platesPieces;
            fabric.alarmTape = Fabric.this.alarmTape;
            return fabric;
        }

    }
}
