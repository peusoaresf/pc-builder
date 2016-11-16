package uva.pcbuilder.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by peuso on 22/09/2016.
 */
public class Storage implements Hardware, Serializable {

    private static Storage example;
    private static List<Hardware> listExample;

    private int idBanco;
    private float preco;
    private float consumoEletrico;
    private String capacidade;
    private String marca;
    private String modelo;

    public Storage(float preco, float consumoEletrico, String capacidade, String marca, String modelo) {
        this.preco = preco;
        this.consumoEletrico = consumoEletrico;
        this.capacidade = capacidade;
        this.marca = marca;
        this.modelo = modelo;
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

    public float getConsumoEletrico() {
        return consumoEletrico;
    }

    public String getCapacidade() {
        return capacidade;
    }

    @Override
    public String getMarca() {
        return marca;
    }

    @Override
    public String getModelo() {
        return modelo;
    }

    public static List<Hardware> createExample() {
        if (example != null) {
            return listExample;
        }
        else {
            example = new Storage(100, 8, "#TB", "Marca#Exemplo", "Modelo#Exemplo");
            listExample = new ArrayList<>();
            listExample.add(example);
            return listExample;
        }
    }
}
