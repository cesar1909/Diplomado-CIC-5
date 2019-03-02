package mx.ipn.cic.masterdetailexample.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import mx.ipn.cic.masterdetailexample.R;
import mx.ipn.cic.masterdetailexample.exceptions.BussinesException;
import mx.ipn.cic.masterdetailexample.model.BookModel;

public class BookListAdapter extends BaseAdapter {

    private final List<BookModel> books;

    public BookListAdapter(List<BookModel> books)
            throws BussinesException {

        if (books != null) {

            this.books = books;

        } else {

            throw new BussinesException("Books no puede ser null");

        }

    }

    @Override
    public int getCount() {

        return this.books.size();

    }

    @Override
    public BookModel getItem(int position) {
        return this.books.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.getItem(position).hashCode();
    }

    @Override
    public View getView(int position,
                        View reusableView,
                        ViewGroup parent) {

        if (reusableView == null) {

            Context context = parent.getContext();

            LayoutInflater inflater = LayoutInflater.from(context);

            reusableView =
                    inflater.inflate(R.layout.book_list_item,
                            parent,
                            false);

        }

        TextView tvTitle =
                reusableView.findViewById(R.id.tvTitle);

        TextView tvAuthor =
                reusableView.findViewById(R.id.tvAuthor);

        BookModel book = this.getItem(position);

        tvTitle.setText(book.getTitle());
        tvAuthor.setText(book.getAuthor());

        return reusableView;

    }
}
