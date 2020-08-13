package com.example.encuestaproy.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.encuestaproy.R;
import com.example.encuestaproy.entidades.alumnos;

import java.util.List;


public class adapterCarr extends RecyclerView.Adapter<adapterCarr.ViewHolderDatos>{

    List<alumnos> listaAlumnos;

    public adapterCarr(List<alumnos> listaAlumnos){
        this.listaAlumnos = listaAlumnos;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista= LayoutInflater.from(parent.getContext()).inflate(R.layout.listacar,parent,false);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        vista.setLayoutParams(layoutParams);
        return new ViewHolderDatos(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        holder.txtMatricula.setText(listaAlumnos.get(position).getMatricula().toString());
        holder.txtNombre.setText(listaAlumnos.get(position).getNombre().toString());
        holder.txtTutor.setText(listaAlumnos.get(position).getTutor().toString());

    }

    @Override
    public int getItemCount() {
        return listaAlumnos.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView txtMatricula,txtNombre,txtTutor;
        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            txtMatricula = (TextView) itemView.findViewById(R.id.txtMatricula);
            txtNombre = (TextView) itemView.findViewById(R.id.txtNombre);
            txtTutor = (TextView) itemView.findViewById(R.id.txtTutor);
        }
    }
}
