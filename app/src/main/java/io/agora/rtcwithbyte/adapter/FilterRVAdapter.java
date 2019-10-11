package io.agora.rtcwithbyte.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.io.File;
import java.util.List;

import io.agora.rtcwithbyte.model.FilterItem;
import io.agora.rtcwithbyte.utils.CommonUtils;
import io.agora.rtcwithbyte.utils.ToasUtils;
import io.agora.rtcwithbyte.R;

public class FilterRVAdapter extends SelectRVAdapter<FilterRVAdapter.ViewHolder> {
    private List<FilterItem> mFilterList;
    private OnItemClickListener mListener;

    public FilterRVAdapter(List<FilterItem> filterList, OnItemClickListener listener) {
        mFilterList = filterList;
        mListener = listener;
    }

    @Override
    public FilterRVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_filter, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(final FilterRVAdapter.ViewHolder holder, final int position) {
        final FilterItem item = mFilterList.get(position);

        if (mSelect == position) {
            holder.ll.setBackgroundResource(R.drawable.bg_item_select_selector);
        } else {
            holder.ll.setBackgroundResource(R.drawable.bg_item_unselect_selector);
        }

        holder.iv.setImageResource(item.getIcon());
        holder.tv.setText(item.getTitle());
        holder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CommonUtils.isFastClick()) {
                    ToasUtils.show("too fast click");
                    return;
                }
                if (mSelect != position) {
                    mListener.onItemClick(item.getResource().equals("") ? null : new File(item.getResource()));
                    setSelect(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mFilterList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(File file);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout ll;
        ImageView iv;
        TextView tv;

        ViewHolder(View itemView) {
            super(itemView);
            ll = itemView.findViewById(R.id.ll_item_filter);
            iv = itemView.findViewById(R.id.iv_item_filter);
            tv = itemView.findViewById(R.id.tv_item_filter);
        }
    }
}
