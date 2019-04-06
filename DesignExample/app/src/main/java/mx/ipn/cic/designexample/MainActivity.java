package mx.ipn.cic.designexample;

import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final TextInputLayout tilInput = findViewById(R.id.tilInput);

        int[][] states = new int[][]{
                new int[]{android.R.attr.state_enabled}, // enabled
        };

        int[] colors = new int[]{
                Color.rgb(244, 244, 66)
        };

        ColorStateList myList = new ColorStateList(states, colors);
        tilInput.setErrorTextColor(myList);

        FloatingActionButton fabButton = findViewById(R.id.fabButton);

        fabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String cadena = tilInput.getEditText().getText().toString();

                if (cadena.length() < 5) {

                    tilInput.setError("Ingresa un dato válido");

                    Snackbar
                            .make(view, "Este es un Snackbar", Snackbar.LENGTH_INDEFINITE)
                            .setAction("Saludar!", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Toast.makeText(view.getContext(),
                                            "SALUDANDO",
                                            Toast.LENGTH_LONG).show();
                                }
                            })
                            .show();

                } else {
                    tilInput.setError("");
                }

            }
        });

        FloatingActionButton fabButton2 = findViewById(R.id.fabButton2);

        fabButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder =
                        new AlertDialog.Builder(view.getContext());

                builder.setTitle("Este es un título");
                builder.setMessage(R.string.message);

                builder.setNegativeButton(R.string.cancel_button,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                Log.i("MainActivity", "Negative!");

                            }
                        });

                builder.setNeutralButton(R.string.neutral_button,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                Log.i("MainActivity", "Neutral!");

                            }
                        });

                builder.setPositiveButton(R.string.yes_button,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                Log.i("MainActivity", "Positivo!");

                            }
                        });

                builder.setCancelable(false);

                AlertDialog alertDialog = builder.create();

                alertDialog.show();

            }
        });

    }
}
