package mx.ipn.cic.webserviceexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import mx.ipn.cic.webserviceexample.networking.INetworkingListener;
import mx.ipn.cic.webserviceexample.networking.NetworkingManager;

public class MainActivity extends AppCompatActivity {

    private static String TAG = MainActivity.class.getName();

    public static MainActivity instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        instance = this;

        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        NetworkingManager.getInstance().getAll(
                new INetworkingListener() {
                    @Override
                    public void onSuccess(Object result) {

                        //TODO Imprimir la respuesta
                        //      Mostrar en una ListView
                        Log.i(TAG, result.toString());

                    }

                    @Override
                    public void onError(String error) {

                        Toast.makeText(
                                MainActivity.this,
                                error,
                                Toast.LENGTH_LONG)
                                .show();

                    }
                }
        );

    }
}
