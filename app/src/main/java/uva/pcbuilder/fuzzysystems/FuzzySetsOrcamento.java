package uva.pcbuilder.fuzzysystems;

import uva.pcbuilder.fuzzysystems.FuzzyFunction;
import uva.pcbuilder.fuzzysystems.Trapezoid;
import uva.pcbuilder.fuzzysystems.Valor;

/**
 * Created by peuso on 29/09/2016.
 */

public class FuzzySetsOrcamento {
    private FuzzyFunction[] orcamento;

    public FuzzySetsOrcamento() {
        orcamento = new FuzzyFunction[6];
        orcamento[0] = new Trapezoid(Valor.MB);
        orcamento[1] = new Trapezoid(Valor.B);
        orcamento[2] = new Trapezoid(Valor.M);
        orcamento[3] = new Trapezoid(Valor.A);
        orcamento[4] = new Trapezoid(Valor.MA);
        orcamento[5] = new Trapezoid(Valor.E);

        // conjunto nebuloso do orcamento
        // MB
        orcamento[0].setInterval(Trapezoid.ANY_LEFT, 1400);
        orcamento[0].setMiddle(Trapezoid.ANY_LEFT, 800);

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
        orcamento[5].setInterval(5600, Trapezoid.ANY_RIGHT);
        orcamento[5].setMiddle(6200, Trapezoid.ANY_RIGHT);
    }

    public FuzzyFunction[] getFuzzySetsOrcamento() {
        return orcamento;
    }
}
