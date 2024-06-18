package ff.api.forohub.controller;

import ff.api.forohub.domain.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService service;

    @PostMapping
    @Transactional
    public ResponseEntity crear(@RequestBody @Valid DatosCrearTopico datos) {
        var response = service.crearTopico(datos);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizar(@RequestBody @Valid DatosActualizarTopico datos) {
        var response = service.actualizarTopico(datos);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminar(@PathVariable Long id) {
        var response = service.eliminarTopico(id);
        return ResponseEntity.ok(response);
    }


    //TODO: implementar PadeModel
    @GetMapping
    public ResponseEntity<Page<DatosTopico>> listar(@PageableDefault(size = 10)Pageable paginacion) {
        Page<DatosTopico> page = service.listarTopicos(paginacion);
        return ResponseEntity.ok(page);
    }

    //TODO: listar topicos solucionados

    //TODO: listar cursos no solucionados

    @GetMapping("/{id}")
    public ResponseEntity mostrarTopicoRespuestas(@PageableDefault(size = 10)Pageable paginacion,
                                        @PathVariable Long id) {
        var topico = service.mostrarTopico(id, paginacion);
        return ResponseEntity.ok(topico);
    }
}
