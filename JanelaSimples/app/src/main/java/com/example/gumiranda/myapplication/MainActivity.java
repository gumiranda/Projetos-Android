package com.example.gumiranda.myapplication;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button botao;
    private AlertDialog.Builder dialog;
      @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);
          botao = (Button) findViewById(R.id.botaoId);
          botao.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  dialog = new AlertDialog.Builder(MainActivity.this);
                  //configurar a dialog
                  dialog.setTitle("Janelinha marota");
                  dialog.setMessage("Eaae mermãão");
                  dialog.setCancelable(false);//não deixa a pessoa fechar a janela
                  dialog.setIcon(android.R.drawable.ic_delete);//setta o icone da dialog
                  //configurar botoes positivo e negativo
                  //botao nao
                  dialog.setNegativeButton("Não",
                          new DialogInterface.OnClickListener() {
                              @Override
                              public void onClick(DialogInterface dialogInterface, int i) {
                             Toast.makeText(MainActivity.this,"vc apertou nao",Toast.LENGTH_SHORT).show();
                              }
                          });
                  //botao sim
                  dialog.setPositiveButton("Sim",
                          new DialogInterface.OnClickListener() {
                              @Override
                              public void onClick(DialogInterface dialogInterface, int i) {
                                  Toast.makeText(MainActivity.this,"vc apertou sim",Toast.LENGTH_SHORT).show();
                              }
                          });
              }
          });

          dialog.create();
          dialog.show();
    }
}
