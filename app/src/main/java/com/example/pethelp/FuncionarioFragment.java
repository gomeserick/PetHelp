package com.example.pethelp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FuncionarioFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FuncionarioFragment extends Fragment {

    private EditText nome;
    private EditText RG;
    private EditText CPF;
    private EditText telefone;
    private EditText email;
    private EditText endereco;
    private boolean isChanging = false;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters

    public FuncionarioFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FuncionarioFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FuncionarioFragment newInstance(String param1, String param2) {
        FuncionarioFragment fragment = new FuncionarioFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_funcionario,
                container, false);
        Button alterarDados = (Button) view.findViewById(R.id.AlterarDadosFun);
        alterarDados.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AlterarDados();
            }
        });
        Button cadastro = (Button) view.findViewById(R.id.BtnDispAnimal);

        cadastro.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                goToCadastro(v);
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.nome = view.findViewById(R.id.NomeFuncionario);
        this.RG = view.findViewById(R.id.RGFuncionario);
        this.CPF = view.findViewById(R.id.CPFFuncionario);
        this.telefone = view.findViewById(R.id.TelefoneFuncionario);
        this.email = view.findViewById(R.id.EmailFuncionario);
        this.endereco = view.findViewById(R.id.EnderecoFuncionario);
        nome.setEnabled(isChanging);
        RG.setEnabled(isChanging);
        CPF.setEnabled(isChanging);
        telefone.setEnabled(isChanging);
        email.setEnabled(isChanging);
        endereco.setEnabled(isChanging);



    }

    public void goToCadastro(View view){
        FragmentTransaction ft = getParentFragmentManager().beginTransaction();

        ft.replace(R.id.nav_host_fragment_content_main, new DisponibilizaAnimalFragment(), null);
        ft.addToBackStack(DisponibilizaAnimalFragment.class.getName()); // you can use a string here, using the class name is just convenient
        ft.commit();

    }

    public void AlterarDados(){
        nome.setEnabled(!isChanging);
        RG.setEnabled(!isChanging);
        CPF.setEnabled(!isChanging);
        telefone.setEnabled(!isChanging);
        email.setEnabled(!isChanging);
        endereco.setEnabled(!isChanging);
        isChanging = !isChanging;

    }



}