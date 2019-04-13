package mx.ipn.cic.webserviceexample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import mx.ipn.cic.webserviceexample.fragments.UserListFragment;

public class MainActivity extends AppCompatActivity {

    private static String TAG = MainActivity.class.getName();

    public static MainActivity instance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        instance = this;

        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {

            Fragment userListFragment = UserListFragment.newInstance();

            FragmentManager fragmentManager = getSupportFragmentManager();

            FragmentTransaction transaction = fragmentManager.beginTransaction();

            transaction.add(R.id.container, userListFragment);

            transaction.commit();

        }

    }
}
