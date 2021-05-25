package app.lector.tortilleria_salida.event;

public interface IPasarDatos
{
     void irFacebook( String urlFacebook );

    void irTwitter( String urlTwitter );

    void irGoogle( String urlGoogle );

     void hacerLlamada(String numeroCell);

      void checandoSesion();

}
