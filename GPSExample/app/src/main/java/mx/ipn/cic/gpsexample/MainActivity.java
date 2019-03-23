package mx.ipn.cic.gpsexample;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int LOCATION_REQUEST_CODE = 999;
    private TextView tvLatitude;
    private TextView tvLongitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvLatitude = findViewById(R.id.tvLatitude);
        tvLongitude = findViewById(R.id.tvLongitude);

        this.initLocationManager();

    }

    private void initLocationManager() {

        //Preguntar por los permisos necesarios
        //  fineLocation y coarseLocation
        if (
                ContextCompat.checkSelfPermission(this,
                        Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED ||
                        ContextCompat.checkSelfPermission(this,
                                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
        ) {

            //Pedir permisios

            String[] permissions = {Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION};

            ActivityCompat.requestPermissions(this,
                    permissions,
                    LOCATION_REQUEST_CODE);


        } else {

            //Iniciar el LocationManager
            LocationManager locManager =
                    (LocationManager)
                            this.getSystemService(Context.LOCATION_SERVICE);

            //Iniciar las actualizaciones
            locManager.
                    requestLocationUpdates(
                            LocationManager.GPS_PROVIDER,
                            5000,
                            10f,
                            new LocationListener() {
                                @Override
                                public void onLocationChanged(Location location) {

                                    tvLatitude.setText("" + location.getLatitude());
                                    tvLongitude.setText("" + location.getLongitude());
                                    //location.getAltitude();

                                }

                                @Override
                                public void onStatusChanged(String provider, int status, Bundle bundle) {
                                    Log.i("TAG", "onStatusChanged");
                                }

                                @Override
                                public void onProviderEnabled(String provider) {
                                    Log.i("TAG", "onProviderEnabled");
                                }

                                @Override
                                public void onProviderDisabled(String provider) {
                                    Log.i("TAG", "onProviderDisabled");
                                }
                            });
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {

        boolean hasPermissions = true;
        if (requestCode == LOCATION_REQUEST_CODE) {

            for (int grantResult : grantResults) {

                if (grantResult == PackageManager.PERMISSION_DENIED) {
                    hasPermissions = false;
                    break;
                }

            }

            if (hasPermissions) {

                this.initLocationManager();

            } else {

                Toast.makeText(this,
                        "Acepta los permisos necio!",
                        Toast.LENGTH_LONG)
                        .show();

            }

        }

    }
}
