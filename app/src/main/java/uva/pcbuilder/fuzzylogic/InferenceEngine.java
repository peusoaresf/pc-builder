package uva.pcbuilder.fuzzylogic;

import java.util.ArrayList;
import java.util.List;

import uva.pcbuilder.fuzzylogic.fuzzyrules.FuzzyRule;

/**
 * Created by peuso on 29/09/2016.
 */

public class InferenceEngine {
    // lista com valores de fuzzificacao
    private List w = new ArrayList();
    // listas com valores de deffuzificacao
    private List v = new ArrayList();

    private FuzzyRule[]  rules;

    public InferenceEngine(FuzzyRule[] rules) {
        this.rules = rules;
    }

    public void evaluateRules() {
        // percorre as regras e as avalia.
        // Se a pertinencia for maior que 0 a regra é considerada e eh calculado
        // a defuzzificacao da conclusao
        for (int i = 0; i < rules.length; i++) {
            float relevance = rules[i].getAntecedentFunction().getRelevanceValue();
            if (relevance > 0){
                float deffuziValue = rules[i].getConclusion().defuzzification(relevance);
                w.add(relevance);
                v.add(deffuziValue);
            }
        }
    }

    public float getOutPut() {
        // Realiza o calculo baseado no valor de fuzzificacao e defuzzificao para
        // retornar um preço exato da peça

        // soma da multiplicacao de cada w por seu v respectivo
        Float somaWxV = 0f;
        // soma de todos os w
        Float somaW = 0f;

        float somaWxVOutput = 0;
        float somaWOutput = 0;

        for(int i = 0; i < w.size(); i++) {
            somaWxV = somaWxV + ((Float)w.get(i) * (Float)v.get(i));
            somaW = somaW + (Float)w.get(i);
//            System.out.print("V: " + v.get(i) + " - ");
        }

//        System.out.println();

        w.clear();
        v.clear();

        somaWxVOutput = somaWxV;
        somaWOutput = somaW;

        return somaWxVOutput/somaWOutput;
    }
}
