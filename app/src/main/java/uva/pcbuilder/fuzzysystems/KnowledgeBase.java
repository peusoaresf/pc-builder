package uva.pcbuilder.fuzzysystems;

import uva.pcbuilder.fuzzysystems.FuzzyRule;
import uva.pcbuilder.fuzzysystems.FuzzySets;
import uva.pcbuilder.fuzzysystems.Valor;

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

    public KnowledgeBase(FuzzySets fS) {
        rules[0] = new FuzzyRule(fS.getAntecedente()[MB], fS.getConclusao()[MB]);
        rules[1] = new FuzzyRule(fS.getAntecedente()[B], fS.getConclusao()[B]);
        rules[2] = new FuzzyRule(fS.getAntecedente()[M], fS.getConclusao()[M]);
        rules[3] = new FuzzyRule(fS.getAntecedente()[A], fS.getConclusao()[A]);
        rules[4] = new FuzzyRule(fS.getAntecedente()[MA], fS.getConclusao()[MA]);
        rules[5] = new FuzzyRule(fS.getAntecedente()[E], fS.getConclusao()[E]);
    }

    public FuzzyRule[] getRules() {
        return this.rules;
    }
}
