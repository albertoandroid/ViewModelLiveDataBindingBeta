package com.androiddesdecero.viewmodel.viewmodel;

import androidx.lifecycle.ViewModel;

/*
ViewModel-> La clase viewmodel esta diseñada para almacenar y administrar datos relacionados
con la IU en una forma consciente del cicle de vida
La clase viewmodel permite que los datos sobrevian a los cambios de configuración, como son
las rotaciones de pantalla. El ViewModel no se destruye cuando hay un cambio de configuración,
la nueva instancia de el propietrio solo se reconectará al viewmodel existente.
El view model no debe obener referencia a la view es decir a la activity o fragment.

 */
public class SumarViewModel extends ViewModel {

    private int resultado;

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }
}
