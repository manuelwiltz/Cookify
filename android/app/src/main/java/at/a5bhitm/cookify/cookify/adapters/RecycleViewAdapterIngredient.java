package at.a5bhitm.cookify.cookify.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import at.a5bhitm.cookify.cookify.R;
import at.a5bhitm.cookify.cookify.activities.RecipeDetailActivity;
import at.a5bhitm.cookify.cookify.entities.Ingredient;

public class RecycleViewAdapterIngredient extends RecyclerView.Adapter<RecycleViewAdapterIngredient.MyViewHolder> {

    private Context context;
    private List<Ingredient> data;
    RequestOptions option;

    public RecycleViewAdapterIngredient(Context context, List<Ingredient> data) {
        this.context = context;
        this.data = data;

        option = new RequestOptions().centerCrop().placeholder(R.drawable.listview_loading_shape).error(R.drawable.listview_loading_shape);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.ingredient_row_item, parent, false);

        final MyViewHolder viewHolder = new MyViewHolder(view);
        /**viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i  = new Intent(context, RecipeDetailActivity.class);
                i.putExtra("id", data.get(viewHolder.getAdapterPosition()).getId());
                i.putExtra("name", data.get(viewHolder.getAdapterPosition()).getName());
                i.putExtra("amount", data.get(viewHolder.getAdapterPosition()).getAmount());

                context.startActivity(i);
            }
        });*/

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_name.setText(data.get(position).getName());
        holder.tv_amount.setText(data.get(position).getAmount());
        holder.cb_selected.setSelected(data.get(position).getSelected());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name;
        TextView tv_amount;
        CheckBox cb_selected;

        LinearLayout view_container;

        public MyViewHolder(View itemView) {
            super(itemView);
            view_container = itemView.findViewById(R.id.ingredient_row_item_container);

            tv_name = itemView.findViewById(R.id.ingredient_row_item_name);
            tv_amount = itemView.findViewById(R.id.ingredient_row_item_amount);
            cb_selected = itemView.findViewById(R.id.ingredient_row_item_checkbox);
        }
    }

}




