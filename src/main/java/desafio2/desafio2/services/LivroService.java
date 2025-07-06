package desafio2.desafio2.services;

import desafio2.desafio2.entities.Livro;
import org.springframework.stereotype.Service;

@Service
public interface LivroService {
     void cadastrarLivro(Livro livro);

     Livro buscarLivroPorId(Long id);
}
