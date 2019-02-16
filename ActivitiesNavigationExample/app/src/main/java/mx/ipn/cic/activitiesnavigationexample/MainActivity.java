package mx.ipn.cic.activitiesnavigationexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnNavegar = findViewById(R.id.btnNavegar);
        btnNavegar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,
                        SecondActivity.class);

                intent.putExtra("CADENA", "Hola Mundo!");
                intent.putExtra("ENTERO", 10);
                intent.putExtra("flotante", 10.5f);
                intent.putExtra("CADENAS", new String[]{"Hola", "Mundo"});

                startActivity(intent);

                finish();

            }

        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        //Consumos de WS / BD
    }

    @Override
    protected void onPause() {
        super.onPause();

        //Detener reproducciones de AV / Detener WS / Cerrar BD
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i("MainActivity", "MainActivity Destruido");
    }
}
