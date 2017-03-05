package bsd.chula.smartgrass.mvp.suggestion;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

import bsd.chula.smartgrass.R;
import bsd.chula.smartgrass.data.model.Grass;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dev_Tee on 3/5/17.
 */

public class SuggestionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Grass> grassList;
    private OnGrassItemClick onGrassItemClick;

    public SuggestionAdapter(Context context, OnGrassItemClick callback) {
        this.context = context;
        this.onGrassItemClick = callback;

        grassList = new ArrayList<>();
    }

    public void appendItems(List<Grass> itemList) {
        grassList.addAll(itemList);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_grass_item, parent, false);
        return new GrassItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        GrassItemViewHolder viewHolder = (GrassItemViewHolder) holder;
        Grass item = grassList.get(position);

        Glide.with(context).load(item.getPath())
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(viewHolder.imgThumbnail);

        viewHolder.txtName.setText(item.getArtificialGrassName());
        viewHolder.txtDescription.setText(item.toString());

    }

    @Override
    public int getItemCount() {
        return grassList.size();
    }

    public class GrassItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imgThumbnail)
        ImageView imgThumbnail;
        @BindView(R.id.txtName)
        TextView txtName;
        @BindView(R.id.txtDescription)
        TextView txtDescription;

        public GrassItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnGrassItemClick {
        void onGrassItemClick(Grass item);
    }
}
