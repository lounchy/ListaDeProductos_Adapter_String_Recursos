package com.example.lounchy.listadeproductos;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1.Creo String array de string recursos(lista_de_productos.xml)
        final String [] productosArray = getResources().getStringArray(R.array.productos_string_array);

//        final ArrayList<String> lista = new ArrayList<String>(Arrays.asList(productosArray)); //Asi se pasa el String[] a ArrayList

        //5.declaro nuevo boolean con tamaño de productosArray
        final boolean [] pos = new boolean[productosArray.length];
//        Arrays.fill(pos, false); //Es false por defecto

        //2.Creo mi adapter con tres parametros , 1.contexto, 2.array 3. boolean
        final AdapterProductos adapterProductos = new AdapterProductos(this, productosArray, pos);

        //3.Creo mi ListView
        final ListView lv = (ListView)findViewById(R.id.list_view);
        lv.setAdapter(adapterProductos);

        //4.Creo OnItemClickListener
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                //6. Declaro textView para que despues puedo marcar este mismo text view
                TextView textView = (TextView)view.findViewById(R.id.pintar_simple_text_view);
                //Saco el nombre para mostrarlo despues en el Toast
                String productoSelecionado = textView.getText().toString();

                if (pos[position])
                {
                    pos[position] = false;
                    textView.setBackgroundColor(Color.WHITE);
                    Log.d(getClass().getCanonicalName(), "Desmarcado: " +productoSelecionado);//No lo se porque en Android Monitor no aparece este log
                    Toast.makeText(getBaseContext(), "Has desmarcado " + productoSelecionado, Toast.LENGTH_SHORT).show();
                }else
                {
                    pos[position] = true;
                    textView.setBackgroundColor(Color.GRAY);
                    Log.d(getClass().getCanonicalName(), "Marcado: " + productoSelecionado);//No lo se porque en Android Monitor no aparece este log
                    Toast.makeText(getBaseContext(), "Has marcado " + productoSelecionado, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
