package com.zhbit.www.game;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
private ImageView bu,shitou,jiandao,kuang,sui;
    private Button ok;
    private View.OnClickListener okListener=new View.OnClickListener() {
        public void onClick(View v) {
            int[] imageIds = new int[] { R.drawable.bu, R.drawable.jiandao,
                    R.drawable.shitou};
            Random random=new Random();
            int suiimage=imageIds[random.nextInt(3)];
            sui.setImageResource(suiimage);
        }
    };
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ok=(Button)findViewById(R.id.OK) ;
        sui=(ImageView)findViewById(R.id.sui);
        bu=(ImageView)findViewById(R.id.bu);
        shitou=(ImageView)findViewById(R.id.shi);
        jiandao=(ImageView)findViewById(R.id.jian);
//         Intent intent=getIntent();
//        Bundle bd=intent.getExtras();
//        ImageView iv=(ImageView)findViewById(R.id.touxiang);//接收图片

        ok.setOnClickListener(okListener);
    }

}
