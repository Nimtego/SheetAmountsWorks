package model.calculation;

import java.util.ArrayList;
import java.util.List;

import static model.calculation.Discrition.*;

/**
 * Created by myasnikov
 * on 26.07.2017.
 */
public class Excavation {
    private Volume<Float> diggingTrenchInCube; //Рытье траншеи
    private Volume<Float> sandInCube; //Устройство постели из песка для траншеи
    private Volume<Float> backfillingCube; //Обратная засыпка траншеи грунтом.
    private Volume<Float> garbageRemovalCube; //Вывоз мусора

    private Excavation(){}
    public static ExcavationBuilder excavationBuilder() {
        return new Excavation().new ExcavationBuilder();
    }

    public Volume<Float> getDiggingTrenchInCube() {
        return diggingTrenchInCube;
    }

    public Volume<Float> getSandInCube() {
        return sandInCube;
    }

    public Volume<Float> getBackfillingCube() {
        return backfillingCube;
    }

    public Volume<Float> getGarbageRemovalCube() {
        return garbageRemovalCube;
    }
    public String[][] formating() {
        List<Volume> volumeList = new ArrayList<>();
        volumeList.add(diggingTrenchInCube);
        volumeList.add(sandInCube);
        volumeList.add(backfillingCube);
        volumeList.add(garbageRemovalCube);
        String[][] form = new String[volumeList.size()][3];
        int i = 0;
        for (Volume volume : volumeList) {
            form[i][0] = volume.getDescription();
            form[i][1] = String.valueOf(volume.getValue());
            form[i][2] = volume.getUnit();
            i++;
        }
        return form;
    }

    //Builder iner
    public class ExcavationBuilder {

        private ExcavationBuilder() {
        }

        public ExcavationBuilder diggingTrenchInCube(final float diggingTrenchInCube) {
            Excavation.this.diggingTrenchInCube =
                    new Volume<>(DIGGING, VOLUME_CUB, diggingTrenchInCube);
            return this;
        }

        public ExcavationBuilder sandInCube(final float sandInCube) {
            Excavation.this.sandInCube =
                    new Volume<>(SAND, VOLUME_CUB, sandInCube);
            return this;
        }

        public ExcavationBuilder backfillingCube(final float backfillingCube) {
            Excavation.this.backfillingCube =
                    new Volume<>(BACK_FILLING, VOLUME_CUB, backfillingCube);
            return this;
        }

        public ExcavationBuilder garbageRemovalCube(final float garbageRemovalCube) {
            Excavation.this.garbageRemovalCube =
                    new Volume<>(GARBAGE, VOLUME_CUB, garbageRemovalCube);
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
