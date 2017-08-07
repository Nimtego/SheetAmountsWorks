package model.calculation;

/**
 * Created by myasnikov
 * on 26.07.2017.
 */
public class Excavation {
    private float diggingTrenchInCube; //Рытье траншеи
    private float sandInCube; //Устройство постели из песка для траншеи
    private float backfillingCube; //Обратная засыпка траншеи грунтом.
    private float garbageRemovalCube; //Вывоз мусора

    private Excavation(){}
    public static ExcavationBuilder excavationBuilder() {
        return new Excavation().new ExcavationBuilder();
    }

    public float getDiggingTrenchInCube() {
        return diggingTrenchInCube;
    }

    public float getSandInCube() {
        return sandInCube;
    }

    public float getBackfillingCube() {
        return backfillingCube;
    }

    public float getGarbageRemovalCube() {
        return garbageRemovalCube;
    }

    //Builder iner
    public class ExcavationBuilder {

        private ExcavationBuilder() {
        }

        public ExcavationBuilder diggingTrenchInCube(final float diggingTrenchInCube) {
            Excavation.this.diggingTrenchInCube = diggingTrenchInCube;
            return this;
        }

        public ExcavationBuilder sandInCube(final float sandInCube) {
            Excavation.this.sandInCube = sandInCube;
            return this;
        }

        public ExcavationBuilder backfillingCube(final float backfillingCube) {
            Excavation.this.backfillingCube = backfillingCube;
            return this;
        }

        public ExcavationBuilder garbageRemovalCube(final float garbageRemovalCube) {
            Excavation.this.garbageRemovalCube = garbageRemovalCube;
            return this;
        }
        public Excavation build() {
            Excavation excavation = new Excavation();
            excavation.diggingTrenchInCube = Excavation.this.diggingTrenchInCube;
            excavation.sandInCube = Excavation.this.sandInCube;
            excavation.backfillingCube = Excavation.this.backfillingCube;
            excavation.garbageRemovalCube = Excavation.this.garbageRemovalCube;
            return excavation;
        }
    }
}
