package desafio2.desafio2.services;

import desafio2.desafio2.entities.Usuario;
import desafio2.desafio2.repositories.UsuarioRepository;
import desafio2.desafio2.rest.exceptions.CamposInvalidosException;
import desafio2.desafio2.rest.exceptions.UsuarioNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void cadastrarUsuario(Usuario usuario) {
        if(usuario.getNome() == null || usuario.getNome().isEmpty()) {
            throw new CamposInvalidosException("O nome do usuário não pode ser vazio.");
        }
        usuarioRepository.save(usuario);
    }

    @Override
    public Usuario buscarUsuarioPorId(Long id) {
        if(id == null || id <= 0) {
            throw new CamposInvalidosException("O ID do usuário deve ser um número positivo.");
        }
        return usuarioRepository.findById(id).orElseThrow(() -> new UsuarioNaoEncontradoException("Usuário não encontrado com o ID: " + id));
    }

    @Override
    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();

        return usuarios;
    }

}
