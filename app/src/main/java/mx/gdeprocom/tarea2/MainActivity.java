package mx.gdeprocom.tarea2;

import java.util.Calendar;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.view.Menu;
import android.view.View;

import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dateView = (TextView) findViewById(R.id.etfechaselec);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);

        final AppCompatEditText nombre = (AppCompatEditText) findViewById(R.id.etnombre);
        final AppCompatEditText telefono = (AppCompatEditText) findViewById(R.id.ettelefono);
        final AppCompatEditText email = (AppCompatEditText) findViewById(R.id.etemail);
        final AppCompatEditText descripcion = (AppCompatEditText) findViewById(R.id.etdescripcion);
        final TextView fecha=(TextView) findViewById(R.id.etfechaselec);
        //final AppCompatEditText fechaNacimiento = (AppCompatEditText) findViewById(R.id.etfechaselec) ;
        Button btnSiguiente = (Button) findViewById(R.id.btnSiguiente);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreCompleto = nombre.getText().toString();
                String emailContacto = email.getText().toString();
                String telefonoContacto = telefono.getText().toString();
                String descripcionContac = descripcion.getText().toString();
                String fechaNac = fecha.getText().toString();

                Intent intent = new Intent(MainActivity.this, MostrarDatos.class);
                intent.putExtra(getResources().getString(R.string.nombre), nombreCompleto);
                intent.putExtra(getResources().getString(R.string.email),emailContacto);
                intent.putExtra(getResources().getString(R.string.telefono),telefonoContacto);
                intent.putExtra(getResources().getString(R.string.desripcion),descripcionContac);
                intent.putExtra(getResources().getString(R.string.fecha_seleccionada),fechaNac);
                startActivity(intent);
            }
        });
    }
    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        Toast.makeText(getApplicationContext(), "ca",
                Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDate(arg1, arg2+1, arg3);
                }
            };

    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }
}
