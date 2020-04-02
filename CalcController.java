package PolyCalc;

import java.awt.event.*;

public class CalcController
{
	private CalcModel m_model;
	private CalcView m_view;
	
	CalcController(CalcModel model, CalcView view)
	{
		m_model = model;
		m_view = view;

		view.addListener(new addListener());
		view.subtractListener(new subtractListener());
		view.multiplyListener(new multiplyListener());
		view.differentiateListener(new differentiateListener());
		view.integrationListener(new integrationListener());
		view.clearListener(new ClearListener());
	}
	//functia de citire a unei perechi de polinoame
	public void readPair(CalcModel m_model)
    {
        Polynomial Polynomial1 = new Polynomial();
        String[] coefficients  = m_view.getCoefficientsPoly1().split(" ");
        for (int j = coefficients.length - 1; j >= 0; j--)
        {
             Polynomial1.polynomial.add(new Monomial(j, Integer.parseInt(coefficients[j])));
        }
        m_model.setPoly1(Polynomial1);
       
        Polynomial Polynomial2 = new Polynomial();
        coefficients  = m_view.getCoefficientsPoly2().split(" ");
        for (int j = coefficients.length - 1; j >= 0; j--)
        {
            Polynomial2.polynomial.add(new Monomial(j, Integer.parseInt(coefficients[j])));
        }
        m_model.setPoly2(Polynomial2); 
    }
	//Implementare listerners
	class ClearListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			m_model.init();
			m_view.reset();
		}
	}
	
	class addListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Polynomial result = new Polynomial();
			readPair(m_model);
			
			result.add(m_model.getPoly1(), m_model.getPoly2());
			m_view.setResult(result.printPoly());
		}
	}
	
	class subtractListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Polynomial result = new Polynomial();
			readPair(m_model);
			
			result.subtract(m_model.getPoly1(), m_model.getPoly2());
			m_view.setResult(result.printPoly());
		}
	}
	class multiplyListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Polynomial result = new Polynomial();
			readPair(m_model);
			
			result.multiply(m_model.getPoly1(), m_model.getPoly2());
			m_view.setResult(result.printPoly());
		}
	}
	class differentiateListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Polynomial result = new Polynomial();
			readPair(m_model);
			
			result.differentiate(m_model.getPoly1());
			m_view.setResult(result.printPoly());
		}
	}
	class integrationListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Polynomial result = new Polynomial();
			readPair(m_model);
			
			result.integrate(m_model.getPoly1());
			m_view.setResult(result.printPoly());
		}
	}
}
