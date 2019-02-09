package com.example.acer.toasttest;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

//impelement digunakan untuk mewariskan interface
//extend untuk mewariskan method
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int mCount = 0;
    private TextView mShowCount;
  //  private TextView showtoas;
Button tomboltoast, tombolhitung,tombolTelpon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);
        tombolhitung = (Button) findViewById(R.id.button_count);
        tomboltoast = (Button) findViewById(R.id.button_toast);
        tombolTelpon = (Button) findViewById(R.id.telpon);

        tombolhitung.setOnClickListener(this);
        tomboltoast.setOnClickListener(this);
        tombolTelpon.setOnClickListener(this);
    }


    public void  onClick(View view)
    {
        switch (view.getId()){
            case R.id.button_count:
                mCount++;
                if(mShowCount != null)
                {
                    mShowCount.setText(Integer.toString(mCount));

                }
                break;
            case  R.id.button_toast:
                    Toast toast = Toast.makeText(this, R.string.button_label_toast, Toast.LENGTH_LONG);
                    toast.show();
                break;
            case R.id.telpon:
                String phoneNumber = "081391142838";
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumber));
               startActivity(dialPhoneIntent);
                break;
        }
    }


    public void pindah_dengan_data(View view)
    {
        String value= "hello World";
        Intent piindah_dengan_data = new Intent(MainActivity.this, activityWithData.class);
        piindah_dengan_data.putExtra(activityWithData.EXTRA_AGE, 70);
        piindah_dengan_data.putExtra(activityWithData.EXTRA_NAME,value);
        startActivity(piindah_dengan_data);
    }
    public void handphone(View view)
    {
        Intent handphone = new Intent(MainActivity.this, handphone.class);
        startActivity(handphone);
    }
    public void RecycleView(View view)
    {
        Intent RecycleView = new Intent(getApplicationContext(), RecycleView.class);
        startActivity(RecycleView);
    }

}