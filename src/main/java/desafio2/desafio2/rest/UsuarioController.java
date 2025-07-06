package desafio2.desafio2.rest;

import desafio2.desafio2.dtos.LivroResponseDTO;
import desafio2.desafio2.dtos.UsuarioRequestDTO;
import desafio2.desafio2.dtos.UsuarioResponseDTO;
import desafio2.desafio2.entities.Usuario;
import desafio2.desafio2.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<?> cadastrarUsuario(@RequestBody UsuarioRequestDTO usuarioDTO){
        usuarioService.cadastrarUsuario(usuarioDTO.paraUsuario());
        return ResponseEntity.ok("Usuário cadastrado com sucesso!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarUsuarioPorId(@PathVariable Long id) {
        Usuario usuario = usuarioService.buscarUsuarioPorId(id);
        return ResponseEntity.ok(new UsuarioResponseDTO(usuario));
    }
    @GetMapping
    public ResponseEntity<?> listarUsuarios() {
        List<Usuario> usuarios = usuarioService.listarUsuarios();

        List<UsuarioResponseDTO> usuariosDTO = usuarios.stream()
                .map(UsuarioResponseDTO::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(usuariosDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarUsuario(@PathVariable Long id, @RequestBody UsuarioRequestDTO usuarioDTO) {
        Usuario usuario = usuarioDTO.paraUsuario();
        usuario.setId(id);
        usuarioService.atualizarUsuario(usuario);
        return ResponseEntity.ok("Usuário atualizado com sucesso!");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
        return ResponseEntity.ok("Usuário deletado com sucesso!");
    }

    @GetMapping("/{id}/livros-emprestados")
    public ResponseEntity<?> listarLivrosEmprestados(@PathVariable Long id){
        Usuario usuario = usuarioService.buscarUsuarioPorId(id);
        List<LivroResponseDTO> livrosEmprestados = usuario.getLivrosEmprestados().stream()
                .map(LivroResponseDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(livrosEmprestados);
    }



}
