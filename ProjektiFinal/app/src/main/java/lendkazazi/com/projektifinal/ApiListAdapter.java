package lendkazazi.com.projektifinal;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import lendkazazi.com.projektifinal.API.ApiModel;

/**
 * Created by kazazi on 11/01/2018.
 */

public class ApiListAdapter extends RecyclerView.Adapter<ApiListAdapter.ViewHolder> {

    private List<ApiModel> list;
    private Context context;

    public ApiListAdapter(Context context, List<ApiModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_apilist, parent, false);
        return new ViewHolder(v, list);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ApiModel apiModel = list.get(position);

        holder.title.setText(apiModel.getTitle());
        holder.description.setText(apiModel.getDescription());
        Glide.with(context).load(apiModel.getImage()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title, description;
        private ImageView image;

        public ViewHolder(View itemView, final List<ApiModel> lista) {
            super(itemView);

            title = itemView.findViewById(R.id.item_title);
            description = itemView.findViewById(R.id.item_description);
            image = itemView.findViewById(R.id.item_imageview);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(context, ApiListDetail.class);
                    i.putExtra("objekti", lista.get(getAdapterPosition()));
                    context.startActivity(i);
                }
            });

        }
    }
}
