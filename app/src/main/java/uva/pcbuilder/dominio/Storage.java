package uva.pcbuilder.dominio;

/**
 * Created by peuso on 22/09/2016.
 */
public class Storage {
    private float preco;
    private float consumoEletrico;
    private String capacidade;
    private String marca;
    private String modelo;

    public Storage(float preco, float consumoEletrico, String capacidade, String marca, String m) {
        this.preco = preco;
        this.consumoEletrico = consumoEletrico;
        this.capacidade = capacidade;
        this.marca = marca;
        this.modelo = m;
    }

    public String getModel() {
        return modelo;
    }

    public float getPreco() {
        return preco;
    }

    public float getConsumoEletrico() {
        return consumoEletrico;
    }

    public String getCapacidade() {
        return capacidade;
    }

    public String getMarca() {
        return marca;
    }
}
