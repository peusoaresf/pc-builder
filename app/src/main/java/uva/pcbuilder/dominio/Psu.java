package uva.pcbuilder.dominio;

/**
 * Created by peuso on 22/09/2016.
 */
public class Psu {

    private int potencia;
    private int score;
    private String nome;
    private String marca;

    public Psu(int potencia, int score, String nome, String marca) {
        this.potencia = potencia;
        this.score = score;
        this.nome = nome;
        this.marca = marca;
    }

    public int getPotencia() {
        return potencia;
    }

    public int getScore() {
        return score;
    }

    public String getNome() {
        return nome;
    }

    public String getMarca() {
        return marca;
    }
}
