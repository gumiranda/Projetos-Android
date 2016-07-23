package gumiranda.com.gumirandaapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.media.Image;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            SQLiteDatabase bancoDados = openOrCreateDatabase("app", MODE_PRIVATE, null);
            //criamos a tabela
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas(id INTEGER PRIMARY KEY " +
                    "AUTOINCREMENT,nome VARCHAR,idade INT(3))");
//bancoDados.execSQL("DROP TABLE pessoas");
//inserindo dados na tabela
          bancoDados.execSQL("INSERT INTO pessoas(nome,idade) VALUES('Juca',30)");
            bancoDados.execSQL("INSERT INTO pessoas(nome,idade) VALUES('Gustavo',20)");
            bancoDados.execSQL("INSERT INTO pessoas(nome,idade) VALUES('Fulano',35)");
            bancoDados.execSQL("INSERT INTO pessoas(nome,idade) VALUES('Lara',19)");

            //bancoDados.execSQL("UPDATE pessoas SET idade = 28 WHERE id = 1 ");

            //deletando dados do banco
            //bancoDados.execSQL("DELETE FROM pessoas WHERE id = 1 ");



            Cursor cursor = bancoDados.rawQuery("SELECT * FROM pessoas", null);
            int indiceColunaNome = cursor.getColumnIndex("nome");
            int indiceColunaIdade = cursor.getColumnIndex("idade");
            int indiceColunaId = cursor.getColumnIndex("id");

            cursor.moveToFirst();
            while (cursor != null) {
                Log.i("RESULTADO - nome: ", cursor.getString(indiceColunaNome));
                Log.i("RESULTADO - idade: ", cursor.getString(indiceColunaIdade));
                Log.i("RESULTADO - id: ", cursor.getString(indiceColunaId));

                cursor.moveToNext();//se nao fizermos isso o cursor nunca sera nulo
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }




}
