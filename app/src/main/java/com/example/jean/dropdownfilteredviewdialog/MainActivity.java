package com.example.jean.dropdownfilteredviewdialog;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              DetailFragment fragment =  DetailFragment.newInstance("List of Cities");
                fragment.setCities(loadCities());
                fragment.setProvinces(loadProvinces());
                fragment.show(getFragmentManager(), "Popup");
            }
        });
    }

    private List<Province> loadProvinces() {
        List<Province> list = new ArrayList<>();
        list.add(new Province(0, "All Provinces"));
        list.add(new Province(1, "West Cape"));
        list.add(new Province(2, "North Cape"));
        list.add(new Province(3, "East Cape"));
        list.add(new Province(4, "Free State"));
        list.add(new Province(5, "North West"));
        list.add(new Province(6, "Gauteng"));
        list.add(new Province(7, "Natal"));
        list.add(new Province(8, "Mpumalanga"));
        list.add(new Province(9, "Limpopo"));

        return list;
    }

    private List<City> loadCities() {
        List<City> list = new ArrayList<>();
        long cnt = 1;
        // West Cape
        list.add(new City(cnt++, "Cape Town", 1));
        list.add(new City(cnt++, "Bellville", 1));
        list.add(new City(cnt++, "George", 1));
        list.add(new City(cnt++, "Stellenbosch", 1));

        // North Cape
        list.add(new City(cnt++, "Upington", 2));
        list.add(new City(cnt++, "Kimberley", 2));
        list.add(new City(cnt++, "Sprinbok", 2));

        // East Cape
        list.add(new City(cnt++, "Port Elizabeth", 3));
        list.add(new City(cnt++, "East London", 3));
        list.add(new City(cnt++, "Mthatha", 3));

        // Free State
        list.add(new City(cnt++, "Bloemfontein", 4));
        list.add(new City(cnt++, "Zastron", 4));
        list.add(new City(cnt++, "Harrismith", 4));

        // North West
        list.add(new City(cnt++, "Rustenburg", 5));
        list.add(new City(cnt++, "Mafikeng", 5));
        list.add(new City(cnt++, "Potchefstroom", 5));

        // Gauteng
        list.add(new City(cnt++, "Johannesburg", 6));
        list.add(new City(cnt++, "Pretoria", 6));
        list.add(new City(cnt++, "Randburg", 6));

        // Natal
        list.add(new City(cnt++, "Durban", 7));
        list.add(new City(cnt++, "Pietermaritzburg", 7));
        list.add(new City(cnt++, "Vryheid", 7));

        // Mpumalanga
        list.add(new City(cnt++, "Nelspruit", 8));
        list.add(new City(cnt++, "Ermelo", 8));
        list.add(new City(cnt++, "Middelburg", 8));

        // Limpopo
        list.add(new City(cnt++, "Polokwane", 9));
        list.add(new City(cnt++, "Phalaborwa",9));
        list.add(new City(cnt++, "Ellisras", 9));
        return list;
    }


}
