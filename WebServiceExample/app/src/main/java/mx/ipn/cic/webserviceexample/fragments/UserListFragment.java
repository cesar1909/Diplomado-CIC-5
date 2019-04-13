package mx.ipn.cic.webserviceexample.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import mx.ipn.cic.webserviceexample.R;
import mx.ipn.cic.webserviceexample.adapters.UsersListAdapter;
import mx.ipn.cic.webserviceexample.model.UserModel;
import mx.ipn.cic.webserviceexample.networking.INetworkingListener;
import mx.ipn.cic.webserviceexample.networking.NetworkingManager;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserListFragment extends Fragment {

    private static String TAG = UserListFragment.class.getName();

    private ProgressBar pbLoader;
    private ListView lvUsers;

    public static UserListFragment newInstance() {

        Bundle args = new Bundle();

        UserListFragment fragment = new UserListFragment();
        fragment.setArguments(args);

        return fragment;
    }

    public UserListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {

        this.pbLoader = view.findViewById(R.id.pbLoader);
        this.lvUsers = view.findViewById(R.id.lvUsers);

    }


    @Override
    public void onStart() {

        super.onStart();

        //Se muestra el loader
        this.pbLoader.setVisibility(View.VISIBLE);

        NetworkingManager.getInstance().getAll(
                new INetworkingListener() {
                    @Override
                    public void onSuccess(Object result) {

                        //TODO Imprimir la respuesta
                        //      Mostrar en una ListView
                        Log.i(TAG, result.toString());

                        configListView((List<UserModel>) result);

                        //Se oculta el loader
                        pbLoader.setVisibility(View.GONE);

                    }

                    @Override
                    public void onError(String error) {

                        Toast.makeText(
                                getContext(),
                                error,
                                Toast.LENGTH_LONG)
                                .show();

                        //Se oculta el loader
                        pbLoader.setVisibility(View.GONE);
                    }
                }
        );

    }

    private void configListView(List<UserModel> users) {

        final UsersListAdapter adapter = new UsersListAdapter(users);

        this.lvUsers.setAdapter(adapter);

        this.lvUsers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                UserModel user = (UserModel) adapterView.getAdapter().getItem(position);

                Fragment detail = UserDetailFragment.newInstance(user);

                FragmentManager fragmentManager = getFragmentManager();

                FragmentTransaction transaction = fragmentManager.beginTransaction();

                transaction.replace(R.id.container, detail);

                transaction.addToBackStack(null);

                transaction.commit();

            }
        });

    }
}
