package desafio2.desafio2.services;

import desafio2.desafio2.entities.Livro;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LivroService {
     void cadastrarLivro(Livro livro);

     Livro buscarLivroPorId(Long id);

     List<Livro> listarLivros();

     void atualizarLivro(Livro livro);

     void deletarLivro(Long id);

     void emprestarLivro(Long livroId, Long usuarioId);
}
