package mx.ipn.cic.masterdetailexample.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;

import mx.ipn.cic.masterdetailexample.R;
import mx.ipn.cic.masterdetailexample.adapters.BookListAdapter;
import mx.ipn.cic.masterdetailexample.model.BookModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class MasterFragment extends Fragment {

    private static String LISTENER_ARG = "LISTENER_ARG";
    private MasterFragment.MasterFragmentListener listener;

    public static MasterFragment newInstance(MasterFragment.MasterFragmentListener listener) {

        Bundle args = new Bundle();

        args.putSerializable(LISTENER_ARG, listener);

        MasterFragment fragment = new MasterFragment();
        fragment.setArguments(args);

        return fragment;

    }

    public void setListener(MasterFragment.MasterFragmentListener listener) {

        this.listener = listener;

        Bundle arguments = this.getArguments();
        if (arguments != null) {
            arguments.putSerializable(LISTENER_ARG, listener);
        }

    }

    public MasterFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle arguments = this.getArguments();
        if (arguments != null) {

            this.listener =
                    (MasterFragment.MasterFragmentListener) arguments.getSerializable(LISTENER_ARG);

        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_master, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ListView lvBooks = view.findViewById(R.id.lvBooks);

        BookListAdapter adapter = new BookListAdapter(BookModel.defaults(20));

        lvBooks.setAdapter(adapter);

        lvBooks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View cell,
                                    int position,
                                    long itemId) {

                Adapter theAdapter = adapterView.getAdapter();
                BookModel book = (BookModel) theAdapter.getItem(position);

                listener.onBookSelected(book);

            }
        });

    }

    public interface MasterFragmentListener extends Serializable {

        void onBookSelected(BookModel book);

    }

}
