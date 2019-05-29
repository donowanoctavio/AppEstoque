package rumo.info.appestoque;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcosortolani on 05/05/2018.
 */

public class ItemAdapter extends ArrayAdapter<Produtos> {


    private final Context context;
    private final ArrayList<Produtos> elementos;

    public ItemAdapter(Context context, ArrayList<Produtos> elementos){

        super(context,R.layout.item, elementos);
        this.context = context;
        this.elementos = elementos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater =  (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.item,parent,false);

        TextView tvCod = (TextView) rowView.findViewById(R.id.textCodigo);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView);
        TextView tvNome = (TextView) rowView.findViewById(R.id.textNome);
        TextView tvQtd = (TextView) rowView.findViewById(R.id.textQuantidade);
        TextView tvDesc = (TextView) rowView.findViewById(R.id.textDescricao);


        imageView.setImageResource(elementos.get(position).getImagem());
        tvQtd.setText(String.valueOf(elementos.get(position).getQtd()));
        tvNome.setText(elementos.get(position).getNome());
        tvCod.setText(String.valueOf(elementos.get(position).getCod()));
        tvDesc.setText(elementos.get(position).getDesc());

        return rowView;


    }

}
