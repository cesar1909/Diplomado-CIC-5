package mx.ipn.cic.listviewexample.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import mx.ipn.cic.listviewexample.R;
import mx.ipn.cic.listviewexample.model.BookModel;

public class BooksGridAdapter extends BaseAdapter {

    private final List<BookModel> elements;

    public BooksGridAdapter(List<BookModel> elements) {

        this.elements = elements;

    }

    //Define el número total de elementos a mostrar en la UI
    @Override
    public int getCount() {

        return elements.size();
    }

    //Obtiene el elemento (modelo) a mostrar en un item de la UI
    @Override
    public BookModel getItem(int position) {

        return elements.get(position);
    }

    //Obtiene el haschode del elemento (modelo)
    //      a mostrar en un item de la UI
    @Override
    public long getItemId(int position) {

        return getItem(position).hashCode();
    }

    //Devuelve la vista a mostrar en la lista
    @Override
    public View getView(int position,
                        View reusableView,
                        ViewGroup container) {

        if (reusableView == null) {//Tengo que crear una vista nueva

            Context context = container.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);

            reusableView = inflater.inflate(
                    R.layout.grid_view_item,
                    container,
                    false);

        }

        TextView tvTitle = reusableView.findViewById(R.id.tvTitle);
        TextView tvPages = reusableView.findViewById(R.id.tvPages);

        //BookModel book = elements.get(position);
        BookModel book = this.getItem(position);

        tvTitle.setText(book.getTitle());
        tvPages.setText("" + book.getPages());

        return reusableView;

    }
}










