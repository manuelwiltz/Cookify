package at.a5bhitm.cookify.cookify.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import at.a5bhitm.cookify.cookify.R;
import at.a5bhitm.cookify.cookify.activities.RecipeDetailActivity;
import at.a5bhitm.cookify.cookify.entities.Drink;

public class RecycleViewAdapterDrink extends RecyclerView.Adapter<RecycleViewAdapterDrink.MyViewHolder> {

    private Context context;
    private List<Drink> data;
    RequestOptions option;

    public RecycleViewAdapterDrink(Context context, List<Drink> data) {
        this.context = context;
        this.data = data;

        option = new RequestOptions().centerCrop().placeholder(R.drawable.listview_loading_shape).error(R.drawable.listview_loading_shape);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.drink_row_item, parent, false);

        final MyViewHolder viewHolder = new MyViewHolder(view);
        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i  = new Intent(context, RecipeDetailActivity.class);
                i.putExtra("id", data.get(viewHolder.getAdapterPosition()).getId());
                i.putExtra("title", data.get(viewHolder.getAdapterPosition()).getTitle());
                i.putExtra("subtitle", data.get(viewHolder.getAdapterPosition()).getSubtitle());
                i.putExtra("thumbnail_url", data.get(viewHolder.getAdapterPosition()).getThumbnail_url());
                i.putExtra("time", data.get(viewHolder.getAdapterPosition()).getTime());
                i.putExtra("description", data.get(viewHolder.getAdapterPosition()).getDescription());

                context.startActivity(i);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_title.setText(data.get(position).getTitle());
        holder.tv_time_sum.setText(data.get(position).getTime());
        holder.tv_subtitle.setText(data.get(position).getSubtitle());

        Glide.with(context).load(data.get(position).getThumbnail_url()).apply(option).into(holder.img_thumbnail);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_title;
        TextView tv_time_sum;
        TextView tv_subtitle;
        ImageView img_thumbnail;

        LinearLayout view_container;

        public MyViewHolder(View itemView) {
            super(itemView);
            view_container = itemView.findViewById(R.id.drink_row_item_container);

            tv_title = itemView.findViewById(R.id.drink_row_item_title);
            tv_time_sum = itemView.findViewById(R.id.drink_row_item_time_sum);
            tv_subtitle = itemView.findViewById(R.id.drink_row_item_subtitle);
            img_thumbnail = itemView.findViewById(R.id.drink_row_item_thumbnail);
        }
    }

}




