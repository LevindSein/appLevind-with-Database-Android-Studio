package com.example.levindmopro.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.levindmopro.R;
import androidx.recyclerview.widget.RecyclerView;

import com.example.levindmopro.model.MantanModel;

import java.util.ArrayList;
import java.util.List;

public class MantanAdapter extends RecyclerView.Adapter<MantanAdapter.MyViewHolder> {
    List<MantanModel> listItem;
    TextView mNama, mAsal, mKeahlian;
    ImageView mFoto;
    View view;
    private Context ctx;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onClick(int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public MantanAdapter(Context ctx) {
        this.ctx = ctx;
        listItem = new ArrayList<>();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(View v) {
            super(v);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_mantan, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        MantanModel item = listItem.get(position);
        mNama = holder.itemView.findViewById(R.id.txt_name_mantan);
        mAsal = holder.itemView.findViewById(R.id.txt_asal);
        mKeahlian = holder.itemView.findViewById(R.id.txt_keahlian);
        mFoto = holder.itemView.findViewById(R.id.img_movie);

        mNama.setText(item.getName());
        mAsal.setText(item.getAsal());
        mKeahlian.setText(item.getKeahlian());
        mFoto.setImageResource(item.getFotoMantan());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    public void add(MantanModel item) {
        listItem.add(item);
        notifyItemInserted(listItem.size() + 1);
    }

    public void addAll(List<MantanModel> listItem) {
        for (MantanModel item : listItem) {
            add(item);
        }
    }

    public void removeAll() {
        listItem.clear();
        notifyDataSetChanged();
    }

    public void remove(int pos) {
        listItem.remove(pos);
        notifyDataSetChanged();
    }

    public void swap(List<MantanModel> datas) {
        if (datas == null || datas.size() == 0) listItem.clear();
        if (listItem != null && listItem.size() > 0)
            listItem.clear();
        listItem.addAll(datas);
        notifyDataSetChanged();
    }

    public MantanModel getItem(int pos) {
        return listItem.get(pos);
    }

    public void setFilter(List<MantanModel> list) {
        listItem = new ArrayList<>();
        listItem.addAll(list);
        notifyDataSetChanged();
    }

    public List<MantanModel> getListItem() {
        return listItem;
    }
}
