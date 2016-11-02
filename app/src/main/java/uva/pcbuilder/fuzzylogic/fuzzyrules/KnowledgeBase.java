package uva.pcbuilder.fuzzylogic.fuzzyrules;


import uva.pcbuilder.fuzzylogic.Valor;
import uva.pcbuilder.fuzzylogic.fuzzyfunction.FuzzyFunctionGroup;

/**
 * Created by peuso on 29/09/2016.
 */

public class KnowledgeBase {

    private static final int MB = Valor.MB.getPosicaoSet();
    private static final int B  = Valor.B.getPosicaoSet();
    private static final int M  = Valor.M.getPosicaoSet();
    private static final int A  = Valor.A.getPosicaoSet();
    private static final int MA = Valor.MA.getPosicaoSet();
    private static final int E  = Valor.E.getPosicaoSet();

    private FuzzyRule[] rules = new FuzzyRule[6];

    public KnowledgeBase(FuzzyFunctionGroup fG) {
        rules[0] = new FuzzyRule(fG.getAntecedent()[MB], fG.getConclusion()[MB]);
        rules[1] = new FuzzyRule(fG.getAntecedent()[B], fG.getConclusion()[B]);
        rules[2] = new FuzzyRule(fG.getAntecedent()[M], fG.getConclusion()[M]);
        rules[3] = new FuzzyRule(fG.getAntecedent()[A], fG.getConclusion()[A]);
        rules[4] = new FuzzyRule(fG.getAntecedent()[MA], fG.getConclusion()[MA]);
        rules[5] = new FuzzyRule(fG.getAntecedent()[E], fG.getConclusion()[E]);
    }

    public FuzzyRule[] getRules() {
        return this.rules;
    }
}
