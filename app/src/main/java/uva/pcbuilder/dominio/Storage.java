package uva.pcbuilder.dominio;

/**
 * Created by peuso on 22/09/2016.
 */
public class Storage {
    private float preco;
    private float consumoEletrico;
    private String capacidade;
    private String marca;

    public Storage(float preco, float consumoEletrico, String capacidade, String marca) {
        this.preco = preco;
        this.consumoEletrico = consumoEletrico;
        this.capacidade = capacidade;
        this.marca = marca;
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
