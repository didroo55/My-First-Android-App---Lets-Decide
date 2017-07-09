package com.didroo.business;

import com.didroo.DAO.EnterpriseDAO;

public class GetFinalScore {

	
	public String getFinalScorefromOptionScores(EnterpriseDAO dao)
	{
		if(dao.getScoreOne()>dao.getScoreTwo() && dao.getScoreOne()>dao.getScoreThree())
		{
			dao.setFinalDecision(dao.getOptionOne());
		}
		else if(dao.getScoreTwo()>dao.getScoreOne() && dao.getScoreTwo()>dao.getScoreThree())
		{
			dao.setFinalDecision(dao.getOptionTwo());
		}
		
		else
		{
			dao.setFinalDecision(dao.getOptionThree());
		}
		return dao.getFinalDecision();
		
		
	}
}
