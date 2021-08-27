package br.edu.ifsp.scl.sdm.cadastro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import br.edu.ifsp.scl.sdm.cadastro.data.Formulario;

public class MainActivity extends AppCompatActivity {

    EditText edtName, edtPhone, edtEmail, edtCity;
    Spinner spnStates;
    CheckBox ckbList;
    RadioButton rdbMasc;
    Button btnClear, btnSave;
    Formulario form;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarComponentes();
        setarListerners();
    }

    private void inicializarComponentes() {
        edtName = findViewById(R.id.edtName);
        edtPhone = findViewById(R.id.edtPhone);
        edtEmail = findViewById(R.id.edtEmail);
        edtCity = findViewById(R.id.edtCity);
        spnStates = findViewById(R.id.spnStates);
        ckbList = findViewById(R.id.ckbList);
        rdbMasc = findViewById(R.id.rdbMasc);
        btnClear = findViewById(R.id.btnClear);
        btnSave = findViewById(R.id.btnSave);

        form = new Formulario();
    }

    private void clearFields() {
        edtName.setText("");
        edtPhone.setText("");
        edtEmail.setText("");
        edtCity.setText("");
        spnStates.setSelection(0);
        ckbList.setChecked(false);
        rdbMasc.setChecked(true);
    }

    private Formulario fillFormFields() {
        form = new Formulario(
                edtName.getText().toString(),
                edtPhone.getText().toString(),
                edtEmail.getText().toString(),
                ckbList.isChecked(),
                rdbMasc.isChecked(),
                edtCity.getText().toString(),
                ((TextView)spnStates.getSelectedView()).getText().toString()
        );
        return form;

    }

    private void setarListerners() {

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                form.clear();
                clearFields();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                form = fillFormFields();
                Toast.makeText(getApplicationContext(),form.toString(), Toast.LENGTH_LONG).show();
            }
        });

    }
}