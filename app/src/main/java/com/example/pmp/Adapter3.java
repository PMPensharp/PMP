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

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

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


        double powerTask=myDataList.get(position).getDataPower();


        if(getColor(myDataList.get(position).getDataColor())==1){//기력
            double totalTasks = 500000.0;
            double restTask=totalTasks-powerTask;

            double percentagePower = (powerTask*100.0)/totalTasks;
            double percentageRest = (restTask*100.0)/totalTasks;
            viewHolder.view.setBackgroundColor(Color.parseColor("#FFB900"));
            viewHolder.power.setBackgroundColor(Color.parseColor("#FFB900"));
            int[] colorArray=new int[] {Color.parseColor("#515151"),Color.parseColor("#FFB900")};
            viewHolder.buildChart2((int) (percentageRest),(int) (percentagePower),powerTask,colorArray);
            viewHolder.horizonBarChart();
            viewHolder.horizonBarChart2();

            viewHolder.power.setVisibility(View.VISIBLE);
            viewHolder.rest.setVisibility(View.VISIBLE);
            viewHolder.view.setVisibility(View.VISIBLE);


            //그래프
            viewHolder.power.setLayoutParams(new LinearLayout.LayoutParams((int) (percentagePower*10),50));
            viewHolder.rest.setLayoutParams(new LinearLayout.LayoutParams( (int) (percentageRest*10),50));
        }
        else if(getColor(myDataList.get(position).getDataColor())==2){//풍력
            double totalTasks = 1140.0;
            double restTask=totalTasks-powerTask;

            double percentagePower = (powerTask*100.0)/totalTasks;
            double percentageRest = (restTask*100.0)/totalTasks;
            viewHolder.view.setBackgroundColor(Color.parseColor("#00C2FF"));
            viewHolder.power.setBackgroundColor(Color.parseColor("#00C2FF"));
            int[] colorArray=new int[] {Color.parseColor("#515151"),Color.parseColor("#00C2FF")};
            viewHolder.buildChart((int) (percentageRest),(int) (percentagePower),powerTask,colorArray);
            viewHolder.buildLineChart();

            viewHolder.power.setVisibility(View.VISIBLE);
            viewHolder.rest.setVisibility(View.VISIBLE);
            viewHolder.view.setVisibility(View.VISIBLE);


            //그래프
            viewHolder.power.setLayoutParams(new LinearLayout.LayoutParams((int) (percentagePower*10),50));
            viewHolder.rest.setLayoutParams(new LinearLayout.LayoutParams((int) (percentageRest*10),50));
        }
        else if(getColor(myDataList.get(position).getDataColor())==3){//태양력

            viewHolder.backimage.setImageResource(R.drawable.redfield);
            viewHolder.wind.setImageResource(R.drawable.rain);

            viewHolder.text1.setText("온도");
            viewHolder.text2.setText("29℃");
            viewHolder.text3.setText("강수확률");
            viewHolder.text4.setText("20%");

            double totalTasks = 200.0;
            double restTask=totalTasks-powerTask;

            double percentagePower = (powerTask*100.0)/totalTasks;
            double percentageRest = (restTask*100.0)/totalTasks;

            viewHolder.view.setBackgroundColor(Color.parseColor("#FF4D00"));
            viewHolder.power.setBackgroundColor(Color.parseColor("#FF4D00"));
            int[] colorArray=new int[] {Color.parseColor("#515151"),Color.parseColor("#FF4D00")};
            viewHolder.buildChart((int) (percentageRest),(int) (percentagePower),powerTask,colorArray);
            viewHolder.buildLineChart2();

            viewHolder.power.setVisibility(View.VISIBLE);
            viewHolder.rest.setVisibility(View.VISIBLE);
            viewHolder.view.setVisibility(View.VISIBLE);


            //그래프
            viewHolder.power.setLayoutParams(new LinearLayout.LayoutParams((int) (percentagePower*10),50));
            viewHolder.rest.setLayoutParams(new LinearLayout.LayoutParams( (int) (percentageRest*10),50));
        }




        if(getColor(myDataList.get(position).getDataColor())==1){
            viewHolder.changeVisibility2(selectedItems.get(position));
        }
        else {
            viewHolder.changeVisibility(selectedItems.get(position));
        }
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
        LinearLayout hiddenlayout,hiddenlayout2;
        CardView card;
        PieChart pieChart,pieChart2;
        LineChart lineChart;
        HorizontalBarChart barchart,barchart_p;

        ImageView backimage,wind;

        TextView text1,text2,text3,text4;

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
            lineChart=itemView.findViewById(R.id.lineChart);

            hiddenlayout=itemView.findViewById(R.id.hiddenlayout);

            pieChart2=itemView.findViewById(R.id.picChart2);
            barchart=itemView.findViewById(R.id.barchart);
            hiddenlayout2=itemView.findViewById(R.id.hiddenlayout2);

            barchart_p=itemView.findViewById(R.id.barchart_p);

            backimage=itemView.findViewById(R.id.backimage);
            wind =itemView.findViewById(R.id.wind);

            text1=itemView.findViewById(R.id.text1);
            text2=itemView.findViewById(R.id.text2);
            text3=itemView.findViewById(R.id.text3);
            text4=itemView.findViewById(R.id.text4);

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

                    hiddenlayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
                    hiddenlayout2.setVisibility(View.GONE);

                }
            });
            // Animation start
            va.start();
        }

        private void changeVisibility2(final boolean isExpanded) {
            // ValueAnimator.ofInt(int... values)는 View가 변할 값을 지정, 인자는 int 배열
            ValueAnimator va = isExpanded ? ValueAnimator.ofInt(0, 600) : ValueAnimator.ofInt(600, 0);
            // Animation이 실행되는 시간, n/1000초
            va.setDuration(500);
            va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    // imageView의 높이 변경
                    //pieChart.getLayoutParams().height = (int) animation.getAnimatedValue();

                    hiddenlayout.setVisibility(View.GONE);
                    hiddenlayout2.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
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
            pieChart.setCenterText(c+"");
            pieChart.setCenterTextSize(25);
            pieChart.setHoleRadius(30);
            pieChart.setData(pieData);
            pieChart.invalidate();
            pieChart.setHoleRadius(75);
            pieChart.animateXY(1000,1000);


        }

        public void buildChart2(int a, int b, double c,int[] colorArray){
            PieDataSet pieDataSet = new PieDataSet(data1(a,b),"현재예측량");
            pieDataSet.setColors(colorArray);
            PieData pieData =new PieData(pieDataSet);
            pieChart2.setDrawEntryLabels(false);
            pieChart2.setUsePercentValues(false);
            pieData.setValueTextSize(10);
            pieChart2.setCenterText(c+"");
            pieChart2.setCenterTextSize(25);
            pieChart2.setHoleRadius(30);
            pieChart2.setData(pieData);
            pieChart2.invalidate();
            pieChart2.setHoleRadius(75);
            pieChart2.animateXY(1000,1000);
        }

        public void buildLineChart(){
            ArrayList<Entry> values1 = new ArrayList<>();
            ArrayList<Entry> values2=new ArrayList<>();

            values1.add(new Entry(1,1565));
            values1.add(new Entry(2,1597));
            values1.add(new Entry(3,815));
            values1.add(new Entry(4,2256));
            values1.add(new Entry(5,665));
            values1.add(new Entry(6,719));
            values1.add(new Entry(7,1020));
            values1.add(new Entry(8,807));
            values1.add(new Entry(9,916));
            values1.add(new Entry(10,2218));
            values1.add(new Entry(11,2291));
            values1.add(new Entry(12,2112));
            values1.add(new Entry(13,1128));

            values2.add(new Entry(1,1030));
            values2.add(new Entry(2,1034));
            values2.add(new Entry(3,1042));
            values2.add(new Entry(4,1738));
            values2.add(new Entry(5,1005));
            values2.add(new Entry(6,946));
            values2.add(new Entry(7,881));
            values2.add(new Entry(8,839));
            values2.add(new Entry(9,841));
            values2.add(new Entry(10,2018));
            values2.add(new Entry(11,2198));
            values2.add(new Entry(12,2219));
            values2.add(new Entry(13,1121));
            values2.add(new Entry(14,1140));
            values2.add(new Entry(15,1113));
            values2.add(new Entry(16,1055));
            values2.add(new Entry(17,994));
            values2.add(new Entry(18,961));
            values2.add(new Entry(19,971));
            values2.add(new Entry(20,1017));
            values2.add(new Entry(21,1074));
            values2.add(new Entry(22,1118));
            values2.add(new Entry(23,1134));
            values2.add(new Entry(24,1131));


            LineDataSet set1;
            LineDataSet set2;

            set1 = new LineDataSet(values1, "현재");
            set2= new LineDataSet(values2,"예측량");

            ArrayList<ILineDataSet> dataSets = new ArrayList<>();
            dataSets.add(set1); // add the data sets
            dataSets.add(set2);

            // create a data object with the data sets
            LineData data = new LineData(dataSets);

            // black lines and points
            set1.setColor(Color.parseColor("#00C2FF"));
            set1.setCircleColor(Color.parseColor("#00C2FF"));
            set1.setLineWidth(3);

            set2.setColor(Color.parseColor("#515151"));
            set2.setCircleColor(Color.parseColor("#515151"));


            // set data
            lineChart.setData(data);
            lineChart.setVisibleXRangeMaximum(6); // allow 20 values to be displayed at once on the x-axis, not more
            lineChart.moveViewToX(10); // set the left edge of the chart to x-index 10

        }

        public void buildLineChart2(){
            ArrayList<Entry> values = new ArrayList<>();
            ArrayList<Entry> values2= new ArrayList<>();

            values.add(new Entry(1,0));
            values.add(new Entry(2,0));
            values.add(new Entry(3,0));
            values.add(new Entry(4,0));
            values.add(new Entry(5,0));
            values.add(new Entry(6,0));
            values.add(new Entry(7,1));
            values.add(new Entry(8,26));
            values.add(new Entry(9,54));
            values.add(new Entry(10,92));
            values.add(new Entry(11,114));
            values.add(new Entry(12,131));
            values.add(new Entry(13,136));

            values2.add(new Entry(1,0));
            values2.add(new Entry(2,0));
            values2.add(new Entry(3,0));
            values2.add(new Entry(4,0));
            values2.add(new Entry(5,0));
            values2.add(new Entry(6,0));
            values2.add(new Entry(7,0));
            values2.add(new Entry(8,29));
            values2.add(new Entry(9,60));
            values2.add(new Entry(10,110));
            values2.add(new Entry(11,120));
            values2.add(new Entry(12,134));
            values2.add(new Entry(13,142));
            values2.add(new Entry(14,130));
            values2.add(new Entry(15,120));
            values2.add(new Entry(16,101));
            values2.add(new Entry(17,72));
            values2.add(new Entry(18,28));
            values2.add(new Entry(19,6));
            values2.add(new Entry(20,0));
            values2.add(new Entry(21,0));
            values2.add(new Entry(22,0));
            values2.add(new Entry(23,0));
            values2.add(new Entry(24,0));

            LineDataSet set1;
            LineDataSet set2;

            set1 = new LineDataSet(values, "현재");
            set2= new LineDataSet(values2,"예측량");

            ArrayList<ILineDataSet> dataSets = new ArrayList<>();
            dataSets.add(set1); // add the data sets
            dataSets.add(set2);

            // create a data object with the data sets
            LineData data = new LineData(dataSets);


            // black lines and points
            set1.setColor(Color.RED);
            set1.setCircleColor(Color.RED);
            set1.setLineWidth(3);

            set2.setColor(Color.parseColor("#515151"));
            set2.setCircleColor(Color.parseColor("#515151"));

            // set data
            lineChart.setData(data);

            lineChart.setVisibleXRangeMaximum(6); // allow 20 values to be displayed at once on the x-axis, not more
            lineChart.moveViewToX(10); // set the left edge of the chart to x-index 10
        }

        public void horizonBarChart(){
            BarDataSet set1;
            set1 = new BarDataSet(getDataSet(), "20190808");
            set1.setColors(Color.parseColor("#F78B5D"), Color.parseColor("#FCB232"), Color.parseColor("#FDD930"), Color.parseColor("#ADD137"), Color.parseColor("#A0C25A"));
            ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
            dataSets.add(set1);
            BarData data = new BarData(dataSets);
            // hide Y-axis
            YAxis left = barchart.getAxisRight();
            left.setDrawLabels(true);
            left.setDrawAxisLine(true);

            // custom X-axis labels
            String[] values = new String[] { "1시", "2시", "3시", "4시", "5시","6시", "7시", "8시", "9시", "10시","11시", "12시", "13시"};


            XAxis xAxis = barchart.getXAxis();
            xAxis.setDrawLabels(true);
            xAxis.setGranularity(1);
            xAxis.setValueFormatter(new ValueFormatter() {
                @Override
                public String getFormattedValue(float value, AxisBase axis) {
                    return values[(int) value]; // xVal is a string array
                }
            });
            xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

            barchart.setData(data);
            // custom description
            Description description = new Description();
            description.setText("발전량");
            barchart.setDescription(description);
            // hide legend
            barchart.getLegend().setEnabled(false);
            barchart.animateXY(1000,1000);
            barchart.invalidate();
        }

        public void horizonBarChart2(){
            BarDataSet set1;
            set1 = new BarDataSet(getDataSet2(), "20190808예측량");
            set1.setColors(Color.parseColor("#515151"));
            ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
            dataSets.add(set1);
            BarData data = new BarData(dataSets);
            // hide Y-axis
            YAxis left = barchart_p.getAxisRight();
            left.setDrawLabels(true);
            left.setDrawAxisLine(true);

            // custom X-axis labels
            String[] values = new String[] { "15시", "16시"};


            XAxis xAxis = barchart_p.getXAxis();
            xAxis.setDrawLabels(true);
            xAxis.setGranularity(1);
            xAxis.setValueFormatter(new ValueFormatter() {
                @Override
                public String getFormattedValue(float value, AxisBase axis) {
                    return values[(int) value]; // xVal is a string array
                }
            });
            xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

            barchart_p.setData(data);
            // custom description
            Description description = new Description();
            description.setText("예측량");
            barchart_p.setDescription(description);
            // hide legend
            barchart_p.getLegend().setEnabled(false);
            barchart_p.animateXY(1000,1000);
            barchart_p.invalidate();
        }

        private ArrayList<PieEntry> data1(int a,int b){
            ArrayList<PieEntry> datavalue= new ArrayList<>();

            datavalue.add(new PieEntry(a,"나머지"));
            datavalue.add(new PieEntry(b,"현재"));

            return datavalue;
        }

        private ArrayList<BarEntry> getDataSet() {
            ArrayList<BarEntry> valueSet1 = new ArrayList<>();
            BarEntry v1e2 = new BarEntry(1, 467057);
            valueSet1.add(v1e2);
            BarEntry v1e3 = new BarEntry(2, 466165);
            valueSet1.add(v1e3);
            BarEntry v1e4 = new BarEntry(3, 464846);
            valueSet1.add(v1e4);
            BarEntry v1e5 = new BarEntry(4, 464667);
            valueSet1.add(v1e5);
            BarEntry v1e6 = new BarEntry(5, 465035);
            valueSet1.add(v1e6);
            BarEntry v1e7 = new BarEntry(6, 465597);
            valueSet1.add(v1e7);
            BarEntry v1e8 = new BarEntry(7, 465189);
            valueSet1.add(v1e8);
            BarEntry v1e9 = new BarEntry(8, 465352);
            valueSet1.add(v1e9);
            BarEntry v1e10 = new BarEntry(9, 467570);
            valueSet1.add(v1e10);
            BarEntry v1e11 = new BarEntry(10, 467376);
            valueSet1.add(v1e11);
            BarEntry v1e12 = new BarEntry(11, 467083);
            valueSet1.add(v1e12);
            BarEntry v1e13 = new BarEntry(12, 466855);
            valueSet1.add(v1e13);
            BarEntry v1e14 = new BarEntry(13, 466262);
            valueSet1.add(v1e14);
            BarEntry v1e15 = new BarEntry(14, 469914);
            valueSet1.add(v1e15);


            return valueSet1;
        }

        private ArrayList<BarEntry> getDataSet2() {
            ArrayList<BarEntry> valueSet1 = new ArrayList<>();
            BarEntry v1e2 = new BarEntry(15, 437130);
            valueSet1.add(v1e2);
            BarEntry v1e3 = new BarEntry(16, 438610);
            valueSet1.add(v1e3);



            return valueSet1;
        }

        public void setOnViewHolderItemClickListener(OnViewHolderItemClickListener onViewHolderItemClickListener) {
            this.onViewHolderItemClickListener = onViewHolderItemClickListener;
        }
    }

    public class MyXAxisValueFormatter extends ValueFormatter implements IAxisValueFormatter {
        private String[] mValues;

        public MyXAxisValueFormatter(String[] values) {
            this.mValues = values;
        }

        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            return mValues[(int) value];
        }
    }


}





