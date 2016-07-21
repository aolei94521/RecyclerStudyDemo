package com.example.aolei.recyclerviewadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by aolei on 2016/7/20.
 */

public abstract class RecyclerViewvViewCommonAdapter<T> extends RecyclerView.Adapter<RecyclerViewHolder>{

    protected Context mContext;
    protected int mLayoutId;
    private List<T> mDatas;
    protected LayoutInflater mInflater;
    private onItemClickListener mOnItemClickListener;
    private onItemLongClickListener mOnItemLongClickListener;
    /**
     * 点击事件的接口
     */
    public interface onItemClickListener{
        void onItemClick(View view, int position);
    }

    /**
     * 供外部调用的接口
     * @param mOnItemClickListener
     */
    public void setOnItemClickListener(RecyclerViewvViewCommonAdapter.onItemClickListener mOnItemClickListener){
        this.mOnItemClickListener = mOnItemClickListener;
    }
    /**
     * 长按点击事件接口
     */
    public interface onItemLongClickListener{
        void onItemLongClickListener(View view,int position);
    }

    /**
     * 长按点击事件供外部调用的接口
     * @param mOnItemLongClickLisener
     */
    public void setOnItemLongClickListener(RecyclerViewvViewCommonAdapter.onItemLongClickListener mOnItemLongClickLisener){
        this.mOnItemLongClickListener = mOnItemLongClickLisener;
    }

    /**
     * 构造函数
     * @param context
     * @param layoutId
     * @param datas
     */
    public RecyclerViewvViewCommonAdapter(Context context,int layoutId,List<T> datas){
        this.mContext = context;
        this.mDatas = datas;
        this.mLayoutId = layoutId;
        mInflater = LayoutInflater.from(context);
    }

    public int getPosition(RecyclerView.ViewHolder viewHolder){
        return viewHolder.getAdapterPosition();
    }


    public void deleteItem(int position){
        mDatas.remove(position);
        notifyDataSetChanged();
    }

    public abstract void convert(RecyclerViewHolder viewHolder,T t);


    public void notifyData(List<T> datas){
        this.mDatas = datas;
        notifyDataSetChanged();
    }


    @Override
    public RecyclerViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        final RecyclerViewHolder viewHolder = RecyclerViewHolder.get(mContext,parent,mLayoutId);
        viewHolder.getConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                mOnItemClickListener.onItemClick(v, getPosition(viewHolder));
            }
        });
        viewHolder.getConvertView().setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(final View v) {
                mOnItemLongClickListener.onItemLongClickListener(v,getPosition(viewHolder));
                //deleteItem(getPosition(viewHolder));
                return false;
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, final int position) {
        convert(holder, mDatas.get(position));
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }


}
