package app.lector.tortilleria_salida.ui.producto;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProductoViewModel extends ViewModel
{
    private MutableLiveData<String> mTextProd;

    public ProductoViewModel()
    {
        mTextProd = new MutableLiveData<>();
        mTextProd.setValue(" seguimos de mas");

    }

    public LiveData<String> getTextProd() {
        return mTextProd;
    }

}