package uva.pcbuilder.fuzzylogic.fuzzyrules;

import uva.pcbuilder.fuzzylogic.fuzzyfunction.FuzzyFunction;

/**
 * Created by peuso on 29/09/2016.
 */

public class FuzzyRule {

    FuzzyFunction antecedentFunction;
    FuzzyFunction conclusion;

    public FuzzyRule(FuzzyFunction antecedentFunction, FuzzyFunction conclusion) {
        this.antecedentFunction = antecedentFunction;
        this.conclusion = conclusion;
    }


    public FuzzyFunction getAntecedentFunction() {
        return antecedentFunction;
    }

    public FuzzyFunction getConclusion() {
        return conclusion;
    }
}
