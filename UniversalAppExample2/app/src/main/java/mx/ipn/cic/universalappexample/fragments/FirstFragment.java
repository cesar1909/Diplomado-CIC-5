package mx.ipn.cic.universalappexample.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import mx.ipn.cic.universalappexample.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

    public static FirstFragment newInstance() {

        Bundle args = new Bundle();

        FirstFragment fragment = new FirstFragment();
        fragment.setArguments(args);

        return fragment;
    }

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle arguments = this.getArguments();

        if (arguments != null) {

            //Configura las variables

        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btnNavega = view.findViewById(R.id.btnNavega);

        boolean isTablet = getResources().getBoolean(R.bool.isTablet);

        if (isTablet) {

            btnNavega.setVisibility(View.INVISIBLE);

        } else {

            btnNavega.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    SecondFragment second = SecondFragment.newInstance();

                    FragmentManager manager = getFragmentManager();

                    FragmentTransaction transaction =
                            manager.beginTransaction();

                    transaction.replace(R.id.container, second);

                    transaction.addToBackStack(null);

                    transaction.commit();

                }
            });

        }

    }
}
