package ff.api.forohub.controller;

import ff.api.forohub.domain.curso.*;
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

    //TODO: DELETE ( activar o desactivar curso)
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity cambiarEstado(@PathVariable Long id){

        return ResponseEntity.ok().build();
    }

    //TODO: Listar cursos activos

    //TODO: listar cursos inactivos

    //TODO: listar todos los cursos

    //TODO: get curso y listado de topicos
}
