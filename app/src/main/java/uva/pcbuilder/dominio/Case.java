package uva.pcbuilder.dominio;

/**
 * Created by peuso on 22/09/2016.
 */
public class Case {
    private float preco;
    private String nome;

    public Case(float preco, String nome) {
        this.preco = preco;
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public String getNome() {
        return nome;
    }
}
