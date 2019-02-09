package game.myapplication;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private android.support.v7.widget.GridLayout raster;
    private ArrayList<ImageView> jetons;
    int yellowTurn = 0;
    int redTurn = 0;
    boolean pcTurn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        addEventListeners();
        startGame();
    }

    private void initializeViews(){
        raster = findViewById(R.id.rasterGridLayout);
        raster.setBackground(getResources().getDrawable(R.drawable.board));

        jetons = new ArrayList<>();
        jetons.add((ImageView) findViewById(R.id.imageView));
        jetons.add((ImageView) findViewById(R.id.imageView2));
        jetons.add((ImageView) findViewById(R.id.imageView3));
        jetons.add((ImageView) findViewById(R.id.imageView4));
        jetons.add((ImageView) findViewById(R.id.imageView5));
        jetons.add((ImageView) findViewById(R.id.imageView6));
        jetons.add((ImageView) findViewById(R.id.imageView7));
        jetons.add((ImageView) findViewById(R.id.imageView8));
        jetons.add((ImageView) findViewById(R.id.imageView9));

        /*for (ImageView img : jetons) {
            img.setOnHoverListener(this, new MotionEvent() ->{
                img.setBackground(getResources().getDrawable(R.drawable.shadow));
                return true;
            });
            img.setOnClickListener(currentView -> img.setBackground(getResources().getDrawable(R.drawable.yellow)));
        }*/
    }

    private void addEventListeners(){

    }

    public void startGame(){
        Random random = new Random();
        pcTurn = random.nextBoolean();

        if (pcTurn){
            startTurnPc(){

            }
        }
    }

    public void dropIn(View view){
        ImageView counter = (ImageView) view;
        if (!pcTurn & counter.getDrawable() == null) {
            counter.setTranslationY(-1500);
            counter.setImageResource(R.drawable.yellow);
            counter.animate().translationYBy(1500).setDuration(300);
        }
    }

    public void startTurnPc(){


        //end of turn:
        if (!boardFull){
            startTurnUser();
        } else {
            //decideWinner()
        }
    }

    public void startTurnUser(){


        //end of turn:
        if (!boardFull){
            startTurnPc();
        } else {
            //decideWinner()
        }
    }
}
