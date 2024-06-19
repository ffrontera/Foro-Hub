package ff.api.forohub.domain.curso;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

    boolean existsByNombre(String nombre);

    Page<Curso> findByActivoTrue(Pageable paginacion);

    Page<Curso> findByActivoFalse(Pageable paginacion);
}
