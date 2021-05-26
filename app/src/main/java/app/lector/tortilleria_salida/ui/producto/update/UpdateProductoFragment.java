package app.lector.tortilleria_salida.ui.producto.update;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.lector.tortilleria_salida.R;

public class UpdateProductoFragment extends Fragment {

    private UpdateProductoViewModel mViewModel;

    public static UpdateProductoFragment newInstance() {
        return new UpdateProductoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.update_producto_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(UpdateProductoViewModel.class);
        // TODO: Use the ViewModel
    }

}