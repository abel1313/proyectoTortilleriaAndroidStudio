package app.lector.tortilleria_salida.ui.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GalleryViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public GalleryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Galería de imágenes de la \"Tortillería la salida\" ");
    }

    public LiveData<String> getText() {
        return mText;
    }
}