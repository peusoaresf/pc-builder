package uva.pcbuilder.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by peuso on 22/09/2016.
 */
public class VideoGraphicsAdapter implements Hardware, Serializable {

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

    public int getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(int i) {
        idBanco = i;
    }

    @Override
    public float getPreco() {
        return price;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String getMarca() {
        return marca;
    }

    public float getConsumo() {
        return consumo;
    }

    @Override
    public String getModelo() {
        return modelo;
    }

    @Override
    public String getCategoria() {
        return "Placa de Vídeo";
    }

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
