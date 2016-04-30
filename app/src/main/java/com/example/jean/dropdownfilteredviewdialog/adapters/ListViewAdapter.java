package com.example.jean.dropdownfilteredviewdialog.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.jean.dropdownfilteredviewdialog.models.City;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jean on 24/11/2015.
 */
public class ListViewAdapter extends BaseAdapter implements Filterable {

    private LayoutInflater inflater;
    private List<City> cities;
    private List<City> filteredCities;
    private CityFilter cityFilter;
    private Context context;

    public ListViewAdapter(Context context, List<City> cities) {
        this.context = context;
        this.cities = cities;
        this.filteredCities = cities;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return cities.size();
    }

    @Override
    public City getItem(int position) {
        return cities.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View updateView;
        if (convertView == null) {
            updateView = inflater.inflate(android.R.layout.simple_list_item_1, null);
        } else {
            updateView = convertView;
        }
        City c = cities.get(position);
        TextView textView = (TextView) updateView.findViewById(android.R.id.text1);
        textView.setText(c.getName());
        return updateView;
    }

    @Override
    public Filter getFilter() {
        if (cityFilter == null) {
            cityFilter = new CityFilter();
        }
        return cityFilter;
    }

    private class CityFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            long provinceId = Long.parseLong(constraint.toString());
            FilterResults results = new FilterResults();

            if (provinceId > 0) {
                ArrayList<City> filterList = new ArrayList<>();
                for (City city : filteredCities) {
                    if (city.getProvinceId() == provinceId) {
                        filterList.add(city);
                    }
                }
                results.count = filterList.size();
                results.values = filterList;
            } else {
                // No filtering
                results.count = filteredCities.size();
                results.values = filteredCities;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            cities = (ArrayList<City>) results.values;
            notifyDataSetChanged();
        }
    }
}
