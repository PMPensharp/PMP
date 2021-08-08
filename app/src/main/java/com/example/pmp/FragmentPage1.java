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

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;

import java.util.ArrayList;

public class FragmentPage1 extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_page_1,
                container,
                false);
        //풍력 발전소
        PieChart pieChart1 = view.findViewById(R.id.piechart1);
        ArrayList NoOfEmp1 = new ArrayList();
        NoOfEmp1.add(new Entry(60f, 0));
        NoOfEmp1.add(new Entry(40f, 0));
        PieDataSet dataSet1 = new PieDataSet(NoOfEmp1, " ");
        ArrayList year1 = new ArrayList();
        year1.add("");
        year1.add("");
        PieData data1 = new PieData(year1, dataSet1); // MPAndroidChart v3.X 오류 발생
        pieChart1.setData(data1);
        pieChart1.animateXY(2000, 2000);
        //색
        final int[] MY_COLORS = {Color.parseColor("#FF00C2FF"), Color.rgb(145, 154, 163)};
        ArrayList<Integer> colors = new ArrayList<Integer>();
        for (int c : MY_COLORS) colors.add(c);
        dataSet1.setColors(colors);
        //그 외의 설정
        pieChart1.setCenterText(30.4 + "%");
        pieChart1.setCenterTextColor(Color.rgb(0, 0, 0));
        pieChart1.setCenterTextSize(20);
        pieChart1.setDescription("");
        Legend l = pieChart1.getLegend();
        l.setEnabled(false); // x-Values List false 안보이게 / true 보이게

        //태양열 발전소
        PieChart pieChart2 = view.findViewById(R.id.piechart2);
        ArrayList NoOfEmp2 = new ArrayList();
        NoOfEmp2.add(new Entry(60f, 0));
        NoOfEmp2.add(new Entry(40f, 0));
        PieDataSet dataSet2 = new PieDataSet(NoOfEmp2, " ");
        PieData data2 = new PieData(year1, dataSet2); // MPAndroidChart v3.X 오류 발생
        pieChart2.setData(data2);
        pieChart2.animateXY(2000, 2000);
        //색
        final int[] MY_COLORS2 = {Color.parseColor("#FFFF4D00"), Color.rgb(145, 154, 163)};
        ArrayList<Integer> colors2 = new ArrayList<Integer>();
        for (int c : MY_COLORS2) colors2.add(c);
        dataSet2.setColors(colors2);
        //그 외의 설정
        pieChart2.setCenterText(30.4 + "%");
        pieChart2.setCenterTextColor(Color.rgb(0, 0, 0));
        pieChart2.setCenterTextSize(20);
        pieChart2.setDescription("");
        Legend l2 = pieChart2.getLegend();
        l2.setEnabled(false); // x-Values List false 안보이게 / true 보이게

        //기력 발전소
        PieChart pieChart3 = view.findViewById(R.id.piechart3);
        ArrayList NoOfEmp3 = new ArrayList();
        NoOfEmp3.add(new Entry(60f, 0));
        NoOfEmp3.add(new Entry(40f, 0));
        PieDataSet dataSet3 = new PieDataSet(NoOfEmp3, " ");
        PieData data3 = new PieData(year1, dataSet3); // MPAndroidChart v3.X 오류 발생
        pieChart3.setData(data3);
        pieChart3.animateXY(2000, 2000);
        //색
        final int[] MY_COLORS3 = {Color.parseColor("#FFFFB900"), Color.rgb(145, 154, 163)};
        ArrayList<Integer> colors3 = new ArrayList<Integer>();
        for (int c : MY_COLORS3) colors3.add(c);
        dataSet3.setColors(colors3);
        //그 외의 설정
        pieChart3.setCenterText(30.4 + "%");
        pieChart3.setCenterTextColor(Color.rgb(0, 0, 0));
        pieChart3.setCenterTextSize(20);
        pieChart3.setDescription("");
        Legend l3 = pieChart3.getLegend();
        l3.setEnabled(false); // x-Values List false 안보이게 / true 보이게

        //수력 발전소
        PieChart pieChart4 = view.findViewById(R.id.piechart4);
        ArrayList NoOfEmp4 = new ArrayList();
        NoOfEmp4.add(new Entry(60f, 0));
        NoOfEmp4.add(new Entry(40f, 0));
        PieDataSet dataSet4 = new PieDataSet(NoOfEmp4, " ");
        PieData data4 = new PieData(year1, dataSet4); // MPAndroidChart v3.X 오류 발생
        pieChart4.setData(data4);
        pieChart4.animateXY(2000, 2000);
        //색
        final int[] MY_COLORS4 = {Color.parseColor("#FF6F8ACD"), Color.rgb(145, 154, 163)};
        ArrayList<Integer> colors4 = new ArrayList<Integer>();
        for (int c : MY_COLORS4) colors4.add(c);
        dataSet4.setColors(colors4);
        //그 외의 설정
        pieChart4.setCenterText(30.4 + "%");
        pieChart4.setCenterTextColor(Color.rgb(0, 0, 0));
        pieChart4.setCenterTextSize(20);
        pieChart4.setDescription("");
        Legend l4 = pieChart4.getLegend();
        l4.setEnabled(false); // x-Values List false 안보이게 / true 보이게
        return view;
    }

}