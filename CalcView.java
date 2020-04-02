package PolyCalc;

import java.awt.*;
import javax.swing.*;

import PolyCalc.CalcModel;

import java.awt.event.*;

public class CalcView extends JFrame
{
	private JTextField degreePoly1 = new JTextField(3);
	private JTextField degreePoly2 = new JTextField(3);
	private JTextField coefficientsPoly1 = new JTextField(10);
	private JTextField coefficientsPoly2 = new JTextField(10);
	private JTextField result = new JTextField(20);
	
	private JButton addBtn = new JButton("+");
	private JButton substractBtn = new JButton("-");
	private JButton multiplyBtn = new JButton("*");
	private JButton divideBtn = new JButton("/");
	private JButton differentiateBtn = new JButton("d");
	private JButton integrationBtn = new JButton("I");
	private JButton clearBtn = new JButton("Clear");

	
	CalcView(CalcModel model)
	{
		result.setEditable(false);
		//Gruparea pentru insert-uri
		JPanel inputs = new JPanel();
		inputs.setLayout(new GridLayout(4,3));
		inputs.add(new JLabel(" "));inputs.add(new JLabel("Degrees"));inputs.add(new JLabel("Coefficients"));
		inputs.add(new JLabel("Polynom 1 :"));inputs.add(degreePoly1);inputs.add(coefficientsPoly1);
		inputs.add(new JLabel("Polynom 2 :"));inputs.add(degreePoly2);inputs.add(coefficientsPoly2);
		inputs.add(new JLabel("Operations :"));
		//Gruparea pentru butoanele pentru functii
		JPanel functions = new JPanel();
		functions.setLayout(new GridLayout(3,2));
		functions.add(addBtn);functions.add(substractBtn);
		functions.add(multiplyBtn);functions.add(divideBtn);	
		functions.add(differentiateBtn);functions.add(integrationBtn);
		//Gruparea pentru rezultat
		JPanel results = new JPanel();
		results.setLayout(new GridLayout(1,3));
		results.add(new JLabel("Result"));results.add(result);results.add(clearBtn);
		//Gruparea toatala
		JPanel content = new JPanel();
		content.setLayout(new GridLayout(3,1));
		
		content.add(inputs);
		content.add(functions);
		content.add(results);
						
		this.setContentPane(content);
		this.pack();

		this.setTitle("Polynomial Calculator");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	int getDegreePoly1()
    {
        return Integer.parseInt(degreePoly1.getText());    
    }
    String getCoefficientsPoly1()
    {
        return coefficientsPoly1.getText();
    }
    int getDegreePoly2()
    {
        return Integer.parseInt(degreePoly1.getText());    
    }  
    String getCoefficientsPoly2()
    {
        return coefficientsPoly2.getText();
    }
	
	void addListener(ActionListener mal)
	{
		addBtn.addActionListener(mal);
	}
	void subtractListener(ActionListener mal)
	{
		substractBtn.addActionListener(mal);
	}
	void multiplyListener(ActionListener mal)
	{
		multiplyBtn.addActionListener(mal);
	}
	void divideListener(ActionListener mal)
	{
		divideBtn.addActionListener(mal);
	}
	void differentiateListener(ActionListener mal)
	{
		differentiateBtn.addActionListener(mal);
	}
	void integrationListener(ActionListener mal)
	{
		integrationBtn.addActionListener(mal);
	}
	void clearListener(ActionListener mal)
	{
		clearBtn.addActionListener(mal);
	}
	
	void setResult(String newTotal)
	{
		result.setText(newTotal);
	}
	void reset()
	{
		result.setText("0");
	}
}
