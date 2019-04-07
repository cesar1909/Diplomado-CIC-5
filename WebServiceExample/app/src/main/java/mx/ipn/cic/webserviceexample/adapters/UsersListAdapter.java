package mx.ipn.cic.webserviceexample.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import mx.ipn.cic.webserviceexample.R;
import mx.ipn.cic.webserviceexample.model.UserModel;

public class UsersListAdapter extends BaseAdapter {

    private final List<UserModel> list;

    public UsersListAdapter(List<UserModel> list) {

        this.list = list;

    }

    @Override
    public int getCount() {

        return this.list.size();
    }

    @Override
    public UserModel getItem(int position) {
        return this.list.get(position);
    }

    @Override
    public long getItemId(int i) {
        return this.getItem(i).hashCode();
    }

    @Override
    public View getView(int position,
                        View view,
                        ViewGroup viewGroup) {

        if (view == null) {

            LayoutInflater inflater =
                    LayoutInflater.from(viewGroup.getContext());

            view = inflater.inflate(
                    R.layout.users_item_layout,
                    viewGroup,
                    false
            );

        }

        UserModel user = this.getItem(position);

        TextView tvName = view.findViewById(R.id.tvName);
        TextView tvLastname = view.findViewById(R.id.tvLastname);

        tvName.setText(user.getName());
        tvLastname.setText(user.getLastname());

        return view;
    }
}
