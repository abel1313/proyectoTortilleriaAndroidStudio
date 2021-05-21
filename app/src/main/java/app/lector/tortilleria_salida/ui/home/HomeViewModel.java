package app.lector.tortilleria_salida.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private MutableLiveData<String> mTextEjemplo;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");

        mTextEjemplo = new MutableLiveData<>();
        mTextEjemplo.setValue("Example a la vista");
    }

    public LiveData<String> getText() {
        return mText;
    }
    public LiveData<String> getTextEjemplo() {
        return mTextEjemplo;
    }
}