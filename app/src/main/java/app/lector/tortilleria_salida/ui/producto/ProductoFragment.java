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

import app.lector.tortilleria_salida.ui.login.LoginFragment;
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
    private SharedPreferences preferences;

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

//        linearLayoutAgregarPedido = view.findViewById(R.id.linearLayoutAgregarPedido);
//        linearViewCardLogin = view.findViewById(R.id.layoutCardLogin);
//

//        obtenerProductos = new ProductoWebService( getActivity(), view);
////
//        obtenerProductos.getProducto();

        LoginFragment loginFragment = new LoginFragment();

        FragmentManager fragmentManager = getChildFragmentManager();

        fragmentManager.beginTransaction()
                .add(R.id.fragmentLoginOrOther, loginFragment)
                .setReorderingAllowed(true)
                .commit();



//        usuarioViewModel = new ViewModelProvider(this).get(UsuarioViewModel.class);
//        usuarioViewModel.getUsuarioModel().observe(getActivity(), cambioNombre->
//        {
//            edtContra.setText(cambioNombre + " de mas 13");
//            usuarioViewModel.getUsuarioModel().setValue(cambioNombre +"  cambio");
//            usuarioViewModel.getContraModel().setValue(" dale 13");
//        });

     //   mViewModel.getContraUsuario().observe(getViewLifecycleOwner(), contraUsuario -> { edtContra.setText( contraUsuario); });

        // Create the observer which updates the UI.
//        final Observer<String> nameObserver = newName -> {
//            // Update the UI, in this case, a TextView.
//
//        };

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.


//        btnAccederSistema.setOnClickListener(v ->
//        {
//
//            edtContra.setText( usuarioViewModel.getUsuarioModel().getValue() + " dale ");
//
//            if( edtUsuario.getText().toString().trim().equals("") || edtContra.getText().toString().trim().equals("") )
//            {
//              //  Toast.makeText(getActivity(),"No deje campos vacíos ", Toast.LENGTH_LONG).show();
//                Snackbar.make(view, "No deje campos vacíos", Snackbar.LENGTH_LONG)
//                        .show();
//                new UsuarioWebService(getActivity()).accederSistema( this , this, view);
//
//            }else
//                {
//                    new UsuarioWebService(getActivity()).accederSistema( this , this, view);
//            String result = new UsuarioWebService(getActivity()).calando();
//
//
//                    if( preferences == null )
//                    {
//                        preferences = getActivity().getSharedPreferences("usuarioSession", Context.MODE_PRIVATE);
//
//                        Log.d("cacio ", "entro vacion");
//                    }
//            if( preferences != null )
//            {
//                Log.d("vamoss ","=================================================================== " );
//                Log.d("vamoss ", preferences.getString("example", "nad apara mostrar" ) + " " );
//                Log.d("vamoss ","=================================================================== " );
//            }
//
//
//
//                }
//
//        });
        // lamda


        if( HorarioLocal.horarioLocal(8,00,00, 20,00,00) )
        {

//            usuario = new Usuario();
//            usuario.setId(1);
//            usuario.setNombreUsuario("Abel");
//            usuario.setContraUsuario("123");

//            btnUpdateProducto.setOnClickListener( v->{ obtenerProductos.getProducto(); });


//     if( usuario == null)
//     {
//         linearLayoutAgregarPedido.setVisibility(View.GONE);
//
//     }else
//     {
//         linearViewCardLogin.setVisibility(View.GONE);
//     }



        }else
        {
        //    Toast.makeText(getActivity()," es falsote", Toast.LENGTH_LONG).show();
            SharedPreferences settings = getActivity().getSharedPreferences("trece", Context.MODE_PRIVATE);
            settings.edit().clear().commit();
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