package com.androiddesdecero.viewmodel;

import android.view.View;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

/*
Los Binding Adapters son responsables de realizar las llamads apropiadas al framework
para actualizar los valores.
En este ejemplo vamos a crear un Binding Adater que va a anlizar cuando una variable booleana
pasa de verdadero a falso y según ese estado nos hará una vista visible o invisible.

Es decir que el uso de adaptadores nos va a permitir proporcionar nuestra propia logica al objeto
view que queramos.
 */
public class ViewModelBindingAdapter {

    //Lo que ponemos entre comillas es como se va a utilizar en el xml. Ahora lo vemos.
    @BindingAdapter("visible")
    public static void setVisibility(View view, boolean visibility){
        if(visibility == true){
            view.setVisibility(View.VISIBLE);
        }else {
            view.setVisibility(View.GONE);
        }
    }

    @BindingAdapter({"visible", "size"})
    public static void setSize(TextView view, boolean visibility, float size){
        if(visibility == true){
            view.setVisibility(View.VISIBLE);
        }else {
            view.setVisibility(View.GONE);
        }
        view.setTextSize(size);
    }
}
