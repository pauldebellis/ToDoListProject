package adi.todolistapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by klaus_000 on 8/17/2016.
 */
public class CustomBaseAdapter extends BaseAdapter {

    private ArrayList <Encounters> listList;
    private Context context;

    public CustomBaseAdapter(ArrayList<Encounters> listList, Context context) {
        this.listList = listList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

//        View row = inflater.inflate;


        return null;
    }
}
