package com.ar.realmexercise.model;

import io.realm.RealmList;
import io.realm.RealmObject;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by RadyaLabs PC on 07/11/2017.
 */

@NoArgsConstructor
@Data
public class Person extends RealmObject {

    private String name;
    private int age;
    private String id;

}
