package com.example.pmp;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;

public class Adapter3 extends RecyclerView.Adapter<Adapter3.ViewHolder  > {

    private ArrayList<Data> myDataList = null;

    private SparseBooleanArray selectedItems = new SparseBooleanArray();

    private int prePosition=-1;

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

        if(getColor(myDataList.get(position).getDataColor())==1){
            viewHolder.view.setBackgroundColor(Color.parseColor("#FFB900"));
            viewHolder.power.setBackgroundColor(Color.parseColor("#FFB900"));
            int[] colorArray=new int[] {Color.parseColor("#515151"),Color.parseColor("#FFB900")};
            viewHolder.buildChart((int) (percentageRest),(int) (percentagePower),powerTask,colorArray);
        }
        else if(getColor(myDataList.get(position).getDataColor())==2){
            viewHolder.view.setBackgroundColor(Color.parseColor("#00C2FF"));
            viewHolder.power.setBackgroundColor(Color.parseColor("#00C2FF"));
            int[] colorArray=new int[] {Color.parseColor("#515151"),Color.parseColor("#00C2FF")};
            viewHolder.buildChart((int) (percentageRest),(int) (percentagePower),powerTask,colorArray);
        }
        else if(getColor(myDataList.get(position).getDataColor())==3){
            viewHolder.view.setBackgroundColor(Color.parseColor("#FF4D00"));
            viewHolder.power.setBackgroundColor(Color.parseColor("#FF4D00"));
            int[] colorArray=new int[] {Color.parseColor("#515151"),Color.parseColor("#FF4D00")};
            viewHolder.buildChart((int) (percentageRest),(int) (percentagePower),powerTask,colorArray);
        }


        viewHolder.power.setVisibility(View.VISIBLE);
        viewHolder.rest.setVisibility(View.VISIBLE);
        viewHolder.view.setVisibility(View.VISIBLE);


        //그래프
        viewHolder.power.setLayoutParams(new LinearLayout.LayoutParams((int) (percentagePower*10),50));
        viewHolder.rest.setLayoutParams(new LinearLayout.LayoutParams( (int) (percentageRest*10),50));

        viewHolder.changeVisibility(selectedItems.get(position));

        //액션 이펙트
        viewHolder.setOnViewHolderItemClickListener(new OnViewHolderItemClickListener() {
            @Override
            public void onViewHolderItemClick() {
                if(selectedItems.get(position)){
                    // 펼쳐진 Item을 클릭 시
                    selectedItems.delete(position);
                } else {
                    // 직전의 클릭됐던 Item의 클릭상태를 지움
                    selectedItems.delete(prePosition);
                    // 클릭한 Item의 position을 저장
                    selectedItems.put(position, true);
                }
                // 해당 포지션의 변화를 알림
                if (prePosition != -1) notifyItemChanged(prePosition);
                notifyItemChanged(position);
                // 클릭된 position 저장
                prePosition = position;
            }
        }

        );

    }




    public int getColor(String a){
        if(a.equals("기력")){
            return 1;
        }
        else if(a.equals("풍력")){
            return 2;
        }
        else if(a.equals("태양력")){
            return 3;
        }
        else{
            return 4;
        }
    }
    @Override
    public int getItemCount() {
        return myDataList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        View power;
        View rest;
        View view;
        LinearLayout hiddenlayout;
        CardView card;
        PieChart pieChart;

        OnViewHolderItemClickListener onViewHolderItemClickListener;

        ViewHolder(View itemView)
        {
            super(itemView);

            view= itemView.findViewById(R.id.view);
            name = itemView.findViewById(R.id.iv_name);
            power = itemView.findViewById(R.id.viewPower);
            rest = itemView.findViewById(R.id.viewRest);
            card=itemView.findViewById(R.id.card);
            pieChart=itemView.findViewById(R.id.picChart);

            hiddenlayout=itemView.findViewById(R.id.hiddenlayout);

            card.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    onViewHolderItemClickListener.onViewHolderItemClick();
                }
            });


        }

        private void changeVisibility(final boolean isExpanded) {
            // ValueAnimator.ofInt(int... values)는 View가 변할 값을 지정, 인자는 int 배열
            ValueAnimator va = isExpanded ? ValueAnimator.ofInt(0, 600) : ValueAnimator.ofInt(600, 0);
            // Animation이 실행되는 시간, n/1000초
            va.setDuration(500);
            va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    // imageView의 높이 변경
                    //pieChart.getLayoutParams().height = (int) animation.getAnimatedValue();
                    pieChart.requestLayout();
                    // imageView가 실제로 사라지게하는 부분
                    pieChart.setVisibility(View.VISIBLE);
                    hiddenlayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
                }
            });
            // Animation start
            va.start();
        }

        public void buildChart(int a,int b,double c, int[] colorArray){


            PieDataSet pieDataSet = new PieDataSet(data1(a,b),"현재예측량");
            pieDataSet.setColors(colorArray);
            PieData pieData =new PieData(pieDataSet);
            pieChart.setDrawEntryLabels(false);
            pieChart.setUsePercentValues(false);
            pieData.setValueTextSize(10);
            pieChart.setCenterText(b+"%");
            pieChart.setCenterTextSize(25);
            pieChart.setHoleRadius(30);
            pieChart.setData(pieData);
            pieChart.invalidate();
            pieChart.setHoleRadius(75);
            pieChart.animateXY(1000,1000);


        }

        private ArrayList<PieEntry> data1(int a,int b){
            ArrayList<PieEntry> datavalue= new ArrayList<>();

            datavalue.add(new PieEntry(a,"나머지"));
            datavalue.add(new PieEntry(b,"현재"));

            return datavalue;
        }

        public void setOnViewHolderItemClickListener(OnViewHolderItemClickListener onViewHolderItemClickListener) {
            this.onViewHolderItemClickListener = onViewHolderItemClickListener;
        }
    }
}



