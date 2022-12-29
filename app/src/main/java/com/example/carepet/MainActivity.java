package com.example.carepet;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.carepet.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.CameraPosition;
import com.naver.maps.map.MapFragment;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.NaverMapOptions;
import com.naver.maps.map.NaverMapSdk;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.overlay.Marker;
import com.naver.maps.map.overlay.OverlayImage;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private final FragmentManager fragmentManager = getSupportFragmentManager();
    private MapFragment fragmentA = (MapFragment) fragmentManager.findFragmentById(R.id.map);
    private final FragmentB fragmentB = new FragmentB();
    private final FragmentC fragmentC = new FragmentC();

    @SuppressLint({"NonConstantResourceId", "UseCompatLoadingForDrawables"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        NaverMapSdk.getInstance(this).setClient(
                new NaverMapSdk.NaverCloudPlatformClient("voplkfmd7b")
        );

        ImageView imageView = new ImageView(this);
        imageView.setImageDrawable(getDrawable(R.drawable.icon));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        //int dp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80, getResources().getDisplayMetrics());
        imageView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        //imageView.setPadding(dp, dp, dp, dp);
        setContentView(imageView);

        new Handler(Looper.getMainLooper()).postDelayed(() -> runOnUiThread(() -> {
            setContentView(R.layout.activity_main);

            fragmentManager.beginTransaction().add(R.id.fragmentContainerView, fragmentB).commit();

            BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
            bottomNavigationView.setSelectedItemId(R.id.menu_b);
            bottomNavigationView.setOnItemSelectedListener(item -> {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                switch (item.getItemId()) {
                    case R.id.menu_a:
                        if(fragmentA == null) {
                            NaverMapOptions options = new NaverMapOptions()
                                    .camera(new CameraPosition(new LatLng(37.417715, 126.653140), 12));
                            fragmentA = MapFragment.newInstance(options);
                        }
                        fragmentTransaction.replace(R.id.fragmentContainerView, fragmentA);
                        fragmentA.getMapAsync(this);
                        fragmentTransaction.add(R.id.fragmentContainerView, new FragmentA()).commit();
                        break;
                    case R.id.menu_b:
                        fragmentTransaction.replace(R.id.fragmentContainerView, fragmentB).commit();
                        break;
                    case R.id.menu_c:
                        fragmentTransaction.replace(R.id.fragmentContainerView, fragmentC).commit();
                        break;
                }
                return true;
            });
        }), 2000);
    }

    @UiThread
    @Override
    public void onMapReady(@NonNull NaverMap naverMap) {
        Marker[] markers = new Marker[31];
        String[] hospital_name = new String[]{
                "동물사랑동물병원",
                "이광수동물병원",
                "아프리카동물병원",
                "송도종합동물병원",
                "노성남 동물병원",
                "주주동물병원",
                "신퍼피클럽 동물병원",
                "웰니스클리닉 연수점",
                "프라자 동물병원",
                "Central 동물병원",
                "닥터비 동물병원",
                "송도건국동물병원",
                "24시 송도힐 동물메디컬센터",
                "따뜻한 동물병원",
                "웰 동물병원",
                "미라클 동물병원",
                "디오 동물병원",
                "드림동물병원",
                "ACE동물병원",
                "그루동물병원",
                "베리떼 동물병원",
                "닥터정 동물병원",
                "인천광역시 야생동물구조관리센터",
                "아름다운 동물병원",
                "라파엘 동물병원",
                "연수동물메디컬센터",
                "포시즌 동물병원",
                "구피동물병원",
                "24시 오케이 동물병원",
                "우성동물병원"
        };
        double[] x = new double[]{
                126.697957,
                126.672280,
                126.656320,
                126.656243,
                126.644334,
                126.648036,
                126.685452,
                126.681175,
                126.652444,
                126.641007,
                126.676948,
                126.663602,
                126.652284, //
                126.680290,
                126.669874,
                126.647307,
                126.665132,
                126.670337,
                126.641007,
                126.675003,
                126.650837,
                126.646044,
                126.638565,
                126.649915,
                126.652160,
                126.677485,
                126.637903,
                126.679182,
                126.621432,
                126.653140
        };
        double[] y = new double[]{
                37.424452,
                37.407624,
                37.427682,
                37.426047,
                37.425624,
                37.391075,
                37.425231,
                37.404270,
                37.395714,
                37.394467,
                37.416909,
                37.373381,
                37.396800, //
                37.413189,
                37.422474,
                37.394332,
                37.388054,
                37.406688,
                37.394467,
                37.423908,
                37.390984,
                37.392921,
                37.366701,
                37.392069,
                37.395487,
                37.412041,
                37.400030,
                37.418573,
                37.414660,
                37.417715
        };

        for (int i= 0; i<30;i++)
        {
            markers[i] = new Marker();
            markers[i].setPosition(new LatLng(y[i], x[i]));
            if (i % 3 == 0) {
                markers[i].setIcon(OverlayImage.fromResource(R.drawable.cat));
            }
            if (i % 3 == 1) {
                markers[i].setIcon(OverlayImage.fromResource(R.drawable.dog));
            }
            if (i % 3 == 2) {
                markers[i].setIcon(OverlayImage.fromResource(R.drawable.ham));
            }
            markers[i].setCaptionText(hospital_name[i]);
            markers[i].setWidth(80);
            markers[i].setHeight(80);
            markers[i].setMap(naverMap);
        }

    }
}