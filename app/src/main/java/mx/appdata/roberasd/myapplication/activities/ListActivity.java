package mx.appdata.roberasd.myapplication.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import mx.appdata.roberasd.myapplication.R;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView mTextView = (TextView)findViewById(R.id.textview);
        final EditText mEditText = (EditText) findViewById(R.id.edittext);
        Button mButton = (Button) findViewById(R.id.button);
        final ListView mListView = (ListView) findViewById(R.id.listview);

        final ArrayList<String> arrayList = new ArrayList<>();

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.custom_layout, arrayList);

        Bundle bundle = getIntent().getExtras();

        //mTextView.setText(bundle.getString("parametro"));

        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),
                        mListView.getItemAtPosition(position).toString(),
                        Toast.LENGTH_LONG).show();
            }
        });

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList.add(mEditText.getText().toString());
                adapter.notifyDataSetChanged();
                mEditText.setText(" ");
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
