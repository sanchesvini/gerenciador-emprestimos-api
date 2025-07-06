package desafio2.desafio2.rest;

import desafio2.desafio2.entities.Livro;
import desafio2.desafio2.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping
    public ResponseEntity<?> cadastrarLivro(@RequestBody Livro livro) {
        livroService.cadastrarLivro(livro);
        return ResponseEntity.ok("Livro cadastrado com sucesso!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarLivroPorId(@PathVariable Long id) {
        Livro livro = livroService.buscarLivroPorId(id);
        return ResponseEntity.ok(livro);
    }
    @GetMapping
    public ResponseEntity<?> listarLivros() {
        return ResponseEntity.ok(livroService.listarLivros());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarLivro(@PathVariable Long id, @RequestBody Livro livro) {
        livro.setId(id);
        livroService.atualizarLivro(livro);
        return ResponseEntity.ok("Livro atualizado com sucesso!");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarLivro(@PathVariable Long id) {
        livroService.deletarLivro(id);
        return ResponseEntity.ok("Livro deletado com sucesso!");
    }

    @PostMapping("/{livroId}/emprestar/{usuarioId}")
    public ResponseEntity<?> emprestarLivro(@PathVariable Long livroId, @PathVariable Long usuarioId) {
        livroService.emprestarLivro(livroId, usuarioId);
        return ResponseEntity.ok("Livro emprestado com sucesso!");
    }

}
