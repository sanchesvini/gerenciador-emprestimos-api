package desafio2.desafio2.dtos;

import desafio2.desafio2.entities.Livro;

public class LivroRequestDTO {

    //private Long id;
    private String titulo;
    private String autor;
    private int anoPublicacao;

    public Livro paraLivro() {
        return new Livro(titulo, autor, anoPublicacao, true);
    }

    public LivroRequestDTO() {
    }

    public LivroRequestDTO(String titulo, String autor, int anoPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
}
