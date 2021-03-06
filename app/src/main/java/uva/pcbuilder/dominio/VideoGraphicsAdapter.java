package uva.pcbuilder.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by peuso on 22/09/2016.
 */
public class VideoGraphicsAdapter implements Hardware, Serializable {

    // Atributo para peça exemplo
    private static VideoGraphicsAdapter example;
    private static List<Hardware> listExample;

    private int idBanco;
    private int score;
    private String modelo;
    private String marca;
    private float consumo;
    private float price;

    public VideoGraphicsAdapter(int score, String modelo, String marca, float consumo, float price) {
        this.score = score;
        this.modelo = modelo;
        this.marca = marca;
        this.consumo = consumo;
        this.price = price;
    }

    public void setIdBanco(int i) {
        idBanco = i;
    }

    public int getScore() {
        return score;
    }

    public float getConsumo() {
        return consumo;
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
        return "Placa de Vídeo";
    }

    @Override
    public float getPreco() {
        return price;
    }

    @Override
    public String toString() {
        return "PLACA DE VÍDEO\n" +
                "Marca: " + marca + "\n" +
                "Modelo: " + modelo + "\n" +
                "Consumo: " + consumo + "W\n" +
                "Score: " + score + "\n" +
                "Preço: R$" + price;
    }

    // Metodo para criar peça exemplo
    public static List<Hardware> createExample() {
        if (example != null)
            return listExample;
        else {
            example = new VideoGraphicsAdapter(1000, "Modelo#Exemplo", "Marca#Exemplo", 150, 100);
            listExample = new ArrayList<>();
            listExample.add(example);
            return listExample;
        }
    }
}
