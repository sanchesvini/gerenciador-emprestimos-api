package desafio2.desafio2.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;

	@OneToMany(mappedBy = "usuario")
	private List<Livro> livrosEmprestados = new ArrayList<Livro>();
	
	public Usuario( String nome) {
		this.nome = nome;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setLivrosEmprestados(List<Livro> livrosEmprestados) {
		this.livrosEmprestados = livrosEmprestados;
	}

	public Usuario() {

	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	public List<Livro> getLivrosEmprestados() {
		return livrosEmprestados;
	}
	public void addLivroEmprestado(Livro livro) {
		livrosEmprestados.add(livro);
	}
	
	@Override
	public String toString() {
		String livrosEmprestadosStr = "";
		for (Livro livro : livrosEmprestados) {
			livrosEmprestadosStr+= livro.getTitulo() + "\n";
		}
		return "ID: " + this.id + "\n"+
				"Nome: "+ this.nome+ "\n"+
				"Livros emprestados: " + livrosEmprestadosStr;
	}

}
