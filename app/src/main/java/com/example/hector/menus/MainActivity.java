package com.example.hector.menus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private TextView clicka;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        clicka = (TextView) findViewById(R.id.clicka);
        clicka.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                PopupMenu popupMenu = new PopupMenu(MainActivity.this,clicka);
                popupMenu.getMenuInflater().inflate(R.menu.pupupmenu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch(item.getItemId()){
                            case R.id.opcion1:
                                Toast.makeText(getBaseContext(),"Has pulsado opcion 1", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.opcion2:
                                Toast.makeText(getBaseContext(),"Has pulsado opcion 2", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return false;

                    }
                });
                popupMenu.show();
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater mMenuInflater = getMenuInflater();
        mMenuInflater.inflate(R.menu.opcionesmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){
            case R.id.option1:
                Toast.makeText(MainActivity.this, "Has apretado OPCION 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.option2:
                Toast.makeText(MainActivity.this, "Has apretado OPCION 2", Toast.LENGTH_LONG).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.ajustesmenu, menu);
    }

    //Gestion eventos menu Contextual
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.uno:

                Toast.makeText(getBaseContext(),"Has pulsado 1",Toast.LENGTH_LONG);
                break;
            case R.id.dos:
                Toast.makeText(getBaseContext(),"Has pulsado 2",Toast.LENGTH_LONG);
        }
        return super.onContextItemSelected(item);
    }


}
