package app.lector.tortilleria_salida.service;

import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.JobIntentService;

import org.jetbrains.annotations.NotNull;


public class ServiceEjemplo extends JobIntentService {
    public ServiceEjemplo() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {

        super.onCreate();
        Toast.makeText(this, "create service starting se creo 2", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onHandleWork(@NonNull @NotNull Intent intent) {
        Toast.makeText(this, "onHandleWork service", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int onStartCommand(@Nullable @org.jetbrains.annotations.Nullable Intent intent, int flags, int startId) {
        Toast.makeText(this, "onStartCommand service starting "+ intent, Toast.LENGTH_SHORT).show();

        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public boolean stopService(Intent name) {
        Toast.makeText(this, "service stop", Toast.LENGTH_SHORT).show();
        return super.stopService(name);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "service destroy", Toast.LENGTH_SHORT).show();
    }
}