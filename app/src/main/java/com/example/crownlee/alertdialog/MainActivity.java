package com.example.crownlee.alertdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv1;
    private AlertDialog.Builder builder;
    private AlertDialog ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView) findViewById(R.id.textView1);
        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn3);
        Button btn4 = (Button) findViewById(R.id.btn4);
        Button btn5 = (Button) findViewById(R.id.btn5);
        Button btn6 = (Button) findViewById(R.id.btn6);
        Button btn7 = (Button) findViewById(R.id.btn7);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btn1:
                        dialog1();
                        break;
                    case R.id.btn2:
                        dialog2();
                        break;
                    case R.id.btn3:
                        dialog3();
                        break;
                    case R.id.btn4:
                        dialog4();
                        break;
                    case R.id.btn5:
                        dialog5();
                        break;
                    case R.id.btn6:
                        dialog6();
                        break;
                    case R.id.btn7:
                        dialog7();
                        break;
                }
            }
        };
        btn1.setOnClickListener(listener);
        btn2.setOnClickListener(listener);
        btn3.setOnClickListener(listener);
        btn4.setOnClickListener(listener);
        btn5.setOnClickListener(listener);
        btn6.setOnClickListener(listener);
        btn7.setOnClickListener(listener);
    }
    private void dialog1(){
        ad = new AlertDialog.Builder(this).create();
        ad.setTitle("提示");
        ad.setMessage("确定退出吗？");
        ad.setIcon(android.R.drawable.ic_dialog_alert);

        DialogInterface.OnClickListener list1= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which==DialogInterface.BUTTON_POSITIVE){
                    ad.dismiss();
                    MainActivity.this.finish();
                }else if(which==DialogInterface.BUTTON_NEGATIVE){
                    ad.dismiss();

                }
            }
        };
        ad.setButton(DialogInterface.BUTTON_POSITIVE,"退出",list1);
        ad.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",list1);
        ad.show();
    }
    private void dialog2(){
        ad = new AlertDialog.Builder(this).create();
        ad.setTitle("调查");
        ad.setMessage("你忙吗？");
        ad.setIcon(android.R.drawable.ic_dialog_info);

        DialogInterface.OnClickListener list2= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="";
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        str="杜甫很忙";
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        str="杜甫很闲";
                        break;
                    case DialogInterface.BUTTON_NEUTRAL:
                        str="杜甫无所谓";
                        break;
                }
                tv1.setText(str);
            }
        };
        ad.setButton(DialogInterface.BUTTON_POSITIVE,"很忙",list2);
        ad.setButton(DialogInterface.BUTTON_NEGATIVE,"很闲",list2);
        ad.setButton(DialogInterface.BUTTON_NEGATIVE,"一般",list2);
        ad.show();

    }
    private void dialog3(){
        ad = new AlertDialog.Builder(this).create();
        ad.setTitle("输入的");
        ad.setMessage("请输入获奖感言");
        ad.setIcon(android.R.drawable.ic_dialog_dialer);

        final EditText et1 = new EditText(this);
        ad.setView(et1);

        DialogInterface.OnClickListener list3= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv1.setText("你的感言："+et1.getText().toString());
            }
        };
        ad.setButton(DialogInterface.BUTTON_NEGATIVE,"确定",list3);
        ad.show();
    }
    private void dialog4(){
        final String item[]= new String[]{"北京","上海","广州"};
        final boolean bSelect[]=new boolean[item.length];
        DialogInterface.OnMultiChoiceClickListener list4 = new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                bSelect[which] = isChecked;
            }
        };
        builder = new AlertDialog.Builder(this);
        builder.setMultiChoiceItems(item,bSelect,list4);
        ad = builder.create();
        ad.setTitle("多选框");
        DialogInterface.OnClickListener lis41 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="你选了";
                for (int i=0;i< bSelect.length;i++){
                    if(bSelect[i]){
                        str = str +"\n"+item[i];
                    }
                }
                tv1.setText(str);
            }
        };
        ad.setButton(DialogInterface.BUTTON_NEGATIVE,"确定",lis41);
        ad.show();
    }
    private void dialog5(){
        final String item[]= new String[]{"北京","上海","广州"};
        final boolean bSelect[]=new boolean[item.length];
        DialogInterface.OnClickListener list5 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                for (int i=0;i<bSelect.length;i++){
                    if(i!=which){
                        bSelect[i]=false;
                    }else{
                        bSelect[i]=true;
                    }
                }
            }
        };
        builder = new AlertDialog.Builder(this);
        builder.setSingleChoiceItems(item,-1,list5);
        ad = builder.create();
        ad.setTitle("单选");
        DialogInterface.OnClickListener lis51 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="你选了";
                for (int i=0;i< bSelect.length;i++){
                    if(bSelect[i]){
                        str = str +"\n"+item[i];
                    }
                }
                tv1.setText(str);
            }
        };
        ad.setButton(AlertDialog.BUTTON_POSITIVE,"确定",lis51);
        ad.show();
    }
    private void dialog6(){
        final String item[]= new String[]{"北京","上海","广州"};
        final boolean bSelect[]=new boolean[item.length];
        DialogInterface.OnClickListener lis6 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str= "你选择了："+item[which];
                tv1.setText(str);
            }
        };
        builder = new AlertDialog.Builder(this);
        builder.setItems(item,lis6);
        ad = builder.create();
        ad.setTitle("列表");

        DialogInterface.OnClickListener lis61 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ad.dismiss();
            }
        };
        ad.setButton(AlertDialog.BUTTON_POSITIVE,"确定",lis61);
        ad.show();
    }
    private void dialog7(){
        LayoutInflater li = getLayoutInflater();
        View layout = li.inflate(R.layout.mylayout,null);
        final EditText et1 = (EditText) findViewById(R.id.editText);

        ad = new AlertDialog.Builder(this).create();
        ad.setTitle("自定义布局");
        ad.setView(layout);

        DialogInterface.OnClickListener lis7 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv1.setText("输入的是："+et1.getText().toString());
            }
        };
        ad.setButton(AlertDialog.BUTTON_POSITIVE,"确定",lis7);
        ad.setButton(AlertDialog.BUTTON_NEGATIVE,"取消",lis7);
        ad.show();
    }

}