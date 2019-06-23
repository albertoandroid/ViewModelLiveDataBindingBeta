package com.androiddesdecero.viewmodel.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.androiddesdecero.viewmodel.R;
import com.androiddesdecero.viewmodel.utils.User;
import com.androiddesdecero.viewmodel.viewmodel.LiveDataViewModel;

import java.util.List;

/*
    LiveData es una Clase Observable data holder.
    Un data holder tiene muy poco comportamiento o nada pero muchos datos. Como un livedata es
    un observable notifica a los observers cuando los datos cambian. Podemos actualizar de
    una manera reactiva nuestra interfaz de usuario.
    A diferencia de un observable normal,
    LiveData es consciente del ciclo de vida, lo que significa que respeta el ciclo de vida
    de otros componentes de la aplicación, como las activities, fragments o servicios.
    Con esto nos garantizamos que LiveData solo actualiza los observadores de componentes
    de aplicaciones que se encuentren en un estado de ciclo de vida activa. Eso es una gran
    ventaja para nosotros.

    Nota: -> LiveData considera que un observador, que esta representado por la clase Observer
    esta en un estado activo si su ciclo de vida esta en el estado Started o Resumed.
    LiveData solo notifica a los observadores activos sobre las actualizaciones.
    Los observadores inactivos registrados para ver los objetos LiveData no son
    notificados de los cambios.

    Podemos registrar un observador emparejado con un objeto que implemente la interface "LiceCiclOwner"
    Esta relación permite que el observador se elminite cuando el estado del objeto correspondiente
    del ciclo de vida cambie a Destroy.
    Esto es muyt util para nuestras activitites y fragments debido a que pueden observar a los
    objetos LiveData y así no nos tenemos que preocupar por las fugas de memoria.
    Las activities y fragmentes son desuscribidas instantaneamente cuando sus ciclos de vida son
    destruidos.

     */
public class LiveDataActivity extends AppCompatActivity {

    private TextView tvLiveData;
    private Button btSave;
    private int numero = 0;
    private LiveDataViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data);

        setUpView();
    }

    private void setUpView(){
        viewModel = ViewModelProviders.of(this).get(LiveDataViewModel.class);
        tvLiveData = findViewById(R.id.tvLiveData);
        btSave = findViewById(R.id.btSave);
        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(numero == 0){
                    User user = new User();
                    user.setNombre("Alberto");
                    user.setEdad("30");
                    Log.d("TAG1", "numero0");
                    viewModel.addUser(user);
                }
                if(numero == 1){
                    User user = new User();
                    user.setNombre("Maria");
                    user.setEdad("23");
                    viewModel.addUser(user);
                }
                if(numero == 2){
                    User user = new User();
                    user.setNombre("Manuel");
                    user.setEdad("40");
                    viewModel.addUser(user);
                }
                numero++;
            }
        });

        /*
        Tenemos que crear nuestro observer que observe nuestra clase Observable
        liveDataUserViewModel.
         */
        final Observer<List<User>> listObserver = new Observer<List<User>>() {
            @Override
            /*
            el método onChanged se ejecuta cada vez que el observable emite datos.
            Lo que quiere decir que hemos de actualizar.
             */
            public void onChanged(@Nullable List<User> userList) {
                String texto = "";
                for(int i=0; i<userList.size(); i++){
                    texto += userList.get(i).getNombre() + " " + userList.get(i).getEdad() +"\n";
                }
                tvLiveData.setText(texto);
            }
        };

        /*
        Tenemos el Observer y el observable. Ahora toca subscribir el observer al observable
        y así pueda estar notificado de cada cambio.
        .observe(this, listObserver)-> le decimos al observable que observer se va a
        subcibir a el.
        El propietario del ciclo de vida de ese LiveData en este caso es this.
         */
        viewModel.getUserList().observe(LiveDataActivity.this, listObserver);

        /*
        Nota: podemos registrar el Observador emparejado a un objeto que implementa la interfaz
        LiveCycleOwner. Como son las activities o fragment, ya que esta relación nos permite
        que el observador se elimine cuando el estado del objeto cambia su estado de vida a Destruido.
        Esto nos permite que nuestras activities y fragment observern de forma sergua los objetos
        livedata y no nos tenemos que preocupar por las fugas de memoria puesto que se desubcriben de
        forma instantanea cuando se destruye su ciclo de vida.
        Es decir que LiveData esta bien diseñado y nos ayuda a los desarrolladores a no tener
        que estar pedientes de los memory Leak.
         */
    }
}
