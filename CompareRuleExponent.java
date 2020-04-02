package PolyCalc;

import java.util.Comparator;

public class CompareRuleExponent implements Comparator<Monomial>
{

	@Override
	public int compare(Monomial o1, Monomial o2)
	{
		return o2.getExponent() - o1.getExponent();
	}

}
