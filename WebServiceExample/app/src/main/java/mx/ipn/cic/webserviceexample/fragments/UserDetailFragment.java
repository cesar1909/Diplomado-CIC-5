package mx.ipn.cic.webserviceexample.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import mx.ipn.cic.webserviceexample.R;
import mx.ipn.cic.webserviceexample.model.UserModel;
import mx.ipn.cic.webserviceexample.networking.INetworkingListener;
import mx.ipn.cic.webserviceexample.networking.NetworkingManager;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserDetailFragment extends Fragment {

    private static String USER_ARG = "USER_ARG";
    private UserModel user;

    public static UserDetailFragment newInstance(UserModel user) {

        Bundle args = new Bundle();

        args.putSerializable(USER_ARG, user);

        UserDetailFragment fragment = new UserDetailFragment();
        fragment.setArguments(args);

        return fragment;
    }

    public UserDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = this.getArguments();
        if (args != null) {
            this.user = (UserModel) args.getSerializable(USER_ARG);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final EditText etName = view.findViewById(R.id.etName);
        final EditText etLastname = view.findViewById(R.id.etLastname);
        final EditText etAge = view.findViewById(R.id.etAge);
        final EditText etAddress = view.findViewById(R.id.etAddress);

        etName.setText(this.user.getName());
        etLastname.setText(this.user.getLastname());
        etAge.setText("" + this.user.getAge());
        etAddress.setText(this.user.getMainAddress());

        Button btnUpdate = view.findViewById(R.id.btnUpdate);
        Button btnDelete = view.findViewById(R.id.btnDelete);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UserModel userToUpdate = new UserModel();

                userToUpdate.setId(user.getId());
                userToUpdate.setName(etName.getText().toString());
                userToUpdate.setLastname(etLastname.getText().toString());
                userToUpdate.setMainAddress(etAddress.getText().toString());

                Integer age = Integer.parseInt(etAge.getText().toString());
                userToUpdate.setAge(age);

                NetworkingManager.getInstance()
                        .update(userToUpdate,
                                new INetworkingListener() {
                                    @Override
                                    public void onSuccess(Object result) {

                                        Toast.makeText(getContext(),
                                                result.toString(),
                                                Toast.LENGTH_LONG).show();

                                    }

                                    @Override
                                    public void onError(String error) {

                                        Toast.makeText(getContext(),
                                                error,
                                                Toast.LENGTH_LONG).show();

                                    }
                                });

            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NetworkingManager.getInstance().delete(
                        user,
                        new INetworkingListener() {
                            @Override
                            public void onSuccess(Object result) {

                                Toast.makeText(getContext(),
                                        "Usuario eliminado exitosamente",
                                        Toast.LENGTH_LONG)
                                        .show();

                                getFragmentManager().popBackStack();

                            }

                            @Override
                            public void onError(String error) {

                                Toast.makeText(getContext(),
                                        error,
                                        Toast.LENGTH_LONG)
                                        .show();

                            }
                        });

            }
        });

    }
}
