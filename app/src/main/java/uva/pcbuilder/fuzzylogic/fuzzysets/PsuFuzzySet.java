package uva.pcbuilder.fuzzylogic.fuzzysets;

import uva.pcbuilder.fuzzylogic.Valor;
import uva.pcbuilder.fuzzylogic.fuzzyfunction.FuzzyFunction;
import uva.pcbuilder.fuzzylogic.fuzzyfunction.TrapezoidFunction;

/**
 * Created by peuso on 18/11/2016.
 */

public class PsuFuzzySet implements FuzzySet {
    private FuzzyFunction[] precoPsu;

    public PsuFuzzySet() {
        precoPsu = new FuzzyFunction[6];
        precoPsu[0] = new TrapezoidFunction(Valor.MB);
        precoPsu[1] = new TrapezoidFunction(Valor.B);
        precoPsu[2] = new TrapezoidFunction(Valor.M);
        precoPsu[3] = new TrapezoidFunction(Valor.A);
        precoPsu[4] = new TrapezoidFunction(Valor.MA);
        precoPsu[5] = new TrapezoidFunction(Valor.E);

        // conjunto nebuloso do orcamento
        // MB
        precoPsu[0].setInterval(TrapezoidFunction.ANY_LEFT, 110);
        precoPsu[0].setMiddle(TrapezoidFunction.ANY_LEFT, 70);

        // B
        precoPsu[1].setInterval(70, 190);
        precoPsu[1].setMiddle(110, 150);

        // M
        precoPsu[2].setInterval(150, 270);
        precoPsu[2].setMiddle(190, 230);

        // A
        precoPsu[3].setInterval(230, 350);
        precoPsu[3].setMiddle(270, 310);

        // MA
        precoPsu[4].setInterval(310, 430);
        precoPsu[4].setMiddle(350, 390);

        //E
        precoPsu[5].setInterval(390, TrapezoidFunction.ANY_RIGHT);
        precoPsu[5].setMiddle(430, TrapezoidFunction.ANY_RIGHT);
    }

    @Override
    public FuzzyFunction[] getFuzzySet() {
        return precoPsu;
    }
}
