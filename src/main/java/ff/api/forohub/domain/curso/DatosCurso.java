package ff.api.forohub.domain.curso;

public record DatosCurso(String nombre, Categoria categoria) {

    public DatosCurso(Curso curso) {
        this(curso.getNombre(), curso.getCategoria());
    }
}
