package com.didroo.android;

import com.didroo.DAO.EnterpriseDAO;
import com.didroo.business.GetRatingNumeric;
import com.mkyong.android.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class RateOptionThreeActivity extends Activity {
	
	
	EnterpriseDAO data ;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_option_three);
        TextView titleText = (TextView) findViewById(R.id.rateOptionThreeTitle);
        TextView parameterOneText = (TextView) findViewById(R.id.parameterOneOptionThreeText);
        TextView parameterTwoText = (TextView) findViewById(R.id.parameterTwoOptionThreeText);
        TextView parameterThreeText = (TextView) findViewById(R.id.parameterThreeOptionThreeText);
        
        
    	Intent intent = getIntent();
       	Bundle bundle = intent.getExtras().getBundle("transferBundleTwo");
    	this.data =  (EnterpriseDAO) bundle.getSerializable("transferDAOTwo");
    	
    	
    	titleText.setText("How do you rate " + data.getOptionThree());
    	parameterOneText.setText("Please Rate " +data.getOptionThree()+" for " +data.getParameterOne() );
        parameterTwoText.setText("Please Rate " +data.getOptionThree()+" for " +data.getParameterTwo() );
        parameterThreeText.setText("Please Rate " +data.getOptionThree()+" for " +data.getParameterThree() );  
        
       
        Button decideButton = (Button) findViewById(R.id.optionThreeRated);
        decideButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				 Spinner spinnerParameterOne = (Spinner) findViewById(R.id.parameterOneOptionThreeSpinner);
			        Spinner spinnerParameterTwo = (Spinner) findViewById(R.id.parameterTwoOptionThreeSpinner);
			        Spinner spinnerParameterThree = (Spinner) findViewById(R.id.parameterThreeOptionThreeSpinner);
			        
			        GetRatingNumeric utility = new GetRatingNumeric();
			        int parameterOneRating = utility.getRatingNumeric(spinnerParameterOne.getSelectedItem().toString());
			        int parameterTwoRating = utility.getRatingNumeric(spinnerParameterTwo.getSelectedItem().toString());
			        int parameterThreeRating = utility.getRatingNumeric(spinnerParameterThree.getSelectedItem().toString());
			        data.setScoreThree((parameterOneRating+parameterTwoRating+parameterThreeRating)/3);
			        
				loadOptionTwoRating ();
			}
		});
        
    }
    
    public void loadOptionTwoRating ()
    {
    	Intent callerintent = new Intent(this,FinalDecisionactivity.class);
    	 Bundle transferDataBundle = new Bundle();
    	 transferDataBundle.putSerializable("transferDAOThree", data);
    	 callerintent.putExtra("transferBundleThree", transferDataBundle);
    	startActivity(callerintent);
    }
    
    
}