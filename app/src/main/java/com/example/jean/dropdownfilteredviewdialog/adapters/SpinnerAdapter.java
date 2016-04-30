package com.example.jean.dropdownfilteredviewdialog.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.jean.dropdownfilteredviewdialog.models.Province;

import java.util.List;

/**
 * Created by Jean on 24/11/2015.
 */
public class SpinnerAdapter extends ArrayAdapter<Province> {

    List<Province> provinces;
    Context mContext;

    public SpinnerAdapter(Context context, int resource, List<Province> objects) {
        super(context, resource, objects);
        mContext = context;
        provinces = objects;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        TextView view = new TextView(mContext);
        view.setText(provinces.get(position).getName());
        view.setHeight(50);
        return view;
    }
}
