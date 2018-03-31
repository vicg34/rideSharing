package computing.mobile.com.ridesharing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }
    public void Onclick_wel(View v)
    {
        if(v.getId()==R.id.button6)
        {
            Intent myIntent = new Intent(this, Login.class);
            startActivity(myIntent);
        }
        else if(v.getId()==R.id.button7)
        {
            Intent myIntent = new Intent(this, Register.class);
            startActivity(myIntent);
        }

    }
}
