package model;

/**
 * Created by myasnikov
 * on 26.05.2017.
 */
public class SheetAmounts {
    private float diggingTrenchInCube; //Рытье траншеи
    private float sandInCube; //Устройство постели из песка для траншеи
    private float syntheticMaterialInSquare; //Устройство прослойки из нетканого синтетиче-ского материала
    private float pipesMeters; //Прокладка трубы
    private int quantityCable; //Прокладка кабеля при весе 1м до 10кг штук/веток
    private float generalLongCableMeters; //Общая длинна кабеля
    private float cableInPipeMeters; //В трубе
    private float cableInSoilMeters; //В траншее в земле
    private float cableStockMeters; //Запас кабеля под укладку
    private int platesPieces; //Укладка плит ПЗК 480х480 мм
    private float backfillingCube; //Обратная засыпка траншеи грунтом.
    private float garbageRemovalCube; //Вывоз мусора

    private SheetAmounts() {}

    public static SheetAmountsBuilder sheetAmountsBuilder() {
        return new SheetAmounts().new SheetAmountsBuilder();
    }
    //Builder iner
    public class SheetAmountsBuilder {

        private SheetAmountsBuilder() {}

        public SheetAmountsBuilder diggingTrenchInCube(final float diggingTrenchInCube) {
            SheetAmounts.this.diggingTrenchInCube = diggingTrenchInCube;
            return this;
        }
        public SheetAmountsBuilder sandInCube(final float sandInCube) {
            SheetAmounts.this.sandInCube = sandInCube;
            return this;
        }
        public SheetAmountsBuilder syntheticMaterialInSquare(final float syntheticMaterialInSquare) {
            SheetAmounts.this.syntheticMaterialInSquare = syntheticMaterialInSquare;
            return this;
        }
        public SheetAmountsBuilder pipesMeters(final float pipesMeters) {
            SheetAmounts.this.pipesMeters = pipesMeters;
            return this;
        }
        public SheetAmountsBuilder quantityCable(final int quantityCable) {
            SheetAmounts.this.quantityCable = quantityCable;
            return this;
        }
        public SheetAmountsBuilder generalLongCableMeters(final float generalLongCableMeters) {
            SheetAmounts.this.generalLongCableMeters = generalLongCableMeters;
            return this;
        }
        public SheetAmountsBuilder cableInPipeMeters(final float cableInPipeMeters) {
            SheetAmounts.this.cableInPipeMeters = cableInPipeMeters;
            return this;
        }
        public SheetAmountsBuilder cableInSoilMeters(final float cableInSoilMeters) {
            SheetAmounts.this.cableInSoilMeters = cableInSoilMeters;
            return this;
        }
        public SheetAmountsBuilder cableStockMeters(final float cableStockMeters) {
            SheetAmounts.this.cableStockMeters = cableStockMeters;
            return this;
        }
        public SheetAmountsBuilder platesPieces(final int platesPieces) {
            SheetAmounts.this.platesPieces = platesPieces;
            return this;
        }
        public SheetAmountsBuilder backfillingCube(final float backfillingCube) {
            SheetAmounts.this.backfillingCube = backfillingCube;
            return this;
        }
        public SheetAmountsBuilder garbageRemovalCube(final float garbageRemovalCube) {
            SheetAmounts.this.garbageRemovalCube = garbageRemovalCube;
            return this;
        }

        public SheetAmounts build() {
            SheetAmounts sheetAmounts = new SheetAmounts();
            sheetAmounts.diggingTrenchInCube = SheetAmounts.this.diggingTrenchInCube;
            sheetAmounts.sandInCube = SheetAmounts.this.sandInCube;
            sheetAmounts.syntheticMaterialInSquare = SheetAmounts.this.syntheticMaterialInSquare;
            sheetAmounts.pipesMeters = SheetAmounts.this.pipesMeters;
            sheetAmounts.quantityCable = SheetAmounts.this.quantityCable;
            sheetAmounts.generalLongCableMeters = SheetAmounts.this.generalLongCableMeters;
            sheetAmounts.cableInPipeMeters = SheetAmounts.this.cableInPipeMeters;
            sheetAmounts.cableInSoilMeters = SheetAmounts.this.cableInSoilMeters;
            sheetAmounts.cableStockMeters = SheetAmounts.this.cableStockMeters;
            sheetAmounts.platesPieces = SheetAmounts.this.platesPieces;
            sheetAmounts.backfillingCube = SheetAmounts.this.backfillingCube;
            sheetAmounts.garbageRemovalCube = SheetAmounts.this.garbageRemovalCube;
            return sheetAmounts;
        }

    }

    public float getDiggingTrenchInCube() {
        return diggingTrenchInCube;
    }

    public void setDiggingTrenchInCube(float diggingTrenchInCube) {
        this.diggingTrenchInCube = diggingTrenchInCube;
    }

    public float getSandInCube() {
        return sandInCube;
    }

    public void setSandInCube(float sandInCube) {
        this.sandInCube = sandInCube;
    }

    public float getSyntheticMaterialInSquare() {
        return syntheticMaterialInSquare;
    }

    public void setSyntheticMaterialInSquare(float syntheticMaterialInSquare) {
        this.syntheticMaterialInSquare = syntheticMaterialInSquare;
    }

    public float getPipesMeters() {
        return pipesMeters;
    }

    public void setPipesMeters(float pipesMeters) {
        this.pipesMeters = pipesMeters;
    }

    public int getQuantityCable() {
        return quantityCable;
    }

    public void setQuantityCable(int quantityCable) {
        this.quantityCable = quantityCable;
    }

    public float getGeneralLongCableMeters() {
        return generalLongCableMeters;
    }

    public void setGeneralLongCableMeters(float generalLongCableMeters) {
        this.generalLongCableMeters = generalLongCableMeters;
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

    public float getCableStockMeters() {
        return cableStockMeters;
    }

    public void setCableStockMeters(float cableStockMeters) {
        this.cableStockMeters = cableStockMeters;
    }

    public int getPlatesPieces() {
        return platesPieces;
    }

    public void setPlatesPieces(int platesPieces) {
        this.platesPieces = platesPieces;
    }

    public float getBackfillingCube() {
        return backfillingCube;
    }

    public void setBackfillingCube(float backfillingCube) {
        this.backfillingCube = backfillingCube;
    }

    public float getGarbageRemovalCube() {
        return garbageRemovalCube;
    }

    public void setGarbageRemovalCube(float garbageRemovalCube) {
        this.garbageRemovalCube = garbageRemovalCube;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n").append("TO DO");
        return String.valueOf(sb);
    }
}
