package edm.rs.senac.com.br.projetocontas;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private double agua = 50;
    private double telefone = 100;
    private double luz = 80;
    private double outra = 50;
    private double total = 0;
    private AlertDialog alerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckBox checkBoxAgua = (CheckBox)findViewById(R.id.check_agua);
        checkBoxAgua.setText(checkBoxAgua.getText().toString() + " ("+ agua+ ")");
        checkBoxAgua.setTag(agua);

        CheckBox checkBoxTelefone = (CheckBox)findViewById(R.id.check_telefone);
        checkBoxTelefone.setText(checkBoxTelefone.getText().toString() + " (" + telefone + ")");
        checkBoxTelefone.setTag(telefone);

        CheckBox checkBoxLuz = (CheckBox)findViewById(R.id.check_luz);
        checkBoxLuz.setText(checkBoxLuz.getText().toString() + " ("+ luz + ")");
        checkBoxLuz.setTag(luz);

        CheckBox checkBoxOutra = (CheckBox)findViewById(R.id.check_outra);
        checkBoxOutra.setText(checkBoxOutra.getText().toString() + " ("+ outra + ")");
        checkBoxOutra.setTag(outra);
    }

    public void onCalcular(View view) {
        total = 0;
        CheckBox cbAgua = (CheckBox) findViewById(R.id.check_agua);
        CheckBox cbTelefone = (CheckBox) findViewById(R.id.check_telefone);
        CheckBox cbLuz = (CheckBox) findViewById(R.id.check_luz);
        CheckBox cbOutra = (CheckBox) findViewById(R.id.check_outra);

        if(cbAgua.isChecked()) {
           total += (double) cbAgua.getTag();
        }

        if(cbTelefone.isChecked()){
            total += (double) cbTelefone.getTag();
        }

        if(cbLuz.isChecked()) {
            total += (double) cbLuz.getTag();
        }

        if(cbOutra.isChecked()) {
            total += (double) cbOutra.getTag();
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Atenção");
        builder.setMessage("Você deseja pagar R$ "+ total);

        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(MainActivity.this, "positivo=" + arg1, Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(MainActivity.this, "negativo=" + arg1, Toast.LENGTH_SHORT).show();
            }
        });

        alerta = builder.create();
        alerta.show();



    }

}
