package rumo.info.appestoque;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class IncluirProduto extends AppCompatActivity {
    EditText edCod ;
    EditText edQtd ;
    EditText edNome ;
    EditText edDesc ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incluir_produto);

        //recebe os dados do form
        edCod = (EditText) findViewById(R.id.edCod);
        edQtd = (EditText) findViewById(R.id.edQtd);
        edNome = (EditText) findViewById(R.id.edNome);
        edDesc = (EditText) findViewById(R.id.edDesc);


        Button salvar = (Button) findViewById(R.id.btInserir);
        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                if(edCod.getText().length() == 0 || edQtd.getText().length() == 0 ||edNome.getText().length() == 0 ||edDesc.getText().length() == 0){
                    Toast.makeText(getApplicationContext(),"Preencha todos os campos", Toast.LENGTH_SHORT).show();
                }
                else {
                    int cod= Integer.parseInt(edCod.getText().toString());
                    int qtd= Integer.parseInt(edQtd.getText().toString());
                    String nome= edNome.getText().toString();
                    String desc= edDesc.getText().toString();


                    try {

                        SQLiteDatabase bancoDados = openOrCreateDatabase("smartstock", MODE_PRIVATE, null);
                        String strSQL = "INSERT INTO produto (cod,nome,qtd,desc) values (" + cod + ",'" + nome + "'," + qtd + ",'" + desc + "')";
                        bancoDados.execSQL(strSQL);
                        Log.i("LogX", "Produto cadastrado com sucesso");
                        Toast.makeText(getApplicationContext(), "Produto Cadastrado com Sucesso", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }


            }
        });
    }
}
