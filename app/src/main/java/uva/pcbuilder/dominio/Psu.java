package uva.pcbuilder.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by peuso on 22/09/2016.
 */
public class Psu implements Hardware, Serializable {

    // Atributos para peça Exemplo
    private static Psu example;
    private static List<Hardware> listExample;

    private int idBanco;
    private int potencia;
    private float preco;
    private String modelo;
    private String marca;

    public Psu(int potencia, float price, String modelo, String marca) {
        this.potencia = potencia;
        this.preco = price;
        this.modelo = modelo;
        this.marca = marca;
    }

    public void setIdBanco(int i) {
        idBanco = i;
    }

    public int getPotencia() {
        return potencia;
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
    public String getCategoria() {
        return "Fonte";
    }

    @Override
    public float getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "FONTE\n" +
                "Marca: " + marca + "\n" +
                "Modelo: " + modelo + "\n" +
                "Potencia: " + potencia + "W\n" +
                "Preço: R$" + preco;
    }

    // Metodo para criar peça exemplo
    public static List<Hardware> createExample() {
        if (example != null)
            return listExample;
        else {
            example = new Psu(500, 100, "Modelo#Exemplo", "Marca#Exemplo");
            listExample = new ArrayList<>();
            listExample.add(example);
            return listExample;
        }
    }
}
