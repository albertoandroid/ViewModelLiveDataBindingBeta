package com.androiddesdecero.viewmodel.viewmodel;

import androidx.lifecycle.ViewModel;

import com.androiddesdecero.viewmodel.utils.User;

import java.util.ArrayList;
import java.util.List;

public class UserViewModel extends ViewModel {

    private List<User> userList;

    public UserViewModel(){
        userList = new ArrayList<>();
    }

    private UserViewModel(List<User> users){
        userList = users;
    }

    //Clase que nos permite agregar usuario a la lista
    public void addUser(User user){
        userList.add(user);
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;

    }
}


