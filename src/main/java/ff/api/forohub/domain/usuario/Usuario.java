package ff.api.forohub.domain.usuario;

import ff.api.forohub.domain.respuesta.Respuesta;
import ff.api.forohub.domain.topico.Topico;
import ff.api.forohub.domain.usuario.perfil.Perfil;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.util.List;

public class Usuario {

    private Long id;
    private String nombre;
    private String email;
    private String contraseña;
    private List<Perfil> perfiles;
    @OneToMany(mappedBy = "autorTopico", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Topico> topicos;
    @OneToMany(mappedBy = "autorRespuesta", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Respuesta> respuestas;
}
