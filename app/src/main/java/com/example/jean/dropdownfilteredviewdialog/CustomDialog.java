package com.example.jean.dropdownfilteredviewdialog;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Filter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CustomDialog.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CustomDialog#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CustomDialog extends DialogFragment implements AdapterView.OnItemSelectedListener {


    private List<Province> provinces;
    private List<City> cities;

    private SpinnerAdapter spinnerAdapter;
    private ListViewAdapter listViewAdapter;

    private OnFragmentInteractionListener mListener;

    public CustomDialog() {
        // Empty constructor necessary when restoring the fragment
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment CustomDialog.
     */

    public static CustomDialog newInstance(String title) {
        CustomDialog fragment = new CustomDialog();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public void setProvinces(List<Province> provinces) {
        this.provinces = provinces;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Create a plain Dialog
        Dialog dialog = new Dialog(getActivity());
        if (getArguments() != null) {
            dialog.setTitle(getArguments().getString("title"));
        }
        // Set a custom content view
        dialog.setContentView(R.layout.fragment_detail);

        // Get references to the ListView and Spinner
        ListView listViewCities = (ListView) dialog.findViewById(R.id.listView);
        Spinner spinnerProvinces = (Spinner) dialog.findViewById(R.id.spinner);

        // Link the appropriate adapter to each view
        spinnerAdapter = new SpinnerAdapter(getActivity(),
                android.R.layout.simple_list_item_1, provinces);
        spinnerProvinces.setAdapter(spinnerAdapter);
        listViewAdapter = new ListViewAdapter(getActivity(), cities);
        listViewCities.setAdapter(listViewAdapter);

        // Register a callback function for when a item has been selected on a spinner
        spinnerProvinces.setOnItemSelectedListener(this);

        return dialog;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Province province = spinnerAdapter.getItem(position);
        listViewAdapter.getFilter().filter(Long.toString(province.getId()), new Filter.FilterListener() {
            @Override
            public void onFilterComplete(int count) {

            }
        });
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
