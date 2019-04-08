package bd.ac.uiu.mcc;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editText1,editText2,editText3,editText4;
    ImageView imageView;
    TextView textView;
    Button button;
    DataBaseHandler dataBaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initilize();
        textView.setOnClickListener(this);
        button.setOnClickListener(this);

    }

    private void validation() {
        dataBaseHandler=new DataBaseHandler(this);
        dataBaseHandler.open();

        if(!editText1.getText().toString().isEmpty()){
            if(!editText2.getText().toString().isEmpty()) {
                if(!editText3.getText().toString().isEmpty()) {
                    if(!editText4.getText().toString().isEmpty()){
                        User user=new User(editText1.getText().toString(),editText3.getText().toString(),editText2.getText().toString(),editText4.getText().toString(),imageView.getId());
                        Intent intent=new Intent(MainActivity.this,NextActivity.class);
                        dataBaseHandler.insert(user);
                        dataBaseHandler.close();
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(this,"Enter Phone No", Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Toast.makeText(this,"Enter Email", Toast.LENGTH_LONG).show();
                }

            }
            else{
                Toast.makeText(this,"Enter age", Toast.LENGTH_LONG).show();
            }
        }
        else{
            Toast.makeText(this,"Enter Name", Toast.LENGTH_LONG).show();
        }
        dataBaseHandler.close();
    }

    private void initilize() {
        editText1=findViewById(R.id.et1);
        editText2=findViewById(R.id.et2);
        editText3=findViewById(R.id.et3);
        editText4=findViewById(R.id.et4);
        imageView=findViewById(R.id.iv);
        textView=findViewById(R.id.tv1);
        button=findViewById(R.id.bt);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv1:
                Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(takePicture, 0);
                Intent pickPhoto = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(pickPhoto , 1);
                break;
            case R.id.bt:
                validation();
                break;

        }


    }
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        switch(requestCode) {
            case 0:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = imageReturnedIntent.getData();
                    imageView.setImageURI(selectedImage);
                }

                break;
            case 1:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = imageReturnedIntent.getData();
                    imageView.setImageURI(selectedImage);
                }
                break;
        }
    }

}
