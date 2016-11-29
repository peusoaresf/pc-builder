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
        // Ao criar um novo sistema fuzzy, é iniciado seus conjuntos nebulosos
        this.antecedentFuzzySet = OrcamentoFuzzySet.create();
        this.conclusionFuzzySet = conclusionFuzzySet;
    }

    public float calcularValorMaximo(float valorOrcamento) {

        // Instancia um grupo de conjuntos nebulosos com o grupo antecedente da regra e a conclusao
        FuzzyFunctionGroup fG = new FuzzyFunctionGroup(antecedentFuzzySet.getFuzzySet(), conclusionFuzzySet.getFuzzySet());

        // Realiza a fuzzificacao do antecedente para um valor de orçamento
        fG.fuzzificacaoAntecedente(valorOrcamento);

        // A base de conhecimento (onde estao as regras nebulosas) eh iniciada com o grupo de conjuntos
        KnowledgeBase knowledgeBase = new KnowledgeBase(fG);

        // A inferencia recebe as regras nebulosas
        InferenceEngine IE = new InferenceEngine(knowledgeBase.getRules());

        // E as avalia..
        IE.evaluateRules();

        // para realizar os calculos necessarios para retornar o valor exato de uma peça
        return IE.getOutPut();
    }
}
