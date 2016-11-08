package mx.gdeprocom.tarea2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MostrarDatos extends AppCompatActivity {
    private TextView tvDNombre;
    private TextView tvDFecha;
    private TextView tvDTelefono;
    private TextView tvDEmail;
    private TextView tvDDescripcion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_datos);

        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString(getResources().getString(R.string.nombre));
        String fecha = parametros.getString(getResources().getString(R.string.fecha_nacimiento));
        String telefono = parametros.getString(getResources().getString(R.string.telefono));
        String email = parametros.getString(getResources().getString(R.string.email));
        String desripcion = parametros.getString(getResources().getString(R.string.desripcion));
        Button btnEditar = (Button) findViewById(R.id.btnEditar);

        tvDNombre = (TextView) findViewById(R.id.tvDNombre);
        tvDFecha = (TextView) findViewById(R.id.tvDFecha);
        tvDEmail = (TextView) findViewById(R.id.tvDEmail);
        tvDTelefono = (TextView) findViewById(R.id.tvDTelefono);
        tvDDescripcion = (TextView) findViewById(R.id.tvDDescripcion);

        tvDNombre.setText(nombre);
        tvDFecha.setText(fecha);
        tvDTelefono.setText(telefono);
        tvDEmail.setText(email);
        tvDDescripcion.setText(desripcion);

        btnEditar.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             Intent intent = new Intent(MostrarDatos.this,MainActivity.class);
                                             //startActivity(intent);
                                             onRestart();
                                             finish();
                                         }
                                     }
        );
    }

}
