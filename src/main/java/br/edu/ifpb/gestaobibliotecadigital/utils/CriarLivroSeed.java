package br.edu.ifpb.gestaobibliotecadigital.utils;

import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.LivroBuilder;
import java.util.ArrayList;
import java.util.List;

public class CriarLivroSeed {

    private static final List<Livro> bancoDeLivros = new ArrayList<>();

    static {
        Livro padroeDeProjeto = new LivroBuilder()
                .setTitulo("Padrões de Projetos: Soluções Reutilizáveis de Software Orientados a Objetos")
                .setAutor("Erich Gamma")
                .setAno(2000)
                .setEditora("Bookman")
                .setISBN("978-8573076103")
                .setSinopse("Catálogo de soluções simples e sucintas para os problemas mais frequentes na área de projeto.")
                .setCategoria("Tecnologia")
                .builder();

        Livro useCabecaJava = new LivroBuilder()
                .setTitulo("Use a Cabeça Java – 3ª Edição: Guia do Aprendiz Para Programação no Mundo Real")
                .setAutor("Kathy Sierra")
                .setAno(2024)
                .setEditora("Alta Books")
                .setISBN("978-8550819884")
                .setSinopse("Experiência completa de aprendizado em Java e programação orientada a objetos.")
                .setCategoria("Tecnologia")
                .builder();

        Livro entendendoAlgoritmos = new LivroBuilder()
                .setTitulo("Entendendo Algoritmos")
                .setAutor("Kathy Sierra")
                .setAno(2017)
                .setEditora("Novatec")
                .setISBN("978-8575225639")
                .setSinopse("Introdução prática aos algoritmos mais utilizados.")
                .setCategoria("Tecnologia")
                .builder();

        Livro senhorDosAneisParte1 = new LivroBuilder()
                .setTitulo("O Senhor dos Anéis: A Sociedade do Anel")
                .setAutor("J.R.R. Tolkien")
                .setAno(2019)
                .setEditora("HarperCollins")
                .setISBN("978-8595084759")
                .setSinopse("Bilbo deixa o Condado para Frodo iniciar uma jornada pela Terra-média.")
                .setCategoria("Fantasia")
                .builder();

        Livro senhorDosAneisParte2 = new LivroBuilder()
                .setTitulo("O Senhor dos Anéis: As duas torres")
                .setAutor("J.R.R. Tolkien")
                .setAno(2019)
                .setEditora("HarperCollins")
                .setISBN("978-8595084766")
                .setSinopse("A jornada continua com Legolas, Gimli e Aragorn tentando resgatar os hobbits.")
                .setCategoria("Fantasia")
                .builder();

        Livro senhorDosAneisParte3 = new LivroBuilder()
                .setTitulo("O Senhor dos Anéis: O retorno do rei")
                .setAutor("J.R.R. Tolkien")
                .setAno(2019)
                .setEditora("HarperCollins")
                .setISBN("978-8595084773")
                .setSinopse("Sam e Frodo enfrentam o desafio final em Mordor.")
                .setCategoria("Fantasia")
                .builder();
//        Novros livros
        Livro diarioBanana1 = new LivroBuilder()
                .setTitulo("Diário de um Banana 1")
                .setAutor("Jeff Kinney")
                .setAno(2008)
                .setEditora("VR Editora")
                .setISBN("978-8576831303")
                .setSinopse("Não é fácil ser criança. E ninguém sabe disso melhor do que Greg Heffley, que se vê mergulhado no mundo do ensino fundamental.")
                .setCategoria("Infantil")
                .builder();

        Livro diarioBanana2 = new LivroBuilder()
                .setTitulo("Diário de um Banana 2: Rodrick é o cara")
                .setAutor("Jeff Kinney")
                .setAno(2009)
                .setEditora("VR Editora")
                .setISBN("978-8576831952")
                .setSinopse("Faça o que quiser, só não pergunte a Greg Heffley como foram suas férias de verão, porque ele realmente não quer falar sobre isso.")
                .setCategoria("Infantil")
                .builder();

        Livro diarioBanana3 = new LivroBuilder()
                .setTitulo("Diário de um Banana 3: A gota d’água")
                .setAutor("Jeff Kinney")
                .setAno(2010)
                .setEditora("VR Editora")
                .setISBN("978-8576832294")
                .setSinopse("Greg não toma jeito mesmo. E a cada dia se envolve em mais confusão. O difícil é fazer seu pai engolir esse talento de Greg para se meter em situações embaraçosas.")
                .setCategoria("Infantil")
                .builder();

        Livro diarioBanana4 = new LivroBuilder()
                .setTitulo("Diário de um Banana. Dias de Cão - Volume 4")
                .setAutor("Jeff Kinney")
                .setAno(2011)
                .setEditora("Vergara e Riba")
                .setISBN("978-8576832768")
                .setSinopse("Férias de verão: o tempo está lindo, e toda garotada está se divertindo ao ar livre. Onde está Greg Heffley?")
                .setCategoria("Infantil")
                .builder();

        Livro diarioBanana5 = new LivroBuilder()
                .setTitulo("Diário de um Banana 5: A verdade nua e crua")
                .setAutor("Jeff Kinney")
                .setAno(2011)
                .setEditora("VR Editora")
                .setISBN("978-8576832768")
                .setSinopse("Greg Heffley sem quis crescer logo. Mas será que ficar mais velho é tão legal assim? De repente, Greg começa a lidar com as pressões das festas de meninos e meninas.")
                .setCategoria("Infantil")
                .builder();

        Livro diarioBanana6 = new LivroBuilder()
                .setTitulo("Diário de um Banana 6: Casa dos horrores")
                .setAutor("Jeff Kinney")
                .setAno(2011)
                .setEditora("VR Editora")
                .setISBN("978-8576833680")
                .setSinopse("Em sua sexta aventura, Greg Heffley passará por grandes apuros. As coisas para ele vão de mal a pior, tanto na escola como em sua casa. Greg será suspeito de vandalismo e se tornará um suposto foragido da polícia.")
                .setCategoria("Infantil")
                .builder();

        Livro diarioBanana7 = new LivroBuilder()
                .setTitulo("Diário de um Banana 7: Segurando vela")
                .setAutor("Jeff Kinney")
                .setAno(2013)
                .setEditora("VR Editora")
                .setISBN("978-8576834847")
                .setSinopse("O Dia dos Namorados está chegando e Greg Heffley continua sozinho. Mas um baile organizado pela escola pode mudar tudo. Ele precisa encontrar uma garota urgente. Para isso, conta com a ajuda de outro solteirão, Rowley, seu melhor amigo.")
                .setCategoria("Infantil")
                .builder();

        Livro diarioBanana8 = new LivroBuilder()
                .setTitulo("Diário de um Banana 8: Maré de azar")
                .setAutor("Jeff Kinney")
                .setAno(2014)
                .setEditora("VR Editora")
                .setISBN("978-8576836902")
                .setSinopse("Greg Heffley está bolado. Seu companheiro de todas as horas, Rowley, o abandonou, e encontrar novos amigos na escola acabou se revelando uma tarefa muito difícil.")
                .setCategoria("Infantil")
                .builder();

        Livro diarioBanana9 = new LivroBuilder()
                .setTitulo("Diário de um Banana 9: Caindo na estrada")
                .setAutor("Jeff Kinney")
                .setAno(2015)
                .setEditora("VR Editora")
                .setISBN("978-8576838234")
                .setSinopse("As férias do Greg tinham tudo para serem perfeitas, até que sua mãe vem com a bomba: eles farão uma viagem de carro em família. ")
                .setCategoria("Infantil")
                .builder();

        Livro diarioBanana10 = new LivroBuilder()
                .setTitulo("Diário de um Banana 10: Bons Tempos")
                .setAutor("Jeff Kinney")
                .setAno(2015)
                .setEditora("VR Editora")
                .setISBN("978-8576839422")
                .setSinopse("Greg Heffley está prestes a descobrir que a vida era muito melhor nos velhos tempos. Com sua cidade voluntariamente 'desconectada', a vida moderna tem seus desafios.")
                .setCategoria("Infantil")
                .builder();

        Livro diarioBanana11 = new LivroBuilder()
                .setTitulo("Diário de um Banana 11: Vai ou Racha")
                .setAutor("Jeff Kinney")
                .setAno(2016)
                .setEditora("VR Editora")
                .setISBN("978-8550700601")
                .setSinopse("A pressão só aumenta para Greg Heffley. A única coisa em que ele parece ser realmente bom é em videojogos, mas a mãe quer que ele alargue os seus horizontes e faça mais alguma coisa - QUALQUER coisa! Quando o Greg encontra uma velha câmara de filmar, ele tem a certeza de que descobriu a forma ideal de, finalmente, mostrar a todos os seus grandes talentos escondidos.")
                .setCategoria("Infantil")
                .builder();

        Livro diarioBanana12 = new LivroBuilder()
                .setTitulo("Diário de um Banana 12: Apertem os cintos")
                .setAutor("Jeff Kinney")
                .setAno(2017)
                .setEditora("VR Editora")
                .setISBN("978-8550701448")
                .setSinopse("Os Heffley estão dando o fora! Greg e sua família decidem fugir do frio e do estresse das festas de fim de ano e embarcam no primeiro avião com destino a uma ilha tropical. Mas, e se o paraíso não for tudo isso?")
                .setCategoria("Infantil")
                .builder();

        // Júlio Verne
        Livro viagemCentroTerra = new LivroBuilder()
                .setTitulo("Viagem ao Centro da Terra")
                .setAutor("Júlio Verne")
                .setAno(2023)
                .setEditora("Pé da Letra")
                .setISBN("978-8595201736")
                .setSinopse("Axel é um jovem órfão que mora em Hamburgo com seu tio Otto Lindenbrock, um renomado cientista da área de Geologia e Mineralogia. Um dia, o cientista encontra um pergaminho escrito em linguagem misteriosa.")
                .setCategoria("Infantil")
                .builder();

        Livro ilhaMisteriosa = new LivroBuilder()
                .setTitulo("A ilha misteriosa")
                .setAutor("Júlio Verne")
                .setAno(2021)
                .setEditora("Principis")
                .setISBN("978-8595201736")
                .setSinopse("Depois de sequestrar um balão de um campo confederado, um grupo de cinco abolicionistas americanos cai das nuvens em uma ilha vulcânica desconhecida no oceano Pacífico.")
                .setCategoria("Infantil")
                .builder();

        // Art Spiegelman
        Livro maus = new LivroBuilder()
                .setTitulo("Maus")
                .setAutor("Art Spiegelman")
                .setAno(2005)
                .setEditora("Quadrinhos na Cia")
                .setISBN("978-8535906288")
                .setSinopse("Maus (\"rato\", em alemão) é a história de Vladek Spiegelman, judeu polonês que sobreviveu ao campo de concentração de Auschwitz, narrada por ele próprio ao filho Art.")
                .setCategoria("Aventura")
                .builder();

        Livro bichos = new LivroBuilder()
                .setTitulo("A revolução dos bichos: Um conto de fadas")
                .setAutor("George Orwell")
                .setAno(2007)
                .setEditora("Companhia das Letras")
                .setISBN("978-8535909555")
                .setSinopse("Narra a insurreição dos animais de uma granja contra seus donos. Progressivamente, porém, a revolução degenera numa tirania ainda mais opressiva que a dos humanos.")
                .setCategoria("Clássicos de Ficção")
                .builder();

        Livro vidasSecas = new LivroBuilder()
                .setTitulo("Vidas Secas")
                .setAutor("Graciliano Ramos")
                .setAno(2024)
                .setEditora("Editora Itatiaia")
                .setISBN("978-6554700276")
                .setSinopse("\"Vidas Secas\" é um retrato magistral das condições humanas diante das adversidades, explorando temas universais como a busca por um lar, a esperança em meio à desolação e a resistência humana perante a natureza implacável.")
                .setCategoria("Clássicos de Ficção")
                .builder();
        // Holly Black
        Livro spiderwick1 = new LivroBuilder()
                .setTitulo("O guia de campo: 1")
                .setAutor("Holly Black")
                .setAno(2004)
                .setEditora("Rocco")
                .setISBN("978-8532517708")
                .setSinopse("Fadas, duendes, gnomos e seres fantásticos, podem estar do seu lado agora mesmo, então fique alerta! Há muito mais nesse mundo do que os olhos podem ver. Para divulgar essa informação, os irmãos Grace pediram que Holly Black e Tony DiTerlizzi transformassem a sua história em uma série de cinco livros.")
                .setCategoria("Infantil")
                .builder();

        Livro spiderwick2 = new LivroBuilder()
                .setTitulo("Pedra da visão: 2")
                .setAutor("Holly Black")
                .setAno(2004)
                .setEditora("Rocco")
                .setISBN("978-8532517715")
                .setSinopse("Jared e Mallory precisam salvar o irmão e ao mesmo tempo driblar todos os tipos de criaturas amedrontadoras. Eles também acabam fazendo estranhas alianças e conhecendo surpreendentes formas de vida.")
                .setCategoria("Infantil")
                .builder();

        Livro spiderwick3 = new LivroBuilder()
                .setTitulo("Segredo de Lucinda: 3")
                .setAutor("Holly Black")
                .setAno(2005)
                .setEditora("Rocco")
                .setISBN("978-8532518798")
                .setSinopse("Jared e Mallory precisam salvar o irmão e ao mesmo tempo driblar todos os tipos de criaturas amedrontadoras. Eles também acabam fazendo estranhas alianças e conhecendo surpreendentes formas de vida.")
                .setCategoria("Infantil")
                .builder();

        Livro spiderwick4 = new LivroBuilder()
                .setTitulo("A árvore de ferro: 4")
                .setAutor("Holly Black")
                .setAno(2005)
                .setEditora("Rocco")
                .setISBN("978-8532518804")
                .setSinopse("Jared está vendo dois Simon ao mesmo tempo; enquanto um remexe a bolsa de Mallory, o outro está sentado ao lado da mãe. Para piorar a situação, eles ainda têm pela frente a arriscada missão de resgatar a irmã das garras de Korting, Mulgarath e de todos os outros seres fantásticos que exigem o Guia de Campo como recompensa.")
                .setCategoria("Infantil")
                .builder();

        Livro spiderwick5 = new LivroBuilder()
                .setTitulo("A ira de Mulgarath: 5")
                .setAutor("Holly Black")
                .setAno(2006)
                .setEditora("Rocco")
                .setISBN("978-8532519993")
                .setSinopse("Mulgarath roubou o livro mágico de Arthur Spiderwick e deseja tornar-se o mestre do mundo. Com a ajuda do gnomo Tibério, do desajeitado Gritalhão e outros seres encantados que povoam a história, conseguirão Jared, Simon e Mallory triunfar sobre as forças do mal e fazer com que o precioso guia de campo seja usado para o bem de todos?")
                .setCategoria("Infantil")
                .builder();
        // Adicionar no banco de dados
        bancoDeLivros.add(padroeDeProjeto);
        bancoDeLivros.add(useCabecaJava);
        bancoDeLivros.add(entendendoAlgoritmos);
        bancoDeLivros.add(senhorDosAneisParte1);
        bancoDeLivros.add(senhorDosAneisParte2);
        bancoDeLivros.add(senhorDosAneisParte3);
        // Diário de um Banana
        bancoDeLivros.add(diarioBanana1);
        bancoDeLivros.add(diarioBanana2);
        bancoDeLivros.add(diarioBanana3);
        bancoDeLivros.add(diarioBanana4);
        bancoDeLivros.add(diarioBanana5);
        bancoDeLivros.add(diarioBanana6);
        bancoDeLivros.add(diarioBanana7);
        bancoDeLivros.add(diarioBanana8);
        bancoDeLivros.add(diarioBanana9);
        bancoDeLivros.add(diarioBanana10);
        bancoDeLivros.add(diarioBanana11);
        bancoDeLivros.add(diarioBanana12);
        // // Júlio Verne
        bancoDeLivros.add(viagemCentroTerra);
        bancoDeLivros.add(ilhaMisteriosa);
        // Outros
        bancoDeLivros.add(maus);
        bancoDeLivros.add(bichos);
        bancoDeLivros.add(vidasSecas);
        // Spiderwick
        bancoDeLivros.add(spiderwick1);
        bancoDeLivros.add(spiderwick2);
        bancoDeLivros.add(spiderwick3);
        bancoDeLivros.add(spiderwick4);
        bancoDeLivros.add(spiderwick5);
    }

    public static List<Livro> getLivros() {
        return new ArrayList<>(bancoDeLivros);
    }
}
