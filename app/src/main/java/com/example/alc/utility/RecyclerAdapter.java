package com.example.alc.utility;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alc.R;
import com.example.alc.model.ItemJSON;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private static ClickListener clickListener;
    private List<ItemJSON> developers;
    private Context context;

    public RecyclerAdapter(Context context, List<ItemJSON> developers) {
        this.context = context;
        this.developers = developers;
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.user_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.userName.setText(String.valueOf(developers.get(position).getUserName()));
        Picasso.with(context)
                .load(developers.get(position).getProfilePhoto())
                .transform(new RoundImageTransformation())
                .into(holder.userPicture);
    }

    public void setClickListener(ClickListener clickListener) {
        RecyclerAdapter.clickListener = clickListener;
    }

    public ItemJSON getUserByPos(int pos) {
        return developers.get(pos);
    }

    @Override
    public int getItemCount() {
        return developers.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public interface ClickListener {
        void itemClicked(View view, int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView userName;
        ImageView userPicture;

        public ViewHolder(View itemView) {
            super(itemView);
            userName = (TextView) itemView.findViewById(R.id.user_name);
            userPicture = (ImageView) itemView.findViewById(R.id.user_picture);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (clickListener != null) {
                Log.d("Log", view.getClass().getName());
                clickListener.itemClicked(view, this.getLayoutPosition());
            }
        }
    }
}
