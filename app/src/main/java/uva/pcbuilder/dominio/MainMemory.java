package uva.pcbuilder.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by peuso on 22/09/2016.
 */
public class MainMemory implements Hardware, Serializable {

    // Atributos para criar peça de exemplo
    private static MainMemory example;
    private static List<Hardware> listExample;

    private int idBanco;
    private float preco;
    private float consumoEletrico;
    private String marca;
    private String modelo;
    private String capacidade;
    private String tipo;

    public MainMemory(float preco, float consumoEletrico, String marca, String modelo, String capacidade, String tipo) {
        this.preco = preco;
        this.consumoEletrico = consumoEletrico;
        this.marca = marca;
        this.modelo = modelo;
        this.capacidade = capacidade;
        this.tipo = tipo;
    }

    public void setIdBanco(int i) {
        idBanco = i;
    }

    public float getConsumoEletrico() {
        return consumoEletrico;
    }

    public String getCapacidade() {
        return capacidade;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public int getIdBanco() {
        return idBanco;
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
    public float getPreco() {
        return preco;
    }

    @Override
    public String getCategoria() {
        return "Memória RAM";
    }

    @Override
    public String toString() {
        return "MEMÓRIA RAM\n" +
                "Marca: " + marca + "\n" +
                "Modelo: " + modelo + "\n" +
                "Tamanho: " + capacidade + "\n" +
                "Tipo: " + tipo + "\n" +
                "Consumo: " + consumoEletrico + "W\n" +
                "Preço: R$" + preco;
    }

    // Metodo para criar peça exemplo
    public static List<Hardware> createExample() {
        if (example != null)
            return listExample;
        else {
            example = new MainMemory(100, 3, "Marca#Exemplo", "Modelo#Exemplo", "#GB", "TIPO#");
            listExample = new ArrayList<>();
            listExample.add(example);
            return listExample;
        }
    }
}
