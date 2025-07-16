package br.edu.ifpb.gestaobibliotecadigital.app;

import br.edu.ifpb.gestaobibliotecadigital.filters.LivroFiltro;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.Colecao;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;
import br.edu.ifpb.gestaobibliotecadigital.utils.CriarLivroSeed;
import br.edu.ifpb.gestaobibliotecadigital.views.livros.ListaLivros;

import java.util.List;

public class MainEquipe2 {

    private static final List<Livro> bancoDeLivros = CriarLivroSeed.getLivros();

    public static void main(String[] args) {
        new ListaLivros().setVisible(true);
    }

    // Compose: Criação coleções
    private static void mostrarColecaoEngenharia() {
        Colecao engenhariaSoftware = new Colecao("Fundamentos do Software Moderno");

        LivroFiltro filtro = new LivroFiltro(bancoDeLivros);
        // busca do resultado
        List<Livro> resultados = filtro
                .porCategoria("Tecnologia")
                .filtrar();
        for (Livro livro : resultados) {
            engenhariaSoftware.adicionar(livro);
        }

        System.out.println(engenhariaSoftware);
        System.out.println("===".repeat(10));
    }

    private static void mostrarTrilogiaTolkien() {
        Colecao trilogiaTolkien = new Colecao("Trilogia Senhor dos Anéis");

        LivroFiltro filtro = new LivroFiltro(bancoDeLivros);

        List<Livro> resultados = filtro
                .porPalavra("Senhor dos Anéis")
                .filtrar();
        for (Livro livro : resultados) {
            trilogiaTolkien.adicionar(livro);
        }

        System.out.println(trilogiaTolkien);
    }
}
