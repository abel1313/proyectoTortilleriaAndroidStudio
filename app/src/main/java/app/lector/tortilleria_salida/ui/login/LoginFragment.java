package app.lector.tortilleria_salida.ui.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;

import app.lector.tortilleria_salida.R;
import app.lector.tortilleria_salida.databinding.FragmentLoginBinding;
import app.lector.tortilleria_salida.databinding.FragmentProductoBinding;
import app.lector.tortilleria_salida.model.Usuario;
import app.lector.tortilleria_salida.ui.producto.update.UpdateProductoFragment;
import app.lector.tortilleria_salida.webService.usuarios.UsuarioWebService;


public class LoginFragment extends Fragment {

    private FragmentLoginBinding bindingProducto;
    private EditText edtUsuario, edtContra;
    private Button btnAccederSistema;

    private LoginViewModel model;

    private Usuario u;

    private  SharedPreferences sharedPreferencesLogin;



    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);





//                getActivity().getSharedPreferences("trece", Context.MODE_PRIVATE);
//
//        String uno = prefs.getString("a","no existe valor alguno");
//        Toast.makeText(getActivity()," iniciando no es null " + uno , Toast.LENGTH_LONG).show();
//
//        if( prefs == null )
//        {
//
//
//        }



//        if( u == null )
//        {
//
//               FragmentManager fragmentManager = getParentFragmentManager();
//            fragmentManager.beginTransaction()
//                    .replace(R.id.fragmentLoginOrOther, OtroFragment.class,null)
//                    .setReorderingAllowed(true)
//                    .commit();
//        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment



        bindingProducto = FragmentLoginBinding.inflate(inflater, container, false);

        View view = bindingProducto.getRoot();

        edtUsuario = bindingProducto.edtUsuarioSistema;
        edtContra = bindingProducto.edtContraSistema;
        btnAccederSistema = bindingProducto.btnAccesoSistema;

        // Get the ViewModel.
        model = new ViewModelProvider(this).get(LoginViewModel.class);

        // Create the observer which updates the UI.
        final Observer<String> nameObserver = new Observer<String>() {
            @Override
            public void onChanged(@Nullable final String newName) {
                // Update the UI, in this case, a TextView.


                edtContra.setText(newName +" si mero " +model.getUsuarioNombre().getValue());
//                model.getUsuarioNombre().setValue(newName);

            }
        };

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.

        model.getUsuarioNombre().observe(getViewLifecycleOwner(), nameObserver);




//        btnUpdateProducto = bindingProducto.btnUpdateProducto;

     //   Toast.makeText(getActivity()," Buena 13"+ model.getUsuarioNombre().getValue(), Toast.LENGTH_LONG).show();


        SharedPreferences prefes3;
        prefes3 = getActivity().getSharedPreferences("treceSesion", Context.MODE_PRIVATE);

        if( prefes3.getString("sessionActiva","noexiste").equals("adminListo") )
        {
            FragmentManager fragmentManager = getParentFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentLoginOrOther, OtroFragment.class,null)
                    .setReorderingAllowed(true)
                    .commit();
        }


        return view;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        sharedPreferencesLogin = getActivity().getSharedPreferences("usuarioSesion", Context.MODE_PRIVATE);

        if( sharedPreferencesLogin
                .getString("nombreUsuario","default")
                .equals("admin"))
        {
            Toast.makeText(getActivity(), sharedPreferencesLogin.getString("nombreUsuario","default")+ " antes" , Toast.LENGTH_LONG ).show();

            FragmentManager fragmentManagerUpdate = getParentFragmentManager();
            fragmentManagerUpdate.beginTransaction()
                    .replace(R.id.fragmentLoginOrOther, UpdateProductoFragment.class,null)
                    .setReorderingAllowed(true)
                    .commit();

        }

        btnAccederSistema.setOnClickListener(v->
        {
            if( !edtContra.getText().toString().trim().equals("") &&
                    !edtUsuario.getText().toString().trim().equals("") )
            {
                try {
                    FragmentManager fragmentRepace = getParentFragmentManager();
                    new UsuarioWebService(getActivity())
                            .accederSistema(this,this,view, fragmentRepace);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }else
            {
                Snackbar.make(view, "No deje campos vacíos", Snackbar.LENGTH_LONG).show();
                edtContra.setText("");
                edtUsuario.setText("");

            }
        });

    }




}