package app.lector.tortilleria_salida.ui.home;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import org.jetbrains.annotations.NotNull;

import app.lector.tortilleria_salida.R;
import app.lector.tortilleria_salida.databinding.FragmentHomeBinding;
import app.lector.tortilleria_salida.event.IPasarDatos;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    private ImageButton btnFacebook, btnTwitter, btnLlamar, btnCorreo;

    private IPasarDatos ipasarDatos;




    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnFacebook = view.findViewById(R.id.btnFacebook);
        btnTwitter = view.findViewById(R.id.btnTwitter);
        btnLlamar = view.findViewById(R.id.btnPhone);

        btnCorreo = view.findViewById(R.id.btnGoogle);


        btnLlamar.setOnClickListener(v->
        {
            final String numero = "tel:7221111793";
            ipasarDatos.hacerLlamada( numero );
        });
        btnFacebook.setOnClickListener( v->
        {
            final String url = "https://www.facebook.com/abelito13/";
            ipasarDatos.irFacebook( url );
        });
        btnTwitter.setOnClickListener( v->
        {
            final String url = "https://twitter.com/Abel53406980";
            ipasarDatos.irTwitter( url );
        });

        btnCorreo.setOnClickListener( v->
        {
            final String url = "https://twitter.com/Abel53406980";
            ipasarDatos.irGoogle( url );
        });

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        SharedPreferences prefes;
        prefes = getActivity().getSharedPreferences("trece", Context.MODE_PRIVATE);

        Toast.makeText(getActivity(),""+ prefes.getString("a","HOM"), Toast.LENGTH_LONG).show();

        if( prefes.getString("a","HOM").equals("abel"))
        {
            SharedPreferences prefes2;
            prefes2 = getActivity().getSharedPreferences("treceSesion", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor2 = prefes2.edit();
            editor2.putString("sessionActiva", "adminListo").commit();
        }

//        final TextView textView = binding.textHome;
//      //  final TextView textViewEjemplo = binding.textEjemplo;
//
//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        //homeViewModel.getTextEjemplo().observe(getViewLifecycleOwner(),s -> textViewEjemplo.setText(s));
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            ipasarDatos = (IPasarDatos) context;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(e.toString()
                    + " must implement NoticeDialogListener");
        }
    }



}