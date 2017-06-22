package asd.com.myapplication;

import android.app.ActivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.qiushui.blurredview.BlurredView;

public class Activity3 extends AppCompatActivity implements View.OnTouchListener {
    LinearLayout rel_bak;
    ImageView image;
    RelativeLayout rel;

    TextView bottom, txt;

    GestureDetector relGestureDetector, textGestureDetector;

    BlurredView blurredView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        relGestureDetector = new GestureDetector(new SimpleGestureWithRelListener());
        textGestureDetector = new GestureDetector(new SimpleGestureWithTextListener());
        rel_bak = (LinearLayout) findViewById(R.id.rel_bak);
        rel_bak.setOnTouchListener(this);
        image = (ImageView) findViewById(R.id.image);
        rel = (RelativeLayout) findViewById(R.id.rel);
        rel.setOnTouchListener(this);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Activity3.this, "image...", Toast.LENGTH_SHORT).show();
            }
        });

        bottom = (TextView) findViewById(R.id.bottom);
        bottom.setOnTouchListener(this);
        txt = (TextView) findViewById(R.id.txt);
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Activity3.this, "txt", Toast.LENGTH_SHORT).show();
            }
        });

        blurredView = (BlurredView) findViewById(R.id.BlurredView);
        blurredView.setBlurredLevel(10);
        blurredView.setBlurredTop(50);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (view.getId()) {
            case R.id.rel:
               return relGestureDetector.onTouchEvent(motionEvent);

            case R.id.bottom:
               return textGestureDetector.onTouchEvent(motionEvent);
        }
        return true;
    }

    private class SimpleGestureWithRelListener extends
            GestureDetector.SimpleOnGestureListener {

        /*****
         * OnGestureListener的函数
         *****/

        final int FLING_MIN_DISTANCE = 100, FLING_MIN_VELOCITY = 200;

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            Toast.makeText(Activity3.this, "click...", Toast.LENGTH_SHORT).show();
            return super.onSingleTapUp(e);
        }

        // 触发条件 ：
        // X轴的坐标位移大于FLING_MIN_DISTANCE，且移动速度大于FLING_MIN_VELOCITY个像素/秒

        // 参数解释：
        // e1：第1个ACTION_DOWN MotionEvent
        // e2：最后一个ACTION_MOVE MotionEvent
        // velocityX：X轴上的移动速度，像素/秒
        // velocityY：Y轴上的移动速度，像素/秒
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                               float velocityY) {


            if (e1.getX() - e2.getX() > FLING_MIN_DISTANCE
                    && Math.abs(velocityX) > FLING_MIN_VELOCITY) {
                // Fling left
//                rel.offsetLeftAndRight(80 - rel.getWidth());
//                Toast.makeText(Activity3.this, "Fling Left", Toast.LENGTH_SHORT).show();
                rel.startAnimation(AnimationUtils.loadAnimation(Activity3.this, R.anim.translate_in));
            } else if (e2.getX() - e1.getX() > FLING_MIN_DISTANCE
                    && Math.abs(velocityX) > FLING_MIN_VELOCITY) {
                // Fling right
//                rel.offsetLeftAndRight(rel.getWidth() - 80);
//                Toast.makeText(Activity3.this, "Fling Right", Toast.LENGTH_SHORT).show();
                rel.startAnimation(AnimationUtils.loadAnimation(Activity3.this, R.anim.translate_out));
            }
            return true;
        }

    }

    private class SimpleGestureWithTextListener extends
            GestureDetector.SimpleOnGestureListener {

        /*****
         * OnGestureListener的函数
         *****/

        final int FLING_MIN_DISTANCE = 100, FLING_MIN_VELOCITY = 200;

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            Toast.makeText(Activity3.this, "onSingleTapUp", Toast.LENGTH_SHORT).show();
            return super.onSingleTapUp(e);
        }


        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
//            FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) rel_bak.getLayoutParams();
//            params.height = (int) (params.height - distanceY);
//            rel_bak.setLayoutParams(params);

            /*  if (e1.getY() - e2.getY() > FLING_MIN_DISTANCE
                    && Math.abs(velocityY) > FLING_MIN_VELOCITY) {
                // Fling left
//                rel.offsetLeftAndRight(80 - rel.getWidth());
//                Toast.makeText(Activity3.this, "Fling top", Toast.LENGTH_SHORT).show();
//                rel.startAnimation(AnimationUtils.loadAnimation(Activity3.this, R.anim.translate_in));
                rel_bak.getLayoutParams().height= (int) (e1.getY() - e2.getY());
            } else if (e2.getY() - e1.getY() > FLING_MIN_DISTANCE
                    && Math.abs(velocityY) > FLING_MIN_VELOCITY) {
                // Fling right
//                rel.offsetLeftAndRight(rel.getWidth() - 80);
//                Toast.makeText(Activity3.this, "Fling bottom", Toast.LENGTH_SHORT).show();
//                rel.startAnimation(AnimationUtils.loadAnimation(Activity3.this, R.anim.translate_out));
                rel_bak.getLayoutParams().height= (int) (e2.getY() - e1.getY());
            }*/
            return true;
        }

        // 触发条件 ：
        // X轴的坐标位移大于FLING_MIN_DISTANCE，且移动速度大于FLING_MIN_VELOCITY个像素/秒

        // 参数解释：
        // e1：第1个ACTION_DOWN MotionEvent
        // e2：最后一个ACTION_MOVE MotionEvent
        // velocityX：X轴上的移动速度，像素/秒
        // velocityY：Y轴上的移动速度，像素/秒
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                               float velocityY) {


            if (e1.getY() - e2.getY() > FLING_MIN_DISTANCE
                    && Math.abs(velocityY) > FLING_MIN_VELOCITY) {
                // Fling left
//                rel.offsetLeftAndRight(80 - rel.getWidth());
//                Toast.makeText(Activity3.this, "Fling top", Toast.LENGTH_SHORT).show();
//                rel.startAnimation(AnimationUtils.loadAnimation(Activity3.this, R.anim.translate_in));


                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) rel_bak.getLayoutParams();
                params.height = 200;
                rel_bak.setLayoutParams(params);
            } else if (e2.getY() - e1.getY() > FLING_MIN_DISTANCE
                    && Math.abs(velocityY) > FLING_MIN_VELOCITY) {
                // Fling right
//                rel.offsetLeftAndRight(rel.getWidth() - 80);
//                Toast.makeText(Activity3.this, "Fling bottom", Toast.LENGTH_SHORT).show();
//                rel.startAnimation(AnimationUtils.loadAnimation(Activity3.this, R.anim.translate_out));

                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) rel_bak.getLayoutParams();
                params.height = 1000;
                rel_bak.setLayoutParams(params);
            }
            return true;
        }

    }
}