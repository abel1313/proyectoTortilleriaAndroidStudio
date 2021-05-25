package app.lector.tortilleria_salida.webService.usuarios;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.Observable;

import app.lector.tortilleria_salida.R;
import app.lector.tortilleria_salida.ViewModel.UsuarioViewModel;
import app.lector.tortilleria_salida.model.ConfigRequeen;
import app.lector.tortilleria_salida.model.Usuario;
import app.lector.tortilleria_salida.patronDiseno.MySingleton;
import app.lector.tortilleria_salida.ui.producto.ProductoViewModel;

public class UsuarioWebService
{

    private ProductoViewModel mViewModel;
    private SharedPreferences preferences;

    private Context context;
    private EditText edt;
    public UsuarioWebService( final Context context)
    {
    this.context = context;
        preferences = this.context.getSharedPreferences("usuarioSesion", context.MODE_PRIVATE);
    }
    public void getUsuarios()
    {
        final String urlService =  new ConfigRequeen().toString();
       final String url = urlService+"/tortilleria/usuarios/add";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {



                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                    }
                });

        // Access the RequestQueue through your singleton class.
        MySingleton.getInstance(this.context).addToRequestQueue(jsonObjectRequest);

    }

    public void accederSistema( ViewModelStoreOwner store, LifecycleOwner lifecycle, View view)
    {
        final String urlService =  new ConfigRequeen().toString();
        final String url = urlService+"/producto/usuarios/acceder";
        final String url1 = urlService+"/producto/getProducto/"+1;
        edt = view.findViewById(R.id.edtContraSistema);


     //   final LinearLayout linearLayoutAgregarPedido = view.findViewById(R.id.linearLayoutAgregarPedido);
      //  final LinearLayout linearViewCardLogin  = view.findViewById(R.id.layoutCardLogin);

        Usuario usu = new Usuario();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url1, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //textView.setText("Response: " + response.toString());
//                        usu.setNombreUsuario(("Abel"));
//                        usu.setContraUsuario(("123"));
//
//                        UsuarioViewModel model = new ViewModelProvider( store ).get(UsuarioViewModel.class);
//                        model.getUsuarioModel().observe(lifecycle, users -> {
//                            // update UI
//
//                            edt.setText(users + " dale ");
//                        });

                        if( response != null )
                        {
                            Log.d("vamoss ","desabilitar layout " );

                        //    linearViewCardLogin.setVisibility(View.INVISIBLE);
                          //  linearLayoutAgregarPedido.setVisibility(View.INVISIBLE);
                        }

                        Log.d("vamoss ","=================================================================== " );

                        Log.d("vamoss ","response: "+ response.toString() );

                        Log.d("vamoss ","=================================================================== " );


                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("example",  response.toString() );
                        editor.commit();


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                    }
                });
        // Access the RequestQueue through your singleton class.

        MySingleton.getInstance(this.context).addToRequestQueue(jsonObjectRequest);
    }


    public String calando()
    {



        return "exactament";
    }



}
