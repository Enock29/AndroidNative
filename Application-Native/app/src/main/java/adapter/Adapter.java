package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.exo.R;
import java.util.List;
import models.User;

public class Adapter extends BaseAdapter {
    private Context context;
    private List<User> userList;
    private LayoutInflater inflater;

    public Adapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
        this.inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public User getItem(int position) {
        return userList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = inflater.inflate(R.layout.adapter_layout, null);

        User current_user = getItem(position);
        String nom = current_user.getNom();
        String prenom = current_user.getPrenom();

        TextView nom_view = convertView.findViewById(R.id.txt_nom);
        TextView prenom_view = convertView.findViewById(R.id.txt_prenom);

        nom_view.setText(nom);
        prenom_view.setText(prenom);

        return  convertView;
    }
}
