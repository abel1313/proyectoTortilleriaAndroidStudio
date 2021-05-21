package app.lector.tortilleria_salida.model;


public class ConfigRequeen
{
    private final String url;
    private final String puerto;
    private final String host;
    private final String recurso;


    public ConfigRequeen() {
        this.url = "http://";
        this.puerto = "8080";
        this.host = "192.168.1.73:";
        this.recurso = "/empresa/sistema";
    }

    public ConfigRequeen(final String url, final String puero, final String host, String recurso) {
        this.url = url;
        this.puerto = puero;
        this.host = host+":";
        this.recurso = recurso;
    }

    @Override
    public String toString() {
        return this.url+this.host+this.puerto+this.recurso;
    }
}
