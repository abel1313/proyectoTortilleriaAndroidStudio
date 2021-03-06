package app.lector.tortilleria_salida;

import android.content.ClipData;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import app.lector.tortilleria_salida.databinding.ActivityMainBinding;
import app.lector.tortilleria_salida.event.IPasarDatos;
import app.lector.tortilleria_salida.permisos.Permiso;

public class MainActivity extends AppCompatActivity implements IPasarDatos {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    private Permiso permiso;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);



        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        permiso = new Permiso(  this );


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    @Override
    public void irFacebook(String urlFacebook) {

        permiso.irRedSocial( urlFacebook );
//        Uri uri = Uri.parse( urlFacebook );
//        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intent);
//        }


    }

    @Override
    public void irTwitter(String urlTwitter)
    {
        permiso.irRedSocial( urlTwitter );

    }

    @Override
    public void irGoogle(String urlGoogle) {
        Toast.makeText(this, "Bienvenido,  esta opci??n no realiza ningua acci??n", Toast.LENGTH_LONG).show();
    }

    @Override
    public void hacerLlamada(String numeroCel )
    {
        permiso.permisoAppLlamar(numeroCel);

    }

    @Override
    public void checandoSesion() {

    }


//    @Override
//    protected void onStop() {
//        super.onStop();
//      //  Toast.makeText(this, " stop ", Toast.LENGTH_LONG).show();
//
//        SharedPreferences settings, settings2;
//        settings = getSharedPreferences("trece", Context.MODE_PRIVATE);
//        settings.edit().clear().commit();
//
//        settings2 = getSharedPreferences("treceSession", Context.MODE_PRIVATE);
//        settings2.edit().clear().commit();
//
//        Toast.makeText(this, " delete ", Toast.LENGTH_LONG).show();
//
//
//    }

//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        finish();
//        SharedPreferences settings = getSharedPreferences("trece", Context.MODE_PRIVATE);
//        settings.edit().clear().commit();
//        Toast.makeText(this, " delete ", Toast.LENGTH_LONG).show();
//
//    }

}