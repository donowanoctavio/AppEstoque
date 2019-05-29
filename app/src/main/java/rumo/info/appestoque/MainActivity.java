package rumo.info.appestoque;

import android.content.Intent;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //configura o banco de dados
        SQLiteDatabase bancoDados = openOrCreateDatabase("smartstock",MODE_PRIVATE,null);
        bancoDados.execSQL("CREATE TABLE IF NOT EXISTS produto (cod INT, nome VARCHAR, qtd INT, desc VARCHAR)");





        Button btAcessar = (Button) findViewById(R.id.btAcessar);

        btAcessar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // abrir tela de login
                Intent it = new Intent(MainActivity.this,Login.class);
                startActivity(it);
            }
        });
    }
}
