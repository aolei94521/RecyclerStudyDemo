package com.example.aolei.recyclerviewadapter.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.aolei.recyclerviewadapter.R;
import com.example.aolei.recyclerviewadapter.viewholder.RecyclerViewHolder;
import com.example.aolei.recyclerviewadapter.adapter.RecyclerViewvViewCommonAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private List<String> mDates = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView)findViewById(R.id.rv);
        for (int i = 0; i < 10; i++) {
            mDates.add(i+"");
        }
        Log.d("mDate",mDates.toString());
        //获得线性布局的管理器
        mRecyclerView = (RecyclerView)findViewById(R.id.rv);
        final RecyclerViewvViewCommonAdapter commonAdapter = new RecyclerViewvViewCommonAdapter<String>(MainActivity.this,R.layout.recyclertest,mDates) {

            @Override
            public void convert(final RecyclerViewHolder viewHolder, final String s) {
                if (mDates != null && mDates.size() != 0){
                    int i = 0;
                    viewHolder.setTextView(R.id.tv_item3_text,mDates.get(i++));
                }
            }
        };
        commonAdapter.setOnItemClickListener(new RecyclerViewvViewCommonAdapter.onItemClickListener() {
            @Override
            public void onItemClick(final View view, final int position) {
                Toast.makeText(MainActivity.this, "click", Toast.LENGTH_SHORT).show();
            }
        });
        commonAdapter.setOnItemLongClickListener(new RecyclerViewvViewCommonAdapter.onItemLongClickListener() {
            @Override
            public void onItemLongClickListener(final View view, final int position) {
                Toast.makeText(MainActivity.this, "LongClick", Toast.LENGTH_SHORT).show();

            }
        });
        mRecyclerView.setAdapter(commonAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setNestedScrollingEnabled(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }
}
