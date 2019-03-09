package mx.ipn.cic.universalappexample;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import mx.ipn.cic.universalappexample.fragments.FirstFragment;
import mx.ipn.cic.universalappexample.fragments.SecondFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {

            FragmentManager manager = this.getSupportFragmentManager();

            FragmentTransaction transaction = manager.beginTransaction();

            boolean isTablet = false;

            // Evaluar si es tablet o smartphone
            if (this.findViewById(R.id.detail) != null) {
                //Estamos en tablet

                SecondFragment secondFragment = SecondFragment.newInstance();

                transaction.add(R.id.detail, secondFragment);

                isTablet = true;

            }

            FirstFragment firstFragment = FirstFragment.newInstance(isTablet);

            transaction.add(R.id.container, firstFragment);

            transaction.commit();

        }
    }
}
