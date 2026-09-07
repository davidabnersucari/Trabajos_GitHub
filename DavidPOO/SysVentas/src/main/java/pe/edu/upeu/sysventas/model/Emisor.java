package pe.edu.upeu.sysventas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emisor {
    private Long id;
    private String ruc;
    private String razonSocial;
    private String nombreComercial;
    private String direccion;
    private String ubigeo;
    private String telefono;
    private String email;
}
