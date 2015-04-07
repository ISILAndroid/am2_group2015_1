package com.isil.am2.am2sharedpreferences;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	private EditText eteUsername, etePassword;
	private Button btnLogin;
    private  String username, password;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        validateSession();
		app();
	}

    private void validateSession() {
        //TODO como validamos que exita la sessión ?
        //gotoDashBoard();
    }

    private void app() {
		// TODO Auto-generated method stub
		eteUsername= (EditText)findViewById(R.id.eteUsername);
		etePassword= (EditText)findViewById(R.id.etePassword);
		btnLogin = (Button)findViewById(R.id.btnLogin);
		
		//events
		btnLogin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
            // TODO Auto-generated method stub
            if(validateForm())
            {
                savePreferences();
                gotoDashBoard();
            }
			}
		});
	}

    private void gotoDashBoard() {
        Intent intent= new Intent(this, DashboardActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);

        startActivity(intent);
        //finish();
    }

    protected void savePreferences() {
		// TODO Auto-generated method stub

		SharedPreferences sp = getSharedPreferences("MYSHAREDPREFERENCES", 0);
		SharedPreferences.Editor editor = sp.edit();
		editor.putString("USERNAME", username);
		editor.commit();
		
	}

	protected boolean validateForm() {
        // TODO Auto-generated method stub
        username = eteUsername.getText().toString().trim();
        password = etePassword.getText().toString().trim();

        if (username.equals("")) {
            eteUsername.setError("Ingresar un email");
            return false;
        }
        if (password.equals(""))
        {
            eteUsername.setError("Ingresar un password");
            return false;
        }
		return true;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		return false;
	}

}
