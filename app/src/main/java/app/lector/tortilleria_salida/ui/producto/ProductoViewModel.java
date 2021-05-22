package app.lector.tortilleria_salida.ui.producto;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import app.lector.tortilleria_salida.model.Producto;

public class ProductoViewModel extends ViewModel
{
    private MutableLiveData<String> mTextProd;

    private  MutableLiveData<Producto> datosProducto;

    public ProductoViewModel()
    {
        mTextProd = new MutableLiveData<>();
        mTextProd.setValue(" seguimos de mas");


        datosProducto = new MutableLiveData<>();



    }

    public LiveData<String> getTextProd() {
        return mTextProd;
    }

    public MutableLiveData<Producto> getDatosProducto() {
        return datosProducto;
    }
}