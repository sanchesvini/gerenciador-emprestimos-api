package desafio2.desafio2.entities;

import jakarta.persistence.*;

@Entity
public class Livro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String titulo;
	private String autor;
	private int anoPublicacao;
	private boolean disponivel;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	public Livro(String titulo, String autor, int anoPublicacao, boolean disponivel) {
		this.titulo = titulo;
		this.autor = autor;
		this.anoPublicacao = anoPublicacao;
		this.disponivel = disponivel;
	}

	public Livro() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public int getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setAnoPublicacao(int anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
	public void emprestar() {
		this.disponivel = false;
	}
	public void devolver() {
		this.disponivel = true;
	}

	@Override
	public String toString() {
		String disponibilidade = "";
		if(this.disponivel == true) {
			disponibilidade = "Disponível";
		}else {
			disponibilidade = "Indisponivel";
		}
		return "Titulo: "+ this.titulo + "\n"+
				"Autor: "+ this.autor + "\n"+
				"Ano de publicação: "+ this.anoPublicacao + "\n"+
				disponibilidade + " para empréstimo";
	}


}
