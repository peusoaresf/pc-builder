package uva.pcbuilder.dominio;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by peuso on 22/09/2016.
 */
public class Psu implements Hardware {

    private static Psu example;
    private static List<Hardware> listExample;

    private int idBanco;
    private int potencia;
    private int score;
    private float preco;
    private String modelo;
    private String marca;

    public Psu(int potencia, int score, float price, String modelo, String marca) {
        this.potencia = potencia;
        this.score = score;
        this.preco = price;
        this.modelo = modelo;
        this.marca = marca;
    }

    public int getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(int i) {
        idBanco = i;
    }

    public float getPrice() {
        return preco;
    }

    public int getPotencia() {
        return potencia;
    }

    public int getScore() {
        return score;
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
        if (example != null)
            return listExample;
        else {
            example = new Psu(500, 1000, 100, "Modelo#Exemplo", "Marca#Exemplo");
            listExample = new ArrayList<>();
            listExample.add(example);
            return listExample;
        }
    }
}
