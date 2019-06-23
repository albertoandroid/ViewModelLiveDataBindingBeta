package com.androiddesdecero.viewmodel.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.androiddesdecero.viewmodel.R;
import com.androiddesdecero.viewmodel.utils.User;
import com.androiddesdecero.viewmodel.viewmodel.UserViewModel;

import java.util.ArrayList;
import java.util.List;

public class UserViewModelActivity extends AppCompatActivity {

    private EditText etNombre;
    private EditText etEdad;
    private Button btSalvar;
    private Button btVerUser;
    private TextView tvUser;
    private TextView tvUserViewModel;

    private List<User> userList;
    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_view_model);

        setUpView();
    }

    private void setUpView(){
        /*
        Para instanciar nuestra clase viewmodel tienes que hacerlos a través del ViewModelProvider
        de donde, de la activity y por último la clase de que se trata.
        Esta línea de código nos asocia nuestra clase viewmodel con la ACtibvity y ya va a perdurar.
         */
        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        userList = new ArrayList<>();

        tvUser = findViewById(R.id.tvUser);
        tvUserViewModel = findViewById(R.id.tvUserViewModel);

        etNombre = findViewById(R.id.etNombre);
        etEdad = findViewById(R.id.etEdad);

        btSalvar = findViewById(R.id.btSalvar);
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();
                user.setEdad(etEdad.getText().toString());
                user.setNombre(etNombre.getText().toString());
                userList.add(user);
                userViewModel.addUser(user);
            }
        });
        btVerUser = findViewById(R.id.btVer);
        btVerUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String texto = "";
                for(int i=0; i<userList.size(); i++){
                    texto += userList.get(i).getNombre() + " " + userList.get(i).getEdad()+"\n";
                }
                tvUser.setText(texto);
                texto = "";
                for(User user: userViewModel.getUserList()){
                    texto += user.getNombre() + " " + user.getEdad()+"\n";
                }
                tvUserViewModel.setText(texto);
            }
        });
    }
}
