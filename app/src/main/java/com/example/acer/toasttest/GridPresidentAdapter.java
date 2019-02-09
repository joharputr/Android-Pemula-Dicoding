package com.example.acer.toasttest;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import java.util.ArrayList;

import static android.media.CamcorderProfile.get;

public class GridPresidentAdapter  extends RecyclerView.Adapter<GridPresidentAdapter.GridViewHolder> {

    private Context context;
    private ArrayList<President> listpresident; //atribut untuk arraylist class President

    //getter mengambil data dari atribut list president berupa aaraylist dari class president
    public ArrayList<President> getListpresident() {
        return listpresident;
    }
    //setter mengisi data dari atribut arraylist
    public void setListpresident(ArrayList<President> listpresident) {
        this.listpresident = listpresident;
    }
    //construktor
    public GridPresidentAdapter(Context context){
        this.context = context;
    }
    @NonNull
    @Override
    //panggil layout inflanter yaitu item_grid_president
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewtype) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_grid_president,viewGroup,false);
        return new GridViewHolder(view);
    }

    @Override
    //isi dari view holder
    public void onBindViewHolder(@NonNull GridViewHolder gridViewHolder, int posisi) {
        Glide.with(context)
                .load(getListpresident().get(posisi).getPhoto())
                //.apply(new RequestOptions().override(350,350))
                .into(gridViewHolder.imgPhoto);
    }

    @Override
    //size dari array list
    public int getItemCount() {
        return getListpresident().size();
    }
    //kelas grid view holder
    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            //memasukan ke id dari layout img_item_photo di item_grid_president
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
}
