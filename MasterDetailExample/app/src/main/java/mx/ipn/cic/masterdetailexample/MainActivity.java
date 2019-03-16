package mx.ipn.cic.masterdetailexample;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import mx.ipn.cic.masterdetailexample.fragments.DetailFragment;
import mx.ipn.cic.masterdetailexample.fragments.MasterFragment;
import mx.ipn.cic.masterdetailexample.model.BookModel;

public class MainActivity extends AppCompatActivity implements MasterFragment.MasterFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {

//            DetailFragment detailFragment =
//                    DetailFragment.newInstance(null);

            MasterFragment masterFragment =
                    MasterFragment.newInstance(this);

            FragmentManager manager = getSupportFragmentManager();

            FragmentTransaction transaction = manager.beginTransaction();

            transaction.replace(R.id.master, masterFragment);
//            transaction.replace(R.id.detail, detailFragment);

            transaction.commit();

        }

    }

    @Override
    public void onBookSelected(BookModel book) {

        Log.i("MainActivity", book.toString());

        DetailFragment detailFragment =
                DetailFragment.newInstance(book);

        FragmentManager manager = getSupportFragmentManager();

        FragmentTransaction transaction = manager.beginTransaction();

        transaction.replace(R.id.detail, detailFragment);

        transaction.commit();

    }
}
