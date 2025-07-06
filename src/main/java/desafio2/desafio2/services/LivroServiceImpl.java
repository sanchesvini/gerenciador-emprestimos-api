package desafio2.desafio2.services;

import desafio2.desafio2.entities.Livro;
import desafio2.desafio2.repositories.LivroRepository;
import desafio2.desafio2.rest.exceptions.CamposInvalidosException;
import desafio2.desafio2.rest.exceptions.LivroExistenteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Optional;

@Service
public class LivroServiceImpl implements LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Override
    public void cadastrarLivro(Livro livro) {
        if (livro.getTitulo() == null || livro.getTitulo().isEmpty() || livro.getAutor() == null || livro.getAutor().isEmpty()) {
            throw new CamposInvalidosException("Campos inválidos: Verifique os dados informados.");
        }
        Optional<Livro> livroOptional = livroRepository.findByTitulo(livro.getTitulo());
        if (livroOptional.isPresent()) {
            throw new LivroExistenteException("Livro já cadastrado: O livro com o título '" + livro.getTitulo() + "' já existe.");
        }
        int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
        if (livro.getAnoPublicacao() > anoAtual) {
            throw new CamposInvalidosException("Ano de publicação inválido: O ano de publicação não pode ser maior que o ano atual.");
        }

        livro.setDisponivel(true);
        livroRepository.save(livro);



    }

}
