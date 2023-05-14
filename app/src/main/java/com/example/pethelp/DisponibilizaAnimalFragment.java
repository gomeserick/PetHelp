package com.example.pethelp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.pethelp.records.Animal;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DisponibilizaAnimalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DisponibilizaAnimalFragment extends Fragment {

    private EditText codigo;
    private EditText raca;
    private EditText cor;
    private EditText genero;
    private EditText temperamento;
    private EditText castrado;
    private Button btn;
    private boolean isChanging;




    public DisponibilizaAnimalFragment() {
        // Required empty public constructor
    }
    // TODO: Rename and change types and number of parameters
    public static DisponibilizaAnimalFragment newInstance(String param1, String param2) {
        DisponibilizaAnimalFragment fragment = new DisponibilizaAnimalFragment();
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
        return inflater.inflate(R.layout.fragment_disponibiliza_animal, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.codigo = view.findViewById(R.id.Codigo);
        this.raca = view.findViewById(R.id.Disp_Raca);
        this.cor = view.findViewById(R.id.Disp_Cor);
        this.genero = view.findViewById(R.id.Disp_Genero);
        this.temperamento = view.findViewById(R.id.Disp_Insert_Temperamento);
        this.castrado = view.findViewById(R.id.Disp_Castrado);
        this.btn = view.findViewById(R.id.BTN_Disp);
        this.isChanging = false;
        change();
    }

    public void change(){
        this.codigo.setEnabled(isChanging);
        this.raca.setEnabled(isChanging);
        this.cor.setEnabled(isChanging);
        this.genero.setEnabled(isChanging);
        this.temperamento.setEnabled(isChanging);
        this.castrado.setEnabled(isChanging);
        this.isChanging = !this.isChanging;
    }

    public void Cadastrar(){
        Animal animal = null;
        if(isChanging){
            String cod = this.codigo.getText().toString();
            String ra = this.raca.getText().toString();
            String co = this.cor.getText().toString();
            String ge = this.cor.getText().toString();
            String te = this.cor.getText().toString();
            boolean ca = Boolean.parseBoolean(this.cor.getText().toString());
            animal = new Animal(cod, ra, co, ge,null ,te, ca);
        }
        change();

    }





}