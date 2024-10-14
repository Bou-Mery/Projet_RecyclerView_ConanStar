package ma.ensa.mobile.conanstar.adapter;

import static com.bumptech.glide.load.resource.bitmap.TransformationUtils.centerCrop;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;



import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import ma.ensa.mobile.conanstar.R;
import ma.ensa.mobile.conanstar.bean.Star;
import ma.ensa.mobile.conanstar.service.StarService;

public class StarAdapter extends RecyclerView.Adapter<StarAdapter.StarViewHolder> implements Filterable {

    private List<Star> stars ;
    private Context context;
    private List<Star> starsFilter;
    private NewFilter mfilter;

    public StarAdapter(List<Star> stars, Context context) {
        this.stars = stars;
        this.context = context;
        this.starsFilter = new ArrayList<>();
        this.starsFilter.addAll(stars);
        mfilter = new NewFilter(this);
    }

    @NonNull
    @Override



    public StarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.star_item , parent , false);
        final StarViewHolder holder = new StarViewHolder(view);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View popup = LayoutInflater.from(context).inflate(R.layout.star_edit_item , null,false);

                final  ImageView img = popup.findViewById(R.id.photo);
                final RatingBar starbar = popup.findViewById(R.id.starbar);
                final TextView  nomper = popup.findViewById(R.id.nomper);
                final TextView idd = popup.findViewById(R.id.idd);

                final ImageView photo = (ImageView) view.findViewById(R.id.foto);
                BitmapDrawable drawable = (BitmapDrawable) photo.getDrawable();
                Bitmap bitmap = drawable.getBitmap();

                img.setImageBitmap(bitmap);
                idd.setText(((TextView) view.findViewById(R.id.id)).getText().toString());
                starbar.setRating(((RatingBar)view.findViewById(R.id.stars)).getRating());
                nomper.setText(((TextView)view.findViewById(R.id.name)).getText().toString());

                AlertDialog dialog = new AlertDialog.Builder(context , R.style.CustomAlertDialog)
                        .setView(popup)
                        .setPositiveButton("Valider", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                float s = starbar.getRating();
                                int ids = Integer.parseInt(idd.getText().toString());
                                Star star = StarService.getInstance().findById(ids);
                                star.setStar(s);
                                StarService.getInstance().update(star);
                                notifyItemChanged(holder.getAdapterPosition());
                                  }
                        })
                        .setNegativeButton("Annuler" , null)
                        .create();

                dialog.show();
            }
        });
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull StarViewHolder holder, int position) {

        Animation animation = AnimationUtils.loadAnimation(holder.itemView.getContext() , android.R.anim.slide_in_left);
        holder.id.setText(starsFilter.get(position).getId()+"");
        holder.name.setText(starsFilter.get(position).getName().toUpperCase());
        holder.stars.setRating(starsFilter.get(position).getStar());
        Glide.with(context)
            .load(starsFilter.get(position).getImg())
            .centerCrop()
            .error(R.drawable.conan)
            .into(holder.foto);
        holder.itemView.startAnimation(animation);
    }

    @Override
    public int getItemCount() {
        return starsFilter.size();
    }

    class StarViewHolder extends RecyclerView.ViewHolder{
        TextView name , id;
        CircleImageView foto;
        RatingBar stars ;
        public StarViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            id = itemView.findViewById(R.id.id);
            foto = itemView.findViewById(R.id.foto);
            stars=itemView.findViewById(R.id.stars);


        }
    }


    @Override
    public Filter getFilter() {
        return mfilter;
    }

    public class NewFilter extends Filter {

        public final  RecyclerView.Adapter mAdapter;
        public NewFilter(RecyclerView.Adapter mAdapter) {
            super();
            this.mAdapter = mAdapter ;
        }

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            starsFilter.clear();
            final FilterResults results = new FilterResults();
            if ( charSequence.length()==0){
                starsFilter.addAll(stars);
            }else{
                final String filterPattern = charSequence.toString().toLowerCase().trim();
                for(Star p : stars ){
                    if(p.getName().toLowerCase().startsWith(filterPattern)){
                        starsFilter.add(p);
                    }
                }
            }
            results.values = starsFilter;
            results.count=starsFilter.size();
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            starsFilter = (List<Star>) filterResults.values;
            this.mAdapter.notifyDataSetChanged();

        }
    }


}
