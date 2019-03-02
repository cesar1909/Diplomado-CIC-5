package mx.ipn.cic.fragmentsexample;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import mx.ipn.cic.fragmentsexample.fragments.BlankFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {

            // Generar una instancia del fragment a mostrar
            BlankFragment blank = new BlankFragment();


            // Obtener una referencia al FragmentManager
            //      (SupportFragmentManager)
            FragmentManager fragmentManager =
                    this.getSupportFragmentManager();

            //Iniciar una transacción
            FragmentTransaction transaction =
                    fragmentManager.beginTransaction();

            //Especificar la transacción
            transaction.add(R.id.container, blank);

            //Confirmar la transacción
            transaction.commit();

        }

    }
}
