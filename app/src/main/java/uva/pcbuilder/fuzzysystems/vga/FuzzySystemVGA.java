package uva.pcbuilder.fuzzysystems.vga;

import uva.pcbuilder.fuzzysystems.FuzzySets;
import uva.pcbuilder.fuzzysystems.FuzzySetsOrcamento;
import uva.pcbuilder.fuzzysystems.InferenceEngine;
import uva.pcbuilder.fuzzysystems.KnowledgeBase;

/**
 * Created by peuso on 23/09/2016.
 */
public class FuzzySystemVGA {

    private FuzzySetsOrcamento fuzzySetsOrcamento;
    private FuzzySetsVGA fuzzySetsVGA;

    public FuzzySystemVGA() {
        this.fuzzySetsOrcamento = new FuzzySetsOrcamento();
        this.fuzzySetsVGA = new FuzzySetsVGA();
    }

    public float calcularValorMaximo(float orcamento) {
        System.out.println("Entrei no sistema fuzzy");

        FuzzySets fS = new FuzzySets(fuzzySetsOrcamento.getFuzzySetsOrcamento(), fuzzySetsVGA.getFuzzySetsVga());

        System.out.println("Instanciei os fuzzy sets");

        fS.fuzzificacaoAntecedente(orcamento);

        System.out.println("Fuzzificacao dos fuzzy sets");

        KnowledgeBase knowledgeBase = new KnowledgeBase(fS);

        System.out.println("Instanciei a base de conhecimento");

        InferenceEngine IE = new InferenceEngine(knowledgeBase.getRules());

        System.out.println("Instanciei a IE com a base de conhecimento");

        IE.evaluateRules();

        System.out.println("Avaliei as regras");

        return IE.getOutPut();
    }
}
