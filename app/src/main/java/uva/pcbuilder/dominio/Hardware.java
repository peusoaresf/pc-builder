package uva.pcbuilder.dominio;

/**
 * Created by peuso on 05/11/2016.
 */

public interface Hardware {
    public String getMarca();
    public String getModelo();
    public float getPreco();
    public String getCategoria();
    // Analisar a sobescrita do metodo toString em todos as entidades na hierarquia.
    // Serviria para mostrar todos os detalhes de dado componente ao ser selecionado no listview.
}
