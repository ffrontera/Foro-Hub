package ff.api.forohub.domain.topico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {

    @Query("""
            select t from Topico t
            where t.titulo=:tituloTopico
            and t.mensaje=:mensajeTopico
            """)
    Boolean existsByTituloAndMensaje(String tituloTopico, String mensajeTopico);
}
