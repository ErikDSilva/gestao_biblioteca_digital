package br.edu.ifpb.gestaobibliotecadigital.controllers;

import br.edu.ifpb.gestaobibliotecadigital.models.livros.LivroBase;
import br.edu.ifpb.gestaobibliotecadigital.services.impl.LivroService;

public class LivroController extends Controller {
    
    private final LivroService livroService = new LivroService();
    
    public void criar(LivroBase livroNovo) {
        verificaUsuarioLogado();
        verificaAdministrador();
        livroService.criarLivro(livroNovo);
    }
    
    public void atualizar(LivroBase livroAtualizar) {
        verificaUsuarioLogado();
        verificaAdministrador();
        livroService.atualizar(livroAtualizar);
    }
    
    public void deletar(LivroBase livroDeletar) {
        verificaUsuarioLogado();
        verificaAdministrador();
        livroService.deletar(livroDeletar);
    }
    
}
