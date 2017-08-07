package model.calculation;

/**
 * Created by myasnikov
 * on 26.07.2017.
 */
public class Fabric {
    private float syntheticMaterialInSquare; //Устройство прослойки из нетканого синтетиче-ского материала
    private float pipesMeters; //Прокладка трубы
    private int quantityCable; //Прокладка кабеля при весе 1м до 10кг штук/веток
    private float generalLongCableMeters; //Общая длинна кабеля
    private float cableStockMeters; //Запас кабеля под укладку
    private int platesPieces; //Укладка плит ПЗК 480х480 мм

    private Fabric(){}
    public static FabricBuilder FabricBuilder() {
        return new Fabric().new FabricBuilder();
    }

    public float getGeneralLongCableMeters() {
        return generalLongCableMeters;
    }

    public float getPipesMeters() {
        return pipesMeters;
    }

    public float getSyntheticMaterialInSquare() {
        return syntheticMaterialInSquare;
    }

    public int getQuantityCable() {
        return quantityCable;
    }

    public float getСableStockMeters() {
        return cableStockMeters;
    }

    public int getPlatesPieces() {
        return platesPieces;
    }

    //Builder iner
    public class FabricBuilder {

        private FabricBuilder() {
        }

        public FabricBuilder syntheticMaterialInSquare(final float syntheticMaterialInSquare) {
            Fabric.this.syntheticMaterialInSquare = syntheticMaterialInSquare;
            return this;
        }

        public FabricBuilder pipesMeters(final float pipesMeters) {
            Fabric.this.pipesMeters = pipesMeters;
            return this;
        }

        public FabricBuilder quantityCable(final int quantityCable) {
            Fabric.this.quantityCable = quantityCable;
            return this;
        }

        public FabricBuilder generalLongCableMeters(final float generalLongCableMeters) {
            Fabric.this.generalLongCableMeters = generalLongCableMeters;
            return this;
        }
        public FabricBuilder cableStockMeters(final float cableStockMeters) {
            Fabric.this.cableStockMeters = cableStockMeters;
            return this;
        }
        public FabricBuilder platesPieces(final int platesPieces) {
            Fabric.this.platesPieces = platesPieces;
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
            return fabric;
        }
    }
}
