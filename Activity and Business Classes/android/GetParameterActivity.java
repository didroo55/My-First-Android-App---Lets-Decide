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

public class GetParameterActivity extends Activity {
	
	
	EnterpriseDAO data ;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_parameters);
        TextView text = (TextView) findViewById(R.id.problemDisplay);
        Intent intent = getIntent();
       
        	Bundle bundle = intent.getExtras().getBundle("transferBundle");
        	
        	 this.data =  (EnterpriseDAO) bundle.getSerializable("transferDAO");
		
		
		   text.setText("Enter your top three criteria for choosing the best "+data.getProblem());
		
		  Button decideButton = (Button) findViewById(R.id.submitParameter);
	        decideButton.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					loadParameters(data);
					
				}
			});
        
   
        
      
        
    }
    
   public void loadParameters(EnterpriseDAO data)
    {
    	
    	//Intent loadParameterIntent = new Intent(this,GetOptionsActivity.class);
    	
    	EditText parameterOne = (EditText) findViewById(R.id.enterparameterOne);
    	
    	EditText parameterTwo = (EditText) findViewById(R.id.enterparameterTwo);
    	
    	EditText parameterThree = (EditText) findViewById(R.id.enterparameterThree);
    	
    	String parameterOneString = parameterOne.getText().toString();
    	String parameterTwoString = parameterTwo.getText().toString();
    	String parameterThreeString = parameterThree.getText().toString();
    	
    	data.setParameterOne(parameterOneString);
    	data.setParameterTwo(parameterTwoString);
    	data.setParameterThree(parameterThreeString);
    	
      
    	
    	Intent intent = new Intent(this,GetOptionsActivity.class);
    	
    	 Bundle transferDataBundle = new Bundle();
    	 transferDataBundle.putSerializable("loadedParameters", data);
    	 intent.putExtra("loadedParametersBundle", transferDataBundle);
    	 startActivity(intent);
    	
    }
    
}