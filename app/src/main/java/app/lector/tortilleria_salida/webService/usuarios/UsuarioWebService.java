package app.lector.tortilleria_salida.webService.usuarios;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import app.lector.tortilleria_salida.model.ConfigRequeen;
import app.lector.tortilleria_salida.patronDiseno.MySingleton;

public class UsuarioWebService
{

    private Context context;
    public UsuarioWebService( final Context context)
    {
    this.context = context;
    }
    public void getUsuarios()
    {
        final String urlService =  new ConfigRequeen().toString();

       final String url = urlService+"/tortilleria/usuarios/add";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        //textView.setText("Response: " + response.toString());
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


}
