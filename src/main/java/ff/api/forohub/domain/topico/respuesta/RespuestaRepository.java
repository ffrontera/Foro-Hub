package ff.api.forohub.domain.topico.respuesta;

import ff.api.forohub.domain.topico.Topico;
import ff.api.forohub.domain.usuario.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {

    boolean existsByMensaje(String mensaje);

    boolean existsByTopicoAndSolucion(Topico topico, boolean solucion);

    boolean existsByTopicoAndMensajeAndAutorRespuesta(Topico topico, String mensaje, Usuario autorRespuesta);

    List<Optional> removeAllByTopico(Topico topico);

    Page<Respuesta> findAllByTopico(Topico topico, Pageable paginacion);
}
