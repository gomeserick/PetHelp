package com.example.pethelp.ui.perfil;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pethelp.R;
import com.example.pethelp.databinding.FragmentPerfilBinding;


/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class PerfilFragment extends Fragment implements View.OnClickListener {

    private FragmentPerfilBinding binding;
    private boolean isChanging = false;
    private MultiAutoCompleteTextView nome;
    private MultiAutoCompleteTextView email;
    private MultiAutoCompleteTextView RG;
    private MultiAutoCompleteTextView CPF;
    private MultiAutoCompleteTextView endereco;
    private MultiAutoCompleteTextView telefone;
    private Button button;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PerfilViewModel perfilViewModel =
                new ViewModelProvider(this).get(PerfilViewModel.class);

        binding = FragmentPerfilBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        loadViews(view);
        this.nome.setEnabled(false);
        this.email.setEnabled(false);
        this.RG.setEnabled(false);
        this.CPF.setEnabled(false);
        this.endereco.setEnabled(false);
        this.telefone.setEnabled(false);
        button.setOnClickListener(this);
        return view;
    }



    private void loadViews(View view){
        nome = view.findViewById(R.id.Nome);
        email = view.findViewById(R.id.Email);
        RG = view.findViewById(R.id.RG);
        CPF = view.findViewById(R.id.CPF);
        endereco = view.findViewById(R.id.Endereco);
        telefone = view.findViewById(R.id.Telefone);
        button = view.findViewById(R.id.Alterar);
    }




    public void alterarDados(){
        nome.setEnabled(!isChanging);
        email.setEnabled(!isChanging);
        RG.setEnabled(!isChanging);
        CPF.setEnabled(!isChanging);
        endereco.setEnabled(!isChanging);
        telefone.setEnabled(!isChanging);
        if(isChanging){
            Toast.makeText(getActivity(), "Dados Salvos", Toast.LENGTH_LONG);
            button.setText("Alterar Dados");
        } else {
            button.setText("Salvar Dados");
        }
        isChanging = !isChanging;

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.Alterar:
            alterarDados();
        }
    }
}