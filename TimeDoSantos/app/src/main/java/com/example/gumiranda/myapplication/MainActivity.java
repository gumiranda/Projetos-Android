package com.example.gumiranda.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ListView listaItens;
    private String [] itens = {"Vanderlei",
            "Vitor ferraz","Zeca","Luis Filipe","Gustavo Henrique",
            "David Braz","Thiago Maia","Renato","Lucas Lima",
            "Vitor Bueno(Copete)","Ricardo Oliveira","Gabigol(Rodrigão)"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       listaItens = (ListView) findViewById(R.id.listViewId);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1,android.R.id.text1,itens);
        listaItens.setAdapter(adaptador);
        listaItens.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int codigoPosicao = i;
                String valorClicado = listaItens.getItemAtPosition(codigoPosicao).toString();

                Toast.makeText(getApplicationContext(),valorClicado,Toast.LENGTH_SHORT).show();
            }
        });


    }
}
