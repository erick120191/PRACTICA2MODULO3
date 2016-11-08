package mx.gdeprocom.tarea2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MostrarDatos extends AppCompatActivity {
    private TextView tvNombre;
    private TextView tvTelefono;
    private TextView tvemail;
    private TextView tvdescripcion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_datos);

        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString(getResources().getString(R.string.nombre));
        String telefono = parametros.getString(getResources().getString(R.string.telefono));
        String email = parametros.getString(getResources().getString(R.string.email));
        String desripcion = parametros.getString(getResources().getString(R.string.desripcion));

        TextView tvNombre = (TextView) findViewById(R.id.tvNombre);
        TextView tvTelefono = (TextView) findViewById(R.id.tvtelefono);
        TextView tvemail = (TextView) findViewById(R.id.tvemail);
        TextView tvdescripcion = (TextView) findViewById(R.id.tvdescripcion);

        tvNombre.setText(nombre);
        tvTelefono.setText(telefono);
        tvemail.setText(email);
        tvdescripcion.setText(desripcion);
    }
}
