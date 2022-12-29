package com.example.carepet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.carepet.databinding.FragmentBBinding;

public class FragmentB extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentBBinding binding = FragmentBBinding.inflate(inflater);

        binding.animalName.setText("냥쉐리");
        binding.sumHospital.setText("29");
        binding.status.setText("비만입니다.");
        binding.nextHospital.setText("D-7");
        binding.doctorAns.setText("산책을 자주하세요, 그리고 적당히 먹이세요");
        binding.ImageView.setImageDrawable(requireContext().getDrawable(R.drawable.blackcat));

        return binding.getRoot();
    }
}