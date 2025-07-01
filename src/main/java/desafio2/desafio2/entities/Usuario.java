package desafio2.desafio2.entities;

import java.util.ArrayList;

public class Usuario {
	private int id;
	private String nome;
	private ArrayList<Livro> livrosEmprestados = new ArrayList<Livro>();
	
	public Usuario(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	public ArrayList<Livro> getLivrosEmprestados() {
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
