package app.lector.tortilleria_salida.model;


import app.lector.tortilleria_salida.base.Base;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class DetallaVenta extends Base
{
    private double subtotalDetalleVenta;
    private double kilosDetalleVenta;
    private double precioDetalleVenta;
    private Producto producto;


}
