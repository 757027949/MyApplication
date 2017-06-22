package asd.com.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;

import asd.com.myapplication.R;

/**
 * Created by Administrator on 2016/10/10.
 */

public class TestView extends View {

    /**
     * 控件宽度
     */
    private int width;
    /**
     * 控件高度
     */
    private int height;

    /**
     * 粉红底色
     */
    private int pinkColor;
    /**
     * 黄色
     */
    private int yellowColor;
    /**
     * 粉色红
     */
    private int pinkRedColor;
    /**
     * 浅红
     */
    private int redColor;
    /**
     * 深红
     */
    private int deepRedColor;
    /**
     * 灰色
     */
    private int grayColor;

    Paint paint;

    public TestView(Context context) {
        super(context);
        initView(context);
    }

    public TestView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public TestView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE); //设置空心
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);

        pinkColor = context.getResources().getColor(R.color.orange);
        yellowColor = context.getResources().getColor(R.color.grey);
        pinkRedColor = context.getResources().getColor(R.color.green);
        redColor = context.getResources().getColor(R.color.blue);
        deepRedColor = context.getResources().getColor(R.color.yellow);
        grayColor = context.getResources().getColor(R.color.red);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        width = getWidth(); //获取宽度
        height = getHeight();//获取高度

//        paintPercentText(canvas);
//        paintPercentBack(canvas);
        paintTest(canvas);
    }

    private void paintPercentText(Canvas canvas) {
        paint.setTextSize(20);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(1);
        paint.setTextAlign(Paint.Align.CENTER);
        for (int i = 0; i <= 10; i++) {
            //保存画布
            canvas.save();
            //旋转角度，第一个参数是旋转的角度、第二个参数和第三个参数是旋转中心点x和y
            canvas.rotate((float) (20 * i + -135 + 20), width / 2, 250);
            //画文字
            canvas.drawText(i * 10 + "", width / 2, 14 + 12 * 2, paint);
            canvas.restore();
        }
    }

    private void paintPercentBack(Canvas canvas) {
        paint.setColor(Color.GRAY);
        paint.setStrokeWidth(20);//outerArcWidth
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);//设置为圆角
        paint.setAntiAlias(true);
        //绘制最外层圆条底色
        RectF outerArea = new RectF(width / 2 - 100, 50, width / 2 + 100, 250);
        canvas.drawArc(outerArea,
                (float) (180),
                (float) (180), false, paint);

        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(20);//outerArcWidth
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);//设置为圆角
        paint.setAntiAlias(true);
        //绘制最外层圆条底色
        outerArea = new RectF(width / 2 - 100, 50, width / 2 + 100, 250);
        canvas.drawArc(outerArea,
                (float) (180),
                (float) (90), false, paint);

        paint.setStyle(Paint.Style.FILL);
        int colorSweep[] = {deepRedColor, yellowColor};
        float position[] = {0.2f, 1.0f};
        SweepGradient sweepGradient = new SweepGradient(width / 2, 0, colorSweep, position);
        paint.setShader(sweepGradient);
        //绘制最外层圆条底色
        outerArea = new RectF(width / 2 - 90, 60, width / 2 + 90, 240);
        canvas.drawArc(outerArea,
                (float) (180),
                (float) (180), true, paint);

    }

    private void paintTest(Canvas canvas) {
        paint.setColor(Color.parseColor("#E2E2E2"));
        paint.setStrokeWidth(10);
//        paint.setColorFilter(new LightingColorFilter(0xFFFFFFFF, 0X00FFFF00));
//        paint.setColorFilter(new PorterDuffColorFilter(Color.BLUE, PorterDuff.Mode.DARKEN));
//        paint.setXfermode(new )
        paint.setStrokeCap(Paint.Cap.ROUND);//设置为圆角
        paint.setAntiAlias(true);
        RectF outerArea = new RectF(5, 5, width - 5, height);
        canvas.drawArc(outerArea,
                (float) (180),
                (float) (180), false, paint);

        paint.setColor(Color.parseColor("#95C468"));
        paint.setStrokeWidth(10);
        paint.setStrokeCap(Paint.Cap.ROUND);//设置为圆角
        paint.setAntiAlias(true);
        outerArea = new RectF(5, 5, width - 5, height);
        canvas.drawArc(outerArea,
                (float) (180),
                (float) (90), false, paint);

        paint.setColor(Color.parseColor("#DE7DA6"));
        paint.setStyle(Paint.Style.FILL);
        outerArea = new RectF(10, 10, width - 10, height);
        Shader mShader = new LinearGradient(width / 2, 0, width / 2, height,
                new int[]{Color.parseColor("#95C468"), Color.parseColor("#E2F5C7"), Color.parseColor("#F0FCE6"), Color.WHITE}, null, Shader.TileMode.REPEAT);
        paint.setShader(mShader);
        canvas.drawArc(outerArea,
                (float) (180),
                (float) (180), false, paint);

        paint.setColor(Color.parseColor("#95C468"));
        paint.setStrokeWidth(2);
        paint.setTextSize(width/5);
        paint.setShader(null);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText("LV.1", width / 2, height / 2, paint);
    }
}
