package com.example.acer.toasttest;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import java.util.ArrayList;

//impelement digunakan untuk mewariskan interface
//extend untuk mewariskan method
public class ListPresidentAdapter extends RecyclerView.Adapter<ListPresidentAdapter.CategoryViewHolder> {
    private Context context;
    private ArrayList<President> listPresident;

    //dipanggil di main activity
    public ListPresidentAdapter(Context context)
    {
        this.context = context;
    }

    //setter getter array list
    public ArrayList<President> getListPresident() {

        return listPresident;
    }

    public void setListPresident(ArrayList<President> listPresident) {
        this.listPresident = listPresident;
    }
    @NonNull
//onCreateViewHolder() inflates an item view and returns a new view holder that contains it. This method is called when the RecyclerView needs a new view holder to represent and item.
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int apapun ) {
       View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_president,viewGroup,false);

        return new CategoryViewHolder(itemRow);
    }


    @Override
//onBindViewHolder() sets the contents of an item at a given position in the RecyclerView. This is called by the RecyclerView, for example, when a new item scrolls into view.
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int position) {
       President president = listPresident.get(position);
     categoryViewHolder.tvName.setText(president.getName());  //digunakan untuk mementukan posisi nama
       categoryViewHolder.tvRemarks.setText(president.getRemarks());   //digunakan untuk mementukan posisi remakrs
        Glide.with(context)
                .load(getListPresident().get(position).getPhoto()) //  //digunakan untuk mementukan posisi foto
                .apply(new RequestOptions().override(55, 55))
                .into(categoryViewHolder.imgPhoto);
    }

    @Override
    //getItemCount() returns the total number of items in the data set held by the adapter.
    public int getItemCount()
    {
        return getListPresident().size();
    }

    //A RecyclerView.ViewHolder describes an item view and metadata about its place within the RecyclerView. Each view holder holds one set of data. The adapter adds data to view holders for the layout manager to display.
    //You define your view holder layout in an XML resource file. It can contain (almost) any type of view, including clickable elements.
    public class CategoryViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        TextView tvRemarks;
        ImageView imgPhoto;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvRemarks = itemView.findViewById(R.id.tv_item_remarks);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
}
