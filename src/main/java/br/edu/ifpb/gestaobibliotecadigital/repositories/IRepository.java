package br.edu.ifpb.gestaobibliotecadigital.repositories;

/**
 * Interface genérica para operações básicas do repositório.
 *
 * @param <T> o tipo de objeto a ser manipulado pelo banco de dados
 */
public interface IRepository<T> {

    /**
     * Carrega os dados da persistência de dados.
     */
    void carregar();

    /**
     * Salva os dados em arquivo.
     */
    void salvar();

    /**
     * Adiciona um novo objeto ao banco de dados.
     *
     * @param entidade o objeto a ser adicionado
     */
    void adicionar(T entidade);

    /**
     * Remove um objeto do banco de dados.
     *
     * @param entidade o objeto a ser removido
     */
    void remover(T entidade);

    /**
     * Atualiza um objeto existente no banco de dados.
     *
     * @param entidade o objeto atualizado
     */
    void atualizar(T entidade);

    /**
     * Exclui um objeto do banco de dados.
     *
     * @param entidade o objeto a ser excluído
     */
    void excluir(T entidade);
}
