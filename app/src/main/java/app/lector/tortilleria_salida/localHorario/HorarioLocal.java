package app.lector.tortilleria_salida.localHorario;

import java.time.LocalTime;

public class HorarioLocal
{
    // veridicar que el la hora en la que se visiste el sistema sea una hora asignada
    public static boolean horarioLocal( int hora, int minuto, int segundo,
                                             int horaCerrado, int minutoCerrado, int segundoCerrado  )
    {
        LocalTime fechaD  = LocalTime.of(  hora,  minuto, segundo );
        LocalTime fechaCerrar  = LocalTime.of(  horaCerrado,  minutoCerrado, segundoCerrado );
        LocalTime justoAhora = LocalTime.now();
        return justoAhora.isAfter(fechaD) && justoAhora.isBefore(fechaCerrar);
    }

    public static boolean fechaLocalAbrir( int hora, int minuto, int segundo  )
    {
        LocalTime fechaDia  = LocalTime.of(  hora,  minuto, segundo );
        LocalTime justoNow = LocalTime.now();
        return justoNow.isAfter(fechaDia);
    }
}
