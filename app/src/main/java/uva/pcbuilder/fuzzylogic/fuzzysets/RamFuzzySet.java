package uva.pcbuilder.fuzzylogic.fuzzysets;

import uva.pcbuilder.fuzzylogic.Valor;
import uva.pcbuilder.fuzzylogic.fuzzyfunction.FuzzyFunction;
import uva.pcbuilder.fuzzylogic.fuzzyfunction.TrapezoidFunction;

/**
 * Created by peuso on 18/11/2016.
 */

public class RamFuzzySet implements FuzzySet {
    private FuzzyFunction[] precoRam;

    public RamFuzzySet() {
        precoRam = new FuzzyFunction[6];
        precoRam[0] = new TrapezoidFunction(Valor.MB);
        precoRam[1] = new TrapezoidFunction(Valor.B);
        precoRam[2] = new TrapezoidFunction(Valor.M);
        precoRam[3] = new TrapezoidFunction(Valor.A);
        precoRam[4] = new TrapezoidFunction(Valor.MA);
        precoRam[5] = new TrapezoidFunction(Valor.E);

        // conjunto nebuloso do orcamento
        // MB
        precoRam[0].setInterval(TrapezoidFunction.ANY_LEFT, 100);
        precoRam[0].setMiddle(TrapezoidFunction.ANY_LEFT, 50);

        // B
        precoRam[1].setInterval(50, 200);
        precoRam[1].setMiddle(100, 150);

        // M
        precoRam[2].setInterval(150, 300);
        precoRam[2].setMiddle(200, 250);

        // A
        precoRam[3].setInterval(250, 400);
        precoRam[3].setMiddle(300, 350);

        // MA
        precoRam[4].setInterval(350, 500);
        precoRam[4].setMiddle(400, 450);

        //E
        precoRam[5].setInterval(450, TrapezoidFunction.ANY_RIGHT);
        precoRam[5].setMiddle(500, TrapezoidFunction.ANY_RIGHT);
    }

    @Override
    public FuzzyFunction[] getFuzzySet() {
        return precoRam;
    }
}
