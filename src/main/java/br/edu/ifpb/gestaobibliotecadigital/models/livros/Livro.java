package br.edu.ifpb.gestaobibliotecadigital.models.livros;

import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.estados.EstadoLivro;
import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.estados.LivroDisponivel;
import java.util.UUID;

public class Livro implements ItemBiblioteca {

    private EstadoLivro estado = new LivroDisponivel(this);

    private UUID id;
    private String titulo;
    private String autor;
    private int ano;
    private String editora;
    private String isbn;
    private String sinopse;
    private String categoria;
//    private String capaAlternativa;
//    private String resumoEstendido;
    
    private int totalAvaliacoes = 0;
    private int somaNotas = 0;

    public double getTotalAvaliacoes() {
        return totalAvaliacoes == 0 ? 0.0 : (double) somaNotas / totalAvaliacoes;
    }
    public void adicionarAvaliacao(int nota){
        this.totalAvaliacoes++;
        this.somaNotas += nota;
    }

    public Livro() {
    }

    public Livro(String titulo, String autor, int ano, String editora, String isbn,
            String sinopse, String categoria) {
        this.id = UUID.randomUUID();
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

    public UUID getId() {
        return id;
    }

    @Override
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
        return "Id: " + id
                + "\nTítulo: " + titulo
                + "\nAutor: " + autor
                + "\nAno: " + ano
                + "\nEditora: " + editora
                + "\nISBN: " + isbn
                + "\nCategoria: " + categoria;
    }

}
