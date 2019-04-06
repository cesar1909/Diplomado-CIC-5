package mx.ipn.cic.googlemapsexample;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity {

    //private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();

        SupportMapFragment mapFragment = (SupportMapFragment) fragmentManager
                .findFragmentById(R.id.mapFragment);

        mapFragment.getMapAsync(new OnMapReadyCallback() {

            @Override
            public void onMapReady(GoogleMap googleMap) {

                //mMap = googleMap;

                LatLng cic = new LatLng(19.5031839, -99.1475951);

                MarkerOptions marker = new MarkerOptions();
                marker.position(cic);
                marker.title("Marker en CIC");

                googleMap.addMarker(marker);

                CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(cic, 16);

                googleMap.moveCamera(cameraUpdate);

            }
        });
    }
}
