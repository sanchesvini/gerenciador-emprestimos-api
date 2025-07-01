package desafio2.desafio2.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;

	@OneToMany(mappedBy = "usuario")
	private List<Livro> livrosEmprestados = new ArrayList<Livro>();
	
	public Usuario(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Usuario() {

	}

	public int getId() {
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
