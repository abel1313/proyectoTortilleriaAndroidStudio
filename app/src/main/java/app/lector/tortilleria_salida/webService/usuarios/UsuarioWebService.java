package app.lector.tortilleria_salida.webService.usuarios;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

import app.lector.tortilleria_salida.R;
import app.lector.tortilleria_salida.ViewModel.UsuarioViewModel;
import app.lector.tortilleria_salida.model.ConfigRequeen;
import app.lector.tortilleria_salida.model.Usuario;
import app.lector.tortilleria_salida.patronDiseno.MySingleton;
import app.lector.tortilleria_salida.ui.login.LoginFragment;
import app.lector.tortilleria_salida.ui.producto.ProductoViewModel;
import app.lector.tortilleria_salida.ui.producto.update.UpdateProductoFragment;

public class UsuarioWebService
{

    private ProductoViewModel mViewModel;
    private final SharedPreferences preferences;

    private Context context;
    private EditText edtUsuario, edtContra;

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

    public void accederSistema(ViewModelStoreOwner store, LifecycleOwner lifecycle, View view, FragmentManager fragmentManagerA) throws JSONException {
        final String urlService =  new ConfigRequeen().toString();
        final String url = urlService+"/producto/usuarios/acceder";
        final String url1 = urlService+"/usuario/acceder/";
        edtContra = view.findViewById(R.id.edtContraSistema);
        edtUsuario = view.findViewById(R.id.edtUsuarioSistema);

      //  String json = g.toJson(usu);
        JSONObject json = new JSONObject();
        json.put("nombreUsuario", edtUsuario.getText().toString().trim() );
        json.put("contrasenaUsuario", edtContra.getText().toString().trim());

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.POST, url1, json, response -> {
                    if( response != null )
                    {
                        try {
                            Log.d("vamoss ",response.getString("nombreUsuario") + " response"  );

                            SharedPreferences.Editor editor = preferences.edit();
                            editor.putString("nombreUsuario",  response.getString("nombreUsuario") );
                            editor.commit();



                            fragmentManagerA.beginTransaction()
                                    .replace(R.id.fragmentLoginOrOther, UpdateProductoFragment.class,null)
                                    .setReorderingAllowed(true)
                                    .commit();
                            edtUsuario.setText("");
                            edtContra.setText("");

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Snackbar.make(view, "Los datos ingresados son incorrectos", Snackbar.LENGTH_LONG).show();
                        edtContra.setText("");
                        edtUsuario.setText("");
                    }
                });
        // Access the RequestQueue through your singleton class.

        MySingleton.getInstance(this.context).addToRequestQueue(jsonObjectRequest);
    }


    public String calando()
    {



        return "exactament";
    }


    public void newMetod()
    {

        StringRequest stringRequest = new StringRequest
                (Request.Method.POST, null,new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                })
        {        protected Map<String,String> getparams()
        {
            Map<String,String> params = new HashMap<>();

            //  String json = g.toJson(usu);
            JSONObject json = new JSONObject();
            params.put("nombreUsuario", "admin");
            params.put("contrasenaUsuario", "admin123");
            Log.d(" errorrr ", "==============================================");
            Log.d(" errorrr ", json.toString());
            Log.d(" errorrr ", "==============================================");
            return params;
        }
        };


    }








}
