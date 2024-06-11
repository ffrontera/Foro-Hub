package ff.api.forohub.domain.topico;

import java.time.LocalDateTime;

public record DatosTopico(Long id, String titulo, String mensaje, LocalDateTime fecha) {

    public DatosTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion());
    }
}
