package com.didroo.android;

import com.didroo.DAO.EnterpriseDAO;
import com.didroo.business.GetFinalScore;
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

public class FinalDecisionactivity extends Activity {
	
	
	EnterpriseDAO data ;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_decision);
        TextView decisionText = (TextView) findViewById(R.id.finalDecision);
        TextView finalScoreOne = (TextView) findViewById(R.id.finalScoreOne);
        TextView finalScoreTwo = (TextView) findViewById(R.id.finalScoreTwo);
        TextView finalScoreThree = (TextView) findViewById(R.id.finalScoreThree);
        
        Intent intent = getIntent();
       	Bundle bundle = intent.getExtras().getBundle("transferBundleThree");
    	this.data =  (EnterpriseDAO) bundle.getSerializable("transferDAOThree");
    	GetFinalScore finalScore = new GetFinalScore();
    	data.setFinalDecision(finalScore.getFinalScorefromOptionScores(data));
    	decisionText.setText(data.getFinalDecision());
    	final Intent backtoHome = new Intent(this, ProblemActivity.class);
    	finalScoreOne.setText(data.getOptionOne() + " scored " + data.getScoreOne());
    	finalScoreTwo.setText(data.getOptionTwo() + " scored " + data.getScoreTwo());
    	finalScoreThree.setText(data.getOptionThree() + " scored " + data.getScoreThree());
    	 Button decideButton = (Button) findViewById(R.id.finalDecisionToHome);
         decideButton.setOnClickListener(new OnClickListener() {
 			
 			@Override
 			public void onClick(View v) {
 				startActivity(backtoHome);
 			}
 		});
         
    }
    
   
    
}