package uva.pcbuilder.dominio;

/**
 * Created by peuso on 22/09/2016.
 */
public class VideoGraphicsAdapter {
    private int score;
    private String nome;
    private String marca;
    private float consumo;
    private float price;

    public VideoGraphicsAdapter(int score, String nome, String marca, float consumo, float price) {
        this.score = score;
        this.nome = nome;
        this.marca = marca;
        this.consumo = consumo;
        this.price = price;
    }

    public float getPreco() {
        return price;
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

    public float getConsumo() {
        return consumo;
    }
}
