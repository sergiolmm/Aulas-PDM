package com.example.sergio.canvas_1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;



public class Quadrado1 extends View {
    // definir a cor a ser utilizada
    private Paint pincelVermelho;
    private Paint pincelPreto;
    private Paint pincelAzul;
    public  int y = 10;
    public  int cx = 100;
    public int cy = 100;

    public  boolean selecionou;

    private Drawable imgProg;

    public Quadrado1(Context context) {
        this(context,null );
    }

    public Quadrado1(Context context, AttributeSet attrs) {
        super(context,attrs);

        setBackgroundColor(Color.LTGRAY);
        //Vermelho
        pincelVermelho = new Paint();
        pincelVermelho.setARGB(255,255,0,0);
        // Preto
        pincelPreto = new Paint();
        pincelPreto.setARGB(255,0,0,0);
        //Azul
        pincelAzul = new Paint();
        pincelAzul.setARGB(255,0,0,255);

        imgProg = context.getResources().getDrawable(R.drawable.programador);


        // configura a view para receber foco e tratar eventos de teclado
        setFocusable(true);
    }

    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);

        imgProg.setBounds(150,150,
                imgProg.getIntrinsicWidth() -100 ,
                imgProg.getIntrinsicHeight() - 100);
        imgProg.draw(canvas);


        //desenha quadrado
        canvas.drawRect(10,y,10+50,y+50,pincelAzul);
        // desenha linha
        canvas.drawLine(50, 50, 100, 100, pincelPreto);

        // desenha circulo
        canvas.drawCircle(cx, cy, 20, pincelVermelho);



    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float lx = event.getX();
        float ly = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
//                    y = (int) ly;
//                    invalidate();
                    selecionou = true;
                break;
            case MotionEvent.ACTION_MOVE:
                if (selecionou) {
                    this.cx = (int) lx;
                    this.cy = (int) ly;
                }
                break;
            case MotionEvent.ACTION_UP:
                selecionou = false;
                break;

        }
        invalidate();
        return  true;
    }
}
