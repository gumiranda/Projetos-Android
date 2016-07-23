package com.example.gumiranda.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private ListView listaSignos;
    private String[] signos = {"Áries","Touro","Gêmeos","CÂNCER","Leão","Virgem","Libra","ESCORPIÃO" +
            "SAGITÁRIO","CAPRICÓRNIO","AQUÁRIO","PEIXES"};
    private String[] perfis = {"São animados,independentes,dinâmicos,corajosos,aventureiros,positivos,pacientes,determinados,leais,românticos e racionais"
            ,"São animados,independentes,dinâmicos,corajosos,aventureiros,positivos,pacientes,determinados,leais,românticos e racionais",
            "São animados,independentes,dinâmicos,corajosos,aventureiros,positivos,pacientes,determinados,leais,românticos e racionais",
            "São animados,independentes,dinâmicos,corajosos,aventureiros,positivos,pacientes,determinados,leais,românticos e racionais",
            "São animados,independentes,dinâmicos,corajosos,aventureiros,positivos,pacientes,determinados,leais,românticos e racionais",
            "São animados,independentes,dinâmicos,corajosos,aventureiros,positivos,pacientes,determinados,leais,românticos e racionais",
            "São animados,independentes,dinâmicos,corajosos,aventureiros,positivos,pacientes,determinados,leais,românticos e racionais",
            "São animados,independentes,dinâmicos,corajosos,aventureiros,positivos,pacientes,determinados,leais,românticos e racionais",
            "São animados,independentes,dinâmicos,corajosos,aventureiros,positivos,pacientes,determinados,leais,românticos e racionais",
            "São animados,independentes,dinâmicos,corajosos,aventureiros,positivos,pacientes,determinados,leais,românticos e racionais",
            "São animados,independentes,dinâmicos,corajosos,aventureiros,positivos,pacientes,determinados,leais,românticos e racionais",
            "São animados,independentes,dinâmicos,corajosos,aventureiros,positivos,pacientes,determinados,leais,românticos e racionais"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaSignos = (ListView) findViewById(R.id.listViewId);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                getApplicationContext(),android.R.layout.simple_list_item_1,android.R.id.text1,signos
        );
        listaSignos.setAdapter(adaptador);
        listaSignos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int codigoPosicao = i;
                Toast.makeText(getApplicationContext(),perfis[codigoPosicao],Toast.LENGTH_LONG).show();
            }
        });
    }
}
