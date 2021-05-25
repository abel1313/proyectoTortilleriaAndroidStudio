package app.lector.tortilleria_salida.model;

import app.lector.tortilleria_salida.base.Base;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Usuario extends Base
{
    private String nombreUsuario;
    
    private String contraUsuario;

}
