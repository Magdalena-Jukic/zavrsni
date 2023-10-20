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

public class FragmentHamburskiLukUnos extends Fragment {

    private EditText et_vanjski_promjer, et_polumjer_savijanja, et_debljina_stjenke,et_kut, et_cijena;
    private Button btn_masa, btn_cijena;
    private TextView tv_masa, tv_cijena;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fourth, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.et_vanjski_promjer=view.findViewById(R.id.et_vanjski_promjer_upis_hamburski_luk);
        this.et_polumjer_savijanja=view.findViewById(R.id.et_polumjer_savijanja_upis_hamburski_luk);
        this.et_debljina_stjenke=view.findViewById(R.id.et_debljina_stjenke_upis_hamburski_luk);
        this.et_kut=view.findViewById(R.id.et_kut_savijanja_upis_hamburski_luk);
        this.et_cijena=view.findViewById(R.id.et_cijena_upis_hamburski_luk);

        this.btn_masa=view.findViewById(R.id.btn_izracun_cijene_upis_hamburski_luk);
        this.btn_cijena=view.findViewById(R.id.btn_izracun_cijene_upis_hamburski_luk);

        this.tv_masa=view.findViewById(R.id.tv_masa_upis_hamburski_luk);
        this.tv_cijena=view.findViewById(R.id.tv_cijena_upis_hamburski_luk);


        btn_masa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp_vanjski_promjer=et_vanjski_promjer.getText().toString();
                String temp_polumjer_savijanja=et_polumjer_savijanja.getText().toString();
                String temp_debljina_stjenke=et_debljina_stjenke.getText().toString();
                String temp_kut=et_kut.getText().toString();

                if("".equals(temp_vanjski_promjer) || "".equals(temp_polumjer_savijanja) || "".equals(temp_debljina_stjenke) || "".equals(temp_kut)){
                    Toast.makeText(getContext(),"Nisu upisane sve potrebne vrijednosti", Toast.LENGTH_LONG).show();
                }
                else{
                    tv_masa.setText(String.format("%.3f", formula_upis_koljeno()) + " [kg]");
                }
            }
        });

        btn_cijena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String temp_vanjski_promjer=et_vanjski_promjer.getText().toString();
                String temp_polumjer_savijanja=et_polumjer_savijanja.getText().toString();
                String temp_debljina_stjenke=et_debljina_stjenke.getText().toString();
                String temp_kut=et_kut.getText().toString();
                String temp_cijena=et_cijena.getText().toString();

                if ("".equals(temp_cijena)){
                    Toast.makeText(getContext(), "Potrebno je unjeti cijenu.", Toast.LENGTH_LONG).show();
                }
                else if("".equals(temp_vanjski_promjer) || "".equals(temp_polumjer_savijanja) || "".equals(temp_debljina_stjenke) || "".equals(temp_kut)){
                    Toast.makeText(getContext(), "Nisu unesene sve potrebne vrijednosti.", Toast.LENGTH_LONG).show();
                }
                else {
                    double C=Double.parseDouble(temp_cijena);
                    tv_cijena.setText(String.format("%.2f", formula_upis_koljeno()*C + " [kn]"));

                }

            }
        });
    }

    public double formula_upis_koljeno(){
        double volumen=0;
        double D=Double.parseDouble(et_debljina_stjenke.getText().toString());
        double F=Double.parseDouble(et_polumjer_savijanja.getText().toString());
        double T=Double.parseDouble(et_debljina_stjenke.getText().toString());
        double kut=Double.parseDouble(et_kut.getText().toString());
        if(T>(D/4)){
            Toast.makeText(getContext(),"Neispravan unos.", Toast.LENGTH_LONG).show();
        }
        else if(kut>180 || kut<0){
            Toast.makeText(getContext(),"Kut savijanja nije dobro definiran! Kut savijanja je u intervalu [0° , 180°]", Toast.LENGTH_LONG).show();
        }
        else{
            volumen=((D*T)-(Math.pow(T,2)))*((Math.pow(3.14,2)*F*kut)/180);
            return volumen*0.00000785;
        }
        return 0;
    }
}
