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
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;

public class FragmentCijevNorma extends Fragment {

    private Spinner spinner_cijevD, spinner_cijevT;
    private String[] stringD;

    private ArrayAdapter<String> arrayAdapterD;

    private String[]  stringT1, stringT2, stringT3, stringT4, stringT5, stringT6, stringT7, stringT8, stringT9,  stringT10, stringT11, stringT12;
    private ArrayAdapter<String> arrayAdapterT;


    private EditText et_duljina, et_cijena;

    private Button btn_masa, btn_cijena;
    private TextView tv_masa, tv_cijena;



    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.spinner_cijevD=view.findViewById(R.id.spinner_vanjski_promjer_cijev);
        this.spinner_cijevT=view.findViewById(R.id.spinner_debljina_stjenke_cijev);

        this.et_duljina=view.findViewById(R.id.et_duljina_cijev);
        this.et_cijena=view.findViewById(R.id.et_cijena_cijev);

        this.btn_masa=view.findViewById(R.id.btn_izracun_mase_cijev);
        this.tv_masa=view.findViewById(R.id.tv_masa_cijev);

        this.btn_cijena=view.findViewById(R.id.btn_izracun_cijene_cijev);
        this.tv_cijena=view.findViewById(R.id.tv_tube_price);

        stringD=getResources().getStringArray(R.array.vanjski_promjer);

        this.arrayAdapterD=new ArrayAdapter<>(getContext(), R.layout.text, stringD);
        spinner_cijevD.setAdapter(arrayAdapterD);

        stringT1=getResources().getStringArray(R.array.cijevT1);
        stringT2=getResources().getStringArray(R.array.cijevT2);
        stringT3=getResources().getStringArray(R.array.cijevT3);
        stringT4=getResources().getStringArray(R.array.cijevT4);
        stringT5=getResources().getStringArray(R.array.cijevT5);
        stringT6=getResources().getStringArray(R.array.cijevT6);
        stringT7=getResources().getStringArray(R.array.cijevT7);
        stringT8=getResources().getStringArray(R.array.cijevT8);
        stringT9=getResources().getStringArray(R.array.cijevT9);
        stringT10=getResources().getStringArray(R.array.cijevT10);
        stringT11=getResources().getStringArray(R.array.cijevT11);
        stringT12=getResources().getStringArray(R.array.cijevT12);



        spinner_cijevD.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    arrayAdapterT=new ArrayAdapter<>(getContext(),R.layout.text, stringT1 );
                }
                if(position==1){
                    arrayAdapterT=new ArrayAdapter<>(getContext(),R.layout.text, stringT2 );
                }
                if(position==2){
                    arrayAdapterT=new ArrayAdapter<>(getContext(),R.layout.text, stringT3 );
                }
                if(position==3){
                    arrayAdapterT=new ArrayAdapter<>(getContext(),R.layout.text, stringT4);
                }
                if(position==4){
                    arrayAdapterT=new ArrayAdapter<>(getContext(),R.layout.text, stringT5 );
                }
                if(position==5){
                    arrayAdapterT=new ArrayAdapter<>(getContext(),R.layout.text, stringT6 );
                }
                if(position==6){
                    arrayAdapterT=new ArrayAdapter<>(getContext(),R.layout.text, stringT7 );
                }
                if(position==7){
                    arrayAdapterT=new ArrayAdapter<>(getContext(),R.layout.text, stringT8 );
                }
                if(position==8){
                    arrayAdapterT=new ArrayAdapter<>(getContext(),R.layout.text, stringT9 );
                }
                if(position==9){
                    arrayAdapterT=new ArrayAdapter<>(getContext(),R.layout.text, stringT10 );
                }
                if(position==10){
                    arrayAdapterT=new ArrayAdapter<>(getContext(),R.layout.text, stringT11 );
                }
                if(position==11){
                    arrayAdapterT=new ArrayAdapter<>(getContext(),R.layout.text, stringT12 );
                }
                saveD(); readT();
                spinner_cijevT.setAdapter(arrayAdapterT);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        btn_masa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp_duljina=et_duljina.getText().toString();
                if("".equals(temp_duljina)){
                    Toast.makeText(getContext(),"Potrebno je upisati duljinu cijevi!", Toast.LENGTH_LONG).show();
                }
                else{
                    tv_masa.setText(String.format("%.3f", formula_cijev()) + " [kg]");
                }

            }
        });

        btn_cijena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp_cijena=et_cijena.getText().toString();
                String temp_duljina=et_duljina.getText().toString();
                if ("".equals(temp_cijena)){
                    Toast.makeText(getContext(), "Potrebno je unjeti cijenu!", Toast.LENGTH_LONG).show();

                }
                else if("".equals(temp_duljina)){
                    Toast.makeText(getContext(), "Potrebno je unjeti duljinu cijevi!", Toast.LENGTH_LONG).show();
                }
                else {
                    tv_cijena.setText(String.format("%.2f", formula_cijev()*Double.parseDouble(temp_cijena)) + " [kn]");
                }
            }
        });


    }

    public double saveD(){
        String temp_vanjski_promjer=spinner_cijevD.getSelectedItem().toString();
        double D=0;
        if (!"".equals(temp_vanjski_promjer)){
            D=Double.parseDouble(temp_vanjski_promjer);
        }
        return D;
    }
    public void readT(){
        spinner_cijevT.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                double duljina=0;
                duljina=spinner_cijevT.getCount();
                for(int i=0; i<duljina; i++){
                    if(position==i){
                        saveT();
                    }
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public double saveT(){
        String temp_debljina_stjenke=spinner_cijevT.getSelectedItem().toString();
        double T = 0;
        if(!"".equals(temp_debljina_stjenke)){
            T=Double.parseDouble(temp_debljina_stjenke);
        }
        return T;
    }

    public double formula_cijev(){
        double L=Double.parseDouble(et_duljina.getText().toString());
        double volumen=0;
        volumen=((saveD()*saveT())-(Math.pow(saveT(),2)))*3.14*L;
        return volumen*0.00000785;
    }

}
