import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
/*
*       Server is handle in this class
*/
public class Server implements Runnable {

    public static final int BASE_PORT = 2000;  // do not change    
    private static ServerSocket serverSocket;  // server Socket for main server 

    public static final int WAIT_AUTH = 0; 
    public static final int AUTH_DONE = 1;
    public static final int    HAS_NAME=2;

  
    public static String WAIT_AUTH_SYM = "Enter Symbol for Bid : "; 
    public static String AUTH_DONE_MSG = "You are authorised to bid\n"; 
    public static String BID_DONE      = "Enter Your Bid : "; 

    public Socket mySocket; // connection socket per thread 
    private int currentState; 
    private String clientName = null;
    private String clientSymbol = null; 
    
    
    public Server(int socket) throws IOException { 
		
		serverSocket = new ServerSocket(socket); 		// accept connections on socket number 
		Data.initialData(); 
		Bid f = new Bid();
    }


    public static void server_loop() throws IOException { 
		
		FB fbobj = new FB (Data.findName("FB"),"FB",Data.findPrice("FB"));
		VRTU vrtuobj = new VRTU (Data.findName("VRTU"),"VRTU",Data.findPrice("VRTU"));
		MSFT msftobj = new MSFT (Data.findName("MSFT"),"MSFT",Data.findPrice("MSFT"));
		GOOGL googlobj = new GOOGL (Data.findName("GOOGL"),"GOOGL",Data.findPrice("GOOGL"));
		YHOO yhooobj = new YHOO (Data.findName("YHOO"),"YHOO",Data.findPrice("YHOO"));
		XLNX xlnxobj = new XLNX (Data.findName("XLNX"),"XLNX",Data.findPrice("XLNX"));
		TSLA tslaobj = new TSLA (Data.findName("TSLA"),"TSLA",Data.findPrice("TSLA"));
		TXN txnobj = new TXN (Data.findName("TXN"),"TXN",Data.findPrice("TXN"));

		while(true) {

		    Socket socket = serverSocket.accept(); 	    
		    Thread worker = new Thread(new Server(socket)); 
		    worker.start();

		}// while loop    
    }

	

		public Server(Socket connectionSocket) { 
		
		this.mySocket = connectionSocket; 
		this.currentState = WAIT_AUTH; 
		this.clientName = null;
		this.clientSymbol = null;  
    	}

		public void run(){  // run methord for threads

		BufferedReader in=null; 
		PrintWriter out=null; 

		try { 
			    in = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
			    out = new PrintWriter(new OutputStreamWriter(mySocket.getOutputStream()));
				
			    String line, outline = "",sym; 
			    double b;

			    for(line = in.readLine();line != null && !line.equals("quit");line = in.readLine()) { 	

					switch(this.currentState) { 
					case WAIT_AUTH: 
					                            
								    this.clientName = line;
								    currentState=HAS_NAME;
								    outline =WAIT_AUTH_SYM;
								    break;
					case HAS_NAME: 	// authorization of symbol		    
								    
								    sym = line;
								    boolean state = sym.equals("FB") ||sym.equals("VRTU") ||sym.equals("MSFT") ||sym.equals("GOOGL") ||sym.equals("YHOO") ||sym.equals("XLNX") ||sym.equals("TSLA") ||sym.equals("TXN") ;
								    if (state){
								    	this.clientSymbol = sym;
								    	this.currentState = AUTH_DONE; 
									if(this.clientSymbol.equals("FB")){
										outline =(BID_DONE+ " Current price is : "+FB.getPrice() +" : \n");
															
									}else if (this.clientSymbol.equals("VRTU")){
									outline =(BID_DONE+ " Current price is : "+VRTU.getPrice() +" : \n");
										
									}else if (this.clientSymbol.equals("MSFT")){
										outline =( " Current state : "+MSFT.getPrice() +" : \n");
																		   										}else if (this.clientSymbol.equals("GOOGL")){
									      outline =( " Current price is : "+GOOGL.getPrice() +" : \n");
								    
									}else if (this.clientSymbol.equals("YHOO")){
										outline =( " Current price is : "+YHOO.getPrice() +" : \n");
										
									}else if (this.clientSymbol.equals("XLNX")){
										outline =(" Current price is : "+XLNX.getPrice() +" :\n ");
										
									}else if (this.clientSymbol.equals("TSLA")){
										outline =( " Current price is : "+TSLA.getPrice() +" :\n ");
										
									}else if (this.clientSymbol.equals("TXN")){
										outline =( " Current price is : "+TXN.getPrice() +" :\n ");
								
									} 	
								    }
									break;
					    /*****************************/
					case AUTH_DONE: if(this.clientSymbol.equals("FB")){
										
										b = Double.parseDouble(line);
									        FB.bid(b);
									        Data.fb.add(new His(this.clientName,this.clientSymbol,b));
									}else if (this.clientSymbol.equals("VRTU")){
										
										b =Double.parseDouble(line);
										VRTU.bid(b);
										Data.vrtu.add(new His(this.clientName,this.clientSymbol,b));
									}else if (this.clientSymbol.equals("MSFT")){
										
										b =Double.parseDouble(line);
								    	        MSFT.bid(b);
								    	        Data.msft.add(new His(this.clientName,this.clientSymbol,b));
									}else if (this.clientSymbol.equals("GOOGL")){
										
										b =Double.parseDouble(line);
								    	        GOOGL.bid(b);
								    	        Data.googl.add(new His(this.clientName,this.clientSymbol,b));
									}else if (this.clientSymbol.equals("YHOO")){
									
										b =Double.parseDouble(line);
								    	        YHOO.bid(b);
								    	        Data.yhoo.add(new His(this.clientName,this.clientSymbol,b));
									}else if (this.clientSymbol.equals("XLNX")){
									
										b =Double.parseDouble(line);
								    	        XLNX.bid(b);
								    	        Data.xlnx.add(new His(this.clientName,this.clientSymbol,b));
									}else if (this.clientSymbol.equals("TSLA")){
										
										b =Double.parseDouble(line);
								    	        TSLA.bid(b);
								    	        Data.tsla.add(new His(this.clientName,this.clientSymbol,b));
									}else if (this.clientSymbol.equals("TXN")){
										
									        b =Double.parseDouble(line);
								    	        TXN.bid(b);
								    	        Data.txn.add(new His(this.clientName,this.clientSymbol,b));
									} 
                                                                        outline =( " Bid DONE ! enter another bid :\n");
					    			break; 
					default: 
					    			System.out.println("Undefined state"); 
					    return; 
					} // case 
					 
					out.print(outline); // Send the said message 
					out.flush(); // flush to network

			    } // for 

			    // close everything 
			    out.close(); 
			    in.close(); 
			    this.mySocket.close(); 
		} // try 	     
		catch (IOException e) { 
		    System.out.println(e); 
		} 
		}
	



}
