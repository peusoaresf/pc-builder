package uva.pcbuilder.fuzzylogic.fuzzysets;

import uva.pcbuilder.fuzzylogic.Valor;
import uva.pcbuilder.fuzzylogic.fuzzyfunction.FuzzyFunction;
import uva.pcbuilder.fuzzylogic.fuzzyfunction.TrapezoidFunction;

/**
 * Created by peuso on 18/11/2016.
 */

public class StorageFuzzySet implements FuzzySet {
    private FuzzyFunction[] precoArmazenamento;

    public StorageFuzzySet() {
        precoArmazenamento = new FuzzyFunction[6];
        precoArmazenamento[0] = new TrapezoidFunction(Valor.MB);
        precoArmazenamento[1] = new TrapezoidFunction(Valor.B);
        precoArmazenamento[2] = new TrapezoidFunction(Valor.M);
        precoArmazenamento[3] = new TrapezoidFunction(Valor.A);
        precoArmazenamento[4] = new TrapezoidFunction(Valor.MA);
        precoArmazenamento[5] = new TrapezoidFunction(Valor.E);

        // conjunto nebuloso do orcamento
        // MB
        precoArmazenamento[0].setInterval(TrapezoidFunction.ANY_LEFT, 160);
        precoArmazenamento[0].setMiddle(TrapezoidFunction.ANY_LEFT, 130);

        // B
        precoArmazenamento[1].setInterval(130, 220);
        precoArmazenamento[1].setMiddle(160, 190);

        // M
        precoArmazenamento[2].setInterval(190, 280);
        precoArmazenamento[2].setMiddle(220, 250);

        // A
        precoArmazenamento[3].setInterval(250, 340);
        precoArmazenamento[3].setMiddle(280, 310);

        // MA
        precoArmazenamento[4].setInterval(310, 400);
        precoArmazenamento[4].setMiddle(340, 370);

        //E
        precoArmazenamento[5].setInterval(370, TrapezoidFunction.ANY_RIGHT);
        precoArmazenamento[5].setMiddle(400, TrapezoidFunction.ANY_RIGHT);
    }

    @Override
    public FuzzyFunction[] getFuzzySet() {
        return precoArmazenamento;
    }
}
