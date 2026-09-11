package pe.edu.upeu.sysventas.model;
import lombok.Getter;
import lombok.Setter;
import pe.edu.upeu.sysventas.enums.Menus;
import pe.edu.upeu.sysventas.enums.TipoTab;
@Setter
@Getter
public class Acceso {
    String idAcceso;
    String urlAcceso;
    String menuItemNombr;
    Menus menuNombre;
    TipoTab nombreTap;

}
