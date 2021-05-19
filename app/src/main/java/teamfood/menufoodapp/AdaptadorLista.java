package teamfood.menufoodapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import teamfood.menufoodapp.teamfood.menufoodapp.Item;

public class AdaptadorLista extends BaseAdapter {
    private Context context;
    private ArrayList<Item> list;


    public AdaptadorLista(Context context, ArrayList<Item> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Item item = (Item) getItem(position);

        convertView = LayoutInflater.from(context).inflate(R.layout.item,null);

        ImageView imgItem = convertView.findViewById(R.id.imgItem);
        TextView txtItem = convertView.findViewById(R.id.txtItem);

        imgItem.setImageResource(item.getImgFoto());
        txtItem.setText(item.getTexto());

        return convertView;
    }
}
