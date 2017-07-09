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

public class RateOptionOneActivity extends Activity {
	
	
	EnterpriseDAO data ;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_option_one);
        TextView titleText = (TextView) findViewById(R.id.rateOptionOneTitle);
        TextView parameterOneText = (TextView) findViewById(R.id.parameterOneOptionOneText);
        TextView parameterTwoText = (TextView) findViewById(R.id.parameterTwoOptionOneText);
        TextView parameterThreeText = (TextView) findViewById(R.id.parameterThreeOptionOneText);
        
        
    	Intent intent = getIntent();
       	Bundle bundle = intent.getExtras().getBundle("loadedOptionsBundle");
    	this.data =  (EnterpriseDAO) bundle.getSerializable("loadedOptions");
    	
    	
    	titleText.setText("How do you rate " + data.getOptionOne());
    	parameterOneText.setText("Please Rate " +data.getOptionOne()+" for " +data.getParameterOne() );
        parameterTwoText.setText("Please Rate " +data.getOptionOne()+" for " +data.getParameterTwo() );
        parameterThreeText.setText("Please Rate " +data.getOptionOne()+" for " +data.getParameterThree() );  
        
        
        
        
       Button decideButton = (Button) findViewById(R.id.optionOneRated);
        decideButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Spinner spinnerParameterOne = (Spinner) findViewById(R.id.parameterOneOptionOneSpinner);
		        Spinner spinnerParameterTwo = (Spinner) findViewById(R.id.parameterTwoOptionOneSpinner);
		        Spinner spinnerParameterThree = (Spinner) findViewById(R.id.parameterThreeOptionOneSpinner);
		        
		        GetRatingNumeric utility = new GetRatingNumeric();
		        int parameterOneRating = utility.getRatingNumeric(spinnerParameterOne.getSelectedItem().toString());
		        int parameterTwoRating = utility.getRatingNumeric(spinnerParameterTwo.getSelectedItem().toString());
		        int parameterThreeRating = utility.getRatingNumeric(spinnerParameterThree.getSelectedItem().toString());
		        data.setScoreOne((parameterOneRating+parameterTwoRating+parameterThreeRating)/3);
				loadOptionOneRating ();
			}
		});
        
       
        
       
        
        
    }
    
    public void loadOptionOneRating ()
    {
    	Intent callerintent = new Intent(this,RateOptionTwoActivity.class);
    	 Bundle transferDataBundle = new Bundle();
    	 transferDataBundle.putSerializable("transferDAOTwo", data);
    	 callerintent.putExtra("transferBundleTwo", transferDataBundle);
    	startActivity(callerintent);
    }
    
}