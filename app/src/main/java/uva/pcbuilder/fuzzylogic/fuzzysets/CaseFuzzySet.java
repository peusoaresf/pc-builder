package uva.pcbuilder.fuzzylogic.fuzzysets;

import uva.pcbuilder.fuzzylogic.Valor;
import uva.pcbuilder.fuzzylogic.fuzzyfunction.FuzzyFunction;
import uva.pcbuilder.fuzzylogic.fuzzyfunction.TrapezoidFunction;

/**
 * Created by peuso on 18/11/2016.
 */

public class CaseFuzzySet implements FuzzySet {
    private FuzzyFunction[] precoCase;

    public CaseFuzzySet() {
        precoCase = new FuzzyFunction[6];
        precoCase[0] = new TrapezoidFunction(Valor.MB);
        precoCase[1] = new TrapezoidFunction(Valor.B);
        precoCase[2] = new TrapezoidFunction(Valor.M);
        precoCase[3] = new TrapezoidFunction(Valor.A);
        precoCase[4] = new TrapezoidFunction(Valor.MA);
        precoCase[5] = new TrapezoidFunction(Valor.E);

        // conjunto nebuloso do orcamento
        // MB
        precoCase[0].setInterval(TrapezoidFunction.ANY_LEFT, 110);
        precoCase[0].setMiddle(TrapezoidFunction.ANY_LEFT, 50);

        // B
        precoCase[1].setInterval(50, 230);
        precoCase[1].setMiddle(110, 170);

        // M
        precoCase[2].setInterval(170, 350);
        precoCase[2].setMiddle(230, 290);

        // A
        precoCase[3].setInterval(290, 470);
        precoCase[3].setMiddle(350, 410);

        // MA
        precoCase[4].setInterval(410, 590);
        precoCase[4].setMiddle(470, 530);

        //E
        precoCase[5].setInterval(530, TrapezoidFunction.ANY_RIGHT);
        precoCase[5].setMiddle(590, TrapezoidFunction.ANY_RIGHT);
    }

    @Override
    public FuzzyFunction[] getFuzzySet() {
        return precoCase;
    }
}
