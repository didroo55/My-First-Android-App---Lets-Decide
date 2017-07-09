package com.didroo.business;

import com.didroo.DAO.EnterpriseDAO;

public class GetRatingNumeric {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
	}

	
	public int getRatingNumeric(String ratingtext)
	{
		if (ratingtext!=null && ratingtext.equals("Awesome"))
				{
				return 5;
				}
		else if (ratingtext!=null && ratingtext.equals("Very Good"))
		{
			return 4;
		}
		
		else if (ratingtext!=null && ratingtext.equals("Moderate"))
		{
			return 3;
		}
		
		else if (ratingtext!=null && ratingtext.equals("Not Bad"))
		{
			return 2;
		}
		
		else if (ratingtext!=null && ratingtext.equals("Yuck!!"))
		{
			return 1;
		}
		else 
		{
			return 0;
		}
		
	}
}
