package desafio2.desafio2.services;

import desafio2.desafio2.entities.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsuarioService {

    void cadastrarUsuario(Usuario usuario);

    Usuario buscarUsuarioPorId(Long id);

    List<Usuario> listarUsuarios();
}
