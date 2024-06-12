package ff.api.forohub.controller;

import ff.api.forohub.domain.curso.CursoService;
import ff.api.forohub.domain.curso.DatosActualizarCurso;
import ff.api.forohub.domain.curso.DatosCrearCurso;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService service;

    @PostMapping
    @Transactional
    public ResponseEntity crear(@RequestBody @Valid DatosCrearCurso datos) {
        var response = service.crearCurso(datos);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizar(@RequestBody @Valid DatosActualizarCurso datos) {
        var response = service.actualizarCurso(datos);
        return ResponseEntity.ok(response);
    }
}
