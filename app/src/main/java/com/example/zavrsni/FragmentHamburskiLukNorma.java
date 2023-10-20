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

public class FragmentHamburskiLukNorma extends Fragment {

    private Spinner spinner_hamburski_lukD, spinner_hamburski_lukF, spinner_hamburski_lukT;
    private String[] stringD;

    private ArrayAdapter<String> arrayAdapterD;

    private String[] stringF1, stringF2, stringF3, stringF4, stringF5, stringF6, stringF7, stringF8, stringF9, stringF10,
                     stringF11, stringF12;

    private String[] stringT1, stringT2, stringT3, stringT4, stringT5, stringT6, stringT7, stringT8, stringT9, stringT10,
            stringT11;

    private ArrayAdapter<String> arrayAdapterF, arrayAdapterT;


    private EditText et_kut_savijanja, et_cijena;

    private Button btn_masa, btn_cijena;
    private TextView tv_masa, tv_cijena;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.spinner_hamburski_lukD=view.findViewById(R.id.spinner_vanjski_promjer_hamburski_luk);
        this.spinner_hamburski_lukF=view.findViewById(R.id.spinner_polumjer_savijanja_hamburski_luk);
        this.spinner_hamburski_lukT=view.findViewById(R.id.spinner_debljina_stjenke_hamburski_luk);

        this.et_kut_savijanja=view.findViewById(R.id.et_kut_savijanja_hamburski_luk);
        this.et_cijena=view.findViewById(R.id.et_cijena_hamburski_luk);

        this.btn_masa=view.findViewById(R.id.btn_izracun_mase_hamburski_luk);
        this.tv_masa=view.findViewById(R.id.tv_masa_hamburski_luk);

        this.btn_cijena=view.findViewById(R.id.btn_izracun_cijene_hamburski_luk);
        this.tv_cijena=view.findViewById(R.id.tv_cijena_hamburski_luk);


        stringD=getResources().getStringArray(R.array.vanjski_promjer);

        this.arrayAdapterD=new ArrayAdapter<>(getContext(), R.layout.text, stringD);
        spinner_hamburski_lukD.setAdapter(arrayAdapterD);

        stringF1=getResources().getStringArray(R.array.hamburski_lukF1);
        stringF2=getResources().getStringArray(R.array.hamburski_lukF2);
        stringF3=getResources().getStringArray(R.array.hamburski_lukF3);
        stringF4=getResources().getStringArray(R.array.hamburski_lukF4);
        stringF5=getResources().getStringArray(R.array.hamburski_lukF5);
        stringF6=getResources().getStringArray(R.array.hamburski_lukF6);
        stringF7=getResources().getStringArray(R.array.hamburski_lukF7);
        stringF8=getResources().getStringArray(R.array.hamburski_lukF8);
        stringF9=getResources().getStringArray(R.array.hamburski_lukF9);
        stringF10=getResources().getStringArray(R.array.hamburski_lukF10);
        stringF11=getResources().getStringArray(R.array.hamburski_lukF11);
        stringF12=getResources().getStringArray(R.array.hamburski_lukF12);


        stringT1=getResources().getStringArray(R.array.hamburski_lukT1);
        stringT2=getResources().getStringArray(R.array.hamburski_lukT2);
        stringT3=getResources().getStringArray(R.array.hamburski_lukT3);
        stringT4=getResources().getStringArray(R.array.hamburski_lukT4);
        stringT5=getResources().getStringArray(R.array.hamburski_lukT5);
        stringT6=getResources().getStringArray(R.array.hamburski_lukT6);
        stringT7=getResources().getStringArray(R.array.hamburski_lukT7);
        stringT8=getResources().getStringArray(R.array.hamburski_lukT8);
        stringT9=getResources().getStringArray(R.array.hamburski_lukT9);
        stringT10=getResources().getStringArray(R.array.hamburski_lukT10);
        stringT11=getResources().getStringArray(R.array.hamburski_lukT11);


        spinner_hamburski_lukD.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    arrayAdapterF=new ArrayAdapter<>(getContext(),R.layout.text, stringF1 );
                    arrayAdapterT=new ArrayAdapter<>(getContext(),R.layout.text, stringT1 );
                }
                if(position ==1){
                    arrayAdapterF=new ArrayAdapter<>(getContext(),R.layout.text, stringF2 );
                    arrayAdapterT=new ArrayAdapter<>(getContext(),R.layout.text, stringT2 );
                }
                if(position ==2){
                    arrayAdapterF=new ArrayAdapter<>(getContext(),R.layout.text, stringF3 );
                    arrayAdapterT=new ArrayAdapter<>(getContext(),R.layout.text, stringT3 );
                }
                if(position ==3){
                    arrayAdapterF=new ArrayAdapter<>(getContext(),R.layout.text, stringF4 );
                    arrayAdapterT=new ArrayAdapter<>(getContext(),R.layout.text, stringT4 );
                }
                if(position ==4){
                    arrayAdapterF=new ArrayAdapter<>(getContext(),R.layout.text, stringF5 );
                    arrayAdapterT=new ArrayAdapter<>(getContext(),R.layout.text, stringT4 );
                }
                if(position ==5){
                    arrayAdapterF=new ArrayAdapter<>(getContext(),R.layout.text, stringF6 );
                    arrayAdapterT=new ArrayAdapter<>(getContext(),R.layout.text, stringT5 );
                }
                if(position ==6){
                    arrayAdapterF=new ArrayAdapter<>(getContext(),R.layout.text, stringF7 );
                    arrayAdapterT=new ArrayAdapter<>(getContext(),R.layout.text, stringT6 );
                }
                if(position==7){
                    arrayAdapterF=new ArrayAdapter<>(getContext(),R.layout.text, stringF8);
                    arrayAdapterT=new ArrayAdapter<>(getContext(),R.layout.text, stringT7);
                }
                if(position==8){
                    arrayAdapterF=new ArrayAdapter<>(getContext(),R.layout.text, stringF9);
                    arrayAdapterT=new ArrayAdapter<>(getContext(),R.layout.text, stringT8);
                }
                if(position==9){
                    arrayAdapterF=new ArrayAdapter<>(getContext(),R.layout.text, stringF10);
                    arrayAdapterT=new ArrayAdapter<>(getContext(),R.layout.text, stringT9);
                }
                if(position==10){
                    arrayAdapterF=new ArrayAdapter<>(getContext(),R.layout.text, stringF11);
                    arrayAdapterT=new ArrayAdapter<>(getContext(),R.layout.text, stringT10);
                }
                if(position==11){
                    arrayAdapterF=new ArrayAdapter<>(getContext(),R.layout.text, stringF12);
                    arrayAdapterT=new ArrayAdapter<>(getContext(),R.layout.text, stringT11);
                }
                saveD(); readF(); readT();

                spinner_hamburski_lukF.setAdapter(arrayAdapterF);
                spinner_hamburski_lukT.setAdapter(arrayAdapterT);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn_masa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp_kut_savijanja=et_kut_savijanja.getText().toString();
                if("".equals(temp_kut_savijanja)){
                    Toast.makeText(getContext(),"Kut savijanja nije određen! Upišite kut savijanja!", Toast.LENGTH_LONG).show();
                }
                else{
                    double value3=0;
                    value3=Double.parseDouble(temp_kut_savijanja);
                    if(value3>180 || value3<0){
                        Toast.makeText(getContext(),"Kut savijanja nije dobro definiran! Kut savijanja je u intervalu [0° , 180°]", Toast.LENGTH_LONG).show();
                        et_kut_savijanja.setText("");
                    }
                    else{
                        tv_masa.setText(String.format("%.3f", formula_koljeno()) + " [kg]");
                    }
                }

            }
        });

        btn_cijena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp_kut=et_kut_savijanja.getText().toString();
                String temp_cijena=et_cijena.getText().toString();

                if ("".equals(temp_cijena)){
                    Toast.makeText(getContext(), "Potrebno je unjeti cijenu!", Toast.LENGTH_LONG).show();

                }
                else if("".equals(temp_kut)){
                    Toast.makeText(getContext(), "Potrebno je unjeti kut savijanja!", Toast.LENGTH_LONG).show();
                }
                else {
                    double cijena=Double.parseDouble(temp_cijena);
                    tv_cijena.setText(String.format("%.2f", formula_koljeno()*cijena) + " [kn]");

                }
            }
        });

    }

    public double saveD(){
        String temp_vanjski_promjer=spinner_hamburski_lukD.getSelectedItem().toString();
        double D=0;
        if (!"".equals(temp_vanjski_promjer)){
            D=Double.parseDouble(temp_vanjski_promjer);
        }
        return D;
    }

    public void readF(){

        spinner_hamburski_lukF.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                double F=0;
                F=spinner_hamburski_lukF.getCount();
                for(int i=0; i<F; i++){
                    if(position==i){
                        saveF();
                    }
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public double saveF(){
        String temp_polumjer_savijanja=spinner_hamburski_lukF.getSelectedItem().toString();
        double F = 0;
        if(!"".equals(temp_polumjer_savijanja)){
            F=Double.parseDouble(temp_polumjer_savijanja);
        }
        return F;
    }

    public void readT(){

        spinner_hamburski_lukT.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                double T=0;
                T=spinner_hamburski_lukT.getCount();
                for(int i=0; i<T; i++){
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
        String temp_debljina_stjenke=spinner_hamburski_lukT.getSelectedItem().toString();
        double T = 0;
        if(!"".equals(temp_debljina_stjenke)){
            T=Double.parseDouble(temp_debljina_stjenke);
        }
        return T;
    }

    public double formula_koljeno(){
        double volumen=0;
        double kut=Double.parseDouble(et_kut_savijanja.getText().toString());
        volumen=((saveD()*saveT())-(Math.pow(saveT(),2)))*((3.14*3.14*saveF()*kut)/180);
        return volumen*0.00000785;
    }

}
