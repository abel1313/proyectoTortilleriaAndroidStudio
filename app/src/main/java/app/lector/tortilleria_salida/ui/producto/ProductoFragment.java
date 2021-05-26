package app.lector.tortilleria_salida.ui.producto;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import org.jetbrains.annotations.NotNull;


import app.lector.tortilleria_salida.R;
import app.lector.tortilleria_salida.ViewModel.UsuarioViewModel;

import app.lector.tortilleria_salida.databinding.FragmentProductoBinding;
import app.lector.tortilleria_salida.event.IPasarDatos;
import app.lector.tortilleria_salida.localHorario.HorarioLocal;

import app.lector.tortilleria_salida.model.Usuario;

import app.lector.tortilleria_salida.ui.fueraHorario.FueraHorarioFragment;
import app.lector.tortilleria_salida.ui.login.LoginFragment;
import app.lector.tortilleria_salida.ui.login.OtroFragment;
import app.lector.tortilleria_salida.ui.producto.update.UpdateProductoFragment;
import app.lector.tortilleria_salida.webService.Producto.ProductoWebService;


public class ProductoFragment extends Fragment {

    private ProductoViewModel mViewModel;

    private UsuarioViewModel usuarioViewModel;

    private FragmentProductoBinding bindingProducto;

    private Usuario usuario;

    private TextView txtDescripccionProducto;
    private TextView txtDisponibilidadProducto;
    private TextView txtNombreProducto;
    private TextView txtPrecioProducto;
    private Button btnUpdateProducto, btnAccederSistema;
    TextView t;





    private Snackbar mySnackbar;

    private IPasarDatos iPasarDatos;

    private ProductoWebService obtenerProductos;
    private SharedPreferences preferencesProducto;

    public ProductoFragment()
    {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {


        bindingProducto = FragmentProductoBinding.inflate(inflater, container, false);

        View view = bindingProducto.getRoot();

        txtDisponibilidadProducto = bindingProducto.txtDisponibilidad;
        txtNombreProducto = bindingProducto.txtNombreProducto;
        txtPrecioProducto = bindingProducto.txtPrecioProductoCard;






       // mViewModel.getDatosProducto().observe(getViewLifecycleOwner(), producto -> txtNombreProducto.setText( producto.getNombreProducto() ));

        // por default
//        mViewModel.getTextProd().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(String s) {
//
//            }
//        });


        return  view;

    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        obtenerProductos = new ProductoWebService( getActivity(), view);

//        obtenerProductos.getProducto();

        preferencesProducto = getActivity().getSharedPreferences("usuarioSesion", Context.MODE_PRIVATE);

        FragmentManager fragmentManager = getChildFragmentManager();
        if( HorarioLocal.horarioLocal(8,00,00, 16,00,00) )
        {
            // solo se llama si esta dentro del horario establecido xD
            obtenerProductos.getProducto();
            if( !preferencesProducto
                    .getString("nombreUsuario","default")
                    .equals("admin"))
            {
                LoginFragment loginFragment = new LoginFragment();
                fragmentManager.beginTransaction()
                        .add(R.id.fragmentLoginOrOther, loginFragment)
                        .setReorderingAllowed(true)
                        .commit();
            }
            else if( preferencesProducto.getString("nombreUsuario","default").equals("admin"))
            {
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentLoginOrOther, UpdateProductoFragment.class, null)
                        .setReorderingAllowed(true)
                        .commit();
            }else
            {
                fragmentManager.beginTransaction()
                        .add(R.id.fragmentLoginOrOther, OtroFragment.class,null)
                        .setReorderingAllowed(true)
                        .commit();
            }

        }else
        {

            FueraHorarioFragment fueraHorarioFragment = new FueraHorarioFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.fragmentLoginOrOther, fueraHorarioFragment)
                    .setReorderingAllowed(true)
                    .commit();
        }

    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    @Override
    public void onAttachFragment(@NonNull @NotNull Fragment childFragment) {
        super.onAttachFragment(childFragment);
    }
}