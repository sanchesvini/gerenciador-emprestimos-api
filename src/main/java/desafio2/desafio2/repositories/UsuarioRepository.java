package desafio2.desafio2.repositories;

import desafio2.desafio2.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // This interface will automatically inherit methods for CRUD operations
    // from JpaRepository, such as save, findById, findAll, deleteById, etc.
}
