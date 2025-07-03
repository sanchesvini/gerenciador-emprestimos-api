package desafio2.desafio2.services;

import desafio2.desafio2.entities.Usuario;
import desafio2.desafio2.repositories.UsuarioRepository;
import desafio2.desafio2.rest.exceptions.CamposInvalidosException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
