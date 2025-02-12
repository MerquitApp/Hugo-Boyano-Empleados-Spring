package one.hgo.empleados.controler;

import one.hgo.empleados.dto.EmpleadoDTO;
import one.hgo.empleados.model.Empleado;
import one.hgo.empleados.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;


@Controller
@RequestMapping("empleado")
public class EmpleadoController {

    @Autowired
    EmpleadoRepository empleadoRepository;

    @GetMapping("/")
    public ResponseEntity<List<Empleado>> getAllEmpleados() {
        return ResponseEntity.ok(empleadoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> getEmpleadoById(@RequestParam("id") Long id) {
        return ResponseEntity.ok(Objects.requireNonNull(empleadoRepository.findById(id).orElse(null)));
    }

    @PostMapping("/")
    public ResponseEntity<Empleado> createEmpleado(@RequestBody EmpleadoDTO empleadoDTO) {
        String nombre = empleadoDTO.getNombre();
        String apellido = empleadoDTO.getApellido();
        String email = empleadoDTO.getEmail();
        String fotoSrc = empleadoDTO.getFotoSrc();
        Date fechaContratacion = empleadoDTO.getFechaContratacion();

        Empleado empleado = new Empleado();
        empleado.setNombre(nombre);
        empleado.setApellido(apellido);
        empleado.setEmail(email);
        empleado.setFotoSrc(fotoSrc);
        empleado.setFechaContratacion(fechaContratacion);

        return ResponseEntity.ok(empleadoRepository.save(empleado));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Empleado> updateEmpleado(@RequestParam("id") Long id) {
        return ResponseEntity.ok(empleadoRepository.findById(id).orElse(null));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Empleado> deleteEmpleado(@RequestParam("id") Long id) {
        return ResponseEntity.ok(empleadoRepository.findById(id).orElse(null));
    }
}
