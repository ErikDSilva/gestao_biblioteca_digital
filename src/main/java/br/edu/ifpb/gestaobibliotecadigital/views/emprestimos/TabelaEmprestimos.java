package br.edu.ifpb.gestaobibliotecadigital.views.emprestimos;

import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.Emprestimo;
import br.edu.ifpb.gestaobibliotecadigital.utils.Formatter;
import br.edu.ifpb.gestaobibliotecadigital.views.components.TabelaItensPanel;
import java.util.ArrayList;
import java.util.List;

public class TabelaEmprestimos extends TabelaItensPanel<Emprestimo> {

    public TabelaEmprestimos() {
        super(new ArrayList<>());
    }

    public TabelaEmprestimos(List<Emprestimo> emprestimos) {
        super(emprestimos);
    }

    @Override
    protected String[] getColunas() {
        String[] colunas = {
            "Data saída",
            "Usuário",
            "Livro",
            "Status",
            "Data da renov./dev.",
            "Renov. feitas",
            "Pode renovar",
            "Última renov.",
            "Devolvido em",
            "Multa"
        };

        return colunas;
    }

    @Override
    protected Object getValueAt(Emprestimo item, int coluna) {
        return switch (coluna) {
            case 0 ->
                item.getDataEmprestimo();
            case 1 ->
                item.getUsuario().getNome();
            case 2 ->
                item.getLivro().getTitulo();
            case 3 -> {
                if (item.estaAtrasado()) {
                    yield "Atrasado";
                } else if (item.foiDevolvido()) {
                    yield "Devolvido";
                } else if (item.temMultaPendente()) {
                    yield "Multa";
                } else {
                    yield "Emprestado";
                }
            }
            case 4 ->
                item.getDataRenovacaoOuDevolucao();
            case 5 ->
                item.getQuantidadeRenovacoes();
            case 6 ->
                item.getQuantidadeRenovacoesRestantes() == 0 ? "Não" : item.getQuantidadeRenovacoesRestantes();
            case 7 ->
                item.getDataUltimaRenovacao() == null ? "Nunca renovado" : item.getDataUltimaRenovacao();
            case 8 ->
                item.getDataDevolvido() == null ? "Não devolvido" : item.getDataDevolvido();
            case 9 ->
                item.getMulta() == 0 ? "-" : "R$ " + Formatter.of(item.getMulta()).toString();
            default ->
                null;
        };
    }

    @Override
    protected int getColunaOrdenacaoPadrao() {
        return 0;
    }

    @Override
    protected boolean isOrdenacaoDecrescente() {
        return true;
    }
}
