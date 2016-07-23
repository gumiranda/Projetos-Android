package com.example.gumiranda.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView botaoJogar;
    private String[] opcao = {"cara","coroa"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botaoJogar = (ImageView) findViewById(R.id.moedaId);
        botaoJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//gerar numero aleatorio
                Random randomico = new Random();
                int numeroAleatorio = randomico.nextInt(2);//0 ou 1
                //0 eh cara e 1 eh coroa
              //  opcao[numeroAleatorio]
                Intent intent = new Intent(MainActivity.this,DetalheActivity.class);
                intent.putExtra("opçao",opcao[numeroAleatorio]);
                startActivity(intent);
            }
        });

    }
}
