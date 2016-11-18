package uva.pcbuilder.fuzzylogic.fuzzysets;

import uva.pcbuilder.fuzzylogic.Valor;
import uva.pcbuilder.fuzzylogic.fuzzyfunction.FuzzyFunction;
import uva.pcbuilder.fuzzylogic.fuzzyfunction.TrapezoidFunction;

/**
 * Created by peuso on 18/11/2016.
 */

public class CpuFuzzySet implements FuzzySet {

    private FuzzyFunction[] precoCpu;

    public CpuFuzzySet() {
        precoCpu = new FuzzyFunction[6];
        precoCpu[0] = new TrapezoidFunction(Valor.MB);
        precoCpu[1] = new TrapezoidFunction(Valor.B);
        precoCpu[2] = new TrapezoidFunction(Valor.M);
        precoCpu[3] = new TrapezoidFunction(Valor.A);
        precoCpu[4] = new TrapezoidFunction(Valor.MA);
        precoCpu[5] = new TrapezoidFunction(Valor.E);

        // conjunto nebuloso do orcamento
        // MB
        precoCpu[0].setInterval(TrapezoidFunction.ANY_LEFT, 220);
        precoCpu[0].setMiddle(TrapezoidFunction.ANY_LEFT, 100);

        // B
        precoCpu[1].setInterval(100, 460);
        precoCpu[1].setMiddle(220, 340);

        // M
        precoCpu[2].setInterval(340, 700);
        precoCpu[2].setMiddle(460, 580);

        // A
        precoCpu[3].setInterval(580, 940);
        precoCpu[3].setMiddle(700, 820);

        // MA
        precoCpu[4].setInterval(820, 1180);
        precoCpu[4].setMiddle(940, 1060);

        //E
        precoCpu[5].setInterval(1060, TrapezoidFunction.ANY_RIGHT);
        precoCpu[5].setMiddle(1180, TrapezoidFunction.ANY_RIGHT);
    }

    @Override
    public FuzzyFunction[] getFuzzySet() {
        return precoCpu;
    }
}
