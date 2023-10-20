package com.example.zavrsni;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentReducirUnos extends Fragment {

    private EditText et_vanjski_promjerD, et_vanjski_promjerD1, et_duljinaL, et_debljina_stjenkeT, et_debljina_stjenkeT1, et_cijena;
    private Button btn_masa, btn_cijena;
    private TextView tv_masa, tv_cijena;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sixth, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.et_vanjski_promjerD=view.findViewById(R.id.et_vanjski_promjer_sireg_dijela_upis_reducir);
        this.et_vanjski_promjerD1=view.findViewById(R.id.et_vanjski_promjer_uzeg_dijela_upis_reducir);
        this.et_duljinaL=view.findViewById(R.id.et_duljina_upis_reducir);
        this.et_debljina_stjenkeT=view.findViewById(R.id.et_debljina_stjenke_sireg_dijela_upis_reducir);
        this.et_debljina_stjenkeT1=view.findViewById(R.id.et_debljina_stjenke_uzeg_dijela_upis_reducir);
        this.et_cijena=view.findViewById(R.id.et_cijena_upis_reducir);

        this.btn_masa=view.findViewById(R.id.btn_izracun_mase_upis_reducir);
        this.btn_cijena=view.findViewById(R.id.btn_izracun_cijene_upis_reducir);

        this.tv_masa=view.findViewById(R.id.tv_masa_upis_reducir);
        this.tv_cijena=view.findViewById(R.id.tv_cijena_upis_reducir);


        btn_masa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp_vanjski_promjerD=et_vanjski_promjerD.getText().toString();
                String temp_vanjski_promjerD1=et_vanjski_promjerD1.getText().toString();
                String temp_debljina_stjenkeT=et_debljina_stjenkeT.getText().toString();
                String temp_debljina_stjenkeT1=et_debljina_stjenkeT1.getText().toString();
                String temp_duljinaL=et_duljinaL.getText().toString();
                if("".equals(temp_vanjski_promjerD) || "".equals(temp_vanjski_promjerD1) || "".equals(temp_debljina_stjenkeT) || "".equals(temp_debljina_stjenkeT1) || "".equals(temp_duljinaL)){
                    Toast.makeText(getContext(),"Nisu upisane sve potrebne vrijednosti", Toast.LENGTH_LONG).show();
                }
                else{

                    tv_masa.setText(String.format("%.3f", formula_upis_reducir()) + " [kg]");
                }
            }
        });

        btn_cijena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp_vanjski_promjerD=et_vanjski_promjerD.getText().toString();
                String temp_vanjski_promjerD1=et_vanjski_promjerD1.getText().toString();
                String temp_debljina_stjenkeT=et_debljina_stjenkeT.getText().toString();
                String temp_debljina_stjenkeT1=et_debljina_stjenkeT1.getText().toString();
                String temp_duljinaL=et_duljinaL.getText().toString();
                String temp_cijena=et_cijena.getText().toString();

                if("".equals(temp_vanjski_promjerD) || "".equals(temp_vanjski_promjerD1) || "".equals(temp_debljina_stjenkeT) || "".equals(temp_debljina_stjenkeT1) || "".equals(temp_duljinaL)){
                    Toast.makeText(getContext(),"Nisu unešene sve potreben vrijednosti.", Toast.LENGTH_LONG).show();
                }
                else if("".equals(temp_cijena)){
                    Toast.makeText(getContext(),"Potrebno je unijeti cijenu proizvoda.", Toast.LENGTH_LONG).show();
                }
                else{
                    double C=Double.parseDouble(temp_cijena);
                    tv_cijena.setText(String.format("%.2f",formula_upis_reducir()*C)+" [kn]");
                }


            }
        });
    }

    public double formula_upis_reducir(){
        double volumen=0;
        double D=Double.parseDouble(et_vanjski_promjerD.getText().toString());
        double D1=Double.parseDouble(et_vanjski_promjerD.getText().toString());
        double T=Double.parseDouble(et_debljina_stjenkeT.getText().toString());
        double T1=Double.parseDouble(et_debljina_stjenkeT1.getText().toString());
        double L=Double.parseDouble(et_duljinaL.getText().toString());
        if(T>(D/4) || T1>(D1/4)){
            Toast.makeText(getContext(),"Neispravan unos.", Toast.LENGTH_LONG).show();
        }
        else{
            volumen=(3.14/3)*(L-(0.5*Math.sqrt(D*T))-(0.5*Math.sqrt(D1*T1)));
            volumen*= (D*T) -Math.pow(T,2)-(T*T1)+(D1*T1)-Math.pow(T1,2)+(0.5*D*T1)+(0.5*D1*T);
            return volumen*0.00000785;
        }
        return 0;
    }
}