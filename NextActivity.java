package bd.ac.uiu.mcc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class NextActivity extends AppCompatActivity implements View.OnClickListener {
   Button button;
   DataBaseHandler dataBaseHandler;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        button.findViewById(R.id.bt1);
        button.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        dataBaseHandler.open();
        ArrayList<User> users=dataBaseHandler.getUser();

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User lhs, User rhs) {
                // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                if(Integer.parseInt(lhs.getAge())>Integer.parseInt(lhs.getAge())){
                    return -1;

                }
                else if(Integer.parseInt(lhs.getAge())<Integer.parseInt(lhs.getAge())){
                    return 1;

                }
                else {
                    return 0;

                }


            }
        });

        recyclerView.setHasFixedSize(true);


        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new MyAdapter(users);
        recyclerView.setAdapter(mAdapter);

    }
}
