package uva.pcbuilder.dominio;

import java.util.Date;

/**
 * Created by peuso on 01/11/2016.
 */

public class FavoriteBuild {

    private int idBanco;
    private String nomeFavorito;
    private String dataFavorito;
    private Computer computer;

    public FavoriteBuild(int id, String nome, String data, Computer c) {
        idBanco = id;
        nomeFavorito = nome;
        dataFavorito = data;
        computer = c;
    }

    public int getIdBanco() {
        return idBanco;
    }

    public String getNomeFavorito() {
        return nomeFavorito;
    }

    public String getDataFavorito() {
        return dataFavorito;
    }

    public Computer getComputer() {
        return computer;
    }

}
