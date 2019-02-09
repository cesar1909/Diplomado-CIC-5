package mx.ipn.cic.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setContentView(R.layout.activity_main);

        final EditText etInput = this.findViewById(R.id.etInput);

        final TextView tvOutput = this.findViewById(R.id.tvTitle);

        Button btnProcesa = this.findViewById(R.id.btnProcess);

        tvOutput.setText("Hola Mundo!");

        etInput.setHint("Escribe algo:");
        etInput.setText("Texto inicio");

        btnProcesa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("MainActivity", "Presionó el botón!");

                Button btn = (Button) view;
                btn.setText("Ya fue presionado");

                tvOutput.setText(etInput.getText().toString());

                etInput.setText(null);

            }
        });

    }

    public void presionado(View view){

        Log.d("MainActivity", "Presionó el otro botón!");

    }
}
