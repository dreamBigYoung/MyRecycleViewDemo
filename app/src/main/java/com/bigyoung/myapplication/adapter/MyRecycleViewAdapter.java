package com.bigyoung.myapplication.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bigyoung.myapplication.R;
import com.bigyoung.myapplication.bean.InforBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by BigYoung on 2017/10/23.
 */

public class MyRecycleViewAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private List<InforBean> mBeanList;

    public MyRecycleViewAdapter(Context context) {
        mContext = context;
    }

    public void setBeanList(List<InforBean> beanList) {
        mBeanList = beanList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_recycle_view, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.mItemText.setText(mBeanList.get(position).getText());
        switch (getItemViewType(position)) {
            case 0:
                myViewHolder.mItemText.setBackgroundColor(Color.BLACK);
                break;
            case 1:
                myViewHolder.mItemText.setBackgroundColor(Color.BLUE);
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return position%2;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        if (mBeanList != null)
            return mBeanList.size();
        return 0;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_text)
        TextView mItemText;

        MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
