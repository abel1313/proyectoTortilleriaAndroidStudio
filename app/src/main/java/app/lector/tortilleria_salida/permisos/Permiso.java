package app.lector.tortilleria_salida.permisos;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.IOException;

public class Permiso
{

    Activity activity;

    public Permiso( Activity activity)
    {
        this.activity = activity;
    }
    public void permisoAppLlamar(String numeroCel)
    {
        if (ContextCompat.checkSelfPermission(
                this.activity, Manifest.permission.CALL_PHONE ) ==
                PackageManager.PERMISSION_GRANTED) {

            Intent i = new Intent(Intent.ACTION_CALL, Uri.parse(numeroCel));

// Verify that the intent will resolve to an activity
            if (i.resolveActivity( this.activity.getPackageManager()) != null) {
                this.activity.startActivity(i);
            }

        } else if (ContextCompat.checkSelfPermission(
                this.activity, Manifest.permission.CALL_PHONE ) ==
                PackageManager.PERMISSION_DENIED ) {

            //  solicitarPermiso();
            showRequestPermissionDialog();


        } else {
            //  solicitarPermiso();
            showRequestPermissionDialog();
        }
    }

    private void showRequestPermissionDialog() {
        AlertDialog.Builder reqAlertDialog = new AlertDialog.Builder( this.activity );
        reqAlertDialog.setTitle("Permisos para llamar ");
        reqAlertDialog.setMessage("Es necesario este permiso");

        reqAlertDialog.setPositiveButton("conceder",
                (dialog, which) -> ActivityCompat.requestPermissions( this.activity,
                        new String[] {Manifest.permission.CALL_PHONE},
                        100));
        reqAlertDialog.setNegativeButton("denegar",
                (dialog, which) -> dialog.dismiss());

        reqAlertDialog.create().show();
    }


    public void irRedSocial( String url )
    {
        Uri uri = Uri.parse( url );
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        if (intent.resolveActivity(this.activity.getPackageManager()) != null) {
            this.activity.startActivity(intent);
        }
    }

}
