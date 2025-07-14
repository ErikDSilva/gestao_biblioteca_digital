package br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.estrategias;

public class EmprestimoPremium implements EstrategiaEmprestimo {

    @Override
    public String getNome() {
        return "Empréstimo Premium";
    }

    @Override
    public int calcularMaximoDias() {
        return 14;
    }

    @Override
    public double calcularMulta(int diasAtraso) {
        return diasAtraso * 0.50;
    }

    @Override
    public int calcularMaximoRenovacoes() {
        return 5;
    }

}
