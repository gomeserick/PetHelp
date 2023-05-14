package com.example.pethelp;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pethelp.records.Cliente;
import com.example.pethelp.sql.SqlCliente;

public class Usuario {
    public boolean logar(View v){

        EditText user = v.findViewById(R.id.Login_Nome);
        EditText password = v.findViewById(R.id.password);

        SqlCliente sqlCliente = new SqlCliente();
        Cliente cliente = sqlCliente.readClienteEmail(user.getText().toString());
        Context context = v.getContext();
        Toast.makeText(context, cliente.getEmail(), Toast.LENGTH_SHORT).show();


        return false;
    }
}
