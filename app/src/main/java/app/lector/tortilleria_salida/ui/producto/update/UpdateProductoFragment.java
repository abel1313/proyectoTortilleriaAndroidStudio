package app.lector.tortilleria_salida.ui.producto.update;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import app.lector.tortilleria_salida.R;
import app.lector.tortilleria_salida.databinding.FragmentLoginBinding;
import app.lector.tortilleria_salida.databinding.UpdateProductoFragmentBinding;
import app.lector.tortilleria_salida.ui.login.LoginFragment;
import app.lector.tortilleria_salida.ui.login.OtroFragment;

public class UpdateProductoFragment extends Fragment {

    private UpdateProductoViewModel mViewModel;
private UpdateProductoFragmentBinding updateProductoFragmentBinding;

private Button btnSalir, btnUpdateProducto;

    private SharedPreferences sharedPreferencesUpdateProducto;

    public static UpdateProductoFragment newInstance() {
        return new UpdateProductoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        updateProductoFragmentBinding = UpdateProductoFragmentBinding.inflate(inflater, container, false);
        View view = updateProductoFragmentBinding.getRoot();

        btnSalir = updateProductoFragmentBinding.btnSalir;

       return view;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sharedPreferencesUpdateProducto = getActivity().getSharedPreferences("usuarioSesion", Context.MODE_PRIVATE);








        btnSalir.setOnClickListener(v->
    {

        if( !sharedPreferencesUpdateProducto
                .getString("nombreUsuario","default")
                .equals(""))
        {
            sharedPreferencesUpdateProducto.edit().clear().commit();

            FragmentManager fragmentManager = getParentFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentLoginOrOther, LoginFragment.class,null)
                    .setReorderingAllowed(true)
                    .commit();

         //   Toast.makeText(getActivity(), " delete ", Toast.LENGTH_LONG).show();
        }

    });


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(UpdateProductoViewModel.class);
        // TODO: Use the ViewModel
    }

}