package ff.api.forohub.domain.topico;

import ff.api.forohub.domain.curso.CursoRepository;
import ff.api.forohub.domain.topico.validaciones.ValidadorTopico;
import ff.api.forohub.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private List<ValidadorTopico> validarTopico;

    public DatosTopico crearTopico(DatosCrearTopico datos) {

        validarTopico.forEach(v -> v.validar(datos));

        var titulo = datos.titulo();
        var mensaje = datos.mensaje();
        var autor = usuarioRepository.getReferenceById(datos.idAutor());
        var curso = cursoRepository.getReferenceById(datos.idCurso());

        var topico = new Topico(titulo, mensaje, autor, curso);
        topicoRepository.save(topico);
        return new DatosTopico(topico);
    }
}
