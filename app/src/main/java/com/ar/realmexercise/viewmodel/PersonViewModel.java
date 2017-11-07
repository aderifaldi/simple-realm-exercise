package com.ar.realmexercise.viewmodel;

import android.view.View;

import com.ar.realmexercise.model.Person;

/**
 * Created by RadyaLabs PC on 07/11/2017.
 */

public class PersonViewModel {

    private View.OnClickListener onClickListener;
    private String name;
    private int age;
    private String id;

    public PersonViewModel(Person item, View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
        this.name = item.getName();
        this.age = item.getAge();
        this.id = item.getId();
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return  "" + age + " Ages";
    }

    public String getId() {
        return id;
    }

    public void onItemClick(View view) {
        onClickListener.onClick(view);
    }

}
