package ff.api.forohub.domain.topico.respuesta;

public record DatosRespuesta(String mensaje, Long idTopico, Long idAutor, Boolean solucionado) {

    public DatosRespuesta(Respuesta respuesta) {
        this(respuesta.getMensaje(),
                respuesta.getTopico().getId(),
                respuesta.getAutorRespuesta().getId(),
                respuesta.getSolucion());
    }
}
