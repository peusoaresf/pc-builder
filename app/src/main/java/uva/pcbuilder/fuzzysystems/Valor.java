package uva.pcbuilder.fuzzysystems;

/**
 * Created by peuso on 29/09/2016.
 */

public enum Valor {
    // Muito baixo, baixo, medio, alto, muito alto, entusiasta
    MB,B, M, A, MA, E;

    public int getPosicaoSet() {
        if (this == MB) {
            return 0;
        }
        if (this == B) {
            return 1;
        }
        if (this == M) {
            return 2;
        }
        if (this == A) {
            return 3;
        }
        if (this == MA) {
            return 4;
        }
        if (this == E) {
            return 5;
        };

        return -1;
    }
}
