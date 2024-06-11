package ff.api.forohub.domain.respuesta;

import ff.api.forohub.domain.topico.Topico;
import ff.api.forohub.domain.usuario.Usuario;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public class Respuesta {

    private Long id;
    private String mensaje;
    @ManyToOne
    private Topico topico;
    private LocalDateTime fechaCreacion;
    @ManyToOne
    private Usuario autorRespuesta;
    private Boolean solucion;
}
