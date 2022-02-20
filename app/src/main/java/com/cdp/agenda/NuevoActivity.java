package com.cdp.agenda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.cdp.agenda.db.Basecont;

public class NuevoActivity extends AppCompatActivity {
    ImageView objImagen;
    Button tomarF;
    String tomar;
    EditText txtNombre, txtTelefono, txtnotas;
    Button btnGuarda;
    static final int PETICION_ACCESO_CAM = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*
        objImagen = (ImageView) findViewById(R.id.Foto);
        tomarF = (Button) findViewById(R.id.tomarfoto);
        tomarF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                permisos();
            }
        });
        */



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);

        txtNombre = findViewById(R.id.txtNombre);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtnotas = findViewById(R.id.txtnotas);
        btnGuarda = findViewById(R.id.btnGuarda);

        btnGuarda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!txtNombre.getText().toString().equals("") && !txtTelefono.getText().toString().equals("")) {

                    Basecont basecont = new Basecont(NuevoActivity.this);
                    long id = basecont.insertarContacto(txtNombre.getText().toString(), txtTelefono.getText().toString(), txtnotas.getText().toString());

                    if (id > 0) {
                        Toast.makeText(NuevoActivity.this, "REGISTRO GUARDADO", Toast.LENGTH_LONG).show();
                        limpiar();
                    } else {
                        Toast.makeText(NuevoActivity.this, "ERROR AL GUARDAR REGISTRO", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(NuevoActivity.this, "DEBE LLENAR LOS CAMPOS OBLIGATORIOS", Toast.LENGTH_LONG).show();
                }
            }
        });
    }





    private void limpiar() {
        txtNombre.setText("");
        txtTelefono.setText("");
        txtnotas.setText("");
    }
}