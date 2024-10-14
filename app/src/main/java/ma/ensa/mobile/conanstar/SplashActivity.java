package ma.ensa.mobile.conanstar;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashActivity extends AppCompatActivity {

    private ImageView  star1 ,star2 ,star3 ,star4 ,star5 , bg;
    private TextView nameApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        star1= findViewById(R.id.star1);
        star1.animate().rotation(360f).setDuration(2000);
        star1.animate().scaleX(0.5f).scaleY(0.5f).setDuration(3000);
        star1.animate().translationYBy(1000f).setDuration(2000);
        star1.animate().alpha(0f).setDuration(6000);

        star2= findViewById(R.id.star2);
        star2.animate().rotation(360f).setDuration(2000);
        star2.animate().scaleX(0.5f).scaleY(0.5f).setDuration(3000);
        star2.animate().translationYBy(1000f).setDuration(2000);
        star2.animate().alpha(0f).setDuration(6000);

        star3= findViewById(R.id.star3);
        star3.animate().rotation(360f).setDuration(2000);
        star3.animate().scaleX(0.5f).scaleY(0.5f).setDuration(3000);
        star3.animate().translationYBy(1000f).setDuration(2000);
        star3.animate().alpha(0f).setDuration(6000);

        star4= findViewById(R.id.star4);
        star4.animate().rotation(360f).setDuration(2000);
        star4.animate().scaleX(0.5f).scaleY(0.5f).setDuration(3000);
        star4.animate().translationYBy(1000f).setDuration(2000);
        star4.animate().alpha(0f).setDuration(6000);

        star5= findViewById(R.id.star5);
        star5.animate().rotation(360f).setDuration(2000);
        star5.animate().scaleX(0.5f).scaleY(0.5f).setDuration(3000);
        star5.animate().translationYBy(1000f).setDuration(2000);
        star5.animate().alpha(0f).setDuration(6000);




//        nameApp = findViewById(R.id.nameApp);
//        nameApp.animate().translationYBy(200f).setDuration(4000);
//
//        bg = findViewById(R.id.bg);
//        bg.animate().translationYBy(200f).setDuration(4000);


        applyLightEffect(star1);
        applyLightEffect(star2);
        applyLightEffect(star3);
        applyLightEffect(star4);
        applyLightEffect(star5);


        nameApp = findViewById(R.id.nameApp);
        nameApp.animate().translationYBy(200f).setDuration(4000);
        addGlowEffect(nameApp);

        bg = findViewById(R.id.bg);
        bg.animate().translationYBy(200f).setDuration(4000);




        Thread t = new Thread(){
            @Override
            public void run() {
                try{
                    sleep(5000);
                    Intent intent = new Intent(SplashActivity.this , ListActivity.class);
                    startActivity(intent);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        t.start();



    }


    private void addGlowEffect(View view) {
        ObjectAnimator glowAnimator = ObjectAnimator.ofFloat(view, "alpha", 0.5f, 1f, 0.5f);
        glowAnimator.setDuration(1500);
        glowAnimator.setRepeatCount(ValueAnimator.INFINITE); // Répéter infiniment
        glowAnimator.setRepeatMode(ValueAnimator.REVERSE);
        glowAnimator.start();
    }

    private void applyLightEffect(ImageView imageView) {
        ValueAnimator colorAnim = ValueAnimator.ofFloat(0f, 1f);
        colorAnim.setDuration(2000); // 2 secondes pour l'effet
        colorAnim.setRepeatCount(ValueAnimator.INFINITE);
        colorAnim.setRepeatMode(ValueAnimator.REVERSE);

        colorAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                float value = (float) animator.getAnimatedValue();
                imageView.setColorFilter(Color.argb((int) (value * 255), 255, 255, 0)); // Effet lumineux jaune
            }
        });
        colorAnim.start();
    }


    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}