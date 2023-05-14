package com.example.pethelp.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.pethelp.AnimalActivity;
import com.example.pethelp.MainActivity;
import com.example.pethelp.R;
import com.example.pethelp.databinding.FragmentHomeBinding;
import com.example.pethelp.enums.Caes;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    private ImageButton cao1;
    private ImageButton cao2;
    private ImageButton cao3;
    private ImageButton cao4;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        cao1 = view.findViewById(R.id.Cachorro1);
        cao2 = view.findViewById(R.id.Cachorro2);
        cao3 = view.findViewById(R.id.Cachorro3);
        cao4 = view.findViewById(R.id.Cachorro4);



    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    public void goToDog(View v){
        Intent i = new Intent(MainActivity.getInstace(), AnimalActivity.class);
        ImageButton image = v.findViewById(v.getId());
        i.putExtra("Cao",v.getId());
        String fullName = getResources().getResourceName(v.getId());
        String name = fullName.substring(fullName.lastIndexOf("/") + 1);
        i.putExtra("Nome", name);
        passDog(i,image.getId());
        startActivity(i);
    }

    public void passDog(Intent i, int id){

        if (id == cao1.getId()){
            i.putExtra("Enum", Caes.CACHORRO1);
        } else if(id == cao2.getId()){
            i.putExtra("Enum", Caes.CACHORRO2);
        } else if(id == cao3.getId()){
            i.putExtra("Enum", Caes.CACHORRO3);
        } else if(id == cao4.getId()){
            i.putExtra("Enum", Caes.CACHORRO4);
        } else {
            throw new IllegalStateException("Unexpected value: " + id);
        }
    }
}