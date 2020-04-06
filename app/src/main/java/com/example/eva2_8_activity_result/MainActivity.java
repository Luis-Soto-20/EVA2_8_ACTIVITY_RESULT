package com.example.eva2_8_activity_result;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Intent inSelRest, intent2, intentIMG, intentAUD, intentVID;
final int restaurante  = 1000;
final int contactos = 2000;
final int imagenes = 3000;
final int audio = 4000;
final int video = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inSelRest = new Intent(this,MyDataActivity.class);
        intent2 = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
        intentIMG = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intentAUD = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
        intentVID = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI );


    }

    public void onClick (View v){
        startActivityForResult(inSelRest,restaurante);

    }
    public void onClick2(View v){
        startActivityForResult(intent2,contactos);

    }
    public void onClick3(View v){
        startActivityForResult(intentIMG,imagenes);

    }
    public void onClick4(View v){
        startActivityForResult(intentAUD,audio);

    }
    public void onClick5(View v){
        startActivityForResult(intentVID,video);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case restaurante: //Que actividad deolvio datos
                if(resultCode== Activity.RESULT_OK){ //Cual fue la respuesta
                    //Escribir aqui la accion a ejecutar con los datos devueltos
                    Toast.makeText(this,data.getStringExtra("aaaa"),Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this,"Cancelado por el usuario",Toast.LENGTH_SHORT).show();
                }
                break;

            case contactos:
                if(resultCode== Activity.RESULT_OK){
                    String sCont = data.getDataString();
                    Log.wtf("contactos",sCont);
                    Toast.makeText(this,sCont,Toast.LENGTH_SHORT).show();
                }
                break;
            case imagenes:
                if(resultCode== Activity.RESULT_OK){
                    String sImg = data.getDataString();
                    Log.wtf("imagenes",sImg);
                    Toast.makeText(this,sImg,Toast.LENGTH_SHORT).show();
                }
                break;
            case audio:
                if(resultCode== Activity.RESULT_OK){
                    String sAud = data.getDataString();
                    Log.wtf("audio",sAud);
                    Toast.makeText(this,sAud,Toast.LENGTH_SHORT).show();
                }
                break;
            case video:
                if(resultCode== Activity.RESULT_OK){
                    String sVid = data.getDataString();
                    Log.wtf("video",sVid);
                    Toast.makeText(this,sVid,Toast.LENGTH_SHORT).show();
                }
                break;

            default:
        }
    }


}
