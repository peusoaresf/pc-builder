package uva.pcbuilder.fuzzysystems;

import uva.pcbuilder.fuzzysystems.FuzzyFunction;
import uva.pcbuilder.fuzzysystems.Valor;

/**
 * Created by peuso on 29/09/2016.
 */

public class Trapezoid implements FuzzyFunction {

    public static final int ANY_LEFT = -10;
    public static final int ANY_RIGHT = -10;

    private float middleLeft, middleRight;
    private float left, right;
    private float relevanceValue;

    private Valor valor;

    public Trapezoid(Valor valor) {
        this.valor = valor;
    }

    @Override
    public void setInterval(int left, int right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public void setMiddle(int middleLeft, int middleRight) {
        this.middleLeft = middleLeft;
        this.middleRight = middleRight;
    }

    @Override
    public void fuzzification(float t) {
        // se for uma curva trapezoidal com inicio e fim
        if(right > ANY_RIGHT && middleRight > ANY_RIGHT && left > ANY_LEFT && middleLeft > ANY_LEFT) {
            if(t <= left) {
                this.relevanceValue = 0;
                return;
            }
            else if(t < middleLeft) {
                this.relevanceValue = (t-left)/(middleLeft-left);
                return;
            }
            else if(t <= middleRight) {
                this.relevanceValue = 1;
                return;
            }
            else if(t < right) {
                this.relevanceValue = (right-t)/(right-middleRight);
                return;
            }
            else {
                this.relevanceValue = 0;
                return;
            }
        }

        // se for uma curva trapezoidal com valores fixos a esquerda mas qualquer valor a direita
        if(right == ANY_RIGHT && middleRight == ANY_RIGHT) {
            if(t <= left) {
                this.relevanceValue = 0;
                return;
            }
            else if(t < middleLeft) {
                this.relevanceValue = (t-left)/(middleLeft-left);
                return;
            }
            else if(t >= middleLeft) {
                this.relevanceValue = 1;
                return;
            }
        }

        // se for uma curva trapezoidal com valores fixos a direita mas qualquer valor a direita
        if(left == ANY_LEFT && middleLeft == ANY_LEFT) {
            if(t <= middleRight) {
                this.relevanceValue = 1;
                return;
            }
            else if(t < right) {
                this.relevanceValue = (right-t)/(right-middleRight);
                return;
            }
            else if(t >= right) {
                this.relevanceValue = 0;
                return;
            }
        }
    }

    @Override
    public float defuzzification(float f) {
        // defuzzification precisa ser reescrito
        // por uma conclusao de regra
        return -1;
    }

    @Override
    public float getRelevanceValue() {
        return this.relevanceValue;
    }

    public Valor getValor() {
        return this.valor;
    }
}
