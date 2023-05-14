package com.example.pethelp.ui.login.cadastro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pethelp.MainActivity;
import com.example.pethelp.R;
import com.example.pethelp.records.Cliente;
import com.example.pethelp.sql.SqlCliente;

public class CadastroActivity extends AppCompatActivity {

    private EditText nome;
    private EditText RG;
    private EditText CPF;
    private EditText endereco;
    private EditText email;
    private EditText senha;
    private EditText telefone;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadrastro);


        this.nome = findViewById(R.id.Cadastro_nome);
        this.RG = findViewById(R.id.Cadastro_RG);
        this.CPF = findViewById(R.id.Cadastro_CPF);
        this.endereco = findViewById(R.id.Cadastro_Endereco);
        this.email = findViewById(R.id.Cadastro_email);
        this.senha = findViewById(R.id.username4);
        this.telefone = findViewById(R.id.username3);
    }


    public void cadastrar(View v){
        String nome = this.nome.getText().toString();
        String RG = this.RG.getText().toString();
        String CPF = this.CPF.getText().toString();
        String email = this.email.getText().toString();
        String endereco = this.endereco.getText().toString();
        String senha = this.senha.getText().toString();
        boolean notificacao = false;
        String telefone = this.telefone.getText().toString();
        Cliente user = new Cliente(nome, RG, CPF, endereco, senha, notificacao, telefone);
        SqlCliente cli = new SqlCliente();
        cli.createCliente(user);
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }



}
