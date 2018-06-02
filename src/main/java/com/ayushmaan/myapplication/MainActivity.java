package com.ayushmaan.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {

    GestureDetector gestureDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        gestureDetector=new GestureDetector(MainActivity.this, MainActivity.this );
        Toolbar toolbar = (Toolbar) findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );

        FloatingActionButton fab = (FloatingActionButton) findViewById( R.id.fab );
        fab.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make( view, "Replace with your own action", Snackbar.LENGTH_LONG )
                        .setAction( "Action", null ).show();
            }
        } );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate( R.menu.menu_main, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected( item );
    }

    @Override
    public boolean onFling(MotionEvent motionEvent1, MotionEvent motionEvent2, float X, float Y){
        if(motionEvent1.getY()-motionEvent2.getY()>50){
            Toast.makeText(MainActivity.this,"Swipe Up",Toast.LENGTH_LONG).show();
            return true;
        }

        if(motionEvent2.getY()-motionEvent1.getY()>50){
            Toast.makeText(MainActivity.this,"Swipe Down",Toast.LENGTH_LONG).show();
            return true;
        }

        if(motionEvent1.getX()-motionEvent2.getX()>50){
            Toast.makeText(MainActivity.this,"Swipe Left",Toast.LENGTH_LONG).show();
            return true;
        }

        if(motionEvent2.getX()-motionEvent1.getX()>50){
            Toast.makeText(MainActivity.this,"Swipe Right",Toast.LENGTH_LONG).show();
            return true;
        }
        else
            return true;
    }

    @Override
    public boolean onScroll(MotionEvent arg0,MotionEvent arg1,float arg2,float arg3){
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public void onShowPress(MotionEvent arg0){

    }

    @Override
    public boolean onSingleTapUp(MotionEvent arg0){
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent){
        return gestureDetector.onTouchEvent( motionEvent);
    }

    @Override
    public boolean onDown(MotionEvent arg0){
        return false;
    }
}
