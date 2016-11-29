package uva.pcbuilder.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by peuso on 22/09/2016.
 */
public class OpticalDiskDriver implements Hardware, Serializable {

    // Atributos para peça exemplo
    private static OpticalDiskDriver example;
    private static List<Hardware> listExample;

    private int idBanco;
    private float consumoEletrico;
    private float preco;
    private String marca;
    private String modelo;
    private String tipoMidia;

    public OpticalDiskDriver(float consumoEletrico, float preco, String marca, String modelo, String tipoMidia) {
        this.consumoEletrico = consumoEletrico;
        this.preco = preco;
        this.marca = marca;
        this.modelo = modelo;
        this.tipoMidia = tipoMidia;
    }

    public void setIdBanco(int i) {
        idBanco = i;
    }

    public float getConsumoEletrico() {
        return consumoEletrico;
    }

    public String getTipoMidia() {
        return tipoMidia;
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
        return "Leitor de Disco";
    }

    @Override
    public float getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "LEITOR DE DISCO\n" +
                "Marca: " + marca + "\n" +
                "Modelo: " + modelo + "\n" +
                "Mídia Suportada: " + tipoMidia + "\n" +
                "Consumo: " + consumoEletrico + "W\n" +
                "Preço: R$" + preco;
    }

    // Metodo para criar peça exemplo
    public static List<Hardware> createExample() {
        if (example != null)
            return listExample;
        else {
            example = new OpticalDiskDriver(20, 100, "Marca#Exemplo", "Modelo#Exemplo", "TipoMidia#");
            listExample = new ArrayList<>();
            listExample.add(example);
            return listExample;
        }
    }
}
