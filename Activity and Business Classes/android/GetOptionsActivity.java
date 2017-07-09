package com.didroo.android;

import com.didroo.DAO.EnterpriseDAO;
import com.mkyong.android.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class GetOptionsActivity extends Activity {
	
	EnterpriseDAO data;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_options);
        
    TextView text = (TextView) findViewById(R.id.optionsDisplay);
        Intent intent = getIntent();
        
    	Bundle bundle = intent.getExtras().getBundle("loadedParametersBundle");
    	this.data =  (EnterpriseDAO) bundle.getSerializable("loadedParameters");
    	
     text.setText("Enter your top three choices ");
     Button decideButton = (Button) findViewById(R.id.submitOption);
     decideButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 loadOptions(data);
				
			}
		});
    
        
    }
    
    public void loadOptions(EnterpriseDAO optionsData)
    {
EditText optionOne = (EditText) findViewById(R.id.enteroptionOne);
    	
    	EditText optionTwo = (EditText) findViewById(R.id.enteroptionTwo);
    	
    	EditText optionThree = (EditText) findViewById(R.id.enteroptionThree);
    	
    	String optionOneString = optionOne.getText().toString();
    	String optionTwoString = optionTwo.getText().toString();
    	String optionThreeString =optionThree.getText().toString();
    	
    	data.setOptionOne(optionOneString);
    	data.setOptionTwo(optionTwoString);
    	data.setOptionThree(optionThreeString);
    	
      
    	
    	Intent intent = new Intent(this,RateOptionOneActivity.class);
    	
    	 Bundle transferDataBundle = new Bundle();
    	 transferDataBundle.putSerializable("loadedOptions", data);
    	 intent.putExtra("loadedOptionsBundle", transferDataBundle);
    	 startActivity(intent);
    }
}