package uva.pcbuilder.fuzzylogic.fuzzyfunction;

import uva.pcbuilder.fuzzylogic.Valor;

/**
 * Created by peuso on 29/09/2016.
 */

public class TrapezoidFunction implements FuzzyFunction {

    public static final int ANY_LEFT = -10;
    public static final int ANY_RIGHT = -10;

    private float middleLeft, middleRight;
    private float left, right;
    private float relevanceValue;

    private Valor valor;

    public TrapezoidFunction(Valor valor) {
        this.valor = valor;
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
    public float defuzzification(float relevance) {
        float growth;
        float defuzziValue;

        if (this.getValor().equals(Valor.MB)) {
            growth = right - middleRight;
            defuzziValue =  right - (growth * relevance);
        }
        else if (this.getValor().equals(Valor.E)) {
            growth = middleLeft - left;
            defuzziValue = left + (growth * relevance);
        }
        else {
            growth = middleRight - middleLeft;
            float curva1 = left + (growth * relevance);
            float curva2 = right - (growth * relevance);
            defuzziValue = (curva1 + curva2)/2;
        }

        return defuzziValue;
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
    public float getRelevanceValue() {
        return this.relevanceValue;
    }

    public Valor getValor() {
        return this.valor;
    }
}
