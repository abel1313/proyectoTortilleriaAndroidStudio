package app.lector.tortilleria_salida.ui.producto;


import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import app.lector.tortilleria_salida.R;
import org.jetbrains.annotations.NotNull;

import app.lector.tortilleria_salida.databinding.ProductoFragmentBinding;

public class ProductoFragment extends Fragment {

    private ProductoViewModel mViewModel;
    private ProductoFragmentBinding bindingProducto;

    private LinearLayout linearViewCardLogin, linearLayoutAgregarPedido;


    public static ProductoFragment newInstance() {
        return new ProductoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {

        mViewModel = new ViewModelProvider(this).get(ProductoViewModel.class);
        bindingProducto = ProductoFragmentBinding.inflate(inflater, container, false);

        View view = bindingProducto.getRoot();


        TextView t = bindingProducto.textProducto;

        // lamda
        mViewModel.getTextProd().observe(getViewLifecycleOwner(), s -> {
            t.setText(s);
        });

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

        linearLayoutAgregarPedido.setVisibility(View.GONE);
        linearViewCardLogin.setVisibility(View.INVISIBLE);



    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

}