package edm.rs.senac.com.br.projetocontas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListaActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

     private ArrayList<String> listaPaises;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        listaPaises = new ArrayList<String>();
        listaPaises.add("Argentina");
        listaPaises.add("Brasil");
        listaPaises.add("Estados Unidos");
        listaPaises.add("Paraguai");
        listaPaises.add("Uruguai");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                listaPaises
                );

        ListView listView = (ListView) findViewById(R.id.list_view_paises);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, listaPaises.get(position).toString(), Toast.LENGTH_SHORT).show();
    }
}
