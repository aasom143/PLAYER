package com.example.somesh.player;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,GestureDetector.OnDoubleTapListener{
    GestureDetector gestureDetector;

    static TextView t[]=new TextView[20];
    TextView score ;
    static int k=786;
    Button back,reset;
    static int arr[]=new int[10001];
    static String p[]=new String[20];
    static String ps[]=new String[20];
    static  int sw;
    //private static final String DEBUG_TAG =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        score=(TextView)findViewById(R.id.textView2);
        t[0]=(TextView)findViewById(R.id.textview);
        t[1]=(TextView)findViewById(R.id.textview2);
        t[2]=(TextView)findViewById(R.id.textview3);
        t[3]=(TextView)findViewById(R.id.textview4);
        t[4]=(TextView)findViewById(R.id.textview5);
        t[5]=(TextView)findViewById(R.id.textview6);
        t[6]=(TextView)findViewById(R.id.textview7);
        t[7]=(TextView)findViewById(R.id.textview8);
        t[8]=(TextView)findViewById(R.id.textview9);
        t[9]=(TextView)findViewById(R.id.textview10);
        t[10]=(TextView)findViewById(R.id.textview11);
        t[11]=(TextView)findViewById(R.id.textview12);
        t[12]=(TextView)findViewById(R.id.textview13);
        t[13]=(TextView)findViewById(R.id.textview14);
        t[14]=(TextView)findViewById(R.id.textview15);
        t[15]=(TextView)findViewById(R.id.textview16);
        back=(Button)findViewById(R.id.button);
        reset=(Button)findViewById(R.id.button2);

        gestureDetector =new GestureDetector(this,this);

        int count=0;
        for(int i=0;i<=15;i++)
        {
            String sq=t[i].getText().toString();
            if(!sq.equals(""))
            {
                count=1;
                break;
            }
        }
        for(int i=0;i<=15;i++)
        {
            p[i]=t[i].getText().toString();
        }
        set_colour();

        if(count==0)
        {
        int min=0;
        int max=16;
        Random random=new Random();
        int a=min+random.nextInt(max);
        int b=min+random.nextInt(max);

        while(a==b)
        {
            k++;
            b=min+random.nextInt(max);
        }
        for(int i=0;i<=15;i++)
        {
            t[i].setText("");
            p[i]=t[i].getText().toString();
            ps[i]=t[i].getText().toString();
            t[i].setBackgroundColor(Color.parseColor("#FFECF0DF"));
        }
        if((k+a)%4==0)
        {
            t[a].setText("4");
            p[a]=t[a].getText().toString();
            ps[a]=t[a].getText().toString();
            t[a].setTextColor(Color.parseColor("#494844"));
            t[a].setBackgroundColor(Color.parseColor("#fef8f4d5"));
        }
        else
        {
            //#ffffff
            t[a].setTextColor(Color.parseColor("#494844"));
            t[a].setBackgroundColor(Color.parseColor("#ffffff"));
            t[a].setText("2");
            p[a]=t[a].getText().toString();
            ps[a]=t[a].getText().toString();
        }
        if((k+b)%8==0)
        {
            t[b].setTextColor(Color.parseColor("#494844"));
            t[b].setBackgroundColor(Color.parseColor("#fef8f4d5"));
            t[b].setText("4");
            p[b]=t[b].getText().toString();
            ps[b]=t[b].getText().toString();
        }
        else
        {
            t[b].setTextColor(Color.parseColor("#494844"));
            t[b].setBackgroundColor(Color.parseColor("#ffffff"));
            t[b].setText("2");
            p[b]=t[b].getText().toString();
            ps[b]=t[b].getText().toString();
        }}


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset.setBackgroundColor(Color.parseColor("#b0a3a3"));
                for(int i=0;i<=15;i++)
                {
                    t[i].setText(ps[i]);
                }
                set_colour();
                score__1();
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset.setBackgroundColor(Color.parseColor("#b0a3a3"));
                AlertDialog.Builder a_builder=new AlertDialog.Builder(MainActivity.this);
                a_builder.setMessage("do yo want to reset?")
                        .setCancelable(false)
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                score.setText("0");
                                dialogInterface.cancel();
                                int min=0;
                                int max=16;
                                Random random=new Random();
                                int a=min+random.nextInt(max);
                                int b=min+random.nextInt(max);

                                while(a==b)
                                {
                                    k++;
                                    b=min+random.nextInt(max);
                                }
                                for(i=0;i<=15;i++)
                                {
                                    t[i].setText("");
                                    p[i]=t[i].getText().toString();
                                    t[i].setBackgroundColor(Color.parseColor("#FFECF0DF"));
                                }
                                if((k+a)%4==0)
                                {
                                    t[a].setText("4");
                                    p[a]=t[a].getText().toString();
                                    t[a].setTextColor(Color.parseColor("#494844"));
                                    t[a].setBackgroundColor(Color.parseColor("#fef8f4d5"));
                                }
                                else
                                {
                                    //#ffffff
                                    t[a].setTextColor(Color.parseColor("#494844"));
                                    t[a].setBackgroundColor(Color.parseColor("#ffffff"));
                                    t[a].setText("2");
                                    p[a]=t[a].getText().toString();
                                }
                                if((k+b)%8==0)
                                {
                                    t[b].setTextColor(Color.parseColor("#494844"));
                                    t[b].setBackgroundColor(Color.parseColor("#fef8f4d5"));
                                    t[b].setText("4");
                                    p[b]=t[b].getText().toString();
                                }
                                else
                                {
                                    t[b].setTextColor(Color.parseColor("#494844"));
                                    t[b].setBackgroundColor(Color.parseColor("#ffffff"));
                                    t[b].setText("2");
                                    p[b]=t[b].getText().toString();
                                }
                                for(i=0;i<=15;i++)
                                {
                                    ps[i]=p[i];
                                }
                            }
                        })
                        .setNegativeButton("no", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                dialogInterface.cancel();
                            }
                        });
                AlertDialog alert=a_builder.create();
                alert.setTitle("Restart??");
                alert.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                alert.show();


            }
        });


    }
    public void score__1() {
        int[] arr2=new int[10001];
        int sum = 0;
        for(int i=0;i<=10000;i++)
        {
            arr[i]=0;
            arr2[i]=0;
        }
        for(int i=0;i<=15;i++)
        {
            String w=t[i].getText().toString();
            if(!w.equals("")){
                int ww=Integer.parseInt(w);
                arr[ww]++;
                sum=sum+ww;
            }

        }
        for(int i=0;i<=15;i++)
        {
            String w=ps[i].toString();
            if(!w.equals("")){
                int ww=Integer.parseInt(w);
                arr2[ww]++;
            }

        }
         sw=((arr[2]-arr2[2])*2+(arr[4]-arr2[4])*4+(arr[8]-arr2[8])*8+(arr[16]-arr2[16])*16+(arr[32]-arr2[32])*32+
                (arr[64]-arr2[64])*64+(arr[128]-arr2[128])*128+(arr[256]-arr2[256])*256+(arr[512]-arr2[512])*512+(arr[1024]-arr2[1024])*1024+
                 (arr[2048]-arr2[2048])*2048+(arr[4096]-arr2[4096])*4096+(arr[8192]-arr2[8192])*8192)+sum*2;

//                (arr[2048]-arr2[2048])+(arr[4096]-arr2[4096])+(arr[8192]-arr2[8192])+(arr[16384]-arr2[16384])+(arr[32768]-arr2[32768])+
//                (arr[65536]-arr2[65536])+(arr[131072]-arr2[131072])+(arr[262144]-arr2[262144]))*2;
        String ss=Integer.toString(sw);
        score.setText("score"+"\n"+ss);


    }
    public void method(int aa,int bb,int cc,int dd)
    {
        String s1=t[aa].getText().toString();
        String s2=t[bb].getText().toString();
        String s3=t[cc].getText().toString();
        String s4=t[dd].getText().toString();
        //view.setText("up");
        //up
        if(s1.equals("") && s2.equals("") && s3.equals("") && s4.equals(""))
        {

        }
        else if(s1.equals("") && s2.equals("") && s3.equals("") && !s4.equals(""))
        {
            String ab=t[dd].getText().toString();
            t[dd].setText("");
            t[aa].setText(ab);
        }
        else
        if(s1.equals("") && s2.equals("") && !s3.equals("") && s4.equals(""))
        {
            String ab=t[cc].getText().toString();
            t[cc].setText("");
            t[aa].setText(ab);
        }
        else
        if(s1.equals("") && !s2.equals("") && s3.equals("") && s4.equals(""))
        {
            String ab=t[bb].getText().toString();
            t[bb].setText("");
            t[aa].setText(ab);
        }
        else
        if(!s1.equals("") && s2.equals("") && s3.equals("") && s4.equals(""))
        {

        }
        else
        if(!s1.equals("") && !s2.equals("") && s3.equals("") && s4.equals(""))
        {
            String ab=t[aa].getText().toString();
            String bc=t[bb].getText().toString();
            t[aa].setText("");
            t[bb].setText("");
            Integer i1=Integer.parseInt(ab);
            Integer i2=Integer.parseInt(bc);
            if(ab.equals(bc))
            {
                Integer i3=i1+i2;
                t[aa].setText(i3.toString());
            }
            else
            {
                t[aa].setText(ab);
                t[bb].setText(bc);
            }
        }
        else
        if(!s1.equals("") && s2.equals("") && !s3.equals("") && s4.equals(""))
        {
            String ab=t[aa].getText().toString();
            String bc=t[cc].getText().toString();
            t[aa].setText("");
            t[cc].setText("");
            Integer i1=Integer.parseInt(ab);
            Integer i2=Integer.parseInt(bc);
            if(ab.equals(bc))
            {
                Integer i3=i1+i2;
                t[aa].setText(i3.toString());
            }
            else
            {
                t[aa].setText(ab);
                t[bb].setText(bc);
            }
        }
        else
        if(!s1.equals("") && s2.equals("") && s3.equals("") && !s4.equals(""))
        {
            String ab=t[aa].getText().toString();
            String bc=t[dd].getText().toString();
            t[aa].setText("");
            t[dd].setText("");
            Integer i1=Integer.parseInt(ab);
            Integer i2=Integer.parseInt(bc);
            if(ab.equals(bc))
            {
                Integer i3=i1+i2;
                t[aa].setText(i3.toString());
            }
            else
            {
                t[aa].setText(ab);
                t[bb].setText(bc);
            }
        }
        else
        if(s1.equals("") && !s2.equals("") && !s3.equals("") && s4.equals(""))
        {
            String ab=t[bb].getText().toString();
            String bc=t[cc].getText().toString();
            t[bb].setText("");
            t[cc].setText("");
            Integer i1=Integer.parseInt(ab);
            Integer i2=Integer.parseInt(bc);
            if(ab.equals(bc))
            {
                Integer i3=i1+i2;
                t[aa].setText(i3.toString());
            }
            else
            {
                t[aa].setText(ab);
                t[bb].setText(bc);
            }
        }
        else
        if(s1.equals("") && !s2.equals("") && s3.equals("") && !s4.equals(""))
        {
            String ab=t[bb].getText().toString();
            String bc=t[dd].getText().toString();
            t[bb].setText("");
            t[dd].setText("");
            Integer i1=Integer.parseInt(ab);
            Integer i2=Integer.parseInt(bc);
            if(ab.equals(bc))
            {
                Integer i3=i1+i2;
                t[aa].setText(i3.toString());
            }
            else
            {
                t[aa].setText(ab);
                t[bb].setText(bc);
            }
        }
        else
        if(s1.equals("") && s2.equals("") && !s3.equals("") && !s4.equals(""))
        {
            String ab=t[cc].getText().toString();
            String bc=t[dd].getText().toString();
            t[cc].setText("");
            t[dd].setText("");
            Integer i1=Integer.parseInt(ab);
            Integer i2=Integer.parseInt(bc);
            if(ab.equals(bc))
            {
                Integer i3=i1+i2;
                t[aa].setText(i3.toString());
            }
            else
            {
                t[aa].setText(ab);
                t[bb].setText(bc);
            }
        }
        else
        if(!s1.equals("") && !s2.equals("") && !s3.equals("") && s4.equals(""))
        {
            String ab=t[aa].getText().toString();
            String bc=t[bb].getText().toString();
            String cd=t[cc].getText().toString();
            t[aa].setText("");
            t[bb].setText("");
            t[cc].setText("");
            Integer i1=Integer.parseInt(ab);
            Integer i2=Integer.parseInt(bc);
            Integer i4=Integer.parseInt(cd);
            if(ab.equals(bc))
            {
                Integer i3=i1+i2;
                t[aa].setText(i3.toString());
                t[bb].setText(i4.toString());
            }
            else
            {
                if(bc.equals(cd))
                {
                    t[aa].setText(ab);
                    Integer i3=i2+i4;
                    t[bb].setText(i3.toString());
                }
                else
                {
                    t[aa].setText(ab);
                    t[bb].setText(bc);
                    t[cc].setText(cd);
                }
            }
        }
        else
        if(!s1.equals("") && !s2.equals("") && s3.equals("") && !s4.equals(""))
        {
            String ab=t[aa].getText().toString();
            String bc=t[bb].getText().toString();
            String cd=t[dd].getText().toString();
            t[aa].setText("");
            t[bb].setText("");
            t[dd].setText("");
            Integer i1=Integer.parseInt(ab);
            Integer i2=Integer.parseInt(bc);
            Integer i4=Integer.parseInt(cd);
            if(ab.equals(bc))
            {
                Integer i3=i1+i2;
                t[aa].setText(i3.toString());
                t[bb].setText(i4.toString());
            }
            else
            {
                if(bc.equals(cd))
                {
                    t[aa].setText(ab);
                    Integer i3=i2+i4;
                    t[bb].setText(i3.toString());
                }
                else
                {
                    t[aa].setText(ab);
                    t[bb].setText(bc);
                    t[cc].setText(cd);
                }
            }
        }
        else
        if(!s1.equals("") && s2.equals("") && !s3.equals("") && !s4.equals(""))
        {
            String ab=t[aa].getText().toString();
            String bc=t[cc].getText().toString();
            String cd=t[dd].getText().toString();
            t[aa].setText("");
            t[cc].setText("");
            t[dd].setText("");
            Integer i1=Integer.parseInt(ab);
            Integer i2=Integer.parseInt(bc);
            Integer i4=Integer.parseInt(cd);
            if(ab.equals(bc))
            {
                Integer i3=i1+i2;
                t[aa].setText(i3.toString());
                t[bb].setText(i4.toString());
            }
            else
            {
                if(bc.equals(cd))
                {
                    t[aa].setText(ab);
                    Integer i3=i2+i4;
                    t[bb].setText(i3.toString());
                }
                else
                {
                    t[aa].setText(ab);
                    t[bb].setText(bc);
                    t[cc].setText(cd);
                }
            }
        }
        else
        if(s1.equals("") && !s2.equals("") && !s3.equals("") && !s4.equals(""))
        {
            String ab=t[bb].getText().toString();
            String bc=t[cc].getText().toString();
            String cd=t[dd].getText().toString();
            t[bb].setText("");
            t[cc].setText("");
            t[dd].setText("");
            Integer i1=Integer.parseInt(ab);
            Integer i2=Integer.parseInt(bc);
            Integer i4=Integer.parseInt(cd);
            if(ab.equals(bc))
            {
                Integer i3=i1+i2;
                t[aa].setText(i3.toString());
                t[bb].setText(i4.toString());
            }
            else
            {
                if(bc.equals(cd))
                {
                    t[aa].setText(ab);
                    Integer i3=i2+i4;
                    t[bb].setText(i3.toString());
                }
                else
                {
                    t[aa].setText(ab);
                    t[bb].setText(bc);
                    t[cc].setText(cd);
                }
            }
        }
        else
        {
            String ab=t[aa].getText().toString();
            String bc=t[bb].getText().toString();
            String cd=t[cc].getText().toString();
            String de=t[dd].getText().toString();
            t[aa].setText("");
            t[bb].setText("");
            t[cc].setText("");
            t[dd].setText("");
            Integer i1=Integer.parseInt(ab);
            Integer i2=Integer.parseInt(bc);
            Integer i3=Integer.parseInt(cd);
            Integer i4=Integer.parseInt(de);
            if(ab.equals(bc))
            {
                Integer i5=i1+i2;
                t[aa].setText(i5.toString());
                if(cd.equals(de))
                {
                    Integer i6=i3+i4;
                    t[bb].setText(i6.toString());
                }
                else
                {
                    t[bb].setText(cd);
                    t[cc].setText(de);
                }
            }
            else
            {
                t[aa].setText(ab);
                if(bc.equals(cd))
                {
                    Integer i7=i2+i3;
                    t[bb].setText(i7.toString());
                    t[cc].setText(de);
                }
                else
                {
                    t[bb].setText(bc);
                    if(cd.equals(de))
                    {
                        Integer i8=i3+i4;
                        t[cc].setText(i8.toString());
                    }
                    else
                    {
                        t[cc].setText(cd);
                        t[dd].setText(de);
                    }
                }
            }
        }
    }
    public void set_colour()
    {
        for(int i=0;i<=15;i++)
        {
            String sa=t[i].getText().toString();

            if(sa.equals(""))
            {
                t[i].setBackgroundColor(Color.parseColor("#FFECF0DF"));
            }
            else
            if(sa.equals("2"))
            {
                t[i].setBackgroundColor(Color.parseColor("#ffffff"));
            }
            else
            if(sa.equals("4"))
            {
                t[i].setBackgroundColor(Color.parseColor("#fef8f4d5"));
            }
            else
            if(sa.equals("8"))
            {
                t[i].setBackgroundColor(Color.parseColor("#ecad86"));
            }
            else
            if(sa.equals("16"))
            {
                t[i].setBackgroundColor(Color.parseColor("#e27c3c"));
            }
            else
            if(sa.equals("32"))
            {
                t[i].setBackgroundColor(Color.parseColor("#ee7676"));
            }
            else
            if(sa.equals("64"))
            {
                t[i].setBackgroundColor(Color.parseColor("#fb020e"));
            }
            else
            if(sa.equals("128"))
            {
                t[i].setBackgroundColor(Color.parseColor("#f3f182"));
            }
            else
            if(sa.equals("256"))
            {
                t[i].setBackgroundColor(Color.parseColor("#ebdc3d"));
            }
            else
            if(sa.equals("512"))
            {
                t[i].setBackgroundColor(Color.parseColor("#fcfc03"));
            }
            else
            if(sa.equals("1024"))
            {
                t[i].setBackgroundColor(Color.parseColor("#a9f60e"));
            }
            else
            if(sa.equals("2048"))
            {
                t[i].setBackgroundColor(Color.parseColor("#0fee26"));
            }
            else
            if(sa.equals("4096"))
            {
                t[i].setBackgroundColor(Color.parseColor("#8e9594"));
            }
            else
            if(sa.equals("8192"))
            {
                t[i].setBackgroundColor(Color.parseColor("#494844"));
            }
            else
            if(sa.equals("16384"))
            {
                t[i].setBackgroundColor(Color.parseColor("#418fce"));
            }
            else
            if(sa.equals("32768"))
            {
                t[i].setBackgroundColor(Color.parseColor("#2269d3"));
            }
            else
            if(sa.equals("65536"))
            {
                t[i].setBackgroundColor(Color.parseColor("#2205fa"));
            }
            else
            if(sa.equals("131072"))
            {
                t[i].setBackgroundColor(Color.parseColor("#FF8E04F7"));
            }

            if(sa.equals("2")||sa.equals("4"))
            {
                t[i].setTextColor(Color.parseColor("#494844"));
            }
            else
            {
                t[i].setTextColor(Color.parseColor("#ffffff"));
            }

        }
    }
    public void generate_no()
    {
        int count=0;
        for(int i=0;i<=15;i++)
        {
            String sq=t[i].getText().toString();
            if(!sq.equals(p[i]))
            {
                count=1;
            }
        }
        //generate number
        if(count==1) {
            for(int i=0;i<=15;i++)
            {
                ps[i]=p[i];
            }
            int min = 0;
            int max = 16;
            Random random = new Random();
            int a = min + random.nextInt(max);
            String ss = t[a].getText().toString();
            while (!ss.equals("")) {
                k++;
                a = min + random.nextInt(max);
                ss = t[a].getText().toString();
            }
            if ((k + a) % 4 == 0) {

                t[a].setBackgroundColor(Color.parseColor("#fef8f4d5"));
                t[a].setText("4");
                t[a].setTextColor(Color.parseColor("#494844"));
            } else {
                t[a].setBackgroundColor(Color.parseColor("#ffffff"));
                t[a].setText("2");
                t[a].setTextColor(Color.parseColor("#494844"));
            }
        }
        for(int i=0;i<=15;i++)
        {
            p[i]=t[i].getText().toString();
        }
        int count1=0;
        for(int i=0;i<=15;i++)
        {
            if(p[i].equals(""))
            {
                count1=1;
            }
        }

        if(!p[0].equals(p[4])&&!p[1].equals(p[5])&& !p[2].equals(p[6])&&!p[3].equals(p[7])&&
                !p[8].equals(p[4])&&!p[9].equals(p[5])&& !p[10].equals(p[6])&&!p[11].equals(p[7])&&
                !p[8].equals(p[12])&&!p[9].equals(p[13])&& !p[10].equals(p[14])&&!p[11].equals(p[15])&&
                !p[0].equals(p[1])&&!p[4].equals(p[5])&& !p[8].equals(p[9])&&!p[12].equals(p[13])&&
                !p[2].equals(p[1])&&!p[6].equals(p[5])&& !p[10].equals(p[9])&&!p[14].equals(p[13])&&
                !p[2].equals(p[3])&&!p[6].equals(p[7])&& !p[10].equals(p[11])&&!p[14].equals(p[15])&&count1==0
                )
        {
            Toast.makeText(MainActivity.this, "GameOver!!", Toast.LENGTH_SHORT).show();
//                    AlertDialog alert = null;
//                    alert.setTitle("GameOver!!");
//                    alert.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                    alert.show();
            reset.setBackgroundColor(Color.parseColor("#fcfc03"));
        }
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent event) {
        //v1.setText("onSingleTapConfirmed"+event.toString());
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent event) {
        //v1.setText("onDoubleTap"+event.toString());
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent event) {
        //v1.setText("onDoubleTapEvent"+event.toString());
        return false;
    }

    @Override
    public boolean onDown(MotionEvent event) {
        //v1.setText("onDown"+event.toString());
        return false;
    }

    @Override
    public void onShowPress(MotionEvent event) {
        //v1.setText("onShowPress"+event.toString());

    }

    @Override
    public boolean onSingleTapUp(MotionEvent event) {
        //v1.setText("onSingleTapUp"+event.toString());
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent event1, MotionEvent event2, float v, float v2) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent event) {
        //v1.setText("onLongPress"+event.toString());

    }


    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2, float v, float v2) {
        float x1,x2,y1,y2;
        x1=event1.getX();
        x2=event2.getX();
        y1=event1.getY();
        y2=event2.getY();
        if(y1-y2>100)
        {
            for(int i=0;i<=15;i++)
            {
                p[i]=t[i].getText().toString();
            }
            Toast.makeText(MainActivity.this, "UP", Toast.LENGTH_SHORT).show();

            //1st column
            method(0,4,8,12);
            //2nd column
            method(1,5,9,13);
            // 3rd column
            method(2,6,10,14);
//            // 4th column;
            method(3,7,11,15);

            set_colour();

            generate_no();
            score__1();



        }

        else if(y2-y1>200)
        {
            for(int i=0;i<=15;i++)
            {
                p[i]=t[i].getText().toString();
            }

            Toast.makeText(MainActivity.this, "DOWN", Toast.LENGTH_SHORT).show();
            //view.setText("down");
            //down
            method(12,8,4,0);

            //2nd column
            method(13,9,5,1);

            // 3rd column
            method(14,10,6,2);

//            // 4th column;
            method(15,11,7,3);

            set_colour();

            generate_no();
            score__1();

        }

        else if(x1-x2 >100)
        {
            for(int i=0;i<=15;i++)
            {
                p[i]=t[i].getText().toString();
            }
            Toast.makeText(MainActivity.this, "LEFT", Toast.LENGTH_SHORT).show();

            method(0,1,2,3);

            //2nd column
            method(4,5,6,7);

            // 3rd column
            method(8,9,10,11);

            // 4th column;
            method(12,13,14,15);

            set_colour();

            generate_no();

            score__1();


            //view.setText("left");
            //left
        }
        else if(x2-x1 >100)
        {
            for(int i=0;i<=15;i++)
            {
                p[i]=t[i].getText().toString();
            }

            Toast.makeText(MainActivity.this, "RIGHT", Toast.LENGTH_SHORT).show();
            method(3,2,1,0);

            //2nd column
            method(7,6,5,4);

            // 3rd column
            method(11,10,9,8);

//            // 4th column;
            method(15,14,13,12);

            set_colour();

            generate_no();
            score__1();

            //view.setText("right");
            //right
        }

        //v1.setText("onFling"+event1.toString()+event2.toString());
        return false;
    }


}

