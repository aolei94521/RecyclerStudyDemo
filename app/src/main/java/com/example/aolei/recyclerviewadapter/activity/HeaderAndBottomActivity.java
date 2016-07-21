package com.example.aolei.recyclerviewadapter.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.aolei.recyclerviewadapter.R;
import com.example.aolei.recyclerviewadapter.adapter.HeaderBottomAdapter;

public class HeaderAndBottomActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private HeaderBottomAdapter mHeaderBottomAdapter;
    GridLayoutManager mGridLayoutManager;
    LinearLayoutManager mLinearLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_header_and_bottom);
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerview_list);

        mGridLayoutManager = new GridLayoutManager(HeaderAndBottomActivity.this,3);
        mRecyclerView.setLayoutManager(mGridLayoutManager);//显示用线性宫格表示
        mRecyclerView.setAdapter(mHeaderBottomAdapter = new HeaderBottomAdapter(this));

        mGridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup(){

            @Override
            public int getSpanSize(final int position) {
                return (mHeaderBottomAdapter.isHeaderView(position) || mHeaderBottomAdapter.isBootomView(position)) ? mGridLayoutManager.getSpanCount() : 1;
            }
        });
    }
}
