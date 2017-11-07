package com.ar.realmexercise.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.ar.realmexercise.R;
import com.ar.realmexercise.model.Person;
import com.ar.realmexercise.view.adapter.PersonListAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getName();

    @BindView(R.id.listPerson)
    RecyclerView listPerson;

    PersonListAdapter adapter;
    LinearLayoutManager linearLayoutManager;

    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        ButterKnife.bind(this);
        realm = Realm.getDefaultInstance();

        adapter = new PersonListAdapter(this);
        linearLayoutManager = new LinearLayoutManager(this);

        listPerson.setAdapter(adapter);
        listPerson.setLayoutManager(linearLayoutManager);

        loadLocalData(realm);

    }

    private void loadLocalData(Realm realm) {

        RealmResults<Person> results = realm.where(Person.class).findAll();

        if (results.size() == 0){
            insertData(realm);
            Toast.makeText(this, "Please launch, again!", Toast.LENGTH_SHORT).show();
        }else {
            adapter.getData().clear();
            for (int i = 0; i < results.size(); i++) {
                adapter.getData().add(results.get(i));
                adapter.notifyItemInserted(adapter.getData().size() - 1);
            }

            adapter.notifyDataSetChanged();
        }

    }


    private void insertData(Realm realm) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                // Add a person
                for (int i = 0; i < 5; i ++){
                    Person person = realm.createObject(Person.class);
                    person.setId("" + (i + 1));
                    person.setName("Young Person " + (i + 1));
                    person.setAge(14 + i);
                }
            }
        });
    }
}
