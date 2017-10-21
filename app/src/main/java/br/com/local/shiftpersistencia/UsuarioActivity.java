package br.com.local.shiftpersistencia;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.orhanobut.hawk.Hawk;

import static android.R.attr.editable;

public class UsuarioActivity extends AppCompatActivity {

    private EditText etUsuario;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        etUsuario = (EditText) findViewById(R.id.etUsuario);

        sp = getPreferences(MODE_PRIVATE);

        etUsuario.setText(sp.getString("usuario",""));

        Toast.makeText(this, Hawk.get("usuariosecreto",""),Toast.LENGTH_SHORT).show();

        etUsuario.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                SharedPreferences.Editor e = sp.edit();
                e.putString("usuario", s.toString());
                e.apply();

                Hawk.put("usuariosecreto", s.toString());


            }
        });


    }

    public void entrar(View v) {
    }

    public void limpar(View v) {
    }
}
