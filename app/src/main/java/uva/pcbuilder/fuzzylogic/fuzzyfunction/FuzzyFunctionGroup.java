package uva.pcbuilder.fuzzylogic.fuzzyfunction;

/**
 * Created by peuso on 01/11/2016.
 */

public class FuzzyFunctionGroup {
    private FuzzyFunction[] antecedent;
    private FuzzyFunction[] conclusion;

    public FuzzyFunctionGroup(FuzzyFunction[] antecedent, FuzzyFunction[] conclusion) {
        this.antecedent = antecedent;
        this.conclusion = conclusion;
    }

    public void fuzzificacaoAntecedente(float orcamento) {
        antecedent[0].fuzzification(orcamento);
        antecedent[1].fuzzification(orcamento);
        antecedent[2].fuzzification(orcamento);
        antecedent[3].fuzzification(orcamento);
        antecedent[4].fuzzification(orcamento);
        antecedent[5].fuzzification(orcamento);
    }

    public FuzzyFunction[] getAntecedent() {
        return antecedent;
    }

    public FuzzyFunction[] getConclusion() {
        return conclusion;
    }
}
