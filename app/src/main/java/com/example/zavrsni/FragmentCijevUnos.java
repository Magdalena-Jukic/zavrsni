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

public class FragmentCijevUnos extends Fragment {

    private EditText et_vanjski_promjer, et_debljina_stjenke, et_duljina, et_cijena;
    private Button btn_masa, btn_cijena;
    private TextView tv_masa, tv_cijena;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.et_vanjski_promjer=view.findViewById(R.id.et_vanjski_promjer_upis_cijev);
        this.et_debljina_stjenke=view.findViewById(R.id.et_debljina_stjenke_upis_cijev);
        this.et_duljina=view.findViewById(R.id.et_duljina_upis_cijev);
        this.et_cijena=view.findViewById(R.id.et_cijena_upis_cijev);

        this.btn_masa=view.findViewById(R.id.btn_izracun_mase_upis_cijev);
        this.btn_cijena=view.findViewById(R.id.btn_izracun_cijene_upis_cijev);

        this.tv_masa=view.findViewById(R.id.tv_masa_upis_cijev);
        this.tv_cijena=view.findViewById(R.id.tv_cijena_upis_cijev);

        btn_masa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp_vanjski_promjer=et_vanjski_promjer.getText().toString();
                String temp_debljina_stjenke=et_debljina_stjenke.getText().toString();
                String temp_duljina=et_duljina.getText().toString();

                if("".equals(temp_vanjski_promjer) || "".equals(temp_debljina_stjenke) || "".equals(temp_duljina)){
                    Toast.makeText(getContext(),"Nisu upisane sve potrebne vrijednosti!", Toast.LENGTH_LONG).show();
                }
                else{
                    double D=Double.parseDouble(temp_vanjski_promjer), T=Double.parseDouble(temp_debljina_stjenke), L=Double.parseDouble(temp_duljina);
                    tv_masa.setText(String.format("%.3f", formula_upis_cijev()) + " [kg]");
                }
            }
        });

        btn_cijena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp_vanjski_promjer=et_vanjski_promjer.getText().toString();
                String temp_debljina_stjenke=et_debljina_stjenke.getText().toString();
                String temp_duljina=et_duljina.getText().toString();
                String temp_cijena=et_cijena.getText().toString();

                if("".equals(temp_vanjski_promjer) || "".equals(temp_debljina_stjenke) || "".equals(temp_duljina)){
                    Toast.makeText(getContext(),"Nisu upisane sve potrebne vrijednosti!", Toast.LENGTH_LONG).show();
                }
                else if("".equals(temp_cijena)){
                    Toast.makeText(getContext(),"Potrebno je unjeti cijenu proizvoda!", Toast.LENGTH_LONG).show();
                }
                else{
                    tv_cijena.setText(String.format("%.2f",formula_upis_cijev()*Double.parseDouble(temp_cijena))+" [kn]");
                }
            }
        });
    }

    public double formula_upis_cijev(){
        double volumen=0;
        double D=Double.parseDouble(et_vanjski_promjer.getText().toString());
        double T=Double.parseDouble(et_debljina_stjenke.getText().toString());
        double L=Double.parseDouble(et_duljina.getText().toString());
        if(T>(D/4)){
            Toast.makeText(getContext(),"Neispravan unos!", Toast.LENGTH_LONG).show();
        }
        else{
            volumen=((D*T)-(Math.pow(T,2)))*3.14*L;
            return volumen*0.00000785;
        }
        return 0;
    }
}
