package com.example.acer.toasttest;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;


public class RecycleView extends AppCompatActivity {

    private RecyclerView rvCategory;
    private  ArrayList<President> lsist = new ArrayList<>();
    final String STATE_TITLE="state_String";
    final String STATE_LIST="state_list";
    final  String STATE_MODE="state_mode";
    int mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        rvCategory = findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

     //   lsist.addAll(PresidentData.getListData());
      // showRecyclerList(); //ambil dari adapter
       // showRecycleGrid();

        if(savedInstanceState == null){
           setActionBarTitle("mode get");
            lsist.addAll(PresidentData.getListData());
            showRecyclerList();
            mode = R.id.action_list; //mode pertama kali
        }else {
            String stateTitle = savedInstanceState.getString(STATE_LIST);
            ArrayList<President> stateList = savedInstanceState.getParcelableArrayList(STATE_LIST);
            int stateMode = savedInstanceState.getInt(STATE_MODE);
            setActionBarTitle(stateTitle);
            lsist.addAll(stateList);
            setMode(stateMode);
        }
    }

    private void showRecyclerList() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListPresidentAdapter listPresidentAdapter = new ListPresidentAdapter(this); //yang dipanggil di konstruktor adapter
        listPresidentAdapter.setListPresident(lsist);
        rvCategory.setAdapter(listPresidentAdapter);
        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedPresident(lsist.get(position));
            }
        });
    }
    private void showRecycleGrid(){
        rvCategory.setLayoutManager(new GridLayoutManager(this,2));
       GridPresidentAdapter gridPresidentAdapter  = new GridPresidentAdapter(this);
        gridPresidentAdapter.setListpresident(lsist);
        rvCategory.setAdapter(gridPresidentAdapter);
        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedPresident(lsist.get(position));
            }
        });
    }
    private void showRecycleCardView(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        CardViewPresidentAdapter cardViewPresidentAdapter = new CardViewPresidentAdapter(this);
        cardViewPresidentAdapter.setListPresident(lsist);
        rvCategory.setAdapter(cardViewPresidentAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void setActionBarTitle(String title)
    {
        getSupportActionBar().setTitle(title);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());


        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        String title = null;
        switch (selectedMode) {
            case R.id.action_list:
                title = "Mode List";
                showRecyclerList();
                break;

            case R.id.action_grid:
                title = "Mode Grid";
                showRecycleGrid();
                break;

            case R.id.action_cardview:
                title = "Mode CardView";
                showRecycleCardView();
                break;
        }
        mode = selectedMode;
        setActionBarTitle(title);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_TITLE, getSupportActionBar().getTitle().toString());
        outState.putParcelableArrayList(STATE_LIST,lsist);
        outState.putInt(STATE_MODE,mode);
    }
    private void showSelectedPresident(President capres){
        Toast.makeText(this, "Kamu memilih" +capres.getName(),Toast.LENGTH_SHORT).show();
    }
}
