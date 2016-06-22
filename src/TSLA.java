public class TSLA extends Item{
	
	public static double price;

	public TSLA(String n, String s, double p){
		super(n,s);
		TSLA.price = p;
	}

	public static void setPrice(double p){
		TSLA.price = p;
	}

	public static synchronized double getPrice (){
		return TSLA.price;
	}

	public static synchronized void bid (double p){
		TSLA.setPrice(p);
		Data.priceMap.put("TSLA",new Double(p));
	}

}
