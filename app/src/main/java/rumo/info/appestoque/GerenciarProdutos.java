package rumo.info.appestoque;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class GerenciarProdutos extends AppCompatActivity {


    private ArrayAdapter<String> itensAdaptador;
    private ArrayList<Integer> ids;
    private ArrayList<String> nomes;
    private ArrayList<Integer> qtd;
    private ArrayList<String> desc;

    ListView minhaLista;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerenciar_produtos);

        minhaLista = (ListView) findViewById(R.id.lvLista);
        ArrayList<Produtos> produtos = addProdutos();
        ArrayAdapter adapter = new ItemAdapter(this, produtos);
        minhaLista.setAdapter(adapter);



        minhaLista.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



                            //code specific to first list item
                            Intent myIntent = new Intent(view.getContext(), EditarProduto.class);
                            myIntent.putExtra("cod",String.valueOf(ids.get(position)));
                            startActivityForResult(myIntent, 0);



                    }


                });




        minhaLista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int pos, long arg3) {
                Log.i("teste","Teste de Clique Longo"+ids.get(pos));

                apagarTarefa(ids.get(pos));
                Intent it = new Intent(GerenciarProdutos.this, GerenciarProdutos.class);
                finish();
                startActivity(it);

                return false;
            }
        });


    }

    private ArrayList<Produtos> addProdutos(){
        ArrayList<Produtos> produtos = new ArrayList<Produtos>();


        SQLiteDatabase bancoDados = openOrCreateDatabase("smartstock", MODE_PRIVATE, null);

        try {


            Cursor cursor = bancoDados.rawQuery("SELECT * from produto order by cod DESC", null);

            ids = new ArrayList<Integer>();

            if (cursor.moveToFirst()) {
                Log.e("LogX", "Nao esta vazio " + cursor.getCount());

                while (cursor != null) {
                    Produtos p = new Produtos(R.drawable.img_box,cursor.getInt(cursor.getColumnIndex("cod")),cursor.getString(cursor.getColumnIndex("nome")),cursor.getInt(cursor.getColumnIndex("qtd")),cursor.getString(cursor.getColumnIndex("desc")));
                    produtos.add(p);
                    ids.add(cursor.getInt(cursor.getColumnIndex("cod")));

                    cursor.moveToNext();
                }
            } else {
                Log.e("LogX", "Cursor vazio.");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return produtos;

    }

    private void carregaProdutos(){



    }

    private void apagarTarefa(Integer id){
        SQLiteDatabase bancoDados = openOrCreateDatabase("smartstock", MODE_PRIVATE, null);
        Log.i("teste","entrou no apagar"+id);
        try{
            bancoDados.execSQL("DELETE FROM produto WHERE cod="+id);
            Log.i("teste","tentou no apagar");
            carregaProdutos();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }



}
