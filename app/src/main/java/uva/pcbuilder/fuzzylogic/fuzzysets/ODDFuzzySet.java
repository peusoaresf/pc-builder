package uva.pcbuilder.fuzzylogic.fuzzysets;

import uva.pcbuilder.fuzzylogic.Valor;
import uva.pcbuilder.fuzzylogic.fuzzyfunction.FuzzyFunction;
import uva.pcbuilder.fuzzylogic.fuzzyfunction.TrapezoidFunction;

/**
 * Created by peuso on 18/11/2016.
 */

public class ODDFuzzySet implements FuzzySet {
    private FuzzyFunction[] precoODD;

    public ODDFuzzySet() {
        precoODD = new FuzzyFunction[6];
        precoODD[0] = new TrapezoidFunction(Valor.MB);
        precoODD[1] = new TrapezoidFunction(Valor.B);
        precoODD[2] = new TrapezoidFunction(Valor.M);
        precoODD[3] = new TrapezoidFunction(Valor.A);
        precoODD[4] = new TrapezoidFunction(Valor.MA);
        precoODD[5] = new TrapezoidFunction(Valor.E);

        // conjunto nebuloso do orcamento
        // MB
        precoODD[0].setInterval(TrapezoidFunction.ANY_LEFT, 70);
        precoODD[0].setMiddle(TrapezoidFunction.ANY_LEFT, 40);

        // B
        precoODD[1].setInterval(40, 130);
        precoODD[1].setMiddle(70, 100);

        // M
        precoODD[2].setInterval(100, 190);
        precoODD[2].setMiddle(130, 160);

        // A
        precoODD[3].setInterval(160, 250);
        precoODD[3].setMiddle(190, 220);

        // MA
        precoODD[4].setInterval(220, 310);
        precoODD[4].setMiddle(250, 280);

        //E
        precoODD[5].setInterval(280, TrapezoidFunction.ANY_RIGHT);
        precoODD[5].setMiddle(310, TrapezoidFunction.ANY_RIGHT);
    }

    @Override
    public FuzzyFunction[] getFuzzySet() {
        return precoODD;
    }
}
