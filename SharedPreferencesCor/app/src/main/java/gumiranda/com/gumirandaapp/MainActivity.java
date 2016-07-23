package gumiranda.com.gumirandaapp;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private RadioButton radioButtonSelecionado;
    private Button botaoSalvar;
    private static final String ARQUIVO_PREFERENCIA = "ArqPreferencia";
    private RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
radioGroup = (RadioGroup) findViewById(R.id.radioGroupId);
        botaoSalvar = (Button) findViewById(R.id.button);
layout = (RelativeLayout) findViewById(R.id.layoutId);
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int idRadioButtonEscolhido = radioGroup.getCheckedRadioButtonId();
                if(idRadioButtonEscolhido>0) {
                    radioButtonSelecionado = (RadioButton) findViewById(idRadioButtonEscolhido);
                    SharedPreferences sharedPreferences = getSharedPreferences
                            (ARQUIVO_PREFERENCIA,0);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    String corEscolhida = radioButtonSelecionado.getText().toString();
                    editor.putString("cor escolhida",corEscolhida);
                    editor.commit();
                    setBackGround(corEscolhida);
                }
            }
        });
//recuperar a cor salva
        SharedPreferences sharedPreferences = getSharedPreferences
                (ARQUIVO_PREFERENCIA,0);
        if(sharedPreferences.contains("cor escolhida")){
            String corRecuperada = sharedPreferences.getString("cor escolhida","Laranja");
            setBackGround(corRecuperada);
        }

    }
private void setBackGround(String cor){
    if(cor.equals("Azul")){
        layout.setBackgroundColor(Color.parseColor("#495b7c"));
    }else if(cor.equals("Laranja")){
        layout.setBackgroundColor(Color.parseColor("#fe8206"));

    }else if(cor.equals("Esse verde mesmo")){
        layout.setBackgroundColor(Color.parseColor("#00ff1e"));
    }
}

}
