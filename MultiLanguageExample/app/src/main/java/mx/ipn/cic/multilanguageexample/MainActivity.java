package mx.ipn.cic.multilanguageexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv1 = findViewById(R.id.tvText1);
        TextView tv2 = findViewById(R.id.tvText2);

        tv1.setText(R.string.cadena5);
        tv2.setText(R.string.cadenaDefault);

    }
}
