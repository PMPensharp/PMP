package com.example.pmp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;

import java.util.ArrayList;

public class FragmentPage2 extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_page_2,container, false);
        //원형그래프
        PieChart pieChart = view.findViewById(R.id.piechart);
        ArrayList NoOfEmp2 = new ArrayList();
        NoOfEmp2.add(new Entry(98f, 0));
        NoOfEmp2.add(new Entry(2f, 1));
        PieDataSet dataSet2 = new PieDataSet(NoOfEmp2, " ");
        ArrayList year2 = new ArrayList();
        year2.add("");
        year2.add("");
        PieData data2 = new PieData(year2, dataSet2); // MPAndroidChart v3.X 오류 발생
        pieChart.setData(data2);
        pieChart.animateXY(2000, 2000);
        //색
        final int[] MY_COLORS = {Color.rgb(35, 58, 160), Color.rgb(145, 154, 163)};
        ArrayList<Integer> colors = new ArrayList<Integer>();
        for (int c : MY_COLORS) colors.add(c);
        dataSet2.setColors(colors);
        //
        pieChart.setCenterText(98.2 + "%");
        pieChart.setCenterTextColor(Color.rgb(0, 0, 0));
        pieChart.setCenterTextSize(40);
        pieChart.setDescription("");
        Legend l = pieChart.getLegend();
        l.setEnabled(false); // x-Values List false 안보이게 / true 보이게

        //막대그래프
        BarChart chart = view.findViewById(R.id.barchart);
        ArrayList NoOfEmp = new ArrayList();
        NoOfEmp.add(new BarEntry(5751f, 0));
        NoOfEmp.add(new BarEntry(5595f, 1));
        NoOfEmp.add(new BarEntry(6051f, 2));
        NoOfEmp.add(new BarEntry(6173f, 3));
        NoOfEmp.add(new BarEntry(5899f, 4));
        NoOfEmp.add(new BarEntry(6026f, 5));
        NoOfEmp.add(new BarEntry(6061f, 6));
        NoOfEmp.add(new BarEntry(6027f, 7));
        NoOfEmp.add(new BarEntry(0f, 8));
        NoOfEmp.add(new BarEntry(6026f, 9));
        NoOfEmp.add(new BarEntry(0f, 10));
        NoOfEmp.add(new BarEntry(5750f, 11));
        NoOfEmp.add(new BarEntry(0f, 12));
        NoOfEmp.add(new BarEntry(5361f, 13));
        ArrayList year = new ArrayList();
        year.add("월");
        year.add("");
        year.add("화");
        year.add("");
        year.add("수");
        year.add("");
        year.add("목");
        year.add("");
        year.add("금");
        year.add("");
        year.add("토");
        year.add("");
        year.add("일");
        year.add("");
        BarDataSet bardataset = new BarDataSet(NoOfEmp, "발전량 예측량");
        chart.animateY(3000);
        BarData data = new BarData(year, bardataset); // MPAndroidChart v3.X 오류 발생
        chart.setData(data);
        chart.setDescriptionTextSize(20);
        chart.setDescriptionColor(android.R.color.black);
        //색
        final int[] MY_COLORS2 = {Color.rgb(45, 50, 141), Color.rgb(255, 152, 2)};
        ArrayList<Integer> colors2 = new ArrayList<Integer>();
        for (int c : MY_COLORS2) colors2.add(c);
        bardataset.setColors(colors2);
        //그외
        chart.setDrawGridBackground(false);
        return view;

    }
}