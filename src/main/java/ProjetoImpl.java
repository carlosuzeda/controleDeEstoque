import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProjetoImpl implements ProjetoDAO {
    //Collection que irá armazenar todos os projetos
    private static Set<Projeto> projetos = new HashSet<>();

    @Override
    public void adicionar(Projeto projeto) throws DadoConsultado {
        for (Projeto projeto1: projetos) {
            if (projeto.getNome().equalsIgnoreCase(projeto.getNome())) {
                throw new DadoConsultado("Esse projeto já existe!");
            }
        }
        projetos.add(projeto);
    }

    @Override
    public List<Projeto> listar() {
        List<Projeto> projetoList = new ArrayList<>();
        projetoList.addAll(projetos);
        return projetoList;
    }

    @Override
    public Projeto consultarPorNome(String nome) throws DadoConsultado {
        for (Projeto projeto: projetos){
            if (projeto.getNome().equalsIgnoreCase(nome)){
                return projeto;
            }
        }
        throw new DadoConsultado("Projeto com o nome (" + nome + ") não encontrado.");
    }

    @Override
    public Projeto alterar(String nome, Projeto projeto) throws DadoConsultado {
        if (projeto.getNome().equalsIgnoreCase(nome)){
            throw new DadoConsultado("Esse projeto não existe!");
        }
        Projeto projetoEncontrado = consultarPorNome(nome);
        projetoEncontrado.setNome(projeto.getNome());
        projetoEncontrado.setObjetivo(projeto.getObjetivo());
        projetoEncontrado.setNecessidades(projeto.getNecessidades());
        projetoEncontrado.setDataInicio(projeto.getDataInicio());
        projetoEncontrado.setDataFinal(projeto.getDataFinal());
        projetoEncontrado.setStatus(projeto.getStatus());
        return projetoEncontrado;
    }

    @Override
    public void excluir(Projeto projeto) throws DadoConsultado, UnsupportedOperationException {
        if (projetos.contains(projeto)){
            projetos.remove(projeto);
            return;
        }
        throw new DadoConsultado("O Projeto não foi encontrado para exclusão.");
    }

    @Override
    public void excluir(String nome) throws DadoConsultado, UnsupportedOperationException {
        Projeto projeto = consultarPorNome(nome);
        this.excluir(projeto);
    }


}