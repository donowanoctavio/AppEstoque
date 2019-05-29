package rumo.info.appestoque;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        Button btCadastrar = (Button) findViewById(R.id.btCadastrar);
        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(TelaPrincipal.this, IncluirProduto.class);
                startActivity(it);
            }
        });

        Button btGerenciar = (Button) findViewById(R.id.btGerenciar);
        btGerenciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(TelaPrincipal.this, GerenciarProdutos.class);
                startActivity(it);
            }
        });

        Button btSobre = (Button) findViewById(R.id.btSobre);
        btSobre.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View view) {
            Intent it = new Intent(TelaPrincipal.this, Sobre.class);
            startActivity(it);
             }

        });

    }
}
