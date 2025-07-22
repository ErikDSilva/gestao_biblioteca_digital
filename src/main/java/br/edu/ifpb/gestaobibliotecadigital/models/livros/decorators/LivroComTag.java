package br.edu.ifpb.gestaobibliotecadigital.models.livros.decorators;

import br.edu.ifpb.gestaobibliotecadigital.models.livros.LivroBase;
import java.util.List;

public class LivroComTag extends LivroDecorator {

    private final List<String> tags;

    public LivroComTag(LivroBase livro, List<String> tags) {
        super(livro);
        this.tags = tags;
    }

    /**
     * Retorna a lista de tags associada ao livro.
     *
     * @return A lista de strings contendo as tags.
     */
    public List<String> getTags() {
        return tags;
    }

    /**
     * Sobrescreve a descrição para adicionar a lista de tags.
     *
     * @return String com a descrição
     */
    @Override
    public String getDescricao() {
        return super.getDescricao() + String.format("\nTags: %s", String.join(", ", tags));
    }
}
