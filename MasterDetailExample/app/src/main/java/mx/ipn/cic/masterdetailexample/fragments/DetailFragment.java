package mx.ipn.cic.masterdetailexample.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import mx.ipn.cic.masterdetailexample.R;
import mx.ipn.cic.masterdetailexample.model.BookModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {//implements MasterFragment.MasterFragmentListener {

    private BookModel book;

    public static DetailFragment newInstance(BookModel book) {

        Bundle args = new Bundle();

        args.putSerializable("BOOK", book);

        DetailFragment fragment = new DetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    //Propiedades UI
    private TextView tvTitle;
    private TextView tvAuthor;
    private TextView tvEditorial;
    private TextView tvPages;

    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle arguments = this.getArguments();

        if (arguments != null) {
            this.book = (BookModel) arguments.getSerializable("BOOK");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.tvTitle = view.findViewById(R.id.tvTitle);
        this.tvAuthor = view.findViewById(R.id.tvAuthor);
        this.tvEditorial = view.findViewById(R.id.tvEditorial);
        this.tvPages = view.findViewById(R.id.tvPages);

        if (book != null) {
            this.tvTitle.setText(book.getTitle());
            this.tvAuthor.setText(book.getAuthor());
            this.tvEditorial.setText(book.getEditorial());
            this.tvPages.setText("" + book.getPages());
        }

    }

    //Métodos de MasterFragmentListener
//    @Override
//    public void onBookSelected(BookModel book) {
//
//        Log.i("DetailFragment", book.toString());
//
//        this.tvTitle.setText(book.getTitle());
//        this.tvAuthor.setText(book.getAuthor());
//        this.tvEditorial.setText(book.getEditorial());
//        this.tvPages.setText("" + book.getPages());
//
//    }
}
