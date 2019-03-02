package mx.ipn.cic.fragmentsexample.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import mx.ipn.cic.fragmentsexample.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {


    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_blank,
                container,
                false);

        Button button = view.findViewById(R.id.btnNavegar);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SecondFragment secondFragment = new SecondFragment();

                FragmentManager fragmentManager = getFragmentManager();

                FragmentTransaction transaction =
                        fragmentManager.beginTransaction();

                transaction.replace(R.id.container, secondFragment);

                transaction.addToBackStack(null);

                transaction.commit();

            }
        });

        return view;
    }

}
