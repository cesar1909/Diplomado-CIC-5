package mx.ipn.cic.fragmentsexample.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import mx.ipn.cic.fragmentsexample.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {

    private String cadena;

    public static SecondFragment newInstance(String cadena) {

        Bundle args = new Bundle();

        args.putString("CADENA", cadena);

        SecondFragment fragment = new SecondFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public SecondFragment() {
        // Required empty public constructor
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle arguments = this.getArguments();
        if(arguments != null){
            this.cadena = arguments.getString("CADENA");
        }

        Log.i("SecondFragment", "onCreate()");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.i("SecondFragment", "onCreateView()");

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second,
                container,
                false);
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Log.i("SecondFragment", "onViewCreated()");

        TextView tvString = view.findViewById(R.id.tvString);

        tvString.setText(this.cadena);

    }
}
