package com.example.sqlliteusuario;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editTextNome;
    Button button;
    UsuarioController usuarioControler;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.salvar);
        editTextNome = findViewById(R.id.nome);
        listView = findViewById(R.id.UsuariosListView);

        usuarioControler = new UsuarioController(getApplicationContext());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = editTextNome.getText().toString();
                usuarioControler.save(new Usuario(nome));
                loadListView();
            }
        });
        loadListView();
    }

    //LoadListView
    public void loadListView() {
        ArrayAdapter<String> adapter = new ArrayAdapter(getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                usuarioControler.getListaNomesUsuarios());
        listView.setAdapter(adapter);
    }
}
