package desafio2.desafio2.rest;

import desafio2.desafio2.entities.Usuario;
import desafio2.desafio2.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<?> cadastrarUsuario(@RequestBody Usuario usuario){
        usuarioService.cadastrarUsuario(usuario);
        return ResponseEntity.ok("Usuário cadastrado com sucesso!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarUsuarioPorId(@PathVariable Long id) {
        Usuario usuario = usuarioService.buscarUsuarioPorId(id);
        return ResponseEntity.ok(usuario);
    }
    @GetMapping
    public ResponseEntity<?> listarUsuarios() {
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }



}
