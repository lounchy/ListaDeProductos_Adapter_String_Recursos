package com.example.lounchy.listadeproductos;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;



public class AdapterProductos extends BaseAdapter {
    private Context context;
    private String [] lista_productos;
    private boolean[]pos;

    public AdapterProductos(Context context, String []lista_productos, boolean[]pos) {
        this.context = context;
        this.lista_productos = lista_productos;
        this.pos = pos;
    }

    @Override
    public int getCount() {
        return this.lista_productos.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent) {

        View vista = converView;
        if (vista == null) {
            Activity a = (Activity) context;
            LayoutInflater li = a.getLayoutInflater();
            vista = li.inflate(R.layout.pintar_simple, parent, false);
        }else
        {
            vista = converView;
        }

        TextView textView = (TextView)vista.findViewById(R.id.pintar_simple_text_view);
        textView.setText(this.lista_productos[position]);


        if (pos[position])//la position esta pintada
        {
            textView.setBackgroundColor(Color.GRAY);
        }else
        {
            textView.setBackgroundColor(Color.WHITE);
        }
        Log.d(getClass().getCanonicalName(), "Inflando elemento: " + position);
        return vista;
    }
//    private String [] productos = context.getResources().getStringArray(R.array.productos);
}
