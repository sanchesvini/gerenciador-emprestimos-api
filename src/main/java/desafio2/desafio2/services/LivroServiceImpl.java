package desafio2.desafio2.services;

import desafio2.desafio2.entities.Livro;
import desafio2.desafio2.repositories.LivroRepository;
import desafio2.desafio2.rest.exceptions.CamposInvalidosException;
import desafio2.desafio2.rest.exceptions.LivroExistenteException;
import desafio2.desafio2.rest.exceptions.LivroNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
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

    @Override
    public Livro buscarLivroPorId(Long id) {
        if (id == null || id <= 0) {
            throw new CamposInvalidosException("ID inválido: O ID do livro deve ser um número positivo.");
        }
        Optional<Livro> livroOptional = livroRepository.findById(id);
        if (!livroOptional.isPresent()) {
            throw new LivroNaoEncontradoException("Livro não encontrado: Não existe livro cadastrado com o ID: " + id);
        }
        return livroOptional.get();
    }

    @Override
    public List<Livro> listarLivros() {
        return livroRepository.findAll();
    }

    @Override
    public void atualizarLivro(Livro livro) {
        Optional<Livro> livroOptional = livroRepository.findById(livro.getId());
        if (!livroOptional.isPresent()) {
            throw new LivroNaoEncontradoException("Livro não encontrado: Não existe livro cadastrado com o ID: " + livro.getId());
        }
        if (livro.getTitulo() == null || livro.getTitulo().isEmpty() || livro.getAutor() == null || livro.getAutor().isEmpty()) {
            throw new CamposInvalidosException("Campos inválidos: Verifique os dados informados.");
        }

        int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
        if (livro.getAnoPublicacao() > anoAtual) {
            throw new CamposInvalidosException("Ano de publicação inválido: O ano de publicação não pode ser maior que o ano atual.");
        }
        livroRepository.save(livro);
    }

    @Override
    public void deletarLivro(Long id) {
        Optional<Livro> livroOptional = livroRepository.findById(id);
        if (!livroOptional.isPresent()) {
            throw new LivroNaoEncontradoException("Livro não encontrado: Não existe livro cadastrado com o ID: " + id);
        }
        livroRepository.deleteById(id);
    }


}
