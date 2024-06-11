package ff.api.forohub.domain.curso;

import ff.api.forohub.domain.topico.Topico;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.util.List;

public class Curso {

    private Long id;
    private String nombre;
    private List<Categoria> categorias;
    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Topico> topicosCurso;
}
