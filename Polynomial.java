package PolyCalc;

import java.util.*;

public class Polynomial
{
	public ArrayList<Monomial> polynomial;

	public Polynomial()
	{
		super();
		this.polynomial = new ArrayList<Monomial>();
		this.sortPoly();
	}

	public ArrayList<Monomial> getPolynomial()
	{
		return polynomial;
	}

	public void setPolynomial(ArrayList<Monomial> polynomial)
	{
		this.polynomial = polynomial;
	}

	public void addMonomial(Monomial monomial)
	{
		this.polynomial.add(monomial);
	}

	// Functia pentru forma canonica a polinoamelor
	public void sortPoly()
	{
		Collections.sort(this.polynomial, new CompareRuleExponent());
		this.polynomial.removeIf(m -> (m.getCoefficient() == 0.0));
		if (this.polynomial.isEmpty() == true)
		{
			this.polynomial.add(new Monomial(0, 0.0));
		}
	}

	//Functia de afisare a unui polinom
	public String printPoly()
	{
		String print = "";
		if (this.polynomial.get(0).getCoefficient() == 0.0 && this.polynomial.get(0).getExponent() == 0)
		{
			print = "0.0";
		} else
		{
			boolean f = true;
			for (Monomial monomial : this.polynomial)
			{
				if (f == true)
				{
					if (monomial.getCoefficient() > 0.0)
					{
						print = print + monomial.toString();
					} else
					{
						print = print + monomial.toString();
					}
					f = false;
				} else
				{
					if (monomial.getCoefficient() > 0.0)
					{
						print = print + "+" + monomial.toString();
					} else
					{
						print = print + monomial.toString();
					}
				}
			}
		}
		return print;
	}

	//Functia de adunarea a polinoamelor
	//Parcurge cele doua polinoame si adauga coeficientii monoamelor de acelasi exponent apoi adauga monoamele ramase cu coeficientii lor
	public void add(Polynomial poly1, Polynomial poly2)
    {
        Polynomial result = new Polynomial();
        int p1size = 0;
        int p2size = 0;
        while (p1size != poly1.polynomial.size() || p2size != poly2.polynomial.size())
        {
            if (p1size != poly1.polynomial.size() && p2size != poly2.polynomial.size())
            {
                if (poly1.polynomial.get(p1size).getExponent() == poly2.polynomial.get(p2size).getExponent())
                {
                    Monomial sum = new Monomial(poly1.polynomial.get(p1size).getExponent(),
                            poly1.polynomial.get(p1size).getCoefficient()
                                    + poly2.polynomial.get(p2size).getCoefficient());
                    p1size++;
                    p2size++;
                    result.addMonomial(sum);
                } else if (poly1.polynomial.get(p1size).getExponent() > poly2.polynomial.get(p2size).getExponent())
                {
                    result.addMonomial(poly1.polynomial.get(p1size));
                    p1size++;
                } else
                {
                    result.addMonomial(poly2.polynomial.get(p2size));
                    p2size++;
                }
            } else if (p1size != poly1.polynomial.size())
            {
                result.addMonomial(poly1.polynomial.get(p1size));
                p1size++;
            } else
            {
                result.addMonomial(poly2.polynomial.get(p2size));
                p2size++;
            }
        }
        result.sortPoly();
        this.setPolynomial(result.polynomial);
    }

	//Functia de scadere
	//Foloseste adunarea si inmulteste monoamele celui de-al doilea coeficient cu -1 pentru a realiza scaderea
	public void subtract(Polynomial poly1, Polynomial poly2)
	{
		Polynomial result = new Polynomial();
		for (Monomial monomial : poly2.polynomial)
		{
			monomial.setCoefficient(-monomial.getCoefficient());
		}
		result.add(poly1, poly2);
		this.setPolynomial(result.polynomial);
	}

	// Functia de inmultire
	// Parcurge polinoamele si inmulteste fiecare monom din primul polinom cu fiecare monom din al doilea
	public void multiply(Polynomial poly1, Polynomial poly2)
	{
		Polynomial result = new Polynomial();
		for (Monomial monom1 : poly1.polynomial)
		{
			for (Monomial monom2 : poly2.polynomial)
			{
				Monomial monomNew = new Monomial(monom1.getExponent() + monom2.getExponent(),monom1.getCoefficient() * monom2.getCoefficient());
				boolean existent = false;
				for (Monomial monomResult : result.polynomial) 
				{
						monomResult.setCoefficient(monomResult.getCoefficient() + monomNew.getCoefficient());
						existent = true;
						break;
				}				
				if(existent == false)
				{
					result.addMonomial(monomNew);
				}
			}
		}
		result.sortPoly();
		this.setPolynomial(result.polynomial);
	}

	// Functia de impartire
	// Neimplementata
	public Polynomial divide(Polynomial poly1, Polynomial poly2)
	{
		Polynomial result = new Polynomial();
		return result;
	}

	//Functia de divizare
	// Parcurge monoamele polinomului si inmulteste exponentul fiecaruia cu coeficientul , apoi decrementeaza exponentul
	public void differentiate(Polynomial poly1)
	{
		Polynomial result = new Polynomial();
		for (Monomial i : poly1.polynomial)
		{
			if (i.getExponent() != 0)
			{
				Monomial mono = new Monomial(i.getExponent() - 1, i.getCoefficient() * i.getExponent());
				result.addMonomial(mono);
			}
		}
		result.sortPoly();
		this.setPolynomial(result.polynomial);
	}

	// Functia de integrare
	//Parcurge monoamele polinomului si incrementeaza exponentul dupa ce imparte coeficientul la exponentul anterior
	public void integrate(Polynomial poly1)
	{
		Polynomial result = new Polynomial();

		for (Monomial i : poly1.polynomial)
		{
			Double d = Double.valueOf(i.getExponent()) + 1.0;
			d = i.getCoefficient() / d;
			Monomial mono = new Monomial(i.getExponent() + 1, d);
			result.addMonomial(mono);
		}
		result.sortPoly();
		this.setPolynomial(result.polynomial);
	}
}
