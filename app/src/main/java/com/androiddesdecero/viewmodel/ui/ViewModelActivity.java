package com.androiddesdecero.viewmodel.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.androiddesdecero.viewmodel.R;
import com.androiddesdecero.viewmodel.utils.Sumar;
import com.androiddesdecero.viewmodel.viewmodel.SumarViewModel;

/*
    ViewModel-> Ayuda a nuestra aplicaciones a gestionar problemas del ciclo de vida.
    Ofrece a nuestras aplicaciones que sean más robustas, mantenibles y testeables.
    ViewModel son objetos que proveen datos a nuestra interfaz de usuario y sobreviven a los
    cambios de configuración.
    Las activities o fragment tienen un ciclo de vida y los viewmodel otro distinto.
    Por norma general si giras la pantalla de tu móvil, la actity se destruye y se vuelve a crear
    esto quiere decir que si no has gestionado bien los datos que estabas mostrando se perderan y
    al hacer el giro te mostraran datos totalmente diferentes lo que es una mala esperiencia de
    usuario.
    Eso es una parte que nos soluciona el viewmodel. Otro es que es pieza fundamental para mvvm.

     */

public class ViewModelActivity extends AppCompatActivity {

    private TextView tvSumar;
    private TextView tvSumarViewModel;
    private Button btSumar;
    private int resultado;
    private SumarViewModel sumarViewModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model);
        Log.d("TAG1", "onCreate()");

        setUpView();
    }

    private void setUpView(){
        /*
        Ejemplo con ViewModel, los datos persisten con los cambios de configuración
        Para instanciar nuestra clase viewmodel tienes que hacerlos a través del ViewModelProvider
        de donde, de la activity y por último la clase de que se trata.
        Esta línea de código nos asocia nuestra clase viewmodel con la ACtibvity y ya va a perdurar.
         */
        sumarViewModel = ViewModelProviders.of(this).get(SumarViewModel.class);

        /*
        Ejemplo sin ViewModel, con el cambio de configuración perdemos los datos.
         */
        tvSumar = findViewById(R.id.tvSumar);
        tvSumarViewModel = findViewById(R.id.tvSumarViewModel);

        tvSumar.setText(" "+ resultado);
        tvSumarViewModel.setText(" "+ sumarViewModel.getResultado());

        btSumar = findViewById(R.id.btSumar);
        btSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultado = Sumar.sumar(resultado);
                tvSumar.setText(" "+ resultado);
                sumarViewModel.setResultado(Sumar.sumar(sumarViewModel.getResultado()));
                tvSumarViewModel.setText(" "+ sumarViewModel.getResultado());
            }
        });
        /*
        Recordamos que el ViewModel ha sido especialmente diseñado por la gente de Google para
        almacenar y administrar datos relacionados con la UI de forma independendiente al ciclo de vida.
        Vemos que la activity se destruye y se recrea y los datos persisten.
        Como veremos más adelante además de proporcionar los datos al fragment o activity, tambien tendra
        la logica de negocio de nuestra aplicacióhn y el manjeo de datos para comunicarse con el modelo.
        Es decir que tambien será el encargado de comunicarse con el respositorio para obtener datos.
        Importante: El viewModel no debe tener ninguna referencia a la View que pertenece.
        como vemos la clase view model es muy simple.
         */

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TAG1", "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TAG1", "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TAG1", "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TAG1", "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAG1", "onDestroy()");
    }
}
