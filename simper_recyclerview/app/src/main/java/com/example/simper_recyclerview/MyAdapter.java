package com.example.simper_recyclerview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Bean> data;
    private Context context;

    public MyAdapter(List<Bean> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context,R.layout.recyclerview_item,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
         holder.tv.setText(data.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return data == null ?  0 : data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tv;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mOnIemClickListener != null){
                        mOnIemClickListener.onRecyclerItemClick(getLayoutPosition());
                    }
                }
            });
        }
    }

    private static OnRecyclerItemClickLister mOnIemClickListener;


    public  void  setRecyclerTeamClickListener(OnRecyclerItemClickLister listener){
        mOnIemClickListener = listener;
    }

    public  interface  OnRecyclerItemClickLister {
        void onRecyclerItemClick(int position);
    }


}
