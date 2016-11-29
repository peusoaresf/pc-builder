package uva.pcbuilder.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by peuso on 22/09/2016.
 */
public class Motherboard implements Hardware, Serializable {

    // Atributos para peça exemplo
    private static Motherboard example;
    private static List<Hardware> listExample;

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

    public void setIdBanco(int i) {
        idBanco = i;
    }

    public float getConsumoEletrico() {
        return consumoEletrico;
    }

    public String getCpuSocket() {
        return cpuSocket;
    }

    public String getSupportedRamType() {
        return supportedRamType;
    }

    @Override
    public int getIdBanco() {
        return idBanco;
    }

    @Override
    public float getPreco() {
        return preco;
    }

    @Override
    public String getMarca() {
        return marca;
    }

    @Override
    public String getModelo() {
        return modelo;
    }

    @Override
    public String getCategoria() {
        return "Placa Mãe";
    }

    @Override
    public String toString() {
        return "PLACA MÃE\n" +
                "Marca: " + marca + "\n" +
                "Modelo: " + modelo + "\n" +
                "Socket: " + cpuSocket + "\n" +
                "Tipo Memória: " + supportedRamType + "\n" +
                "Consumo: " + consumoEletrico + "W\n" +
                "Preço: R$" + preco;
    }

    // Metodo para peça exemplo
    public static List<Hardware> createExample() {
        if (example != null)
            return listExample;
        else {
            example = new Motherboard(40, 100, "Marca#Exemplo", "Modelo#Exemplo", "Socket#", "RamType#");
            listExample = new ArrayList<>();
            listExample.add(example);
            return listExample;
        }
    }
}
