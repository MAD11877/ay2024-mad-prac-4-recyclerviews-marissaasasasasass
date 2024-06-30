package sg.edu.np.mad.madpractical4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

//import sg.edu.np.mad.prac4.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        User user = new User("John Doe", "MAD Developer",1,false);
        TextView tvName = findViewById(R.id.tvName);
        TextView tvDescription = findViewById(R.id.tvDescription);
        Button btnFollow = findViewById(R.id.btnFollow);
        Button btnMsg= findViewById(R.id.button3);
        tvName.setText(user.name);
        tvDescription.setText(user.description);
        btnFollow.setText("Follow");

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        int otp2 = new Random().nextInt(99999);
        tvName.setText(user.name+" "+String.format("%05d", otp2));
        final boolean[] follow = {false};
        btnFollow.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v){

                if( !follow[0]) {
                    btnFollow.setText("Unfollow");
                    Toast.makeText(MainActivity.this, "Followed!", Toast.LENGTH_SHORT).show();
                    follow[0] =true;

                }
                else if (follow[0]){
                    btnFollow.setText("Follow");
                    Toast.makeText(MainActivity.this, "Unfollowed!", Toast.LENGTH_SHORT).show();
                    follow[0] =false;
                }
            }
        });
        btnMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewmessage= new Intent(MainActivity.this,MessageGroup.class);
                startActivity(viewmessage);
            }
        });
    }
}