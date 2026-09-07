package pe.edu.upeu.sysventas.model;

import lombok.Data;
import pe.edu.upeu.sysventas.enums.TipoDocumento;
@Data
public class Cliente {
    String dniruc;
    String nombres;
    String redLegal;
    TipoDocumento tipoDocumento;

}
