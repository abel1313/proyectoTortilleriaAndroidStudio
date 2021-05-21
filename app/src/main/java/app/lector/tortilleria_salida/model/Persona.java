package app.lector.tortilleria_salida.model;



import app.lector.tortilleria_salida.base.Base;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Persona extends Base
{

    private String nombrePersona;
    private String maternoPersona;
    private String paternoPersona;
    private String telefonoPersona;
}
