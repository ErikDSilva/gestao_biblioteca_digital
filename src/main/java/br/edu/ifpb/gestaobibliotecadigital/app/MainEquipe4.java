package br.edu.ifpb.gestaobibliotecadigital.app;

import br.edu.ifpb.gestaobibliotecadigital.models.avaliacao.Avaliacao;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.LivroBuilder;
import br.edu.ifpb.gestaobibliotecadigital.models.usuarios.Administrador;
import br.edu.ifpb.gestaobibliotecadigital.models.usuarios.Usuario;
import br.edu.ifpb.gestaobibliotecadigital.repositories.AvaliacaoRepository;

public class MainEquipe4 {

    public static void main(String[] args) {
        
        Usuario usuario = new Administrador("José", "00000000000000000000000000");
        Livro padroeDeProjeto = new LivroBuilder()
                .setTitulo("Padrões de Projetos: Soluções Reutilizáveis de Software Orientados a Objetos")
                .setAutor("Erich Gamma")
                .setAno(2000)
                .setEditora("Bookman")
                .setIsbn("978-8573076103")
                .setSinopse("Catálogo de soluções simples e sucintas para os problemas mais freqüentes na área de projeto, assinado por quatro profissionais com grande experiência em software orientado a objetos. Um best-seller mundial.")
                .setCategoria("Engenharia de Software")
                .builder();
        
        Avaliacao jose_comentario  = new Avaliacao(padroeDeProjeto, usuario, 3, "lastimavél");
        System.out.println(jose_comentario);
        
        AvaliacaoRepository repo = AvaliacaoRepository.getInstance();
        repo.adicionar(jose_comentario);
        System.out.println(repo.listar());
    }
}
