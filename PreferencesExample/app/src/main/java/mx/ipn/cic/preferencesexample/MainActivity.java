package mx.ipn.cic.preferencesexample;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static String MY_PREFERENCE = "MY_PREFERENCE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText etInput = findViewById(R.id.etInput);
        TextView tvPreference = findViewById(R.id.tvPreference);
        Switch swRemember = findViewById(R.id.swRemember);

        if (getPreference() == null) {
            swRemember.setChecked(false);
        } else {
            swRemember.setChecked(true);
            tvPreference.setText(getPreference());
        }

        swRemember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton,
                                         boolean isChecked) {

                if (isChecked) {
                    savePreference(etInput.getText().toString());
                } else {
                    deletePreference();
                }

            }
        });

        //swRemember.setChecked(getPreference() != null);

    }

    private void deletePreference() {

        SharedPreferences sp =
                this.getSharedPreferences(
                        "MyPreferences",
                        Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sp.edit();

        editor.remove(MY_PREFERENCE);

        editor.apply();

    }

    private void savePreference(String string) {

        SharedPreferences sp =
                this.getSharedPreferences(
                        "MyPreferences",
                        Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sp.edit();

        editor.putString(MY_PREFERENCE, string);

        editor.commit();

    }

    private String getPreference() {

        SharedPreferences sp =
                this.getSharedPreferences(
                        "MyPreferences",
                        Context.MODE_PRIVATE);

        String preferencia =
                sp.getString(MY_PREFERENCE, null);

        return preferencia;

    }
}
