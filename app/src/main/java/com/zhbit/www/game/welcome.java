package com.zhbit.www.game;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;

public class welcome extends AppCompatActivity {
private Button btnok;

    int[] imageIds = new int[] { R.drawable.zongcai, R.drawable.xiaobai,
            R.drawable.nvsheng };
    private ImageView xiaobai,zongcai,nvsheng;
    private ImageView currentImage;
    private View.OnClickListener myListener=new View.OnClickListener(){
        public void onClick(View v) {
            if (v.getId() == R.id.button2) {
                handleImageView((ImageView) v);
                if (v.getId() == R.id.zongcai) {
                    choisetouxiang(v, 0);
                } else if (v.getId() == R.id.xiaobai) {
                    choisetouxiang(v, 1);
                } else if (v.getId() == R.id.nvsheng) {
                    choisetouxiang(v, 2);
                }
                Intent intent = new Intent();
                intent.setClass(welcome.this, MainActivity.class);
                Bundle bundle=new Bundle();	//实例化要传递的数据包
             /*   bundle.putCharSequence("imageIds",imageIds[i] );// 显示选中的图片*/
                intent.putExtras(bundle);	//将数据包保存到intent中
                setResult(1,intent);	//设置返回的结果码，并返回调用该Activity的Activity
                finish();	//关闭当前Activity
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Button btnok=(Button)this.findViewById(R.id.button2);
       // choisetouxiang();//选择头像
        btnok.setOnClickListener(myListener);
        zongcai=(ImageView)findViewById(R.id.zongcai);
        xiaobai=(ImageView)findViewById(R.id.xiaobai);
        nvsheng=(ImageView)findViewById(R.id.nvsheng);
        zongcai.setOnClickListener(myListener);
        xiaobai.setOnClickListener(myListener);
        nvsheng.setOnClickListener(myListener);
       // 默认给第一个Image加边框
        zongcai.setImageResource(R.drawable.kuang);
        currentImage=zongcai;
    }
    public void handleImageView(ImageView imageView){
currentImage.setImageDrawable(null); //清除以前选择的边框
        imageView.setImageResource(R.drawable.kuang);//
        currentImage=imageView;
    }
    public void choisetouxiang(View v,int index){
        zongcai.setImageDrawable(getResources().getDrawable(imageIds[0]));
        xiaobai.setImageDrawable(getResources().getDrawable(imageIds[1]));
        nvsheng.setImageDrawable(getResources().getDrawable(imageIds[2]));
        ImageView view=(ImageView)v;
    }

}
