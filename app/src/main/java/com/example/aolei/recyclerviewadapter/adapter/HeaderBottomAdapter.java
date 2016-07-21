package com.example.aolei.recyclerviewadapter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aolei.recyclerviewadapter.R;

/**
 * Created by aolei on 2016/7/21.
 */

public class HeaderBottomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    //item类型
    public static final int ITEM_TYPE_HEADER = 0;
    public static final int ITEM_TYPE_CONTENT = 1;
    public static final int ITEM_TYPE_BOTTOM = 2;

    //模拟数据
    public String [] texts={"java","python","C++","Php",".NET","js","Ruby","Swift","OC","java","python","C++","Php",".NET","js","Ruby","Swift","OC","java","python","C++","Php",".NET","js","Ruby","Swift","OC"};
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private int mHeaderCount = 1;//头部view的个数
    private int mBottomCount = 1;//底部view的个数

    public HeaderBottomAdapter(Context context){
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }
    //内容的长度
    public int getContentItemCount(){
        return texts.length;
    }
    //判断当前的item是否是HeadView
    public boolean isHeaderView(int position){
        return mHeaderCount != 0 && position < mHeaderCount;
    }
    //判断当前的item是否是BottomView
    public boolean isBootomView(int position){
        return mBottomCount != 0 && position >= (getContentItemCount() + mHeaderCount);
    }

    //判断当前的item的类型
    @Override
    public int getItemViewType(int position){
        int dataItemCount = getContentItemCount();
        if (mHeaderCount != 0 && position < mHeaderCount){
            return ITEM_TYPE_HEADER;
        }else if (mBottomCount != 0 && position >= (mHeaderCount + getContentItemCount())){
            return ITEM_TYPE_BOTTOM;
        }else {
            return ITEM_TYPE_CONTENT;
        }
    }
    //内容的Viewholder
    public static class ContentViewHolder extends RecyclerView.ViewHolder{
        private TextView mTextView;
        public ContentViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView)itemView.findViewById(R.id.tv_item3_text);
        }
    }
    //头部的ViewHolder
    public static class HeaderViewHolder extends RecyclerView.ViewHolder{
        public HeaderViewHolder(View itemView) {
            super(itemView);
        }
    }
    //底部的ViewHolder
    public static class BottomViewHolder extends RecyclerView.ViewHolder{

        public BottomViewHolder(View itemView) {
            super(itemView);
        }
    }


    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_TYPE_HEADER){
            return new HeaderViewHolder(mLayoutInflater.inflate(R.layout.rv_header,parent,false));
        }else if (viewType == ITEM_TYPE_CONTENT){
            return new ContentViewHolder(mLayoutInflater.inflate(R.layout.recyclertest,parent,false));
        }else{
            return new BottomViewHolder(mLayoutInflater.inflate(R.layout.rv_footer,parent,false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HeaderViewHolder) {

        } else if (holder instanceof ContentViewHolder) {
            ((ContentViewHolder) holder).mTextView.setText(texts[position - mHeaderCount]);

        } else if (holder instanceof BottomViewHolder) {

        }
    }

    @Override
    public int getItemCount() {
        return mHeaderCount + getContentItemCount() + mBottomCount;
    }
}
