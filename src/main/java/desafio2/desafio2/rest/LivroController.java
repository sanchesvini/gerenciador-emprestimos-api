package desafio2.desafio2.rest;

import desafio2.desafio2.dtos.LivroRequestDTO;
import desafio2.desafio2.dtos.LivroResponseDTO;
import desafio2.desafio2.dtos.UsuarioResponseDTO;
import desafio2.desafio2.entities.Livro;
import desafio2.desafio2.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping
    public ResponseEntity<?> cadastrarLivro(@RequestBody LivroRequestDTO livroDTO) {
        livroService.cadastrarLivro(livroDTO.paraLivro());
        return ResponseEntity.ok("Livro cadastrado com sucesso!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarLivroPorId(@PathVariable Long id) {
        Livro livro = livroService.buscarLivroPorId(id);
        return ResponseEntity.ok(new LivroResponseDTO(livro));
    }
    @GetMapping
    public ResponseEntity<?> listarLivros() {
        List<Livro> livros = livroService.listarLivros();
        List<LivroResponseDTO> livrosDTO = livros.stream()
                .map(LivroResponseDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(livrosDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarLivro(@PathVariable Long id, @RequestBody LivroRequestDTO livroDTO) {

        Livro livro = livroDTO.paraLivro();
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

    @PostMapping("/{livroId}/devolver")
    public ResponseEntity<?> devolverLivro(@PathVariable Long livroId) {
        livroService.devolverLivro(livroId);
        return ResponseEntity.ok("Livro devolvido com sucesso!");
    }

}
