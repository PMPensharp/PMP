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

        dataList.add(new Data("성산풍력 #1", 1476.0,"풍력"));
        dataList.add(new Data("성산풍력 #2", 898.0,"풍력"));
        dataList.add(new Data("남제주태양광", 134.049,"태양력"));
        dataList.add(new Data("한림복합 #1", 370000.0,"기력"));
        dataList.add(new Data("한림복합 #2", 460000.0,"기력"));
        dataList.add(new Data("한림복합 #3", 470000.0,"기력"));
        dataList.add(new Data("남제주기력 #1", 350000.0,"기력"));
        dataList.add(new Data("남제주기력 #2", 444040.0,"기력"));
        dataList.add(new Data("하동 #1", 469914.0,"기력"));
        dataList.add(new Data("하동 #2", 496000.0,"기력"));
        dataList.add(new Data("하동 #3", 495174.7,"기력"));
        dataList.add(new Data("하동 #4", 485600.2,"기력"));
        dataList.add(new Data("하동 #5", 494051.2,"기력"));
        dataList.add(new Data("하동 #6", 481611.7,"기력"));
        dataList.add(new Data("하동 #7", 463872.0,"기력"));
        dataList.add(new Data("하동 #8", 449931.8,"기력"));
    }

}