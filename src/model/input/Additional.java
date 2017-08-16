package model.input;

/**
 * Created by myasnikov
 * on 16.08.2017.
 */
public class Additional {
    private boolean synthetic;
    private boolean plates;
    private boolean crushedStone;
    private boolean alarmTape;
    private boolean board;

    private Additional(){}
    public static AdditionalBuilder additionalBuilder() {
        return new Additional().new AdditionalBuilder();
    }

    public boolean getSynthetic() {
        return synthetic;
    }

    public boolean getPlates() {
        return plates;
    }

    public boolean getCrushedStone() {
        return crushedStone;
    }

    public boolean getAlarmTape() {
        return alarmTape;
    }

    public boolean getBoard() {
        return board;
    }
    //Builder iner
    public class AdditionalBuilder {

        private AdditionalBuilder() {
        }

        public AdditionalBuilder synthetic(final boolean synthetic) {
            Additional.this.synthetic = synthetic;
            return this;
        }

        public AdditionalBuilder plates(final boolean plates) {
            Additional.this.plates = plates;
            return this;
        }

        public AdditionalBuilder crushedStone(final boolean crushedStone) {
            Additional.this.crushedStone = crushedStone;
            return this;
        }

        public AdditionalBuilder alarmTape(final boolean alarmTape) {
            Additional.this.alarmTape = alarmTape;
            return this;
        }
        public AdditionalBuilder board(final boolean board) {
            Additional.this.board = board;
            return this;
        }
        public Additional build() {
            Additional additional = new Additional();
            additional.synthetic = Additional.this.synthetic;
            additional.plates = Additional.this.plates;
            additional.crushedStone = Additional.this.crushedStone;
            additional.alarmTape = Additional.this.alarmTape;
            additional.board = Additional.this.board;
            additional.board = Additional.this.board;
            return additional;
        }
    }
}
