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

public class RateOptionTwoActivity extends Activity {
	
	
	EnterpriseDAO data ;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_option_two);
        TextView titleText = (TextView) findViewById(R.id.rateOptionTwoTitle);
        TextView parameterOneText = (TextView) findViewById(R.id.parameterOneOptionTwoText);
        TextView parameterTwoText = (TextView) findViewById(R.id.parameterTwoOptionTwoText);
        TextView parameterThreeText = (TextView) findViewById(R.id.parameterThreeOptionTwoText);
        
        
    	Intent intent = getIntent();
       	Bundle bundle = intent.getExtras().getBundle("transferBundleTwo");
    	this.data =  (EnterpriseDAO) bundle.getSerializable("transferDAOTwo");
    	titleText.setText("Please rate " + data.getOptionTwo());
    	
    	
    	parameterOneText.setText("Please Rate " +data.getOptionTwo()+" for " +data.getParameterOne() );
        parameterTwoText.setText("Please Rate " +data.getOptionTwo()+" for " +data.getParameterTwo() );
        parameterThreeText.setText("Please Rate " +data.getOptionTwo()+" for " +data.getParameterThree() );  
        
        
        Button decideButton = (Button) findViewById(R.id.optionTwoRated);
        decideButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Spinner spinnerParameterOne = (Spinner) findViewById(R.id.parameterOneOptionTwoSpinner);
		        Spinner spinnerParameterTwo = (Spinner) findViewById(R.id.parameterTwoOptionTwoSpinner);
		        Spinner spinnerParameterThree = (Spinner) findViewById(R.id.parameterThreeOptionTwoSpinner);
		        
		       
		        GetRatingNumeric utility = new GetRatingNumeric();
		        int parameterOneRating = utility.getRatingNumeric(spinnerParameterOne.getSelectedItem().toString());
		        int parameterTwoRating = utility.getRatingNumeric(spinnerParameterTwo.getSelectedItem().toString());
		        int parameterThreeRating = utility.getRatingNumeric(spinnerParameterThree.getSelectedItem().toString());
		        data.setScoreTwo((parameterOneRating+parameterTwoRating+parameterThreeRating)/3);
		        
				
				loadOptionTwoRating ();
			}
		});
        
    }
    
    public void loadOptionTwoRating ()
    {
    	Intent callerintent = new Intent(this,RateOptionThreeActivity.class);
    	 Bundle transferDataBundle = new Bundle();
    	 transferDataBundle.putSerializable("transferDAOTwo", data);
    	 callerintent.putExtra("transferBundleTwo", transferDataBundle);
    	startActivity(callerintent);
    }
    
    
}