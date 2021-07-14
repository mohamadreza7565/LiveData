package com.rymo.livedata.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rymo.livedata.R;
import com.rymo.livedata.model.Favourites;

import java.util.List;

public class FavRvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    OnItemClickListener onItemClickListener;
    Context context;
    List<Favourites> list;

    public FavRvAdapter(Context context, List<Favourites> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ViewHolder viewHolder = (ViewHolder) holder;

        viewHolder.tv_title.setText(list.get(position).getTitle());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageButton btn_delete;
        TextView tv_title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            btn_delete = itemView.findViewById(R.id.btn_delete);
            tv_title = itemView.findViewById(R.id.tv_title);

            btn_delete.setOnClickListener(v -> {
                onItemClickListener.onDeleteClick(getAdapterPosition(),list.get(getAdapterPosition()));
            });

        }
    }

    public interface OnItemClickListener {
        void onDeleteClick(int position, Favourites favourites);
    }

    public FavRvAdapter setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
        return this;
    }
}
