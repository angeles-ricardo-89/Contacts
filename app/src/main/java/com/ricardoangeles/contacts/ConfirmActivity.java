package com.ricardoangeles.contacts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmActivity extends AppCompatActivity {

    private Contact contacto;

    void setContactData(){
        TextView tvNombre = (TextView) findViewById(R.id.tvNombre);
        TextView tvFechaNacimiento = (TextView) findViewById(R.id.tvFechaNacimiento);
        TextView tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        TextView tvEmail = (TextView) findViewById(R.id.tvEmail);
        TextView tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);

        tvNombre.setText(contacto.getNombreCompleto());
        tvFechaNacimiento.setText(contacto.getFechaNacimiento());
        tvTelefono.setText(contacto.getTelefono());
        tvEmail.setText(contacto.getEmail());
        tvDescripcion.setText(contacto.getDescripcion());

    }

    void assign_events(){
        Button btEditar = (Button) findViewById(R.id.btEditar);
        btEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConfirmActivity.this, MainActivity.class);
                intent.putExtra("DatosContacto", contacto);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        contacto = (Contact) getIntent().getParcelableExtra("DatosContacto");
        setContactData();
        assign_events();
    }
}
