package uva.pcbuilder.fuzzylogic.fuzzyfunction;

/**
 * Created by peuso on 29/09/2016.
 */

public interface FuzzyFunction {

    public void setInterval(int left, int right);

    public void setMiddle(int middleLeft, int middleRight);

    public void fuzzification(float t);

    public float defuzzification(float f);

    public float getRelevanceValue();
}
