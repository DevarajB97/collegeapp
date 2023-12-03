package com.harshini.jbasuser.ui.about;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.harshini.jbasuser.R;

import java.util.ArrayList;
import java.util.List;


public class AboutFragment extends Fragment {
    private ViewPager viewPager;
    private ClassAdapter adapter;
    private List<ClassesModel> list;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        list = new ArrayList<>();
        list.add(new ClassesModel(R.drawable.ug,"Under Graduate", "B.A. Corporate Economics,B.A. English Literature,B.A. Tourism & Travel Management,B.Sc. Mathematics,B.Sc. Statistics,B.Sc. Microbiology,B.Sc. Computer Science,B.Sc. Electronics and Communication Science,B.Com. Information System Management,B.Sc. Interior design and Decor,B.Com,B.Com(CS),B.Com. (Honours),B.Com(Accounts & Finance),B.B.A.,aBCA."));
        list.add(new ClassesModel(R.drawable.pg,"Post Graduate", "M.A Corporate Economics,M.Sc Applied Microbiology,M.Sc Mathematics,M.Sc Computer Science,M.Sc. Physics,MCA,M.Com(CS)"));
        list.add(new ClassesModel(R.drawable.phd,"Doctor of Philosophy", "A PhD is a globally recognized postgraduate academic degree awarded by universities and higher education institutions to a candidate who has submitted a thesis or dissertation, based on extensive and original research in their chosen field. These are the subjects that we can offered to students for there future :  Ph.D in psychology, Ph.d in zoology, Ph.D in Human Science"));
        list.add(new ClassesModel(R.drawable.mphil,"Master of Philosophy", "M.Phil Corporate Secretaryship"));


        adapter = new ClassAdapter(getContext(), list);

        viewPager = view.findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);

        ImageView imageView = view.findViewById(R.id.college_image);


           Glide.with(getContext())
                   .load("https://firebasestorage.googleapis.com/v0/b/jbas-college-dd415.appspot.com/o/WhatsApp%20Image%202021-03-30%20at%2010.12.13%20PM.jpeg?alt=media&token=56ae0a42-f149-426c-b3c4-f2e7204665dd")
                   .into(imageView);



        return view;
    }
}
