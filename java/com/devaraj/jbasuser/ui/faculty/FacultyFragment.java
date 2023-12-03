package com.harshini.jbasuser.ui.faculty;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.harshini.jbasuser.R;

import java.util.ArrayList;
import java.util.List;


public class FacultyFragment extends Fragment {

    private RecyclerView administrativeTeacher,mathsbscteacher, statisticsbsc, microbiologybsc, ecbsc, csbsc, iddbsc, infobcom, bcom, csbcom, honoursbcom, afbcom, bba, bca, corporateeconomicsba, englishliteratureba, ttmba, others;
    private LinearLayout administrativeNoData, mathsbscteacherNoData, statisticsbscNoData, microbiologybscNoData, ecbscNoData,csbscNoData, iddbscNoData, infobcomNoData, bcomNoData, csbcomNoData,honoursbcomNoData,afbcomNoData,bbaNoData, bcaNoData, corporateeconomicsbaNoData, englishliteraturebaNoData, ttmbaNoData, othersNoData;
    private List<TeacherData> list1, list2, list3, list4, list5, list6, list7, list8, list9, list10, list11, list12, list13, list14, list15, list16, list17, list18;
    private TeacherAdapter adapter;
    private DatabaseReference reference, dbRef;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_faculty, container, false);
        administrativeTeacher = view.findViewById(R.id.administrativeTeacher);
        mathsbscteacher = view.findViewById(R.id.mathsbscteacher);
        statisticsbsc = view.findViewById(R.id.statisticsbsc);
        microbiologybsc = view.findViewById(R.id.microbiologybsc);
        ecbsc = view.findViewById(R.id.ecbsc);
        csbsc = view.findViewById(R.id.csbsc);
        iddbsc = view.findViewById(R.id.iddbsc);
        infobcom = view.findViewById(R.id.infobcom);
        bcom = view.findViewById(R.id.bcom);
        csbcom = view.findViewById(R.id.csbcom);
        honoursbcom = view.findViewById(R.id.honoursbcom);
        afbcom = view.findViewById(R.id.afbcom);
        bba = view.findViewById(R.id.bba);
        bca = view.findViewById(R.id.bca);
        corporateeconomicsba = view.findViewById(R.id.corporateeconomicsba);
        englishliteratureba = view.findViewById(R.id.englishliteratureba);
        ttmba = view.findViewById(R.id.ttmba);
        others = view.findViewById(R.id.others);

        administrativeNoData = view.findViewById(R.id.administrativeNoData);
        mathsbscteacherNoData = view.findViewById(R.id.mathsbscteacherNoData);
        statisticsbscNoData = view.findViewById(R.id.statisticsbscNoData);
        microbiologybscNoData = view.findViewById(R.id.microbiologybscNoData);
        ecbscNoData = view.findViewById(R.id.ecbscNoData);
        csbscNoData = view.findViewById(R.id.csbscNoData);
        iddbscNoData = view.findViewById(R.id.iddbscNoData);
        infobcomNoData = view.findViewById(R.id.infobcomNoData);
        bcomNoData = view.findViewById(R.id.bcomNoData);
        csbcomNoData = view.findViewById(R.id.csbcomNoData);
        honoursbcomNoData = view.findViewById(R.id.honoursbcomNoData);
        afbcomNoData = view.findViewById(R.id.afbcomNoData);
        bbaNoData = view.findViewById(R.id.bbaNoData);
        bcaNoData = view.findViewById(R.id.bcaNoData);
        corporateeconomicsbaNoData = view.findViewById(R.id.corporateeconomicsbaNoData);
        englishliteraturebaNoData = view.findViewById(R.id.englishliteraturebaNoData);
        ttmbaNoData = view.findViewById(R.id.ttmbaNoData);
        othersNoData = view.findViewById(R.id.othersNoData);


        reference = FirebaseDatabase.getInstance().getReference().child("teacher");


        administrativeTeacher();
        mathsTeacher();
        statTeacher();
        microbscTeacher();
        ecbscTeacher();
        csbscTeacher();
        idbscTeacher();
        isbcomTeacher();
        bcomTeacher();
        csbcomTeacher();
        honobcomTeacher();
        afbcomTeacher();
        bbaTeacher();
        bccTeacher();
        cebaTeacher();
        elbaTeacher();
        ttmbaTeacher();
        others();



        return view;

    }


    private void administrativeTeacher() {
        dbRef = reference.child("Administrative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    administrativeNoData.setVisibility(View.VISIBLE);
                    administrativeTeacher.setVisibility(View.GONE);
                } else {
                    administrativeNoData.setVisibility(View.GONE);
                    administrativeTeacher.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    administrativeTeacher.setHasFixedSize(true);
                    administrativeTeacher.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list1, getContext());
                    administrativeTeacher.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void mathsTeacher() {
        dbRef = reference.child("Mathematics Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    mathsbscteacherNoData.setVisibility(View.VISIBLE);
                    mathsbscteacher.setVisibility(View.GONE);
                }else {
                    mathsbscteacherNoData.setVisibility(View.GONE);
                    mathsbscteacher.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    mathsbscteacher.setHasFixedSize(true);
                    mathsbscteacher.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list2, getContext());
                    mathsbscteacher.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void statTeacher() {
        dbRef = reference.child("Statistics Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list3 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    statisticsbscNoData.setVisibility(View.VISIBLE);
                    statisticsbsc.setVisibility(View.GONE);
                }else {
                    statisticsbscNoData.setVisibility(View.GONE);
                    statisticsbsc.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    statisticsbsc.setHasFixedSize(true);
                    statisticsbsc.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list3, getContext());
                    statisticsbsc.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void microbscTeacher() {
        dbRef = reference.child("Microbiology Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list4 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    microbiologybscNoData.setVisibility(View.VISIBLE);
                    microbiologybsc.setVisibility(View.GONE);
                }else {
                    microbiologybscNoData.setVisibility(View.GONE);
                    microbiologybsc.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    microbiologybsc.setHasFixedSize(true);
                    microbiologybsc.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list4, getContext());
                    microbiologybsc.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void ecbscTeacher() {
        dbRef = reference.child("Electronics and Communication Science Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list5 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    ecbscNoData.setVisibility(View.VISIBLE);
                    ecbsc.setVisibility(View.GONE);
                }else {
                    ecbscNoData.setVisibility(View.GONE);
                    ecbsc.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list5.add(data);
                    }
                    ecbsc.setHasFixedSize(true);
                    ecbsc.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list5, getContext());
                    ecbsc.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    ////////////////////////////////////////////////////////////////
    private void csbscTeacher() {
        dbRef = reference.child("Computer Science Department BSC");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list6 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    csbscNoData.setVisibility(View.VISIBLE);
                    csbsc.setVisibility(View.GONE);
                }else {
                    csbscNoData.setVisibility(View.GONE);
                    csbsc.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list6.add(data);
                    }
                    csbsc.setHasFixedSize(true);
                    csbsc.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list6, getContext());
                    csbsc.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    //
    private void idbscTeacher() {
        dbRef = reference.child("Interior and Decor Design Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list7 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    iddbscNoData.setVisibility(View.VISIBLE);
                    iddbsc.setVisibility(View.GONE);
                }else {
                    iddbscNoData.setVisibility(View.GONE);
                    iddbsc.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list7.add(data);
                    }
                    iddbsc.setHasFixedSize(true);
                    iddbsc.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list7, getContext());
                    iddbsc.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    //
    private void isbcomTeacher() {
        dbRef = reference.child("Information System Management Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list8 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    infobcomNoData.setVisibility(View.VISIBLE);
                    infobcom.setVisibility(View.GONE);
                }else {
                    infobcomNoData.setVisibility(View.GONE);
                    infobcom.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list8.add(data);
                    }
                    infobcom.setHasFixedSize(true);
                    infobcom.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list8, getContext());
                    infobcom.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    //
    private void bcomTeacher() {
        dbRef = reference.child("Bachelor of Commerce Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list9 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    bcomNoData.setVisibility(View.VISIBLE);
                    bcom.setVisibility(View.GONE);
                }else {
                    bcomNoData.setVisibility(View.GONE);
                    bcom.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list9.add(data);
                    }
                    bcom.setHasFixedSize(true);
                    bcom.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list9, getContext());
                    bcom.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    //
    private void csbcomTeacher() {
        dbRef = reference.child("Computer Science Department BCOM");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list10 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    csbcomNoData.setVisibility(View.VISIBLE);
                    csbcom.setVisibility(View.GONE);
                }else {
                    csbcomNoData.setVisibility(View.GONE);
                    csbcom.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list10.add(data);
                    }
                    csbcom.setHasFixedSize(true);
                    csbcom.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list10, getContext());
                    csbcom.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    //
    private void honobcomTeacher() {
        dbRef = reference.child("Honours Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list11 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    honoursbcomNoData.setVisibility(View.VISIBLE);
                    honoursbcom.setVisibility(View.GONE);
                }else {
                    honoursbcomNoData.setVisibility(View.GONE);
                    honoursbcom.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list11.add(data);
                    }
                    honoursbcom.setHasFixedSize(true);
                    honoursbcom.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list11, getContext());
                    honoursbcom.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    //
    private void afbcomTeacher() {
        dbRef = reference.child("Accounts and Finance Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list12 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    afbcomNoData.setVisibility(View.VISIBLE);
                    afbcom.setVisibility(View.GONE);
                }else {
                    afbcomNoData.setVisibility(View.GONE);
                    afbcom.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list12.add(data);
                    }
                    afbcom.setHasFixedSize(true);
                    afbcom.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list12, getContext());
                    afbcom.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    //
    private void bbaTeacher() {
        dbRef = reference.child("Bachelor of Business Administration Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list13 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    bbaNoData.setVisibility(View.VISIBLE);
                    bba.setVisibility(View.GONE);
                }else {
                    bbaNoData.setVisibility(View.GONE);
                    bba.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list13.add(data);
                    }
                    bba.setHasFixedSize(true);
                    bba.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list13, getContext());
                    bba.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    //
    private void bccTeacher() {
        dbRef = reference.child("Bachelor of Computer Application Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list14 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    bcaNoData.setVisibility(View.VISIBLE);
                    bca.setVisibility(View.GONE);
                }else {
                    bcaNoData.setVisibility(View.GONE);
                    bca.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list14.add(data);
                    }
                    bca.setHasFixedSize(true);
                    bca.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list14, getContext());
                    bca.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    //
    private void cebaTeacher() {
        dbRef = reference.child("Corporate Economics Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list15 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    corporateeconomicsbaNoData.setVisibility(View.VISIBLE);
                    corporateeconomicsba.setVisibility(View.GONE);
                }else {
                    corporateeconomicsbaNoData.setVisibility(View.GONE);
                    corporateeconomicsba.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list15.add(data);
                    }
                    corporateeconomicsba.setHasFixedSize(true);
                    corporateeconomicsba.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list15, getContext());
                    corporateeconomicsba.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    //
    private void elbaTeacher() {
        dbRef = reference.child("English Literature Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list16 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    englishliteraturebaNoData.setVisibility(View.VISIBLE);
                    englishliteratureba.setVisibility(View.GONE);
                }else {
                    englishliteraturebaNoData.setVisibility(View.GONE);
                    englishliteratureba.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list16.add(data);
                    }
                    englishliteratureba.setHasFixedSize(true);
                    englishliteratureba.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list16, getContext());
                    englishliteratureba.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    //
    private void ttmbaTeacher() {
        dbRef = reference.child("Tourism and Travel Management Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list17 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    ttmbaNoData.setVisibility(View.VISIBLE);
                    ttmba.setVisibility(View.GONE);
                }else {
                    ttmbaNoData.setVisibility(View.GONE);
                    ttmba.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list17.add(data);
                    }
                    ttmba.setHasFixedSize(true);
                    ttmba.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list17, getContext());
                    ttmba.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }



    private void others() {
        dbRef = reference.child("Others");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list18 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    othersNoData.setVisibility(View.VISIBLE);
                    others.setVisibility(View.GONE);
                }else {
                    othersNoData.setVisibility(View.GONE);
                    others.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list18.add(data);
                    }
                    others.setHasFixedSize(true);
                    others.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list18, getContext());
                    others.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}