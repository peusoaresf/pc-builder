package uva.pcbuilder.dominio;

/**
 * Created by peuso on 22/09/2016.
 */
public class OpticalDiskDriver {

    private int idBanco;
    private float consumoEletrico;
    private float preco;
    private String marca;
    private String modelo;
    private String capacidade;

    public OpticalDiskDriver(float consumoEletrico, float preco, String marca, String m, String capacidade) {
        this.consumoEletrico = consumoEletrico;
        this.preco = preco;
        this.marca = marca;
        this.modelo = m;
        this.capacidade = capacidade;
    }

    public int getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(int i) {
        idBanco = i;
    }

    public float getPreco() {
        return preco;
    }

    public String getMarca() {
        return marca;
    }

    public String getCapacidade() {
        return capacidade;
    }
}
