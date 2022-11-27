package com.abhi.Chargify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.transition.Fade;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

public class homeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        View back , card1 ,card2 , reset;
        TextView connect,fr;
        final int[] freqSent = new int[1];
        SeekBar freq;
        View a1,a2,a3,a4,a5,a6,a7,a8,b1,b2,b3,b4,b5,b6,b7,b8,c1,c2,c3,c4,c5,c6,c7,c8,d1,d2,d3,d4,d5,d6,d7,d8,e1,e2,e3,e4,e5,e6,e7,e8,f1,f2,f3,f4,f5,f6,f7,f8,g1,g2,g3,g4,g5,g6,g7,g8,h1,h2,h3,h4,h5,h6,h7,h8;
        int[][] a = {{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}};
        byte[] b ={0,0,0,0,0,0,0,0};
        final UUID mUUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
        boolean [][] active = {{false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false}};

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Fade fade = new Fade();
        View decor = getWindow().getDecorView();
        fade.excludeTarget(R.id.clayout,true);
        fade.excludeTarget(R.id.splash_layout,true);
        fade.excludeTarget(android.R.id.navigationBarBackground,true);
        fade.excludeTarget(android.R.id.statusBarBackground,true);
        getWindow().setEnterTransition(fade);
        getWindow().setExitTransition(fade);

        // Bluetooth Adapter
        if (ContextCompat.checkSelfPermission(homeActivity.this, Manifest.permission.BLUETOOTH_CONNECT) == PackageManager.PERMISSION_DENIED)
        {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S)
            {
                ActivityCompat.requestPermissions(homeActivity.this, new String[]{Manifest.permission.BLUETOOTH_CONNECT}, 2);
                return;
            }
        }
        BluetoothAdapter btAdapter = BluetoothAdapter.getDefaultAdapter();

        BluetoothDevice hc05 = btAdapter.getRemoteDevice("00:22:03:01:72:C4");

        BluetoothSocket btSocket = null;
        int counter = 0;
        do {
            try {
                btSocket = hc05.createRfcommSocketToServiceRecord(mUUID);
                btSocket.connect();
            } catch (IOException e) {
                e.printStackTrace();
            }
            counter++;
        }while(!btSocket.isConnected() && counter < 3);






        back = findViewById(R.id.back);
        card1 = findViewById(R.id.bbox);
        card2 = findViewById(R.id.bbox2);
        back.animate().alpha(0f).setDuration(1000);
        card1.animate().alpha(1f).setDuration(2000);
        card2.animate().alpha(1f).setDuration(2000);
        reset = findViewById(R.id.add);
        //Grid Control
        connect = findViewById(R.id.connect);
        freq = findViewById(R.id.freq);
        fr = findViewById(R.id.fr);
        a1 = findViewById(R.id.a1);
        a2 = findViewById(R.id.a2);
        a3 = findViewById(R.id.a3);
        a4 = findViewById(R.id.a4);
        a5 = findViewById(R.id.a5);
        a6 = findViewById(R.id.a6);
        a7 = findViewById(R.id.a7);
        a8 = findViewById(R.id.a8);

        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);

        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);
        c3 = findViewById(R.id.c3);
        c4 = findViewById(R.id.c4);
        c5 = findViewById(R.id.c5);
        c6 = findViewById(R.id.c6);
        c7 = findViewById(R.id.c7);
        c8 = findViewById(R.id.c8);

        d1 = findViewById(R.id.d1);
        d2 = findViewById(R.id.d2);
        d3 = findViewById(R.id.d3);
        d4 = findViewById(R.id.d4);
        d5 = findViewById(R.id.d5);
        d6 = findViewById(R.id.d6);
        d7 = findViewById(R.id.d7);
        d8 = findViewById(R.id.d8);

        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        e3 = findViewById(R.id.e3);
        e4 = findViewById(R.id.e4);
        e5 = findViewById(R.id.e5);
        e6 = findViewById(R.id.e6);
        e7 = findViewById(R.id.e7);
        e8 = findViewById(R.id.e8);

        f1 = findViewById(R.id.f1);
        f2 = findViewById(R.id.f2);
        f3 = findViewById(R.id.f3);
        f4 = findViewById(R.id.f4);
        f5 = findViewById(R.id.f5);
        f6 = findViewById(R.id.f6);
        f7 = findViewById(R.id.f7);
        f8 = findViewById(R.id.f8);

        g1 = findViewById(R.id.g1);
        g2 = findViewById(R.id.g2);
        g3 = findViewById(R.id.g3);
        g4 = findViewById(R.id.g4);
        g5 = findViewById(R.id.g5);
        g6 = findViewById(R.id.g6);
        g7 = findViewById(R.id.g7);
        g8 = findViewById(R.id.g8);

        h1 = findViewById(R.id.h1);
        h2 = findViewById(R.id.h2);
        h3 = findViewById(R.id.h3);
        h4 = findViewById(R.id.h4);
        h5 = findViewById(R.id.h5);
        h6 = findViewById(R.id.h6);
        h7 = findViewById(R.id.h7);
        h8 = findViewById(R.id.h8);
        System.out.println("clicked");

        //
        Drawable circle = getDrawable(R.drawable.circle2);
        Drawable circle0 = getDrawable(R.drawable.circle);



        BluetoothSocket  finalBtSocket = btSocket;

        freq.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                fr.setText(String.valueOf(Math.pow(10,3-progress))+"HZ");
                freqSent[0] = progress+65;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                arUpdate(finalBtSocket,freqSent[0]);
            }
        });
        card1.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                float w = (card1.getWidth()-40)/8;
                float h = (card1.getHeight()-40)/8;

                if (event.getX() > 20 && event.getX() < -10+20+w  && event.getY() > 10+20 && event.getY() < -10+20+h && !active[0][0]){a1.setBackground(circle);active[0][0] = true;arUpdate(finalBtSocket,1);}
                if (event.getX() > 10+20+w && event.getX() < -10+20+2*w && event.getY() > 10+20 && event.getY() < -10+20+h && !active[0][1]){a2.setBackground(circle);active[0][1] = true;arUpdate(finalBtSocket,2);}
                if (event.getX() > 10+20+2*w && event.getX() < -10+20+3*w && event.getY() > 10+20 && event.getY() < -10+20+h && !active[0][2]){a3.setBackground(circle);active[0][2] = true;arUpdate(finalBtSocket,3);}
                if (event.getX() > 10+20+3*w && event.getX() < -10+20+4*w && event.getY() > 10+20 && event.getY() < -10+20+h && !active[0][3]){a4.setBackground(circle);active[0][3] = true;arUpdate(finalBtSocket,4);}
                if (event.getX() > 10+20+4*w && event.getX() < -10+20+5*w && event.getY() > 10+20 && event.getY() < -10+20+h && !active[0][4]){a5.setBackground(circle);active[0][4] = true;arUpdate(finalBtSocket,5);}
                if (event.getX() > 10+20+5*w && event.getX() < -10+20+6*w && event.getY() > 10+20 && event.getY() < -10+20+h && !active[0][5]){a6.setBackground(circle);active[0][5] = true;arUpdate(finalBtSocket,6);}
                if (event.getX() > 10+20+6*w && event.getX() < -10+20+7*w && event.getY() > 10+20 && event.getY() < -10+20+h && !active[0][6]){a7.setBackground(circle);active[0][6] = true;arUpdate(finalBtSocket,7);}
                if (event.getX() > 10+20+7*w && event.getX() < -10+20+8*w && event.getY() > 10+20 && event.getY() < -10+20+h && !active[0][7]){a8.setBackground(circle);active[0][7] = true;arUpdate(finalBtSocket,8);}

                if (event.getX() > 10+20 && event.getX() < -10+20+w  && event.getY() > 10+20+h && event.getY() < -10+20+2*h && !active[1][0]){b1.setBackground(circle);active[1][0] = true;arUpdate(finalBtSocket,9);}
                if (event.getX() > 10+20+w && event.getX() < -10+20+2*w && event.getY() > 10+20+h && event.getY() < -10+20+2*h && !active[1][1]){b2.setBackground(circle);active[1][1] = true;arUpdate(finalBtSocket,10);}
                if (event.getX() > 10+20+2*w && event.getX() < -10+20+3*w && event.getY() > 10+20+h && event.getY() < -10+20+2*h && !active[1][2]){b3.setBackground(circle);active[1][2] = true;arUpdate(finalBtSocket,11);}
                if (event.getX() > 10+20+3*w && event.getX() < -10+20+4*w && event.getY() > 10+20+h && event.getY() < -10+20+2*h && !active[1][3]){b4.setBackground(circle);active[1][3] = true;arUpdate(finalBtSocket,12);}
                if (event.getX() > 10+20+4*w && event.getX() < -10+20+5*w && event.getY() > 10+20+h && event.getY() < -10+20+2*h && !active[1][4]){b5.setBackground(circle);active[1][4] = true;arUpdate(finalBtSocket,13);}
                if (event.getX() > 10+20+5*w && event.getX() < -10+20+6*w && event.getY() > 10+20+h && event.getY() < -10+20+2*h && !active[1][5]){b6.setBackground(circle);active[1][5] = true;arUpdate(finalBtSocket,14);}
                if (event.getX() > 10+20+6*w && event.getX() < -10+20+7*w && event.getY() > 10+20+h && event.getY() < -10+20+2*h && !active[1][6]){b7.setBackground(circle);active[1][6] = true;arUpdate(finalBtSocket,15);}
                if (event.getX() > 10+20+7*w && event.getX() < -10+20+8*w && event.getY() > 10+20+h && event.getY() < -10+20+2*h && !active[1][7]){b8.setBackground(circle);active[1][7] = true;arUpdate(finalBtSocket,16);}

                if (event.getX() > 10+20 && event.getX() < -10+20+w  && event.getY() > 10+20+2*h && event.getY() < -10+20+3*h && !active[2][0]){c1.setBackground(circle);active[2][0] = true;arUpdate(finalBtSocket,17);}
                if (event.getX() > 10+20+w && event.getX() < -10+20+2*w && event.getY() > 10+20+2*h && event.getY() < -10+20+3*h && !active[2][1]){c2.setBackground(circle);active[2][1] = true;arUpdate(finalBtSocket,18);}
                if (event.getX() > 10+20+2*w && event.getX() < -10+20+3*w && event.getY() > 10+20+2*h && event.getY() < -10+20+3*h && !active[2][2]){c3.setBackground(circle);active[2][2] = true;arUpdate(finalBtSocket,19);}
                if (event.getX() > 10+20+3*w && event.getX() < -10+20+4*w && event.getY() > 10+20+2*h && event.getY() < -10+20+3*h && !active[2][3]){c4.setBackground(circle);active[2][3] = true;arUpdate(finalBtSocket,20);}
                if (event.getX() > 10+20+4*w && event.getX() < -10+20+5*w && event.getY() > 10+20+2*h && event.getY() < -10+20+3*h && !active[2][4]){c5.setBackground(circle);active[2][4] = true;arUpdate(finalBtSocket,21);}
                if (event.getX() > 10+20+5*w && event.getX() < -10+20+6*w && event.getY() > 10+20+2*h && event.getY() < -10+20+3*h && !active[2][5]){c6.setBackground(circle);active[2][5] = true;arUpdate(finalBtSocket,22);}
                if (event.getX() > 10+20+6*w && event.getX() < -10+20+7*w && event.getY() > 10+20+2*h && event.getY() < -10+20+3*h && !active[2][6]){c7.setBackground(circle);active[2][6] = true;arUpdate(finalBtSocket,23);}
                if (event.getX() > 10+20+7*w && event.getX() < -10+20+8*w && event.getY() > 10+20+2*h && event.getY() < -10+20+3*h && !active[2][7]){c8.setBackground(circle);active[2][7] = true;arUpdate(finalBtSocket,24);}

                if (event.getX() > 10+20 && event.getX() < -10+20+w  && event.getY() > 10+20+3*h && event.getY() < -10+20+4*h && !active[3][0]){d1.setBackground(circle);active[3][0] = true;arUpdate(finalBtSocket,25);}
                if (event.getX() > 10+20+w && event.getX() < -10+20+2*w && event.getY() > 10+20+3*h && event.getY() < -10+20+ 4*h && !active[3][1]){d2.setBackground(circle);active[3][1] = true;arUpdate(finalBtSocket,26);}
                if (event.getX() > 10+20+2*w && event.getX() < -10+20+3*w && event.getY() > 10+20+3*h && event.getY() < -10+20+ 4*h && !active[3][2]){d3.setBackground(circle);active[3][2] = true;arUpdate(finalBtSocket,27);}
                if (event.getX() > 10+20+3*w && event.getX() < -10+20+4*w && event.getY() > 10+20+3*h && event.getY() < -10+20+ 4*h && !active[3][3]){d4.setBackground(circle);active[3][3] = true;arUpdate(finalBtSocket,28);}
                if (event.getX() > 10+20+4*w && event.getX() < -10+20+5*w && event.getY() > 10+20+3*h && event.getY() < -10+20+ 4*h && !active[3][4]){d5.setBackground(circle);active[3][4] = true;arUpdate(finalBtSocket,29);}
                if (event.getX() > 10+20+5*w && event.getX() < -10+20+6*w && event.getY() > 10+20+3*h && event.getY() < -10+20+ 4*h && !active[3][5]){d6.setBackground(circle);active[3][5] = true;arUpdate(finalBtSocket,30);}
                if (event.getX() > 10+20+6*w && event.getX() < -10+20+7*w && event.getY() > 10+20+3*h && event.getY() < -10+20+ 4*h && !active[3][6]){d7.setBackground(circle);active[3][6] = true;arUpdate(finalBtSocket,31);}
                if (event.getX() > 10+20+7*w && event.getX() < -10+20+8*w && event.getY() > 10+20+3*h && event.getY() < -10+20+ 4*h && !active[3][7]){d8.setBackground(circle);active[3][7] = true;arUpdate(finalBtSocket,32);}

                if (event.getX() > 10+20 && event.getX() < -10+20+w  && event.getY() > 10+20+4*h && event.getY() < -10+20+5*h && !active[4][0]){e1.setBackground(circle);active[4][0] = true;arUpdate(finalBtSocket,33);}
                if (event.getX() > 10+20+w && event.getX() < -10+20+2*w && event.getY() > 10+20+4*h && event.getY() < -10+20+5*h && !active[4][1]){e2.setBackground(circle);active[4][1] = true;arUpdate(finalBtSocket,34);}
                if (event.getX() > 10+20+2*w && event.getX() < -10+20+3*w && event.getY() > 10+20+4*h && event.getY() < -10+20+5*h && !active[4][2]){e3.setBackground(circle);active[4][2] = true;arUpdate(finalBtSocket,35);}
                if (event.getX() > 10+20+3*w && event.getX() < -10+20+4*w && event.getY() > 10+20+4*h && event.getY() < -10+20+5*h && !active[4][3]){e4.setBackground(circle);active[4][3] = true;arUpdate(finalBtSocket,36);}
                if (event.getX() > 10+20+4*w && event.getX() < -10+20+5*w && event.getY() > 10+20+4*h && event.getY() < -10+20+5*h && !active[4][4]){e5.setBackground(circle);active[4][4] = true;arUpdate(finalBtSocket,37);}
                if (event.getX() > 10+20+5*w && event.getX() < -10+20+6*w && event.getY() > 10+20+4*h && event.getY() < -10+20+5*h && !active[4][5]){e6.setBackground(circle);active[4][5] = true;arUpdate(finalBtSocket,38);}
                if (event.getX() > 10+20+6*w && event.getX() < -10+20+7*w && event.getY() > 10+20+4*h && event.getY() < -10+20+5*h && !active[4][6]){e7.setBackground(circle);active[4][6] = true;arUpdate(finalBtSocket,39);}
                if (event.getX() > 10+20+7*w && event.getX() < -10+20+8*w && event.getY() > 10+20+4*h && event.getY() < -10+20+5*h && !active[4][7]){e8.setBackground(circle);active[4][7] = true;arUpdate(finalBtSocket,40);}

                if (event.getX() > 10+20 && event.getX() < -10+20+w  && event.getY() > 10+20+5*h && event.getY() < -10+20+6*h && !active[5][0]){f1.setBackground(circle);active[5][0] = true;arUpdate(finalBtSocket,41);}
                if (event.getX() > 10+20+w && event.getX() < -10+20+2*w && event.getY() > 10+20+5*h && event.getY() < -10+20+6*h && !active[5][1]){f2.setBackground(circle);active[5][1] = true;arUpdate(finalBtSocket,42);}
                if (event.getX() > 10+20+2*w && event.getX() < -10+20+3*w && event.getY() > 10+20+5*h && event.getY() < -10+20+6*h && !active[5][2]){f3.setBackground(circle);active[5][2] = true;arUpdate(finalBtSocket,43);}
                if (event.getX() > 10+20+3*w && event.getX() < -10+20+4*w && event.getY() > 10+20+5*h && event.getY() < -10+20+6*h && !active[5][3]){f4.setBackground(circle);active[5][3] = true;arUpdate(finalBtSocket,44);}
                if (event.getX() > 10+20+4*w && event.getX() < -10+20+5*w && event.getY() > 10+20+5*h && event.getY() < -10+20+6*h && !active[5][4]){f5.setBackground(circle);active[5][4] = true;arUpdate(finalBtSocket,45);}
                if (event.getX() > 10+20+5*w && event.getX() < -10+20+6*w && event.getY() > 10+20+5*h && event.getY() < -10+20+6*h && !active[5][5]){f6.setBackground(circle);active[5][5] = true;arUpdate(finalBtSocket,46);}
                if (event.getX() > 10+20+6*w && event.getX() < -10+20+7*w && event.getY() > 10+20+5*h && event.getY() < -10+20+6*h && !active[5][6]){f7.setBackground(circle);active[5][6] = true;arUpdate(finalBtSocket,47);}
                if (event.getX() > 10+20+7*w && event.getX() < -10+20+8*w && event.getY() > 10+20+5*h && event.getY() < -10+20+6*h && !active[5][7]){f8.setBackground(circle);active[5][7] = true;arUpdate(finalBtSocket,48);}

                if (event.getX() > 10+20 && event.getX() < -10+20+w  && event.getY() > 10+20+6*h && event.getY() < -10+20+7*h && !active[6][0]){g1.setBackground(circle);active[6][0] = true;arUpdate(finalBtSocket,49);}
                if (event.getX() > 10+20+w && event.getX() < -10+20+2*w && event.getY() > 10+20+6*h && event.getY() < -10+20+7*h && !active[6][1]){g2.setBackground(circle);active[6][1] = true;arUpdate(finalBtSocket,50);}
                if (event.getX() > 10+20+2*w && event.getX() < -10+20+3*w && event.getY() > 10+20+6*h && event.getY() < -10+20+7*h && !active[6][2]){g3.setBackground(circle);active[6][2] = true;arUpdate(finalBtSocket,51);}
                if (event.getX() > 10+20+3*w && event.getX() < -10+20+4*w && event.getY() > 10+20+6*h && event.getY() < -10+20+7*h && !active[6][3]){g4.setBackground(circle);active[6][3] = true;arUpdate(finalBtSocket,52);}
                if (event.getX() > 10+20+4*w && event.getX() < -10+20+5*w && event.getY() > 10+20+6*h && event.getY() < -10+20+7*h && !active[6][4]){g5.setBackground(circle);active[6][4] = true;arUpdate(finalBtSocket,53);}
                if (event.getX() > 10+20+5*w && event.getX() < -10+20+6*w && event.getY() > 10+20+6*h && event.getY() < -10+20+7*h && !active[6][5]){g6.setBackground(circle);active[6][5] = true;arUpdate(finalBtSocket,54);}
                if (event.getX() > 10+20+6*w && event.getX() < -10+20+7*w && event.getY() > 10+20+6*h && event.getY() < -10+20+7*h && !active[6][6]){g7.setBackground(circle);active[6][6] = true;arUpdate(finalBtSocket,55);}
                if (event.getX() > 10+20+7*w && event.getX() < -10+20+8*w && event.getY() > 10+20+6*h && event.getY() < -10+20+7*h && !active[6][7]){g8.setBackground(circle);active[6][7] = true;arUpdate(finalBtSocket,56);}


                if (event.getX() > 10+20 && event.getX() < -10+20+w  && event.getY() > 10+20+7*h && event.getY() < -10+20+8*h && !active[7][0]){h1.setBackground(circle);active[7][0] = true;arUpdate(finalBtSocket,57);}
                if (event.getX() > 10+20+w && event.getX() < -10+20+2*w && event.getY() > 10+20+7*h && event.getY() < -10+20+8*h && !active[7][1]){h2.setBackground(circle);active[7][1] = true;arUpdate(finalBtSocket,58);}
                if (event.getX() > 10+20+2*w && event.getX() < -10+20+3*w && event.getY() > 10+20+7*h && event.getY() < -10+20+8*h && !active[7][2]){h3.setBackground(circle);active[7][2] = true;arUpdate(finalBtSocket,59);}
                if (event.getX() > 10+20+3*w && event.getX() < -10+20+4*w && event.getY() > 10+20+7*h && event.getY() < -10+20+8*h && !active[7][3]){h4.setBackground(circle);active[7][3] = true;arUpdate(finalBtSocket,60);}
                if (event.getX() > 10+20+4*w && event.getX() < -10+20+5*w && event.getY() > 10+20+7*h && event.getY() < -10+20+8*h && !active[7][4]){h5.setBackground(circle);active[7][4] = true;arUpdate(finalBtSocket,61);}
                if (event.getX() > 10+20+5*w && event.getX() < -10+20+6*w && event.getY() > 10+20+7*h && event.getY() < -10+20+8*h && !active[7][5]){h6.setBackground(circle);active[7][5] = true;arUpdate(finalBtSocket,62);}
                if (event.getX() > 10+20+6*w && event.getX() < -10+20+7*w && event.getY() > 10+20+7*h && event.getY() < -10+20+8*h && !active[7][6]){h7.setBackground(circle);active[7][6] = true;arUpdate(finalBtSocket,63);}
                if (event.getX() > 10+20+7*w && event.getX() < -10+20+8*w && event.getY() > 10+20+7*h && event.getY() < -10+20+8*h && !active[7][7]){h8.setBackground(circle);active[7][7] = true;arUpdate(finalBtSocket,64);}
                return true;

            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((finalBtSocket.isConnected())) {
                    connect.setText("Connected");
                } else {
                    connect.setText("Not Connected");
                }
                a1.setBackground(circle0);
                a2.setBackground(circle0);
                a3.setBackground(circle0);
                a4.setBackground(circle0);
                a5.setBackground(circle0);
                a6.setBackground(circle0);
                a7.setBackground(circle0);
                a8.setBackground(circle0);

                b1.setBackground(circle0);
                b2.setBackground(circle0);
                b3.setBackground(circle0);
                b4.setBackground(circle0);
                b5.setBackground(circle0);
                b6.setBackground(circle0);
                b7.setBackground(circle0);
                b8.setBackground(circle0);

                c1.setBackground(circle0);
                c2.setBackground(circle0);
                c3.setBackground(circle0);
                c4.setBackground(circle0);
                c5.setBackground(circle0);
                c6.setBackground(circle0);
                c7.setBackground(circle0);
                c8.setBackground(circle0);

                d1.setBackground(circle0);
                d2.setBackground(circle0);
                d3.setBackground(circle0);
                d4.setBackground(circle0);
                d5.setBackground(circle0);
                d6.setBackground(circle0);
                d7.setBackground(circle0);
                d8.setBackground(circle0);

                e1.setBackground(circle0);
                e2.setBackground(circle0);
                e3.setBackground(circle0);
                e4.setBackground(circle0);
                e5.setBackground(circle0);
                e6.setBackground(circle0);
                e7.setBackground(circle0);
                e8.setBackground(circle0);

                f1.setBackground(circle0);
                f2.setBackground(circle0);
                f3.setBackground(circle0);
                f4.setBackground(circle0);
                f5.setBackground(circle0);
                f6.setBackground(circle0);
                f7.setBackground(circle0);
                f8.setBackground(circle0);

                g1.setBackground(circle0);
                g2.setBackground(circle0);
                g3.setBackground(circle0);
                g4.setBackground(circle0);
                g5.setBackground(circle0);
                g6.setBackground(circle0);
                g7.setBackground(circle0);
                g8.setBackground(circle0);

                h1.setBackground(circle0);
                h2.setBackground(circle0);
                h3.setBackground(circle0);
                h4.setBackground(circle0);
                h5.setBackground(circle0);
                h6.setBackground(circle0);
                h7.setBackground(circle0);
                h8.setBackground(circle0);
                active[0][0] = false;
                active[0][1] = false;
                active[0][2] = false;
                active[0][3] = false;
                active[0][4] = false;
                active[0][5] = false;
                active[0][6] = false;
                active[0][7] = false;
                active[1][0] = false;
                active[1][1] = false;
                active[1][2] = false;
                active[1][3] = false;
                active[1][4] = false;
                active[1][5] = false;
                active[1][6] = false;
                active[1][7] = false;
                active[2][0] = false;
                active[2][1] = false;
                active[2][2] = false;
                active[2][3] = false;
                active[2][4] = false;
                active[2][5] = false;
                active[2][6] = false;
                active[2][7] = false;
                active[3][0] = false;
                active[3][1] = false;
                active[3][2] = false;
                active[3][3] = false;
                active[3][4] = false;
                active[3][5] = false;
                active[3][6] = false;
                active[3][7] = false;
                active[4][0] = false;
                active[4][1] = false;
                active[4][2] = false;
                active[4][3] = false;
                active[4][4] = false;
                active[4][5] = false;
                active[4][6] = false;
                active[4][7] = false;
                active[5][0] = false;
                active[5][1] = false;
                active[5][2] = false;
                active[5][3] = false;
                active[5][4] = false;
                active[5][5] = false;
                active[5][6] = false;
                active[5][7] = false;
                active[6][0] = false;
                active[6][1] = false;
                active[6][2] = false;
                active[6][3] = false;
                active[6][4] = false;
                active[6][5] = false;
                active[6][6] = false;
                active[6][7] = false;
                active[7][0] = false;
                active[7][1] = false;
                active[7][2] = false;
                active[7][3] = false;
                active[7][4] = false;
                active[7][5] = false;
                active[7][6] = false;
                active[7][7] = false;
                arUpdate(finalBtSocket,0);

            }
        });
    }
    void arUpdate(BluetoothSocket btSocket,int a) {
        try {
            OutputStream outputStream = btSocket.getOutputStream();
            outputStream.write(a);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

