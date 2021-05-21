package app.lector.tortilleria_salida.model;

import app.lector.tortilleria_salida.base.Base;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario extends Base
{
    private String nombreUsuario;
    
    private String contraUsuario;

}
