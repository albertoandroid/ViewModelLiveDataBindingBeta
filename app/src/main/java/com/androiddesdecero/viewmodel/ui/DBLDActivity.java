package com.androiddesdecero.viewmodel.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.androiddesdecero.viewmodel.R;
import com.androiddesdecero.viewmodel.databinding.ActivityDataBindingBinding;
import com.androiddesdecero.viewmodel.databinding.ActivityDbldBinding;
import com.androiddesdecero.viewmodel.utils.User;
import com.androiddesdecero.viewmodel.viewmodel.DBLDViewModel;

public class DBLDActivity extends AppCompatActivity {

    private DBLDViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_dbld);
        ActivityDbldBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_dbld);
        // Specify the current activity as the lifecycle owner.
        binding.setLifecycleOwner(this);

        //Instanciamos el componente ViewModel
        viewModel = ViewModelProviders.of(this).get(DBLDViewModel.class);
        //Asignamos el Componente a la propiedad de la binding class
        binding.setViewModel(viewModel);

        User user = new User("Alberto", "30");
        viewModel.setUser(user);


    }
}
