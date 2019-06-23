package com.androiddesdecero.viewmodel.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.androiddesdecero.viewmodel.utils.User;

import java.util.ArrayList;
import java.util.List;

public class LiveDataViewModel extends ViewModel {

    /*
    La diferencia que nos encontramos es que la primera opción es un objeto observable
    y por lo tanto va a enviar a los observadores de manera reactiva los cambios y nos ahorra
    tocar la interfaz de usuario.
    Mutable vs LiveData a secas es que LiveData a secas es de solo lectura
    y Mutable es que es de Lectura y escritura que van a ser en la mayor parte de casos.
     */
    private MutableLiveData<List<User>> userListLiveData;
    private List<User> userList;

    /*
    Metodo para leer la lista de usuarios en este caso nos vale un LiveData.
     */
    public LiveData<List<User>> getUserList(){
        //Si no se ha entrado nunca la inicializamos la lista
        if(userListLiveData == null){
            userListLiveData = new MutableLiveData<>();
            userList = new ArrayList<>();
        }
        return userListLiveData;
    }

    /*Actualizar los datos de LiveData tenemos dos metodos
    SetValue -> Si hay observadores activos el valor es enviado. Este método lo debemos
    llamar en el hilo principal de interfaz de usuario.
    PostValue-> Si necesitamos actualizar un valor desde un hilo de background deberemos
    utilizar postValue.
    */
    public void addUser(User user){
        userList.add(user);
        userListLiveData.setValue(userList);
    }
}
