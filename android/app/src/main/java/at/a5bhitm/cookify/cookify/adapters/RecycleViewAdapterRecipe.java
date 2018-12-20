package at.a5bhitm.cookify.cookify.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.Collections;
import java.util.List;

import at.a5bhitm.cookify.cookify.activities.RecipeDetailActivity;
import at.a5bhitm.cookify.cookify.R;
import at.a5bhitm.cookify.cookify.entities.Recipe;

public class RecycleViewAdapterRecipe extends RecyclerView.Adapter<RecycleViewAdapterRecipe.MyViewHolder> {

    private Context context;
    private List<Recipe> recipes;
    RequestOptions option;

    public RecycleViewAdapterRecipe(Context context, List<Recipe> data) {
        this.context = context;
        this.recipes = data;

        option = new RequestOptions().centerCrop().placeholder(R.drawable.listview_loading_shape).error(R.drawable.listview_loading_shape);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.recipe_row_item, parent, false);

        final MyViewHolder viewHolder = new MyViewHolder(view);
        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i  = new Intent(context, RecipeDetailActivity.class);
                i.putExtra("id", recipes.get(viewHolder.getAdapterPosition()).getId());
                i.putExtra("title", recipes.get(viewHolder.getAdapterPosition()).getTitle());
                i.putExtra("subtitle", recipes.get(viewHolder.getAdapterPosition()).getSubtitle());
                i.putExtra("thumbnail_url", recipes.get(viewHolder.getAdapterPosition()).getThumbnail_url());
                i.putExtra("time_sum", recipes.get(viewHolder.getAdapterPosition()).getTime_sum());
                i.putExtra("time_cook", recipes.get(viewHolder.getAdapterPosition()).getTime_cook());
                i.putExtra("description", recipes.get(viewHolder.getAdapterPosition()).getDescription());

                List<String> stringList = recipes.get(viewHolder.getAdapterPosition()).getSteps();
                String[] strings = new String[stringList.size()];
                for (int j = 0; j < stringList.size(); j++) {
                    strings[j] = stringList.get(j);
                }
                i.putExtra("steps", strings);

                /*Log.d("GEEHHT NEEED", Integer.toString(recipes.get(viewHolder.getAdapterPosition()).getSteps().size()));
                for (int j = 0; j < recipes.get(viewHolder.getAdapterPosition()).getSteps().size(); j++) {
                    Log.d("STEPS", "Steps: " + j);
                }*/

                context.startActivity(i);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_title.setText(recipes.get(position).getTitle());
        holder.tv_time_sum.setText(recipes.get(position).getTime_sum());
        holder.tv_subtitle.setText(recipes.get(position).getSubtitle());

        Glide.with(context).load(recipes.get(position).getThumbnail_url()).apply(option).into(holder.img_thumbnail);
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_title;
        TextView tv_time_sum;
        TextView tv_subtitle;
        ImageView img_thumbnail;

        LinearLayout view_container;

        public MyViewHolder(View itemView) {
            super(itemView);
            view_container = itemView.findViewById(R.id.recipe_row_item_container);

            tv_title = itemView.findViewById(R.id.recipe_row_item_title);
            tv_time_sum = itemView.findViewById(R.id.recipe_row_item_time_sum);
            tv_subtitle = itemView.findViewById(R.id.recipe_row_item_subtitle);
            img_thumbnail = itemView.findViewById(R.id.recipe_row_item_thumbnail);
        }
    }

}




