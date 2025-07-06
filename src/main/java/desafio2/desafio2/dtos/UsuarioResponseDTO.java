package desafio2.desafio2.dtos;

import desafio2.desafio2.entities.Usuario;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioResponseDTO {

    private Long id;
    private String nome;
    private List<LivroResponseDTO> livrosEmprestados;

    public UsuarioResponseDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.livrosEmprestados = usuario.getLivrosEmprestados().stream()
                .map(LivroResponseDTO::new)
                .collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<LivroResponseDTO> getLivrosEmprestados() {
        return livrosEmprestados;
    }

    public void setLivrosEmprestados(List<LivroResponseDTO> livrosEmprestados) {
        this.livrosEmprestados = livrosEmprestados;
    }
}
