package ff.api.forohub.domain.usuario;

import ff.api.forohub.domain.topico.respuesta.RespuestaTopico;
import ff.api.forohub.domain.topico.Topico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String contrasenia;
    @OneToMany(mappedBy = "autorTopico", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Topico> topicos;
    @OneToMany(mappedBy = "autorRespuesta", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<RespuestaTopico> respuestas;
}
