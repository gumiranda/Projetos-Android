package gumiranda.com.elite.appelite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText textoTarefa;
    private Button botaoAdicionar;
    private ListView listaTarefas;
    private SQLiteDatabase bancoDados;
    private ArrayAdapter<String> itensAdaptador;
private ArrayList<String> itens;
    private ArrayList<Integer> ids;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            //recuperar componentes
            textoTarefa = (EditText) findViewById(R.id.textoId);
            botaoAdicionar = (Button) findViewById(R.id.botaoAdicionarId);
            listaTarefas = (ListView) findViewById(R.id.listViewId);


//banco de dados
            bancoDados = openOrCreateDatabase("apptarefas", MODE_PRIVATE, null);

//tabela tarefas
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS tarefas(id INTEGER PRIMARY KEY AUTOINCREMENT,tarefa VARCHAR)");
            botaoAdicionar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String textoDigitado = textoTarefa.getText().toString();
                    salvarTarefa(textoDigitado);


                }
            });
            listaTarefas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                 removerTarefa(ids.get(i));
                }
            });

            //Listar tarefas
            recuperarTarefas();

            }
        catch(Exception e){
            e.printStackTrace();
        }

    }
private void salvarTarefa(String texto){
    try {
        if(texto.equals("")){
            Toast.makeText(MainActivity.this,"Digite uma tarefa",Toast.LENGTH_SHORT).show();
        }else {
            bancoDados.execSQL("INSERT INTO tarefas (tarefa) VALUES(' " + texto + " ')");
            Toast.makeText(MainActivity.this,"Tarefa salva com sucesso",Toast.LENGTH_SHORT).show();
            recuperarTarefas();
            textoTarefa.setText("");
        }
    }catch(Exception e){
        e.printStackTrace();
    }
}
    private void recuperarTarefas(){
        try {
            //recupera as tarefas
            Cursor cursor = bancoDados.rawQuery("SELECT * FROM tarefas ORDER BY id DESC", null);
            //recupera os ids das colunas
            int indiceColunaId = cursor.getColumnIndex("id");
            int indiceColunaTarefa = cursor.getColumnIndex("tarefa");

            //Criar adaptador
            ids = new ArrayList<Integer>();
            listaTarefas = (ListView) findViewById(R.id.listViewId);
            itens = new ArrayList<String>();
             itensAdaptador = new ArrayAdapter<String>(getApplicationContext(),android.R.layout
                     .simple_list_item_2,android.R.id.text1,itens);
            listaTarefas.setAdapter(itensAdaptador);

            //listar as tarefas
            cursor.moveToFirst();
            while (cursor != null) {

                Log.i("Resultado -", "Id: " + cursor.getString(indiceColunaId)+ "tarefa : " + cursor.getString(indiceColunaTarefa));
                itens.add(cursor.getString(indiceColunaTarefa));
                ids.add(Integer.parseInt(cursor.getString(indiceColunaId)));
                cursor.moveToNext();
            }
        }catch(Exception e){
                e.printStackTrace();
            }
    }


private void removerTarefa(Integer id){
    try{
        bancoDados.execSQL("DELETE FROM tarefas WHERE id = "+id);
        recuperarTarefas();
        Toast.makeText(MainActivity.this,"Tarefa deletada com sucesso",Toast.LENGTH_SHORT).show();
    }catch(Exception e){
        e.printStackTrace();
    }
}
}