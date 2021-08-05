package com.example.pmp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;


public class Fragment3 extends Fragment {

    private ArrayList<Data> dataList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_3, container, false);

        Spinner spinner = (Spinner) v.findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getActivity(),
                R.array.spinnerArray, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);


        this.InitializeData();
        RecyclerView recyclerView = (RecyclerView)v.findViewById(R.id.rv3);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(manager); // LayoutManager 등록
        recyclerView.setAdapter(new Adapter3(dataList));




        return v;
    }

    public void InitializeData()
    {
        dataList = new ArrayList<>();

        dataList.add(new Data("성산풍력", 3333.0,"풍력"));
        dataList.add(new Data("한경풍력", 2222.0,"풍력"));
        dataList.add(new Data("남제주태양광", 4444.0,"태양력"));
        dataList.add(new Data("한림복합", 4700.0,"기력"));
        dataList.add(new Data("남제주기력#1", 3500.0,"기력"));
        dataList.add(new Data("남제주기력#2", 4444.0,"기력"));

    }

}