package ff.api.forohub.controller;

import ff.api.forohub.domain.topico.EstadoTopicoRespuesta;
import ff.api.forohub.domain.topico.respuesta.DatosCrearRespuesta;
import ff.api.forohub.domain.topico.respuesta.DatosEditarRespuesta;
import ff.api.forohub.domain.topico.respuesta.RespuestaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("/respuestas")
public class RespuestaController {

    @Autowired
    private RespuestaService service;

    @PostMapping
    @Transactional
    public ResponseEntity crear(@RequestBody @Valid DatosCrearRespuesta datos) {
        var response = service.crearRespuesta(datos);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizar(@RequestBody @Valid DatosEditarRespuesta datos) {
        var response = service.editarRespuesta(datos);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity cambiarEstado(@PathVariable Long id) {
        EstadoTopicoRespuesta response = service.marcarDesmarcarComoSolucion(id);
        return ResponseEntity.ok(response);
    }

    //TODO: hacer el delete respuesta, revisar si la respuesta si es satisfactoria, y si no hay otra igual
    // marcar como false el status del topico
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminar(@PathVariable Long id) {

        return ResponseEntity.ok().build();
    }
}
