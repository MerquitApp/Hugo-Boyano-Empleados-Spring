package one.hgo.empleados.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmpleadoDTO {
    private String nombre;
    private String apellido;
    private String email;
    private String fotoSrc;
    private Date fechaContratacion;
}
