package uva.pcbuilder.fuzzylogic.fuzzysets;

import uva.pcbuilder.fuzzylogic.Valor;
import uva.pcbuilder.fuzzylogic.fuzzyfunction.FuzzyFunction;
import uva.pcbuilder.fuzzylogic.fuzzyfunction.TrapezoidFunction;

/**
 * Created by peuso on 01/11/2016.
 */

public class OrcamentoFuzzySet implements FuzzySet {

    private static OrcamentoFuzzySet orcamentoFuzzySet = null;

    private FuzzyFunction[] orcamento;

    private OrcamentoFuzzySet() {
        orcamento = new FuzzyFunction[6];
        orcamento[0] = new TrapezoidFunction(Valor.MB);
        orcamento[1] = new TrapezoidFunction(Valor.B);
        orcamento[2] = new TrapezoidFunction(Valor.M);
        orcamento[3] = new TrapezoidFunction(Valor.A);
        orcamento[4] = new TrapezoidFunction(Valor.MA);
        orcamento[5] = new TrapezoidFunction(Valor.E);

        // conjunto nebuloso do orcamento
        // MB
        orcamento[0].setInterval(TrapezoidFunction.ANY_LEFT, 1400);
        orcamento[0].setMiddle(TrapezoidFunction.ANY_LEFT, 800);

        // B
        orcamento[1].setInterval(800, 2600);
        orcamento[1].setMiddle(1400, 2000);

        // M
        orcamento[2].setInterval(2000, 3800);
        orcamento[2].setMiddle(2600, 3200);

        // A
        orcamento[3].setInterval(3200, 5000);
        orcamento[3].setMiddle(3800, 4400);

        // MA
        orcamento[4].setInterval(4400, 6200);
        orcamento[4].setMiddle(5000, 5600);

        //E
        orcamento[5].setInterval(5600, TrapezoidFunction.ANY_RIGHT);
        orcamento[5].setMiddle(6200, TrapezoidFunction.ANY_RIGHT);
    }

    public static OrcamentoFuzzySet create() {
        if (orcamentoFuzzySet != null)
            return orcamentoFuzzySet;
        else {
            orcamentoFuzzySet = new OrcamentoFuzzySet();
            return orcamentoFuzzySet;
        }
    }

    @Override
    public FuzzyFunction[] getFuzzySet() {
        return orcamento;
    }
}
