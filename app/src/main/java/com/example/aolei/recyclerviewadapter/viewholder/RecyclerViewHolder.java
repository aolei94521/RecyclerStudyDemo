package com.example.aolei.recyclerviewadapter.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by aolei on 2016/7/20.
 */

public class RecyclerViewHolder extends RecyclerView.ViewHolder
{
    private SparseArray<View> mViews;
    private View mConvertView;
    private Context mContext;
    private int mPosition;
    private int mLayoutId;

    /**
     * 构造函数
     * @param context
     * @param parent
     * @param itemView
     */
    public RecyclerViewHolder(Context context, final View itemView,ViewGroup parent) {
        super(itemView);
        mConvertView = itemView;
        mContext = context;
        mViews = new SparseArray<View>();
    }

    /**
     * 通过获取自定义布局，
     * @param context
     * @param parent
     * @param layoutId
     * @return
     */
    public static RecyclerViewHolder get(Context context,ViewGroup parent,int layoutId){
        View itemView = LayoutInflater.from(context).inflate(layoutId,parent,false);
        RecyclerViewHolder holder = new RecyclerViewHolder(context,itemView,parent);
        return holder;
    }

    /**
     *获取View
     * @return
     */
    public View getConvertView(){
        return mConvertView;
    }

    /**
     * 通过viewId获取控件
     * @param viewId
     * @param <T>
     * @return
     */
    public <T extends View> T getView(int viewId){
        View view = mViews.get(viewId);
        if (view == null){
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId,view);
        }
        return (T) view;
    }

    /**
     * 给TextView填充值
     * @param viewId
     * @param text
     * @return
     */
    public RecyclerViewHolder setTextView(int viewId,String text){
        TextView mTextView = getView(viewId);
        mTextView.setText(text);
        return this;
    }

    /**
     * 设置监听事件
     * @param viewId
     * @param listener
     * @return
     */
    public RecyclerViewHolder setOnClickListener(int viewId,View.OnClickListener listener){
        View view = getView(viewId);
        view.setOnClickListener(listener);
        return this;
    }
}
