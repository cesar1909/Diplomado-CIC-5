package mx.ipn.cic.listviewexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import mx.ipn.cic.listviewexample.model.BookModel;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();

        BookModel bookModel =
                (BookModel) intent.getSerializableExtra("BOOK");

        TextView tvId = findViewById(R.id.tvId);
        TextView tvTitle = findViewById(R.id.tvTitle);
        TextView tvAuthor = findViewById(R.id.tvAuthor);
        TextView tvPages = findViewById(R.id.tvPages);
        TextView tvEditorial = findViewById(R.id.tvEditorial);

        tvId.setText(String.valueOf(bookModel.getId()));
        tvTitle.setText(bookModel.getTitle());
        tvAuthor.setText(bookModel.getAuthor());
        tvPages.setText("" + bookModel.getPages() + " Páginas");
        tvEditorial.setText(bookModel.getEditorial());

    }
}
