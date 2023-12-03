package com.harshini.jbasuser.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.harshini.jbasuser.R;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;


public class HomeFragment extends Fragment {
    private SliderLayout sliderLayout;
    private ImageView map;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        sliderLayout = view.findViewById(R.id.slider);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL);
        sliderLayout.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderLayout.setScrollTimeInSec(1);



        setSliderView();

        map = view.findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMap();
            }
        });



        return view;
    }

    private void openMap() {
        Uri uri = Uri.parse("geo:0, 0?q=Justice Basheer Ahmed Sayeed College for women");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }

    private void setSliderView() {
        for (int i = 0; i< 6; i++){
            DefaultSliderView sliderView = new DefaultSliderView(getContext());

            switch (i){
                case 0:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/jbas-college-dd415.appspot.com/o/WhatsApp%20Image%202021-03-30%20at%2010.12.15%20PM.jpeg?alt=media&token=c3167c25-a686-426e-8a88-aa70623a2a3d");
                    break;
                 case 1:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/jbas-college-dd415.appspot.com/o/WhatsApp%20Image%202021-03-30%20at%208.12.37%20PM.jpeg?alt=media&token=2cb2b7ac-e68c-4e04-8ea1-34166bfcac51");
                    break;
                 case 2:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/jbas-college-dd415.appspot.com/o/WhatsApp%20Image%202021-03-30%20at%208.12.40%20PM.jpeg?alt=media&token=ebb41da5-48d1-422e-ab25-27ab6d00e4f2");
                    break;
                 case 3:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/jbas-college-dd415.appspot.com/o/WhatsApp%20Image%202021-03-30%20at%208.12.41%20PM.jpeg?alt=media&token=d41cef86-2db9-4b82-af1a-9d059f442da4");
                    break;
                 case 4:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/jbas-college-dd415.appspot.com/o/WhatsApp%20Image%202021-03-30%20at%208.12.42%20PM.jpeg?alt=media&token=31983518-35ba-4323-886d-1d7012837949");
                    break;
                case 5:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/jbas-college-dd415.appspot.com/o/college.png?alt=media&token=c228eaee-e739-4408-9dac-dfd483d70d84");
                    break;


            }
            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            sliderLayout.addSliderView(sliderView);

        }
    }
}