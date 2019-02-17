package mx.ipn.cic.listviewexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.List;

import mx.ipn.cic.listviewexample.adapters.BooksGridAdapter;
import mx.ipn.cic.listviewexample.model.BookModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<BookModel> elements = BookModel.defaults(20);

        //ListView lvBooks = findViewById(R.id.lvBooks);
        GridView gvBooks = findViewById(R.id.gvBooks);
        
        //BooksAdapter adapter = new BooksAdapter(elements);
        BooksGridAdapter adapter = new BooksGridAdapter(elements);

        gvBooks.setAdapter(adapter);

        gvBooks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view,
                                    int position,
                                    long id) {

                //El adaptador de la lista (BooksAdapter)
                Adapter theAdapter = adapterView.getAdapter();

                BookModel item = (BookModel) theAdapter.getItem(position);

                Toast.makeText(MainActivity.this,
                        "Item: " + item,
                        Toast.LENGTH_LONG).show();

            }
        });

    }
}
