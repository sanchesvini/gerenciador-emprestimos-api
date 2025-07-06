package desafio2.desafio2.rest;

import desafio2.desafio2.entities.Livro;
import desafio2.desafio2.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/livros")
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

}
