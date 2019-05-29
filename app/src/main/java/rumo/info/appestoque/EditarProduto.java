package rumo.info.appestoque;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditarProduto extends AppCompatActivity {

    EditText edCod ;
    EditText edQtd ;
    EditText edNome ;
    EditText edDesc ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_produto);


        //busca no banco
        Intent it = getIntent();
        int id = Integer.parseInt(it.getStringExtra("cod"));
        busca_valores(id);






        //recebe os dados do form
        edCod = (EditText) findViewById(R.id.edCod);
        edQtd = (EditText) findViewById(R.id.edQtd);
        edNome = (EditText) findViewById(R.id.edNome);
        edDesc = (EditText) findViewById(R.id.edDesc);


        Button editar = (Button) findViewById(R.id.btEditar);
        editar.setOnClickListener(new View.OnClickListener() {
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
                        String strSQL = "UPDATE produto SET  qtd="+qtd+ " WHERE cod=" + cod;
                        bancoDados.execSQL(strSQL);
                        Log.i("LogX", "Estoque Editado com sucesso");
                        Toast.makeText(getApplicationContext(), "Estoque Editado com Sucesso", Toast.LENGTH_SHORT).show();
                        Intent it = new Intent(EditarProduto.this,GerenciarProdutos.class);
                        finish();
                        startActivity(it);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }


            }
        });
    }


    public void busca_valores(int id){

        Log.i("teste", String.valueOf(id));

        edNome = (EditText) findViewById(R.id.edNome);
        edQtd = (EditText) findViewById(R.id.edQtd);
        edDesc = (EditText) findViewById(R.id.edDesc);
        edCod = (EditText) findViewById(R.id.edCod);

        try {
            SQLiteDatabase bancoDados = openOrCreateDatabase("smartstock",MODE_PRIVATE,null);

            Cursor cursor = bancoDados.rawQuery("SELECT * from produto WHERE cod="+id, null);

            if (cursor.moveToPosition(0)) {
                Log.e("LogX","Nao esta vazio " + cursor.getCount());

                while (cursor != null) {
                    edNome.setText(cursor.getString(cursor.getColumnIndex("nome")));
                    edQtd.setText(String.valueOf(cursor.getInt(cursor.getColumnIndex("qtd"))));
                    edDesc.setText(cursor.getString(cursor.getColumnIndex("desc")));
                    edCod.setText(String.valueOf(cursor.getInt(cursor.getColumnIndex("cod"))));

                    cursor.moveToNext();
                }
            }else
            {
                Log.e("LogX","Cursor vazio.");
            }


        }
        catch(Exception e){
            e.printStackTrace();
        }
        // fim teste exib
    }
}
