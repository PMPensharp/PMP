package com.example.pmp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class Fragment3 extends Fragment {

    private ArrayList<Data> dataList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v =inflater.inflate(R.layout.fragment_3, container, false);
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

        dataList.add(new Data("성산풍력", 3333.0));
        dataList.add(new Data("한경풍력", 2222.0));
        dataList.add(new Data("남제주태양광", 4444.0));
        dataList.add(new Data("한림복합", 4700.0));
        dataList.add(new Data("남제주기력#1", 3500.0));
        dataList.add(new Data("남제주기력#2", 4444.0));

    }

}