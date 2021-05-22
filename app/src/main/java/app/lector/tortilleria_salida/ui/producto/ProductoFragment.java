package app.lector.tortilleria_salida.ui.producto;


import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import app.lector.tortilleria_salida.R;
import org.jetbrains.annotations.NotNull;


import app.lector.tortilleria_salida.databinding.ProductoFragmentBinding;
import app.lector.tortilleria_salida.localHorario.HorarioLocal;

import app.lector.tortilleria_salida.model.Usuario;
import app.lector.tortilleria_salida.webService.Producto.ProductoWebService;

public class ProductoFragment extends Fragment {

    private ProductoViewModel mViewModel;
    private ProductoFragmentBinding bindingProducto;

    private LinearLayout linearViewCardLogin, linearLayoutAgregarPedido;
    private Usuario usuario;

    private TextView txtDescripccionProducto;
    private TextView txtDisponibilidadProducto;
    private TextView txtNombreProducto;
    private TextView txtPrecioProducto;
    private Button btnUpdateProducto;
    TextView t;

    private ProductoWebService obtenerProductos;
    public static ProductoFragment newInstance() {
        return new ProductoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {


        bindingProducto = ProductoFragmentBinding.inflate(inflater, container, false);

        View view = bindingProducto.getRoot();

        txtDisponibilidadProducto = bindingProducto.txtDisponibilidad;
        txtNombreProducto = bindingProducto.txtNombreProducto;
         txtPrecioProducto = bindingProducto.txtPrecioProductoCard;

        t = bindingProducto.textProducto;
        btnUpdateProducto = bindingProducto.btnUpdateProducto;



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

        linearLayoutAgregarPedido = view.findViewById(R.id.linearLayoutAgregarPedido);
        linearViewCardLogin = view.findViewById(R.id.layoutCardLogin);



        obtenerProductos = new ProductoWebService( getActivity(), view);

        obtenerProductos.getProducto();


        mViewModel = new ViewModelProvider(this).get(ProductoViewModel.class);
        // lamda


        if( HorarioLocal.horarioLocal(8,00,00, 20,00,00) )
        {

//            usuario = new Usuario();
//            usuario.setId(1);
//            usuario.setNombreUsuario("Abel");
//            usuario.setContraUsuario("123");



            btnUpdateProducto.setOnClickListener( v->{ obtenerProductos.getProducto(); });


     if( usuario == null)
     {
         linearLayoutAgregarPedido.setVisibility(View.GONE);

         mViewModel.getTextProd().observe(getViewLifecycleOwner(), s -> {
             t.setText(s);

         });

     }else
     {
         linearViewCardLogin.setVisibility(View.GONE);
     }



        }else
        {
            Toast.makeText(getActivity()," es falsote", Toast.LENGTH_LONG).show();
        }

    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

}