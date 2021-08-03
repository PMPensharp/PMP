package com.example.pmp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adapter3 extends RecyclerView.Adapter<ViewHolder> {

    private ArrayList<Data> myDataList = null;

    Adapter3(ArrayList<Data> dataList){
        myDataList=dataList;
    }

    @NonNull

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //전개자(Inflater)를 통해 얻은 참조 객체를 통해 뷰홀더 객체 생성
        View view = inflater.inflate(R.layout.item_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        //ViewHolder가 관리하는 View에 position에 해당하는 데이터 바인딩

        viewHolder.name.setText(myDataList.get(position).getDataName());
        double totalTasks = 5000.0;
        double powerTask=myDataList.get(position).getDataPower();
        double restTask=totalTasks-powerTask;

        double percentagePower = (powerTask*100.0)/totalTasks;
        double percentageRest = (restTask*100.0)/totalTasks;



        viewHolder.power.setVisibility(View.VISIBLE);
        viewHolder.rest.setVisibility(View.VISIBLE);


        viewHolder.power.setLayoutParams(new LinearLayout.LayoutParams((int) (percentagePower*5), 50));
        viewHolder.rest.setLayoutParams(new LinearLayout.LayoutParams((int) (percentageRest*5), 50));

    }

    @Override
    public int getItemCount() {
        return myDataList.size();
    }
}

class ViewHolder extends RecyclerView.ViewHolder{
    TextView name;
    View power;
    View rest;

    ViewHolder(View itemView)
    {
        super(itemView);

        name = itemView.findViewById(R.id.iv_name);
        power = itemView.findViewById(R.id.viewPower);
        rest = itemView.findViewById(R.id.viewRest);
    }
}


