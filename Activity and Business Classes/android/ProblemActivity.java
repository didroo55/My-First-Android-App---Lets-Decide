package com.didroo.android;

import com.didroo.DAO.EnterpriseDAO;
import com.mkyong.android.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ProblemActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        TextView text = (TextView) findViewById(R.id.headerText);
       // Typeface tf = Typeface.createFromAsset(getApplicationContext().getAssets(),"fonts/HomegirlFiftyShades.ttf");
        //text.setTypeface(tf);
       // Intent helpIintent = new Intent(this,HelpActivity.class);
        Button decideButton = (Button) findViewById(R.id.decide_button);
        decideButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				loadProblem();
			}
		});
       /* Button helpButton = (Button) findViewById(R.id.go_to_help);
        helpButton
        .setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				startHelp();
			}
		}); */
        
    }
    
    public void loadProblem()
    {
    	Intent intent = new Intent(this,GetParameterActivity.class);
    	EditText editText = (EditText)findViewById(R.id.enterProblemTextBox);
    	 String problem = editText.getText().toString();
    	 EnterpriseDAO dataObject = new EnterpriseDAO();
    	 dataObject.setProblem(problem);
    	 Bundle transferDataBundle = new Bundle();
    	 transferDataBundle.putSerializable("transferDAO", dataObject);
    	 intent.putExtra("transferBundle", transferDataBundle);
    	 startActivity(intent);
    	
    }
    
    public void startHelp()
    {
    	Intent intent = new Intent(this,HelpActivity.class);
    	startActivity(intent);
    	
    	
    }
    
}