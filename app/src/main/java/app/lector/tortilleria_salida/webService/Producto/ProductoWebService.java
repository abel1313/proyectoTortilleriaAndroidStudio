package app.lector.tortilleria_salida.webService.Producto;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import app.lector.tortilleria_salida.R;
import app.lector.tortilleria_salida.model.ConfigRequeen;
import app.lector.tortilleria_salida.patronDiseno.MySingleton;

public class ProductoWebService
{
    private Context context;
    private View view;
    private EditText edtPedido;
    private TextView txtExistenciasCalor, txtNombreProductoCard, txtPrecioProductoCard;
    private LinearLayout linearLayoutEjemplo;

    public ProductoWebService(final Context context, View view)
    {
        this.context = context;
        this.view = view;
    }
    public ProductoWebService( )
    {
    }
    public void getProducto()
    {
        txtExistenciasCalor = this.view.findViewById(R.id.existenciasValor);
       // edtPedido = (view.findViewById(R.id.edtPedido));
        txtNombreProductoCard = (view.findViewById(R.id.txtNombreProducto));
        txtPrecioProductoCard = (view.findViewById(R.id.txtPrecioProductoCard));

    //    linearLayoutEjemplo = view.findViewById(R.id.idLayoutVenta);


        final String urlService =  new ConfigRequeen().toString();
        int idProducto = 1;
        final String url = urlService+"/producto/getProducto/"+idProducto;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, response -> {
                    try {

                        datosProducto( response );
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    //textView.setText("Response: " + response.toString());
                }, error -> {
                    errorData( error);
                    Toast.makeText( context ,error+" error", Toast.LENGTH_SHORT).show();
                    Log.d("Errorr", "------------------------------------------------------");
                    Log.d("Errorr", error.getMessage() + " " + url );
                    Log.d("Errorr", "------------------------------------------------------");
                });

        // Access the RequestQueue through your singleton class.
        MySingleton.getInstance(this.context).addToRequestQueue(jsonObjectRequest);

    }

    private void errorData( VolleyError error)
    {
    //    edtPedido = (view.findViewById(R.id.edtPedido));

    //    edtPedido.setText(error.getMessage() + "");
    }

    private void datosProducto( JSONObject jSONObject ) throws JSONException {
        if( jSONObject != null )
        {
            app.lector.tortilleria_salida.model.Producto p = new app.lector.tortilleria_salida.model.Producto();
            p.setId( jSONObject.getInt("id"));
            p.setNombreProducto( jSONObject.getString("nombreProducto"));
            p.setPrecioProducto( jSONObject.getDouble("precioProducto"));
            p.setDisponibilidadProducto( jSONObject.getDouble("disponibilidadProducto"));

            txtExistenciasCalor.setText( p.getDisponibilidadProducto() +" kg");
            txtNombreProductoCard.setText( p.getNombreProducto());
            txtPrecioProductoCard.setText( p.getPrecioProducto() + " kg");




//            LocalTime justoAhora = LocalTime.now();
//            Toast.makeText(context, "En este momento son las %d horas con %d minutos y %d segundos\n"+ justoAhora.getHour()+" "+
//                    justoAhora.getMinute() +" " +justoAhora.getSecond(), Toast.LENGTH_LONG).show();
        }

        // para ocultar un Layout
        //  linearLayoutEjemplo.setVisibility(LinearLayout.GONE);
        // es para mostrar un Layout
     //   linearLayoutEjemplo.setVisibility(LinearLayout.VISIBLE);

    }


}
