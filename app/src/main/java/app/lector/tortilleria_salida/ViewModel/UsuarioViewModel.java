package app.lector.tortilleria_salida.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UsuarioViewModel extends ViewModel
{

    private MutableLiveData<String> usuarioModel;
    private MutableLiveData<String> contraModel;

    public UsuarioViewModel()
    {
        usuarioModel = new MutableLiveData<>();
        contraModel = new MutableLiveData<>();
    }

    public MutableLiveData<String> getUsuarioModel() {
        return usuarioModel;
    }

    public void setUsuarioModel(MutableLiveData<String> usuarioModel) {
        this.usuarioModel = usuarioModel;
    }

    public MutableLiveData<String> getContraModel() {
        return contraModel;
    }

    public void setContraModel(MutableLiveData<String> contraModel) {
        this.contraModel = contraModel;
    }
}
