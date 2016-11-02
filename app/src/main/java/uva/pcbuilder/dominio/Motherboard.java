package uva.pcbuilder.dominio;

/**
 * Created by peuso on 22/09/2016.
 */
public class Motherboard {
    private int idBanco;
    private float consumoEletrico;
    private float preco;
    private String marca;
    private String modelo;
    private String cpuSocket;
    private String supportedRamType;

    public Motherboard(float consumoEletrico, float preco, String marca, String modelo, String cpuSocket, String supportedRamType) {
        this.consumoEletrico = consumoEletrico;
        this.preco = preco;
        this.marca = marca;
        this.modelo = modelo;
        this.cpuSocket = cpuSocket;
        this.supportedRamType = supportedRamType;
    }

    public int getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(int i) {
        idBanco = i;
    }

    public float getConsumoEletrico() {
        return consumoEletrico;
    }

    public float getPreco() {
        return preco;
    }

    public String getMarca() { return marca; }

    public String getModelo() {
        return modelo;
    }

    public String getCpuSocket() {
        return cpuSocket;
    }

    public String getSupportedRamType() {
        return supportedRamType;
    }
}
