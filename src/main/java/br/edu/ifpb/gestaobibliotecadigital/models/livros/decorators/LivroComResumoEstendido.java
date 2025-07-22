package br.edu.ifpb.gestaobibliotecadigital.models.livros.decorators;

import br.edu.ifpb.gestaobibliotecadigital.models.livros.LivroBase;

public class LivroComResumoEstendido extends LivroDecorator {

    private String resumo;

    public LivroComResumoEstendido(LivroBase livro, String resumo) {
        super(livro);
        this.resumo = resumo;
    }

    /**
     * Retorna o resumo estendido do livro.
     *
     * @return String com o resumo.
     */
    public String getResumoEstendido() {
        return resumo;
    }

    /**
     * Sobrescreve o método getDescricao para adicionar o resumo estendido.
     *
     * @return String com a descrição e o resumo
     */
    @Override
    public String getDescricao() {
        return super.getDescricao() + String.format("\nResumo Estendido: %s", resumo);
    }
}
