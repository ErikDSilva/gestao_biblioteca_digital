package br.edu.ifpb.gestaobibliotecadigital.models.livros;

import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.estados.EstadoLivro;
import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.estados.LivroDisponivel;
import java.io.Serializable;

public class Livro implements Serializable {

    private EstadoLivro estado = new LivroDisponivel(this);

    private static final long serialVersionUID = 1L;
    private String titulo;
    private String autor;
    private int ano;
    private String editora;
    private String isbn;
    private String sinopse;
    private String categoria;
//    private String capaAlternativa;
//    private String resumoEstendido;

    public Livro() {
    }

    public Livro(String titulo, String autor, int ano, String editora, String isbn,
            String sinopse, String categoria) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.editora = editora;
        this.isbn = isbn;
        this.sinopse = sinopse;
        this.categoria = categoria;
//        this.capaAlternativa = capaAlternativa;
//        this.resumoEstendido = resumoEstendido;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAno() {
        return ano;
    }

    public String getEditora() {
        return editora;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getSinopse() {
        return sinopse;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setEstado(EstadoLivro estado) {
        this.estado = estado;
    }

    public void definirDisponivel() {
        this.estado.devolver();
    }

    public void definirEmprestado() {
        this.estado.emprestar();
    }

    public void definirReservado() {
        this.estado.reservar();
    }

    public void definirAtrasado() {
        this.estado.atrasar();
    }

//    public String getCapaAlternativa() {
//        return capaAlternativa;
//    }
//
//    public String getResumoEstendido() {
//        return resumoEstendido;
//    }

    @Override
    public String toString() {
        return "Título: " + titulo
                + "\nAutor: " + autor
                + "\nAno: " + ano
                + "\nEditora: " + editora
                + "\nISBN: " + isbn
                + "\nCategoria: " + categoria;
    }

}
