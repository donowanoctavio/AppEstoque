package rumo.info.appestoque;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {


    private EditText edtLogin;
    private EditText edtSenha;
    private Button btnAcessar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtLogin = (EditText) findViewById(R.id.edtLogin);
        edtSenha = (EditText) findViewById(R.id.edtSenha);
        btnAcessar = (Button) findViewById(R.id.btnAcessar);

        btnAcessar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtLogin.getText().toString().equals("admin")
                        && edtSenha.getText().toString().equals("admin")) {

                    //acessando outra classe
                    Intent intent = new Intent(Login.this, TelaPrincipal.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Login / Senha incorretos",
                            Toast.LENGTH_LONG).show(); //flag de alerta
                }
            }
        });
    }

}
