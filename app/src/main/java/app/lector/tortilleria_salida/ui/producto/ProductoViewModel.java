package app.lector.tortilleria_salida.ui.producto;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import app.lector.tortilleria_salida.model.Producto;

public class ProductoViewModel extends ViewModel
{
    private MutableLiveData<String> mTextProd;

    private  MutableLiveData<Producto> datosProducto;
    private MutableLiveData<String> nombreUsuario;
    private MutableLiveData<String> contraUsuario;

    public ProductoViewModel()
    {
        mTextProd = new MutableLiveData<>();
        mTextProd.setValue(" seguimos de mas");
        datosProducto = new MutableLiveData<>();

        nombreUsuario = new MutableLiveData<>();

        contraUsuario = new MutableLiveData<>();


    }

    public LiveData<String> getTextProd() {
        return mTextProd;
    }

    public MutableLiveData<Producto> getDatosProducto() {
        return datosProducto;
    }

    public MutableLiveData<String> getNombreUsuario() {
        return nombreUsuario;
    }

    public MutableLiveData<String> getContraUsuario() {
        return contraUsuario;
    }
}