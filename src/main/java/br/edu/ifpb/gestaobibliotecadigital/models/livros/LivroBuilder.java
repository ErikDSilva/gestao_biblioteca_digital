package br.edu.ifpb.gestaobibliotecadigital.models.livros;

public class LivroBuilder {

    private String titulo;
    private String autor;
    private int ano;
    private String editora;
    private String ISBN;
    private String sinopse;
    private String categoria;
//    private String capaAlternativa;
//    private String resumoEstendido;

    public LivroBuilder setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public LivroBuilder setAutor(String autor) {
        this.autor = autor;
        return this;
    }

    public LivroBuilder setAno(int ano) {
        this.ano = ano;
        return this;
    }

    public LivroBuilder setEditora(String editora) {
        this.editora = editora;
        return this;
    }

    public LivroBuilder setISBN(String ISBN) {
        this.ISBN = ISBN;
        return this;
    }

    public LivroBuilder setSinopse(String sinopse) {
        this.sinopse = sinopse;
        return this;
    }

    public LivroBuilder setCategoria(String categoria) {
        this.categoria = categoria;
        return this;
    }

    public Livro builder() {
        return new Livro(titulo, autor, ano, editora, ISBN, sinopse, categoria);
    }
}
