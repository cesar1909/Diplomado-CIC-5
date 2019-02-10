package mx.ipn.cic.controlsexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvTitle = findViewById(R.id.tvTitle);
        tvTitle.setText("Hola Mundo!");

        tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                        "TextView Presionado",
                        Toast.LENGTH_LONG)
                        .show();
            }
        });

        EditText etInput = findViewById(R.id.etInput);
        etInput.setHint("Este es otro placeholder");

        Button btnBoton = findViewById(R.id.btnBoton);
        btnBoton.setText("Presioname!");

        btnBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),
                        "Hola Mundo!",
                        Toast.LENGTH_LONG)
                        .show();

            }
        });


        ImageView iImage = findViewById(R.id.ivImage);
        iImage.setImageResource(R.drawable.video);

        ImageButton ibBoton = findViewById(R.id.ibBoton);
        ibBoton.setImageResource(R.drawable.flecha_izq);

        ibBoton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                Toast.makeText(getApplicationContext(),
                        "Click Sostenido",
                        Toast.LENGTH_LONG)
                        .show();

                return false;
            }
        });

        CheckBox checkBox = findViewById(R.id.cbCheckBox);
        checkBox.setChecked(false);
        checkBox.isChecked();

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {

                if (checked) {

                    Toast.makeText(getApplicationContext(),
                            "ENCENDIDO",
                            Toast.LENGTH_LONG)
                            .show();

                } else {

                    Toast.makeText(getApplicationContext(),
                            "APAGADO",
                            Toast.LENGTH_LONG)
                            .show();

                }


            }
        });

        RadioGroup radioGroup = findViewById(R.id.rgRadios);
        radioGroup.getCheckedRadioButtonId();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {

                String mensaje = "";
                switch (id) {
                    case R.id.rbUno:
                        mensaje = "UNO";
                        break;
                    case R.id.rbDos:
                        mensaje = "DOS";
                        break;
                    case R.id.rbTres:
                        mensaje = "TRES";
                        break;
                }

                Toast.makeText(getApplicationContext(),
                        mensaje,
                        Toast.LENGTH_LONG)
                        .show();

            }
        });

    }
}




