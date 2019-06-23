package com.androiddesdecero.viewmodel.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.androiddesdecero.viewmodel.utils.User;

import java.util.ArrayList;
import java.util.List;

public class DBLDViewModel extends ViewModel {
    private MutableLiveData<User> user;
    private MutableLiveData<Boolean> visible;
    private MutableLiveData<Float> size;

    public DBLDViewModel(){
        user = new MutableLiveData<>();
        visible = new MutableLiveData<>();
        visible.setValue(true);
        size = new MutableLiveData<>();
        size.setValue(14f);
    }

    public LiveData<User> getUser(){
        //Si no se ha entrado nunca la inicializamos la lista
        return user;
    }

    public void setUser(User user){
        this.user.setValue(user);
    }

    public void updateUser(){
        User user = new User("Laura", "23");
        this.user.setValue(user);
    }

    //////////

    public MutableLiveData<Boolean> getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible.setValue(visible);
    }

    public MutableLiveData<Float> getSize() {
        return size;
    }

    public void chageVisibility(){
        if(visible.getValue().booleanValue() == true){
            visible.setValue(false);
        }else{
            visible.setValue(true);
        }
        size.setValue(size.getValue().floatValue()+5l);
    }
}
