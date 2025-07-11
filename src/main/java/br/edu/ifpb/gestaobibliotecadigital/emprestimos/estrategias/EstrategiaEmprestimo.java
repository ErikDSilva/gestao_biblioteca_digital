package br.edu.ifpb.gestaobibliotecadigital.emprestimos.estrategias;

import java.io.Serializable;

public interface EstrategiaEmprestimo extends Serializable {

    public String getNome();

    public int calcularMaximoDias();

    public double calcularMulta(int diasAtraso);

    public int calcularMaximoRenovacoes();

}
