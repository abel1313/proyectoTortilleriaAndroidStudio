package app.lector.tortilleria_salida.ui.login;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import app.lector.tortilleria_salida.model.Usuario;

public class LoginViewModel  extends ViewModel
{
    private MutableLiveData<String> usuarioNombre;
    private MutableLiveData<String> contraNombre;

    public LoginViewModel()
    {
        usuarioNombre = new MutableLiveData<>();

        contraNombre = new MutableLiveData<>();
    }

    public MutableLiveData<String> getUsuarioNombre() {
        return usuarioNombre;
    }

    public void setUsuarioNombre(MutableLiveData<String> usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }

    public MutableLiveData<String> getContraNombre() {
        return contraNombre;
    }

    public void setContraNombre(MutableLiveData<String> contraNombre) {
        this.contraNombre = contraNombre;
    }
}
