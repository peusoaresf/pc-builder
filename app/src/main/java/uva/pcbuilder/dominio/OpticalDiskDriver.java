package uva.pcbuilder.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by peuso on 22/09/2016.
 */
public class OpticalDiskDriver implements Hardware, Serializable {

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

    public int getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(int i) {
        idBanco = i;
    }

    @Override
    public float getPreco() {
        return preco;
    }

    public float getConsumoEletrico() {
        return consumoEletrico;
    }

    public String getTipoMidia() {
        return tipoMidia;
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
            example = new OpticalDiskDriver(20, 100, "Marca#Exemplo", "Modelo#Exemplo", "TipoMidia#");
            listExample = new ArrayList<>();
            listExample.add(example);
            return listExample;
        }
    }
}
