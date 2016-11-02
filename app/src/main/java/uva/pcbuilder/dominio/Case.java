package uva.pcbuilder.dominio;

/**
 * Created by peuso on 22/09/2016.
 */
public class Case {
    private int idBanco;
    private float preco;
    private String nome;
    private String marca;

    public Case(float preco, String nome, String m) {
        this.preco = preco;
        this.nome = nome;
        this.marca = m;
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

    public String getNome() {
        return nome;
    }
}
