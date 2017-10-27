package com.bigyoung.myapplication;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bigyoung.myapplication.adapter.MyRecycleViewAdapter;
import com.bigyoung.myapplication.bean.InforBean;
import com.bigyoung.myapplication.view.DividerItemView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public RecyclerView mRecycleView;
    public MyRecycleViewAdapter mMyRecycleViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecycleView = (RecyclerView)findViewById(R.id.my_recycle_view);
        mMyRecycleViewAdapter = new MyRecycleViewAdapter(MainActivity.this);

        mRecycleView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        mRecycleView.setAdapter(mMyRecycleViewAdapter);
        mRecycleView.addItemDecoration(new DividerItemView(this,
                DividerItemView.VERTICAL_LIST));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mMyRecycleViewAdapter.setBeanList(getBeanList());
                mMyRecycleViewAdapter.notifyDataSetChanged();
            }
        },2000);

    }
    private List<InforBean> getBeanList(){
        List<InforBean> beanList=new ArrayList<InforBean>();
        InforBean bean=null;
        for (int i = 0; i < 10; i++) {
            bean=new InforBean();
            bean.setText(i+"");
            beanList.add(bean);
        }
        return  beanList;
    }
}
