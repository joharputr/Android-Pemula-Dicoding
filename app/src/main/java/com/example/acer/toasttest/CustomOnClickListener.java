package com.example.acer.toasttest;

import android.view.View;
import android.widget.AdapterView;
//impelement digunakan untuk mewariskan interface
//extend untuk mewariskan method
class CustomOnItemClickListener implements View.OnClickListener {
    private int position;
    private OnItemClickCallback onItemClickCallback;
    CustomOnItemClickListener(int position, OnItemClickCallback onItemClickCallback){
        this.position = position;
        this.onItemClickCallback  = onItemClickCallback;
    }
    @Override
    public void onClick(View v)
    {
        onItemClickCallback.onItemClicked(v, position);
    }
    public interface OnItemClickCallback{
        void onItemClicked(View view,int position);
    }
}
