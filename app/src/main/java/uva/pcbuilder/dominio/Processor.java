package uva.pcbuilder.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by peuso on 22/09/2016.
 */
public class Processor implements Hardware, Serializable {

    // Atributos para peça exemplo
    private static Processor example;
    private static List<Hardware> listExample;

    private int idBanco;
    private int score;
    private float preco;
    private float consumoEletrico;
    private String socket;
    private String modelo;
    private String marca;

    public Processor(int score, float preco, float consumoEletrico, String socket, String modelo, String marca) {
        this.score = score;
        this.preco = preco;
        this.consumoEletrico = consumoEletrico;
        this.socket = socket;
        this.modelo = modelo;
        this.marca = marca;
    }

    public void setIdBanco(int i) {
        idBanco = i;
    }

    public int getScore() {
        return score;
    }

    public float getConsumoEletrico() {
        return consumoEletrico;
    }

    public String getSocket() {
        return socket;
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
        return "Processador";
    }

    @Override
    public String toString() {
        return "PROCESSADOR\n" +
                "Marca: " + marca + "\n" +
                "Modelo: " + modelo + "\n" +
                "Socket: " + socket + "\n" +
                "Score: " + score + "\n" +
                "Consumo: " + consumoEletrico + "W\n" +
                "Preço: R$" + preco;
    }

    // Metodo para criar peça exemplo
    public static List<Hardware> createExample() {
        if (example != null)
            return listExample;
        else {
            example = new Processor(1000, 100, 73, "Socket#", "Modelo#Exemplo", "Marca#Exemplo");
            listExample = new ArrayList<>();
            listExample.add(example);
            return listExample;
        }
    }
}
