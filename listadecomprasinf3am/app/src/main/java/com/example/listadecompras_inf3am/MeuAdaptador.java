package com.example.listadecompras_inf3am;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MeuAdaptador  extends ArrayAdapter <Produto> {
    LayoutInflater inflater;
    int resourceId;

    public MeuAdaptador(@NonNull Context context, int resource, @NonNull List<Produto> objects) {
        super(context, resource, objects);
        resourceId = resource;
        inflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = inflater.inflate(resourceId, parent, false);
        CheckBox checkBox = convertView.findViewById(R.id.checkBox);

        Produto produto = getItem(position);
        checkBox.setText(produto.nome+"("+ (produto.valor)+")");
        checkBox.setChecked(produto.checked);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                produto.checked = isChecked;
            }
        });
            return convertView;
    }
}
