import java.util.List;

public interface ProjetoDAO {

    void adicionar(Projeto projeto) throws DadoConsultado;
    List<Projeto> listar();
    Projeto consultarPorNome(String nome) throws DadoConsultado;
    Projeto alterar(String nome, Projeto projeto) throws DadoConsultado;
    void excluir(Projeto projeto) throws DadoConsultado, UnsupportedOperationException;
    void excluir(String nome) throws DadoConsultado, UnsupportedOperationException;
}

