package PolyCalc;

public class CalcModel
{
	private Polynomial poly1;
	private Polynomial poly2;
	private Polynomial result;
	
	public CalcModel() 
	{
		init();
	}
	
	public void init() 
	{
		poly1 = new Polynomial();
		poly2 = new Polynomial();
		result = new Polynomial();
	}
	//getter si setter pentru cele doua polinoame
	public Polynomial getPoly1() 
	{
		return poly1;
	}
	public void setPoly1(Polynomial poly1) 
	{
		this.poly1 = poly1;
		this.poly1.sortPoly();
	}

	public Polynomial getPoly2() 
	{
		return poly2;
	}

	public void setPoly2(Polynomial poly2) 
	{
		this.poly2 = poly2;
		this.poly2.sortPoly();
	}
	
	public Polynomial getResult() {
		return result;
	}

	public void setResult(Polynomial result) {
		this.result = result;
		this.result.sortPoly();
	}
}
