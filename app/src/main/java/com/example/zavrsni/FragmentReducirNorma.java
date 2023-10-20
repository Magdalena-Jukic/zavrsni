package com.example.zavrsni;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class FragmentReducirNorma extends Fragment {

    private Spinner spinner_reducirD, spinner_reducirD1, spinner_reducirL;
    private String[] stringD, stringD1, stringL;

    private ArrayAdapter<String> arrayAdapterD, arrayAdapterD1, arrayAdapterL;

    private EditText et_siri_dio, et_uzi_dio, et_cijena;
    private Button btn_masa, btn_cijena;
    private TextView tv_masa, tv_cijena;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fifth, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.spinner_reducirD=view.findViewById(R.id.spinner_vanjski_promjer_sireg_dijela_reducir);
        this.spinner_reducirD1=view.findViewById(R.id.spinner_vanjski_promjer_uzeg_dijela_reducir);
        this.spinner_reducirL=view.findViewById(R.id.spinner_duljina_reducir);

        this.stringD=getResources().getStringArray(R.array.vanjski_promjer);

        this.arrayAdapterD=new ArrayAdapter<>(getContext(), R.layout.text, stringD);
        spinner_reducirD.setAdapter(arrayAdapterD);

        this.stringD1=getResources().getStringArray(R.array.vanjski_promjer);
        this.stringL=getResources().getStringArray(R.array.reducirL);

        this.btn_masa=view.findViewById(R.id.btn_izracun_mase_reducir);
        this.btn_cijena=view.findViewById(R.id.btn_izracun_cijene_reducir);

        this.et_siri_dio=view.findViewById(R.id.et_debljina_stjenke_sireg_dijela_reducir);
        this.et_uzi_dio=view.findViewById(R.id.et_debljina_stjenke_uzeg_dijela_reducir);
        this.et_cijena=view.findViewById(R.id.et_cijena_reducir);

        this.tv_masa=view.findViewById(R.id.tv_masa_reducir);
        this.tv_cijena=view.findViewById(R.id.tv_cijena_reducir);

        spinner_reducirD.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ArrayList<String> arrayD1 = new ArrayList<>();
                ArrayList<String> arrayL=new ArrayList<>();

                if(position==0){
                    arrayD1.add("17.2");
                    arrayAdapterD1=new ArrayAdapter<>(getContext() , R.layout.text, arrayD1);

                    arrayL.add(stringL[position]);
                    arrayAdapterL=new ArrayAdapter<String>(getContext(), R.layout.text, arrayL);
                }
              if(position==1){
                  arrayD1.add(stringD1[position-1]);
                  arrayAdapterD1=new ArrayAdapter<>(getContext(), R.layout.text, arrayD1);

                  arrayL.add(stringL[position]);
                  arrayAdapterL=new ArrayAdapter<>(getContext(), R.layout.text, arrayL);
                }

              if(position ==2){
                  for (int i=1;i<=2; i++){
                      arrayD1.add(stringD1[position-i]);
                  }
                  arrayAdapterD1=new ArrayAdapter<>(getContext(), R.layout.text, arrayD1);

                  arrayL.add(stringL[position]);
                  arrayAdapterL=new ArrayAdapter<>(getContext(), R.layout.text, arrayL);
              }
               if(position ==3){
                   PositionSetter(arrayD1, position);
                   arrayAdapterD1=new ArrayAdapter<>(getContext(), R.layout.text, arrayD1);

                   arrayL.add(stringL[position-1]);
                   arrayAdapterL=new ArrayAdapter<>(getContext(), R.layout.text, arrayL);
               }
                if(position ==4){
                    PositionSetter(arrayD1, position);
                    arrayAdapterD1=new ArrayAdapter<>(getContext(), R.layout.text, arrayD1);

                    arrayL.add(stringL[position-1]);
                    arrayAdapterL=new ArrayAdapter<>(getContext(), R.layout.text, arrayL);
                }
                 if(position ==5){
                     PositionSetter(arrayD1, position);
                     arrayAdapterD1=new ArrayAdapter<>(getContext(), R.layout.text, arrayD1);

                     arrayL.add(stringL[position-1]);
                     arrayAdapterL=new ArrayAdapter<>(getContext(), R.layout.text, arrayL);
                }
                if(position ==6){
                    PositionSetter(arrayD1, position);
                     arrayAdapterD1=new ArrayAdapter<>(getContext(), R.layout.text, arrayD1);

                     arrayL.add(stringL[position-1]);
                     arrayAdapterL=new ArrayAdapter<>(getContext(), R.layout.text, arrayL);
                }
                if(position==7){
                    PositionSetter(arrayD1, position);
                    arrayAdapterD1=new ArrayAdapter<>(getContext(), R.layout.text, arrayD1);

                    arrayL.add(stringL[position-2]);
                    arrayAdapterL=new ArrayAdapter<>(getContext(), R.layout.text, arrayL);
                }
                if(position==8){
                    PositionSetter(arrayD1, position);
                    arrayAdapterD1=new ArrayAdapter<>(getContext(), R.layout.text, arrayD1);

                    arrayL.add(stringL[position-2]);
                    arrayAdapterL=new ArrayAdapter<>(getContext(), R.layout.text, arrayL);

                }
                if(position==9){
                    PositionSetter(arrayD1, position);
                    arrayAdapterD1=new ArrayAdapter<>(getContext(), R.layout.text, arrayD1);

                    arrayL.add(stringL[position-2]);
                    arrayAdapterL=new ArrayAdapter<>(getContext(), R.layout.text, arrayL);

                }
              if(position==10){
                  PositionSetter(arrayD1, position);
                  arrayAdapterD1=new ArrayAdapter<>(getContext(), R.layout.text, arrayD1);

                  arrayL.add(stringL[position-2]);
                  arrayAdapterL=new ArrayAdapter<>(getContext(), R.layout.text, arrayL);

                }
                if(position==11){
                    PositionSetter(arrayD1, position);
                    arrayAdapterD1=new ArrayAdapter<>(getContext(), R.layout.text, arrayD1);

                    arrayL.add(stringL[position-2]);
                    arrayAdapterL=new ArrayAdapter<>(getContext(), R.layout.text, arrayL);

                }
                saveD(); readD1(); readL();
                spinner_reducirD1.setAdapter(arrayAdapterD1);
                spinner_reducirL.setAdapter(arrayAdapterL);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn_masa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp_t=et_siri_dio.getText().toString();
                String temp_t1=et_uzi_dio.getText().toString();

                if("".equals(temp_t) || "".equals(temp_t1)){
                    Toast.makeText(getContext(),"Nisu unešene sve potrebne vrijednosti.", Toast.LENGTH_LONG).show();
                }
                else{
                    tv_masa.setText(String.format("%.3f", formula_reducir())+" [kg]");
                }
            }
        });

        btn_cijena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp_t=et_siri_dio.getText().toString();
                String temp_t1=et_uzi_dio.getText().toString();
                String temp_cijena=et_cijena.getText().toString();

                if("".equals(temp_t) || "".equals(temp_t1)){
                    Toast.makeText(getContext(),"Potrebno je unjeti vrijednosti debljina stjenki.", Toast.LENGTH_LONG).show();
                }
                else if("".equals(temp_cijena)){
                    Toast.makeText(getContext(),"Potrebno je unjeti cijenu proizvoda.", Toast.LENGTH_LONG).show();
                }
                else{
                    double cijena=0;
                    cijena=Double.parseDouble(temp_cijena)*formula_reducir();
                    tv_cijena.setText(String.format("%.2f", cijena)+" [kn]");
                }


            }
        });

    }

    public void PositionSetter(ArrayList<String> array, int position){
        for (int i=1;i<=3;i++){
            array.add(stringD1[position-i]);
        }
    }


    public double saveD(){
        String temp_vanjski_promjerD=spinner_reducirD.getSelectedItem().toString();
        double D=0;
        if (!"".equals(temp_vanjski_promjerD)){
            D=Double.parseDouble(temp_vanjski_promjerD);
        }
        return D;
    }

    public void readD1(){

        spinner_reducirD1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                double lenght=0;
                lenght=spinner_reducirD1.getCount();
                for(int i=0; i<lenght; i++){
                    if(position==i){
                        saveD1();
                    }
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public double saveD1(){
        String temp_wall_thickness=spinner_reducirD1.getSelectedItem().toString();
        double sum2 = 0;
        if(!"".equals(temp_wall_thickness)){
            sum2=Double.parseDouble(temp_wall_thickness);
        }
        return sum2;
    }

    public void readL(){

        spinner_reducirL.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                double L=0;
                L=spinner_reducirL.getCount();
                for(int i=0; i<L; i++){
                    if(position==i){
                        saveL();
                    }
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public double saveL(){
        String temp_wall_thickness=spinner_reducirL.getSelectedItem().toString();
        double L = 0;
        if(!"".equals(temp_wall_thickness)){
            L=Double.parseDouble(temp_wall_thickness);
        }
        return L;
    }

    public double formula_reducir(){
        double volumen=0;
        double T=Double.parseDouble(et_siri_dio.getText().toString());
        double T1=Double.parseDouble(et_uzi_dio.getText().toString());

        if(T>(saveD()/4) || T1 > (saveD1()/4)){
            Toast.makeText(getContext(),"Pogrešno je unešena vrijednost debljina stjenki.", Toast.LENGTH_LONG).show();
        }
        else{
            volumen=(3.14/3)*(saveL()-(0.5*Math.sqrt(saveD()*T))-(0.5*Math.sqrt(saveD1()*T1)));
            volumen*= (saveD()*T) -Math.pow(T,2)-(T*T1)+(saveD1()*T1)-Math.pow(T1,2)+(0.5*saveD()*T1)+(0.5*saveD1()*T);
            return volumen*0.00000785;

        }
        return 0;
    }

}