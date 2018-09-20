package com.sandeep.mivi.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.sandeep.mivi.R;
import com.sandeep.mivi.model.IncludedItem;

import java.util.List;

public class RvAdapterSubscriptions extends RecyclerView.Adapter<RvAdapterSubscriptions.SubscriptionViewHolder> {
    Context context;
    private int lastPosition = -1;
    List<IncludedItem> included;

    public RvAdapterSubscriptions(Context context, List<IncludedItem> included) {
        this.context = context;
        this.included = included;
    }

    @NonNull
    @Override
    public SubscriptionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subscription_single, parent, false);
        RvAdapterSubscriptions.SubscriptionViewHolder productsViewHolder = new RvAdapterSubscriptions.SubscriptionViewHolder(view);
        return productsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SubscriptionViewHolder holder, int position) {
        setAnimation(holder.itemView, position);

        holder.tvr1.setText("Type: "+included.get(position).getType());
        holder.tvr2.setText("Id: "+included.get(position).getId());
    }

    @Override
    public int getItemCount() {
        return included.size();
    }

    public class SubscriptionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvr1, tvr2;


        public SubscriptionViewHolder(View itemView) {
            super(itemView);
            tvr1 = itemView.findViewById(R.id.tvr1);
            tvr2 = itemView.findViewById(R.id.tvr2);

        }

        @Override
        public void onClick(View v) {
            //CBHomeActivity.replaceFragment(ProductDetailsFragmment.newInstance("","13"), ProductDetailsFragmment.class.getSimpleName(), "", true, true, false, true);
        }
    }

    private void setAnimation(View viewToAnimate, int position) {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }
}
