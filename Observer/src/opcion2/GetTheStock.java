package opcion2;

import java.text.DecimalFormat;

public class GetTheStock implements Runnable{

	private String stock;
	private double price;
	private Subject stockGrabber;
	
	public GetTheStock(Subject stockGrabber, int newStartTime, String newStock, double newPrice){
				
		this.stockGrabber = stockGrabber;

		// startTime = newStartTime;  Not used to have variable sleep time
		stock = newStock;
		price = newPrice;
		
	}
	
	public void run(){
		
		for(int i = 1; i <= 20; i++){
		
			try{
				
				// Sleep for 2 seconds
				Thread.sleep(2000);
				
				// Use Thread.sleep(startTime * 1000); to 
				// make sleep time variable
			}
			catch(InterruptedException e)
			{}
						
			double randNum = (Math.random() * (.06)) - .03;
			DecimalFormat df = new DecimalFormat("#.##");

	        price = Double.valueOf(df.format((price + randNum)));
			
			if(stock == "IBM") ((StockGrabber) stockGrabber).setIBMPrice(price);
			if(stock == "AAPL") ((StockGrabber) stockGrabber).setAAPLPrice(price);
			if(stock == "GOOG") ((StockGrabber) stockGrabber).setGOOGPrice(price);
			
			System.out.println(stock + ": " + df.format((price + randNum)) + 
					" " + df.format(randNum));
			
			System.out.println();
		
		}
	}
	
}