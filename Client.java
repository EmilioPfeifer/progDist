import java.util.Scanner;
public class Client
{
    public static void main(String[] args)
    {
	Scanner scn = new Scanner(System.in);
	String palabra = "";
        try(com.zeroc.Ice.Communicator communicator = com.zeroc.Ice.Util.initialize(args))
        {
            com.zeroc.Ice.ObjectPrx base = communicator.stringToProxy("SimplePrinter:default -p 10000");
            Demo.PrinterPrx printer = Demo.PrinterPrx.checkedCast(base);
            if(printer == null)
            {
                throw new Error("Invalid proxy");
            }
	    do
	    {
		System.out.print("Inserte texto ('bye' para salir):");
		palabra = scn.nextLine();
            	System.out.println(printer.printString(palabra));
		Thread.sleep(2000);
	    }while(!palabra.equals("bye"));
        }catch (InterruptedException e){}

    }
}
