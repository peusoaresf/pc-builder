package uva.pcbuilder.fuzzylogic.fuzzysets;

import uva.pcbuilder.fuzzylogic.Valor;
import uva.pcbuilder.fuzzylogic.fuzzyfunction.FuzzyFunction;
import uva.pcbuilder.fuzzylogic.fuzzyfunction.TrapezoidFunction;
import uva.pcbuilder.fuzzylogic.fuzzyfunction.VgaTrapezoidFunction;

/**
 * Created by peuso on 01/11/2016.
 */

public class VgaFuzzySet implements FuzzySet {

    private FuzzyFunction[] precoVGA;

    public VgaFuzzySet() {
        precoVGA = new FuzzyFunction[6];
        precoVGA[0] = new VgaTrapezoidFunction(Valor.MB);
        precoVGA[1] = new VgaTrapezoidFunction(Valor.B);
        precoVGA[2] = new VgaTrapezoidFunction(Valor.M);
        precoVGA[3] = new VgaTrapezoidFunction(Valor.A);
        precoVGA[4] = new VgaTrapezoidFunction(Valor.MA);
        precoVGA[5] = new VgaTrapezoidFunction(Valor.E);

        // conjunto nebuloso do orcamento
        // MB
        precoVGA[0].setInterval(TrapezoidFunction.ANY_LEFT, 450);
        precoVGA[0].setMiddle(TrapezoidFunction.ANY_LEFT, 150);

        // B
        precoVGA[1].setInterval(150, 1050);
        precoVGA[1].setMiddle(450, 750);

        // M
        precoVGA[2].setInterval(750, 1650);
        precoVGA[2].setMiddle(1050, 1350);

        // A
        precoVGA[3].setInterval(1350, 2250);
        precoVGA[3].setMiddle(1650, 1950);

        // MA
        precoVGA[4].setInterval(1950, 2850);
        precoVGA[4].setMiddle(2250, 2550);

        //E
        precoVGA[5].setInterval(2550, TrapezoidFunction.ANY_RIGHT);
        precoVGA[5].setMiddle(2850, TrapezoidFunction.ANY_RIGHT);
    }

    @Override
    public FuzzyFunction[] getFuzzySet() {
        return precoVGA;
    }
}
