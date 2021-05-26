package app.lector.tortilleria_salida.ui.fueraHorario;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.lector.tortilleria_salida.R;

public class FueraHorarioFragment extends Fragment {

    private FueraHorarioViewModel mViewModel;

    public static FueraHorarioFragment newInstance() {
        return new FueraHorarioFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fuera_horario_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(FueraHorarioViewModel.class);
        // TODO: Use the ViewModel
    }

}