package sg.edu.np.mad.madpractical4;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import sg.edu.np.mad.madpractical4.R;


public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        List<User> userList = new ArrayList<>();
        String[] names = {"Alice", "Bob", "Charlie", "David", "Emma", "Frank", "Grace", "Henry", "Ivy", "Jack"};
        String[] descriptions = {"Software Engineer", "Teacher", "Artist", "Doctor", "Musician", "Writer", "Athlete", "Chef"};
        for (int i = 0; i < 20; i++) {
            Random random = new Random();

            String name = names[random.nextInt(names.length)];
            String description = descriptions[random.nextInt(descriptions.length)];
            int id = i + 1; // IDs start from 1
            boolean followed = random.nextBoolean();
            User user = new User(name, description, id, followed);
            userList.add(user);


        }
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        UserAdapter adapter = new UserAdapter(userList, this); // Pass context as second parameter
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);
                builder.setMessage("MADness");
                builder.setTitle("Profile");
                builder.setPositiveButton("View", (DialogInterface.OnClickListener) (dialog, which) -> {
                    Intent viewactivity = new Intent(ListActivity.this, MainActivity.class);
                    startActivity(viewactivity);
                });

                // Set the Negative button with No name Lambda OnClickListener method is use of DialogInterface interface.
                builder.setNegativeButton("Cancel", (DialogInterface.OnClickListener) (dialog, which) -> {

                    dialog.cancel();

                });
                AlertDialog alertDialog = builder.create();
                // Show the Alert Dialog box
                alertDialog.show();
            }
        });
    }
}