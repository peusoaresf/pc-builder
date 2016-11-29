package uva.pcbuilder.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by peuso on 22/09/2016.
 */
public class Case implements Hardware, Serializable {

    // Atributos da peça de exemplo
    private static Case example;
    private static List<Hardware> listExample;

    private int idBanco;
    private float preco;
    private String modelo;
    private String marca;

    public Case(float preco, String modelo, String marca) {
        this.preco = preco;
        this.modelo = modelo;
        this.marca = marca;
    }

    public void setIdBanco(int i) {
        idBanco = i;
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
        return "Gabinete";
    }

    @Override
    public String toString() {
        return "GABINETE\n" +
                "Marca: " + marca + "\n" +
                "Modelo: " + modelo + "\n" +
                "Preço: R$" + preco;
    }

    // Metodo para criar uma peça de exemplo
    public static List<Hardware> createExample() {
        if (example != null)
            return listExample;
        else {
            example = new Case(100, "Modelo#Exemplo", "Marca#Exemplo");
            listExample = new ArrayList<>();
            listExample.add(example);
            return listExample;
        }
    }
}
