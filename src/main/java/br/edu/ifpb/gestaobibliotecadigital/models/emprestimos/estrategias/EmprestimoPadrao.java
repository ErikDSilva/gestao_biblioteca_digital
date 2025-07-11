package br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.estrategias;

public class EmprestimoPadrao implements EstrategiaEmprestimo {

    @Override
    public String getNome() {
        return "Empréstimo Padrão";
    }

    @Override
    public int calcularMaximoDias() {
        return 7;
    }

    @Override
    public double calcularMulta(int diasAtraso) {
        return diasAtraso * 1.00;
    }

    @Override
    public int calcularMaximoRenovacoes() {
        return 2;
    }

}
