package com.androiddesdecero.viewmodel.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.androiddesdecero.viewmodel.R;
import com.androiddesdecero.viewmodel.databinding.ActivityDataBindingBinding;
import com.androiddesdecero.viewmodel.utils.User;
import com.androiddesdecero.viewmodel.viewmodel.DBLDViewModel;

/*
DataBinding nos permite vinculr los componentes de la IU de nuestro xml a las fuentes de datos
de nuestra aplicación, usando un formato declarativo en lugar de la programación.
DataBinding nos soluciona el problema que tenemos todos los programadores Android que es escribir
mucho código que no aporta nada a nuestra aplicación pero hay que escribirlo para que funcione.
Es decir ya no vamos a tener que declarar los objetos View en nuestra Activity y tampoco hacer los
findViewById y tampoco estar pendiente de asignarles valor o actualizarlos.
Vamos a ver todo el codigo que nos ahorramos.
 */
public class DataBindingActivity extends AppCompatActivity {

    public User user;

    //public DBLDViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Esto es para layout normales. cuando utilizamos data binding no tenemos
        //que utilizar el setcontentview
        //setContentView(R.layout.activity_data_binding);

        //Clase que genera automaticamente AndroidStudio cuando utilizamos DataBinding
        //en una activity en concreto
        ActivityDataBindingBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding);

        user = new User("albertom", "30");
        //Ahora tenemos que enlazar los datos de nuestro usuario con el databinding de nuestro xml.
        //bingind.setUser -> es del Objeto user que viene XML
        binding.setUser(user);


        user.setNombre("PACO");

        //Cada que se cambia el objeto user, se actualiza automaticamente nuestra vista, esta es una gran
        //ventaja ya que no tenemos que estar actualizando la vista como metodos de ejemplo tv.setText
        //cada vez que un cambio ocurre.


    }



}
