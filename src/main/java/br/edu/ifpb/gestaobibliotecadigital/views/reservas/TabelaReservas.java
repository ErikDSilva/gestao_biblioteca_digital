package br.edu.ifpb.gestaobibliotecadigital.views.reservas;

import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.Reserva;
import br.edu.ifpb.gestaobibliotecadigital.views.components.TabelaItensPanel;
import java.util.ArrayList;
import java.util.List;

public class TabelaReservas extends TabelaItensPanel<Reserva> {

    public TabelaReservas() {
        super(new ArrayList<>());
    }

    public TabelaReservas(List<Reserva> reservas) {
        super(reservas);
    }

    @Override
    protected String[] getColunas() {
        String[] colunas = {
            "Data",
            "Usuário",
            "Livro",
            "Status",
            "Expiração",
            "Encerrada",
            "Com empréstimo"
        };
        return colunas;
    }

    @Override
    protected Object getValueAt(Reserva item, int coluna) {
        return switch (coluna) {
            case 0 ->
                item.getDataReserva();
            case 1 ->
                item.getUsuario().getNome();
            case 2 ->
                item.getLivro().getTitulo();
            case 3 -> {
                if (item.expirada()) {
                    yield "Expirada";
                } else if (item.encerrada()) {
                    yield "Encerrada";
                } else {
                    yield "Aberta";
                }
            }
            case 4 ->
                item.getDataExpiracao();
            case 5 ->
                item.getDataEncerrada();
            case 6 ->
                item.encerrada() ? (item.getEmprestimo() == null ? "Não" : "Sim") : "";
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
