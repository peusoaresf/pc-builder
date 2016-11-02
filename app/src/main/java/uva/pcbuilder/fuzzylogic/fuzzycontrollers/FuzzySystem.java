package uva.pcbuilder.fuzzylogic.fuzzycontrollers;


import uva.pcbuilder.fuzzylogic.InferenceEngine;
import uva.pcbuilder.fuzzylogic.fuzzyrules.KnowledgeBase;
import uva.pcbuilder.fuzzylogic.fuzzyfunction.FuzzyFunctionGroup;
import uva.pcbuilder.fuzzylogic.fuzzysets.FuzzySet;
import uva.pcbuilder.fuzzylogic.fuzzysets.OrcamentoFuzzySet;

/**
 * Created by peuso on 01/11/2016.
 */

public abstract class FuzzySystem {
    private FuzzySet antecedentFuzzySet;
    private FuzzySet conclusionFuzzySet;

    public FuzzySystem(FuzzySet conclusionFuzzySet) {
        this.antecedentFuzzySet = OrcamentoFuzzySet.create();
        this.conclusionFuzzySet = conclusionFuzzySet;
    }

    public float calcularValorMaximo(float valorOrcamento) {

        FuzzyFunctionGroup fG = new FuzzyFunctionGroup(antecedentFuzzySet.getFuzzySet(), conclusionFuzzySet.getFuzzySet());

        fG.fuzzificacaoAntecedente(valorOrcamento);

        KnowledgeBase knowledgeBase = new KnowledgeBase(fG);

        InferenceEngine IE = new InferenceEngine(knowledgeBase.getRules());

        IE.evaluateRules();

        return IE.getOutPut();
    }
}
