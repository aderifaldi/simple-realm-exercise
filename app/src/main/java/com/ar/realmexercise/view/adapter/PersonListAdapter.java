package com.ar.realmexercise.view.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ar.realmexercise.BR;
import com.ar.realmexercise.R;
import com.ar.realmexercise.helper.GenericViewHolder;
import com.ar.realmexercise.model.Person;
import com.ar.realmexercise.viewmodel.PersonViewModel;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by RadyaLabs PC on 11/10/2017.
 */

public class PersonListAdapter extends RecyclerView.Adapter<GenericViewHolder> {
    private List<Person> listItem;
    private Context context;

    public PersonListAdapter(Context context) {
        this.listItem = new ArrayList<>();
        this.context = context;
    }

    public List<Person> getData() {
        return listItem;
    }

    @Override
    public GenericViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.person_list_item, parent, false);
        GenericViewHolder vh = new GenericViewHolder(binding);
        return vh;
    }

    @Override
    public void onBindViewHolder(GenericViewHolder holder, int position) {
        final Person itemData = listItem.get(position);
        PersonViewModel viewModel = new PersonViewModel(itemData, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "" + itemData.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.bindModel(BR.itemData, viewModel);
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }
}
