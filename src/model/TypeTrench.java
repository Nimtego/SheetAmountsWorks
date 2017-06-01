package model;

/**
 * Created by myasnikov
 * on 01.06.2017.
 */
public class TypeTrench {
    private int basisWidth;
    private int depth;
    private float diggingTrench;
    private float backfilling;
    private float sandVolume;

    private TypeTrench() {
    }
    public static TypeTrenchBuilder TypeTrenchBuilder() {
        return new TypeTrench().new TypeTrenchBuilder();
    }
    //Builder iner
    public class TypeTrenchBuilder {

        private TypeTrenchBuilder() {}

        public TypeTrenchBuilder basisWidth(final int basisWidth) {
            TypeTrench.this.basisWidth = basisWidth;
            return this;
        }
        public TypeTrenchBuilder depth(final int depth) {
            TypeTrench.this.depth = depth;
            return this;
        }
        public TypeTrenchBuilder diggingTrench(final float diggingTrench) {
            TypeTrench.this.diggingTrench = diggingTrench;
            return this;
        }
        public TypeTrenchBuilder backfilling(final float backfilling) {
            TypeTrench.this.backfilling = backfilling;
            return this;
        }
        public TypeTrenchBuilder sandVolume(final int sandVolume) {
            TypeTrench.this.sandVolume = sandVolume;
            return this;
        }

        public TypeTrench build() {
            TypeTrench typeTrench = new TypeTrench();
            typeTrench.basisWidth = TypeTrench.this.basisWidth;
            typeTrench.depth = TypeTrench.this.depth;
            typeTrench.diggingTrench = TypeTrench.this.diggingTrench;
            typeTrench.backfilling = TypeTrench.this.backfilling;
            typeTrench.sandVolume = TypeTrench.this.sandVolume;
            return typeTrench;
        }

    }

    public int getBasisWidth() {
        return basisWidth;
    }

    public void setBasisWidth(int basisWidth) {
        this.basisWidth = basisWidth;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public float getDiggingTrench() {
        return diggingTrench;
    }

    public void setDiggingTrench(float diggingTrench) {
        this.diggingTrench = diggingTrench;
    }

    public float getBackfilling() {
        return backfilling;
    }

    public void setBackfilling(float backfilling) {
        this.backfilling = backfilling;
    }

    public float getSandVolume() {
        return sandVolume;
    }

    public void setSandVolume(float sandVolume) {
        this.sandVolume = sandVolume;
    }
}
