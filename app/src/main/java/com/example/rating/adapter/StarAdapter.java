package ma.emsi.recycle1.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.rating.beans.Star;

import java.util.List;

import ma.emsi.recycle1.R;
import ma.emsi.recycle1.beans.Star;

public class StarAdapter extends RecyclerView.Adapter<StarAdapter.StarViewHolder> {
    private static final String TAG = "StarAdapter";
    private List<Star> stars;
    private Context context;
    ;

    public StarAdapter(Context context, List<Star> stars) {
        this.stars = stars;
        this.context = context;
    }

    @NonNull
    @Override
    public StarViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(this.context).inflate(R.layout.star_item, viewGroup, false);
        return new StarViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull StarViewHolder starViewHolder, int i) {
        Log.d(TAG, "onBindView call ! " + i);
        Glide.with(context).asBitmap().load(stars.get(i).getImg()).apply(new RequestOptions().override(100, 100)).into(starViewHolder.img);
        starViewHolder.name.setText(stars.get(i).getName().toUpperCase());
        starViewHolder.stars.setRating(stars.get(i).getStar());
        starViewHolder.idss.setText(stars.get(i).getId() + "");
    }

    @Override
    public int getItemCount() {
        return stars.size();
    }

    public class StarViewHolder extends RecyclerView.ViewHolder {
        TextView idss;
        ImageView img;
        TextView name;
        RatingBar stars;
        RelativeLayout parent;

        public StarViewHolder(@NonNull View itemView) {
            super(itemView);
            idss = itemView.findViewById(R.id.ids);
            img = itemView.findViewById(R.id.img);
            name = itemView.findViewById(R.id.name);
            stars = itemView.findViewById(R.id.stars);
            parent = itemView.findViewById(R.id.parent);
        }
    }
}