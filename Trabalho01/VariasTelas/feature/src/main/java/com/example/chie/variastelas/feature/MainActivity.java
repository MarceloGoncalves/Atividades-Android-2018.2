package com.example.chie.variastelas.feature;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ToggleButton togButton = (ToggleButton) findViewById(R.id.toggleButton);

        toggleClicked(togButton);
        imprimirClicked();
        autoComplete();

    }

    public void toggleClicked(final ToggleButton tgButton){
        final TextView textV = (TextView) findViewById(R.id.textView);

        tgButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    textV.setText("Marcado");
                } else {
                    textV.setText("Desmarcado");
                }
            }
        });
    }

    public void imprimirClicked(){
        Button btnImp = (Button) findViewById(R.id.button_Imprimir);
        final EditText edtSeuText = (EditText) findViewById(R.id.editTextSeuTexto);

        btnImp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = "Texto digitado: " + edtSeuText.getText();
                Toast.makeText(getBaseContext(), msg, Toast.LENGTH_LONG).show();
            }
        });
        edtSeuText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtSeuText.setText(" ");
            }
        });

    }

    public void autoComplete(){
        String str[] ={"Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado", "Domingo"};
        final AutoCompleteTextView compTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        ArrayAdapter<String> dias = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, str);

        compTextView.setThreshold(1);
        compTextView.setAdapter(dias);

        compTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compTextView.setText(" ");
            }
        });
    }
}
