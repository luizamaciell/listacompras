package com.example.listadecompras_inf3am;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<Produto>produtos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        makeProducts();

        ListView listView = findViewById(R.id.listView);
        Button button  = findViewById(R.id.button);
        TextView textView = findViewById(R.id.textView);
        MeuAdaptador adapter = new MeuAdaptador(this, R.layout.item_produto, produtos);
        listView.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener(){
            double result;

            public void onClick(View v){
            for(Produto p : produtos){
                if(p.checked)
                    result = result + p.valor;
            }

            textView.setText("Total dos produtos selecionados "+"R$" + result);
            result = 0;
            }
        });
    }
    private void makeProducts(){
        produtos = new ArrayList<>();
        produtos.add(new Produto("Arroz", 18.9));
        produtos.add(new Produto("Feijão", 9.72));
        produtos.add(new Produto("Carne", 25.78));
        produtos.add(new Produto("Farinha", 3.9));
        produtos.add(new Produto("Leite",5.99 ));
        produtos.add(new Produto("Pão", 4.85));
    }
}