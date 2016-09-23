package uva.pcbuilder.dominio;

/**
 * Created by peuso on 22/09/2016.
 */
public class MainMemory {
    private float preco;
    private float consumoEletrico;
    private int score;
    private String marca;
    private String capacidade;
    private String tipo;

    public MainMemory(float preco, float consumoEletrico, int score, String marca, String capacidade, String tipo) {
        this.preco = preco;
        this.consumoEletrico = consumoEletrico;
        this.score = score;
        this.marca = marca;
        this.capacidade = capacidade;
        this.tipo = tipo;
    }

    public float getPreco() {
        return preco;
    }

    public float getConsumoEletrico() {
        return consumoEletrico;
    }

    public int getScore() {
        return score;
    }

    public String getMarca() {
        return marca;
    }

    public String getCapacidade() {
        return capacidade;
    }

    public String getTipo() {
        return tipo;
    }
}
