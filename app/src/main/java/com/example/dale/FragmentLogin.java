package com.example.dale;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentLogin extends BaseFragment {
    EditText Password,Num;
    Button BtnLogin;
    ImageView TwitterIcon,FacebookIcon,GoogleplusIcon;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
     View  view =inflater.inflate(R.layout.login_fragment,container,false);
        Password = view.findViewById(R.id.password);
        Num = view.findViewById(R.id.mobilenum);
        BtnLogin = view.findViewById(R.id.loginbtn);
        TwitterIcon = view.findViewById(R.id.img_twiter);
        FacebookIcon = view.findViewById(R.id.img_facebook);
        GoogleplusIcon = view.findViewById(R.id.img_goole);
        goToUrl(TwitterIcon,"https://twitter.com/");
        goToUrl(FacebookIcon,"https://web.facebook.com");
        goToUrl(GoogleplusIcon,"http://www.google.com");

BtnLogin.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        checkNumber();
        checkPassword();
    }
});
        return view;
    }
    public void goToUrl(View v,String s){
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(s); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });


    }
    public void checkNumber(){
    String number=Num.getText().toString().trim();
    if (number.isEmpty()){
        Num.setError("Cant Be Empty"); }

}
    public void checkPassword(){
        String pass=Password.getText().toString().trim();
        if (pass.isEmpty()){
            Password.setError("Cant Be Empty"); }

    }

}
