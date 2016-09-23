package uva.pcbuilder.dominio;

/**
 * Created by peuso on 22/09/2016.
 */
public class VideoGraphicsAdapter {
    private int score;
    private String nome;
    private String marca;
    private float consumo;

    public VideoGraphicsAdapter(int score, String nome, String marca, float consumo) {
        this.score = score;
        this.nome = nome;
        this.marca = marca;
        this.consumo = consumo;
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
