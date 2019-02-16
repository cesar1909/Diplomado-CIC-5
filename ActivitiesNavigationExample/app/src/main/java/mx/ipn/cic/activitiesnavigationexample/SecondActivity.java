package mx.ipn.cic.activitiesnavigationexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        //Recuperar extras

        Intent intent = getIntent();

        String cadena = intent.getStringExtra("CADENA");
        int entero = intent.getIntExtra("ENTERO", -1);
        float flotante = intent.getFloatExtra("flotante", -1f);

        String[] cadenas = intent.getStringArrayExtra("CADENAS");

        //Recuperar extras

        String title = String.format("Cadena <%s>, Entero <%d>, Float <%.2f>, Cadenas <%s>",
                cadena,
                entero,
                flotante,
                cadenas[0]);

        TextView tvTitle = findViewById(R.id.tvTitle);

        tvTitle.setText(title);

        Button btnBack = findViewById(R.id.btnAtras);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();

            }
        });
    }
}
