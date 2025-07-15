package br.edu.ifpb.gestaobibliotecadigital.app;

import br.edu.ifpb.gestaobibliotecadigital.models.livros.Colecao;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.LivroBuilder;

public class MainEquipe2 {

    public static void main(String[] args) {
        // Builder: Criação de objetos Livro com muitos atributos.
        Livro padroeDeProjeto = new LivroBuilder()
                .setTitulo("Padrões de Projetos: Soluções Reutilizáveis de Software Orientados a Objetos")
                .setAutor("Erich Gamma")
                .setAno(2000)
                .setEditora("Bookman")
                .setIsbn("978-8573076103")
                .setSinopse("Catálogo de soluções simples e sucintas para os problemas mais freqüentes na área de projeto, assinado por quatro profissionais com grande experiência em software orientado a objetos. Um best-seller mundial.")
                .setCategoria("Engenharia de Software")
                .builder();

        Livro useCabecaJava = new LivroBuilder()
                .setTitulo("Use a Cabeça Java – 3ª Edição: Guia do Aprendiz Para Programação no Mundo Real")
                .setAutor("Kathy Sierra")
                .setAno(2024)
                .setEditora("Alta Books")
                .setIsbn("978-8550819884")
                .setSinopse("O 'Use a Cabeça Java' é uma experiência completa de aprendizado em Java e programação orientada a objetos. Com este livro, você aprenderá a linguagem Java de um jeito único, que ultrapassa os manuais de instruções, ajudando-o a se tornar um programador excelente.")
                .setCategoria("Engenharia de Software")
                .builder();

        Livro EntendendoAlgoritmos = new LivroBuilder()
                .setTitulo("Entendendo Algoritmos")
                .setAutor("Kathy Sierra")
                .setAno(2017)
                .setEditora("Novatec")
                .setIsbn("978-8575225639")
                .setSinopse("Os algoritmos que você mais utilizará como um programador já foram descobertos, testados e provados. Se você quer entendê-los, mas se recusa a estudar páginas e mais páginas de provas, este é o livro certo.")
                .setCategoria("Engenharia de Software")
                .builder();

        Livro senhorDosAneisParte1 = new LivroBuilder()
                .setTitulo("O Senhor dos Anéis: A Sociedade do Anel")
                .setAutor("J.R.R. Tolkien")
                .setAno(2019)
                .setEditora("HarperCollins")
                .setIsbn("978-8595084759")
                .setSinopse("A Sociedade do Anel começa no Condado, a região rural do oeste da Terra-média onde vivem os diminutos e pacatos hobbits. Bilbo Bolseiro, um dos raros aventureiros desse povo, cujas peripécias foram contadas em O Hobbit, resolve ir embora do Condado e deixa sua considerável herança nas mãos de seu jovem parente Frodo.")
                .setCategoria("Fantasia")
                .builder();

        Livro senhorDosAneisParte2 = new LivroBuilder()
                .setTitulo("O Senhor dos Anéis: As duas torres")
                .setAutor("J.R.R. Tolkien")
                .setAno(2019)
                .setEditora("HarperCollins")
                .setIsbn("978-8595084766")
                .setSinopse("De um lado, o trio formado pelo elfo Legolas, pelo anão Gimli e por Aragorn, herdeiro da realeza dos Homens, tenta resgatar os jovens hobbits Merry e Pippin, capturados por guerreiros-órquicos. A busca pelos companheiros perdidos levará os três a confrontar os cavaleiros do reino de Rohan e o mago renegado Saruman, que também deseja o Um Anel para si.")
                .setCategoria("Fantasia")
                .builder();

        Livro senhorDosAneisParte3 = new LivroBuilder()
                .setTitulo("O Senhor dos Anéis: O retorno do rei")
                .setAutor("J.R.R. Tolkien")
                .setAno(2019)
                .setEditora("HarperCollins")
                .setIsbn("978-8595084773")
                .setSinopse("Nas fronteiras de Mordor, Sam resgata Frodo, e os dois hobbits partem para o último estágio de sua jornada rumo ao Monte da Perdição, uma jornada que testará os limites do corpo e da mente dos pequenos heróis.")
                .setCategoria("Fantasia")
                .builder();
        // Composite
        Colecao EngenhariaSoftware = new Colecao("Fundamentos do Software Moderno");
        EngenhariaSoftware.adicionar(padroeDeProjeto);
        EngenhariaSoftware.adicionar(useCabecaJava);
        EngenhariaSoftware.adicionar(EntendendoAlgoritmos);
        System.out.println(EngenhariaSoftware);

        System.out.println("===".repeat(10));
        // Trilogia: Coleção do senhor dos aneis
        Colecao livroDeTolkien = new Colecao("Trilogia Senhor dos Aneis");
        livroDeTolkien.adicionar(senhorDosAneisParte1);
        livroDeTolkien.adicionar(senhorDosAneisParte2);
        livroDeTolkien.adicionar(senhorDosAneisParte3);
        System.out.println(livroDeTolkien);

        // Decoration
    }
}
