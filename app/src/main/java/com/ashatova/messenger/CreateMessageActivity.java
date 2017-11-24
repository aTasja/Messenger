package com.ashatova.messenger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreateMessageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);
    }

    //Вызвать onSendMessage() при щелчке на кнопке
    public void onSendMessage(View view){
        EditText messageView = (EditText)findViewById(R.id.message);
        String messageText = messageView.getText().toString();
        //Intent intent = new Intent(this, ReceiveMessageActivity.class); //яыный интент
        //intent.putExtra(ReceiveMessageActivity.EXTRA_MESSAGE, messageText);
        Intent intent = new Intent(Intent.ACTION_SEND); //неявный интент
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, messageText);
        String chooserTitle = getString(R.string.chooser);
        Intent choosenIntent = Intent.createChooser(intent, chooserTitle);
        //startActivity(intent);
        startActivity(choosenIntent);
    }
}
