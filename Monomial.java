package PolyCalc;

public class Monomial
{
	private int exponent;
	private double coefficient;

	public Monomial(int exponent, double coefficient)
	{
		super();
		this.exponent = exponent;
		this.coefficient = coefficient;
	}

	public int getExponent()
	{
		return exponent;
	}

	public void setExponent(int exponent)
	{
		this.exponent = exponent;
	}

	public double getCoefficient()
	{
		return coefficient;
	}

	public void setCoefficient(double coefficient)
	{
		this.coefficient = coefficient;
	}

	public String toString()
	{
		if (exponent == 0)
		{
			return Double.toString(coefficient);
		} 
		else if (exponent > 1)
		{
			if (coefficient == 1.0)
			{
				return "x^" + exponent;
			} 
			else if (coefficient == -1.0)
			{
				return "-x^" + exponent;
			} 
			else
				return String.format("%.2f", coefficient) + "*x^" + exponent;
		} 
		else
		{
			if (coefficient == 1.0)
			{
				return "x";
			} 
			else if (coefficient == -1.0)
			{
				return "-x";
			} 
			else
				return String.format("%.2f", coefficient) + "*x";
		}
	}
}
