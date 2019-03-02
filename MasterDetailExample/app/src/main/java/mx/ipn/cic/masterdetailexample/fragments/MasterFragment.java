package mx.ipn.cic.masterdetailexample.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import mx.ipn.cic.masterdetailexample.R;
import mx.ipn.cic.masterdetailexample.adapters.BookListAdapter;
import mx.ipn.cic.masterdetailexample.model.BookModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class MasterFragment extends Fragment {


    public static MasterFragment newInstance() {

        Bundle args = new Bundle();

        MasterFragment fragment = new MasterFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public MasterFragment() {
        // Required empty public constructor
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

    }
}
