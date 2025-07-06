package desafio2.desafio2.dtos;

import desafio2.desafio2.entities.Usuario;

public class UsuarioRequestDTO {

    private String nome;

    public Usuario paraUsuario() {
        return new Usuario(nome);
    }

    public UsuarioRequestDTO() {
    }

    public UsuarioRequestDTO(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
