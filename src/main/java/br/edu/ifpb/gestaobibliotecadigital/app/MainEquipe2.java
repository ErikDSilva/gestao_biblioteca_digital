package br.edu.ifpb.gestaobibliotecadigital.app;

import br.edu.ifpb.gestaobibliotecadigital.filters.LivroFiltro;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.Colecao;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.LivroBuilder;

import java.util.ArrayList;
import java.util.List;

public class MainEquipe2 {

    private static final List<Livro> bancoDeLivros = new ArrayList<>();

    public static void main(String[] args) {
        // Builder
        criarLivros();
        // Composite
        mostrarColecaoEngenharia();
        // Composite
        mostrarTrilogiaTolkien();
        // FIltros: 
        // por autor:  'Kathy'
        // por categoria: 'Engenharia de Software'
        // por ano: 2024
        aplicarFiltrosNosLivros();
    }

    private static void criarLivros() {
        // Builder: Criação de objetos Livro com muitos atributos.
        Livro padroeDeProjeto = new LivroBuilder()
                .setTitulo("Padrões de Projetos: Soluções Reutilizáveis de Software Orientados a Objetos")
                .setAutor("Erich Gamma")
                .setAno(2000)
                .setEditora("Bookman")
                .setIsbn("978-8573076103")
                .setSinopse("Catálogo de soluções simples e sucintas para os problemas mais frequentes na área de projeto.")
                .setCategoria("Engenharia de Software")
                .builder();

        Livro useCabecaJava = new LivroBuilder()
                .setTitulo("Use a Cabeça Java – 3ª Edição: Guia do Aprendiz Para Programação no Mundo Real")
                .setAutor("Kathy Sierra")
                .setAno(2024)
                .setEditora("Alta Books")
                .setIsbn("978-8550819884")
                .setSinopse("Experiência completa de aprendizado em Java e programação orientada a objetos.")
                .setCategoria("Engenharia de Software")
                .builder();

        Livro entendendoAlgoritmos = new LivroBuilder()
                .setTitulo("Entendendo Algoritmos")
                .setAutor("Kathy Sierra")
                .setAno(2017)
                .setEditora("Novatec")
                .setIsbn("978-8575225639")
                .setSinopse("Introdução prática aos algoritmos mais utilizados.")
                .setCategoria("Engenharia de Software")
                .builder();

        Livro senhorDosAneisParte1 = new LivroBuilder()
                .setTitulo("O Senhor dos Anéis: A Sociedade do Anel")
                .setAutor("J.R.R. Tolkien")
                .setAno(2019)
                .setEditora("HarperCollins")
                .setIsbn("978-8595084759")
                .setSinopse("Bilbo deixa o Condado para Frodo iniciar uma jornada pela Terra-média.")
                .setCategoria("Fantasia")
                .builder();

        Livro senhorDosAneisParte2 = new LivroBuilder()
                .setTitulo("O Senhor dos Anéis: As duas torres")
                .setAutor("J.R.R. Tolkien")
                .setAno(2019)
                .setEditora("HarperCollins")
                .setIsbn("978-8595084766")
                .setSinopse("A jornada continua com Legolas, Gimli e Aragorn tentando resgatar os hobbits.")
                .setCategoria("Fantasia")
                .builder();

        Livro senhorDosAneisParte3 = new LivroBuilder()
                .setTitulo("O Senhor dos Anéis: O retorno do rei")
                .setAutor("J.R.R. Tolkien")
                .setAno(2019)
                .setEditora("HarperCollins")
                .setIsbn("978-8595084773")
                .setSinopse("Sam e Frodo enfrentam o desafio final em Mordor.")
                .setCategoria("Fantasia")
                .builder();
        bancoDeLivros.add(padroeDeProjeto);
        bancoDeLivros.add(useCabecaJava);
        bancoDeLivros.add(entendendoAlgoritmos);
        bancoDeLivros.add(senhorDosAneisParte1);
        bancoDeLivros.add(senhorDosAneisParte2);
        bancoDeLivros.add(senhorDosAneisParte3);
    }

    // Compose: Criação coleções
    private static void mostrarColecaoEngenharia() {
        Colecao engenhariaSoftware = new Colecao("Fundamentos do Software Moderno");

        LivroFiltro filtro = new LivroFiltro(bancoDeLivros);
        // busca do resultado
        List<Livro> resultados = filtro
                .porCategoria("Engenharia de Software")
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

    //=====================================//
    private static void aplicarFiltrosNosLivros() {
        System.out.println("Livros filtrados");
        LivroFiltro filtro = new LivroFiltro(bancoDeLivros);
        // busca do resultado
        List<Livro> resultados = filtro
                .porAutor("Kathy")
                .porCategoria("Engenharia de Software")
                .porAno(2024)
                .filtrar();
        for (Livro livro : resultados) {
            System.out.println(livro.getTitulo() + " - " + livro.getAutor());
        }
    }
}
