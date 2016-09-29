package uva.pcbuilder.fuzzysystems;

import uva.pcbuilder.fuzzysystems.FuzzyFunction;

/**
 * Created by peuso on 29/09/2016.
 */

public class FuzzySets {
    private FuzzyFunction[] antecedente;
    private FuzzyFunction[] conclusao;

    public FuzzySets(FuzzyFunction[] antecedente, FuzzyFunction[] conclusao) {
        this.antecedente = antecedente;
        this.conclusao = conclusao;
    }

    public void fuzzificacaoAntecedente(float orcamento) {
        antecedente[0].fuzzification(orcamento);
        antecedente[1].fuzzification(orcamento);
        antecedente[2].fuzzification(orcamento);
        antecedente[3].fuzzification(orcamento);
        antecedente[4].fuzzification(orcamento);
        antecedente[5].fuzzification(orcamento);
    }

    public FuzzyFunction[] getAntecedente() {
        return antecedente;
    }

    public FuzzyFunction[] getConclusao() {
        return conclusao;
    }
}
