package com.demas.modul4;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class UserViewHolder extends RecyclerView.ViewHolder{
    TextView txtNamaLengkap;
    TextView txtService;
    TextView txtGender;
    private CardView listUser;
    private Context context;
    private List<User> userList;
    private int id;
    private String namaLengkap;
    private String tglSewa;
    private String umur;
    private String gender;
    private String service;


    public UserViewHolder(@NonNull View itemView){
        super(itemView);
        context = itemView.getContext();

        txtNamaLengkap = itemView.findViewById(R.id.txtNamaLengkapList);
        txtService = itemView.findViewById(R.id.txtServiceList);
        txtGender = itemView.findViewById(R.id.txtGenderList);
        listUser = itemView.findViewById(R.id.row_item);

        listUser.setOnClickListener(new View.OnClickListener() {
            @Override
                    public void onClick(View view) {alertAction(context, getAdapterPosition());}
        });
    }

    private void alertAction(Context context,int position) {
        String[] option ={"Detail", "Edit", "Delete"};
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(context);
        DataHelper db =new DataHelper(context);
        userList = db.selectUserData();

        id = userList.get(position).getId();
        namaLengkap = userList.get(position).getNamaLengkap();
        tglSewa = userList.get(position).getTglSewa();
        umur = userList.get(position).getUmur();
        gender = userList.get(position).getGender();
        service = userList.get(position).getPenyewaan();


        builder.setTitle("Pilih Opsi");
        builder.setItems(option, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                switch (i){
                    case 0:
                        Intent viewActivity = new Intent(context, ViewActivity.class);
                        viewActivity.putExtra("id",id);
                        viewActivity.putExtra("namaLengkap",namaLengkap);
                        viewActivity.putExtra("tglLahir",tglSewa);
                        viewActivity.putExtra("umur",umur);
                        viewActivity.putExtra("gender",gender);
                        viewActivity.putExtra("service",service);

                        context.startActivity(viewActivity);
                        break;

                    case 1:
                            Intent  modifyActivity = new Intent(context,  ModifyActivity.class);
                            modifyActivity.putExtra("id",id);
                            modifyActivity.putExtra("namaLengkap",namaLengkap);
                            modifyActivity.putExtra("tglLahir",tglSewa);
                            modifyActivity.putExtra("umur",umur);
                            modifyActivity.putExtra("gender",gender);
                            modifyActivity.putExtra("service",service);

                            context.startActivity( modifyActivity);
                            break;

                    case 2:
                        DataHelper db = new DataHelper(context);
                        db.delete(userList.get(position).getId());

                        userList = db.selectUserData();
                        MainActivity.setupRecyclerView(context, userList, MainActivity.recyclerView);

                        Toast.makeText(context, "Data Berhasil Dihapus", Toast.LENGTH_SHORT);
                        break;

                }

            }
        });
        builder.show();

    }

}
