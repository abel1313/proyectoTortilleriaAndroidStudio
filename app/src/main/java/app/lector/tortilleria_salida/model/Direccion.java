package app.lector.tortilleria_salida.model;

import app.lector.tortilleria_salida.base.Base;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Direccion extends Base
{
    private String municipioDireccion;
    private String caracteristicasDireccion;
    private String descripccionDireccion;
}
