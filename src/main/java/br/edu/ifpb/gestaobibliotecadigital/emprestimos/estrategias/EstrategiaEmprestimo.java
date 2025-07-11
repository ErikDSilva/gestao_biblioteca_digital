package br.edu.ifpb.gestaobibliotecadigital.emprestimos.estrategias;

import java.io.Serializable;

public interface EstrategiaEmprestimo extends Serializable {

    /**
     * Retorna o nome da estratégia de empréstimo; Exemplo: "Empréstimo Premium"
     *
     * @return Nome da estratégia
     */
    public String getNome();

    /**
     * Calcula o número máximo de dias que o livro pode ficar com o usuário sem
     * renovar/devolver
     *
     * @return Número de dias
     */
    public int calcularMaximoDias();

    /**
     * Calcula o valor da multa em caso de atraso
     *
     * @param diasAtraso Número de dias de atraso
     * @return Valor da multa
     */
    public double calcularMulta(int diasAtraso);

    /**
     * Calcula o número máximo de renovações que podem ser feitas nesta
     * estratégia
     *
     * @return Máximo de renovações
     */
    public int calcularMaximoRenovacoes();

}
