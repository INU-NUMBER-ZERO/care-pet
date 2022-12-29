package com.example.carepet;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.carepet.Data.Data;
import com.example.carepet.databinding.FragmentCBinding;

import java.util.ArrayList;

public class FragmentC extends Fragment {

    Context context;
    ArrayList<Data> data = new ArrayList<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentCBinding binding = FragmentCBinding.inflate(inflater);

        init();
        ListviewAdapter listviewAdapter = new ListviewAdapter(requireContext(), data);
        binding.listView.setAdapter(listviewAdapter);

        return binding.getRoot();
    }

    public void init() {
        data.clear();
        data.add(new Data("강아지", "홍길동", "찰떡콩떡 동물병원", "01234567890"));
        data.add(new Data("고양이", "김연재", "동물사랑동물병원", "01234567890"));
        data.add(new Data("도마뱀", "정환길", "아프리카동물병원", "01234567890"));
        data.add(new Data("기린", "이민규", "이광수동물병원", "01234567890"));
        data.add(new Data("햄스터", "김현빈", "찰떡콩떡 동물병원", "01234567890"));
    }
}