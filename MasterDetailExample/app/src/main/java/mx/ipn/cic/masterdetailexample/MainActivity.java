package mx.ipn.cic.masterdetailexample;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import mx.ipn.cic.masterdetailexample.fragments.DetailFragment;
import mx.ipn.cic.masterdetailexample.fragments.MasterFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {

            MasterFragment masterFragment = MasterFragment.newInstance();
            DetailFragment detailFragment = DetailFragment.newInstance();

            FragmentManager manager = getSupportFragmentManager();

            FragmentTransaction transaction = manager.beginTransaction();

            transaction.add(R.id.master, masterFragment);
            transaction.add(R.id.detail, detailFragment);

            transaction.commit();

        }

    }
}
