package app.lector.tortilleria_salida;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
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
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.nav_productoshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController
                (this, R.id.nav_host_fragment_content_main);
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
        NavController navController = Navigation.findNavController
                (this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    @Override
    public void irFacebook(String urlFacebook) {permiso.irRedSocial( urlFacebook );}

    @Override
    public void irTwitter(String urlTwitter) {permiso.irRedSocial( urlTwitter );}

    @Override
    public void irGoogle(String urlGoogle) {

        Toast.makeText(this, "Bienvenido, este opcion no reliza ninguna acción", Toast.LENGTH_LONG).show();


    }
    @Override
    public void hacerLlamada(String numeroCel ) { permiso.permisoAppLlamar(numeroCel); }
}