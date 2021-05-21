package app.lector.tortilleria_salida.model;

import java.util.List;

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
public class Venta extends Base
{
    private double totalVenta;
    private String fechaVenta;
    private Cliente cliente;
    private Usuario usuario;
    private List<DetallaVenta>listaDetalleVenta;
}
