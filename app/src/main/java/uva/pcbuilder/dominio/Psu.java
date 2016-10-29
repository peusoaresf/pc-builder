package uva.pcbuilder.dominio;

/**
 * Created by peuso on 22/09/2016.
 */
public class Psu {

    private int potencia;
    private int score;
    private float preco;
    private String nome;
    private String marca;

    public Psu(int potencia, int score, float price, String nome, String marca) {
        this.potencia = potencia;
        this.score = score;
        this.preco = price;
        this.nome = nome;
        this.marca = marca;
    }

    public float getPrice() {
        return preco;
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
