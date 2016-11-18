package uva.pcbuilder.fuzzylogic.fuzzysets;

import uva.pcbuilder.fuzzylogic.Valor;
import uva.pcbuilder.fuzzylogic.fuzzyfunction.FuzzyFunction;
import uva.pcbuilder.fuzzylogic.fuzzyfunction.TrapezoidFunction;

/**
 * Created by peuso on 18/11/2016.
 */

public class MoboFuzzySet implements FuzzySet {

    private FuzzyFunction[] precoMobo;

    public MoboFuzzySet() {
        precoMobo = new FuzzyFunction[6];
        precoMobo[0] = new TrapezoidFunction(Valor.MB);
        precoMobo[1] = new TrapezoidFunction(Valor.B);
        precoMobo[2] = new TrapezoidFunction(Valor.M);
        precoMobo[3] = new TrapezoidFunction(Valor.A);
        precoMobo[4] = new TrapezoidFunction(Valor.MA);
        precoMobo[5] = new TrapezoidFunction(Valor.E);

        // conjunto nebuloso do orcamento
        // MB
        precoMobo[0].setInterval(TrapezoidFunction.ANY_LEFT, 240);
        precoMobo[0].setMiddle(TrapezoidFunction.ANY_LEFT, 190);

        // B
        precoMobo[1].setInterval(190, 340);
        precoMobo[1].setMiddle(240, 290);

        // M
        precoMobo[2].setInterval(290, 440);
        precoMobo[2].setMiddle(340, 390);

        // A
        precoMobo[3].setInterval(390, 540);
        precoMobo[3].setMiddle(440, 490);

        // MA
        precoMobo[4].setInterval(490, 640);
        precoMobo[4].setMiddle(540, 590);

        //E
        precoMobo[5].setInterval(590, TrapezoidFunction.ANY_RIGHT);
        precoMobo[5].setMiddle(640, TrapezoidFunction.ANY_RIGHT);
    }

    @Override
    public FuzzyFunction[] getFuzzySet() {
        return precoMobo;
    }
}
