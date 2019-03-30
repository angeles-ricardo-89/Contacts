package com.ricardoangeles.contacts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    private Button btSiguiente;
    private EditText etNombreCompleto;
    private DatePicker dpFechaNacimiento;
    private EditText etTelefono;
    private EditText etEmail;
    private EditText etDescripcion;


    public Contact contact_from_views(){
        Contact contacto;
        String textoFecha;

        textoFecha = dpFechaNacimiento.getDayOfMonth() + "/" + (dpFechaNacimiento.getMonth() + 1) +
                        "/" + dpFechaNacimiento.getYear();
        contacto = new Contact( etNombreCompleto.getText().toString(),
                                etTelefono.getText().toString(),
                                textoFecha,
                                etDescripcion.getText().toString(),
                                etEmail.getText().toString());

        return contacto;
    }

    public void goto_confirm_data(){
        Contact contacto = contact_from_views();
        Intent intent = new Intent(MainActivity.this, ConfirmActivity.class);
        intent.putExtra("DatosContacto", contacto);
        startActivity(intent);
    }


    private void init_views(Contact contacto)
    {
        btSiguiente = (Button) findViewById(R.id.btSiguiente);
        etNombreCompleto = (EditText) findViewById(R.id.etNombreCompleto);
        dpFechaNacimiento = (DatePicker) findViewById(R.id.dpFechaNacimiento);
        etTelefono = (EditText) findViewById(R.id.etTelefono);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etDescripcion = (EditText) findViewById(R.id.etDescripcionContacto);
        assign_events();

        if(contacto != null){
            etNombreCompleto.setText(contacto.getNombreCompleto());
            etTelefono.setText(contacto.getTelefono());
            etEmail.setText(contacto.getEmail());
            etDescripcion.setText(contacto.getDescripcion());
            String[] textoFecha = contacto.getFechaNacimiento().split("/");
            dpFechaNacimiento.updateDate(Integer.parseInt(textoFecha[2]),
                                         Integer.parseInt(textoFecha[1])-1,
                                         Integer.parseInt(textoFecha[0]));
        }
    }

    private void assign_events(){

        btSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goto_confirm_data();
                finish();
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Contact contacto = (Contact) getIntent().getParcelableExtra("DatosContacto");
        this.init_views(contacto);
    }
}
