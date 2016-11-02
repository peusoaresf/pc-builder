package uva.pcbuilder.dominio;

/**
 * Created by peuso on 22/09/2016.
 */
public class Processor {
    private int idBanco;
    private int score;
    private float preco;
    private float consumoEletrico;
    private String socket;
    private String nome;
    private String marca;

    public Processor(int score, float preco, float consumoEletrico, String socket, String nome, String marca) {
        this.score = score;
        this.preco = preco;
        this.consumoEletrico = consumoEletrico;
        this.socket = socket;
        this.nome = nome;
        this.marca = marca;
    }

    public int getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(int i) {
        idBanco = i;
    }

    public int getScore() {
        return score;
    }

    public float getPreco() {
        return preco;
    }

    public float getConsumoEletrico() {
        return consumoEletrico;
    }

    public String getSocket() {
        return socket;
    }

    public String getNome() {
        return nome;
    }

    public String getMarca() {
        return marca;
    }
}
