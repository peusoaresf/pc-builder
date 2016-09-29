package uva.pcbuilder.fuzzysystems.vga;

import uva.pcbuilder.fuzzysystems.FuzzyFunction;
import uva.pcbuilder.fuzzysystems.Trapezoid;
import uva.pcbuilder.fuzzysystems.Valor;

/**
 * Created by peuso on 29/09/2016.
 */

public class FuzzySetsVGA {
    private FuzzyFunction[] precoVGA;

    public FuzzySetsVGA() {
        precoVGA = new FuzzyFunction[6];
        precoVGA[0] = new TrapezoidVGA(Valor.MB);
        precoVGA[1] = new TrapezoidVGA(Valor.B);
        precoVGA[2] = new TrapezoidVGA(Valor.M);
        precoVGA[3] = new TrapezoidVGA(Valor.A);
        precoVGA[4] = new TrapezoidVGA(Valor.MA);
        precoVGA[5] = new TrapezoidVGA(Valor.E);

        // conjunto nebuloso do orcamento
        // MB
        precoVGA[0].setInterval(Trapezoid.ANY_LEFT, 450);
        precoVGA[0].setMiddle(Trapezoid.ANY_LEFT, 150);

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
        precoVGA[5].setInterval(2550, Trapezoid.ANY_RIGHT);
        precoVGA[5].setMiddle(2850, Trapezoid.ANY_RIGHT);
    }

    public FuzzyFunction[] getFuzzySetsVga() {
        return this.precoVGA;
    }
}
