import java.net.*;
import java.io.*;

public class chatserver
{
public static void main(String args[]) throws Exception
{
ServerSocket ss=new ServerSocket(200);
System.out.println("Menunggu Klien mengirim pesan pertama........");
System.out.println("* chat dilakukan 2 arah, bergantian kirim pesan.");
Socket sk=ss.accept();
System.out.println("Klien telah masuk. happy chat! untuk berhenti, ketik stop pada klien.\n\n");
BufferedReader cin=new BufferedReader(new InputStreamReader(sk.getInputStream()));
PrintStream cout=new PrintStream(sk.getOutputStream());
BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
String s;
while ( true )
{
s=cin.readLine();
if (s.equalsIgnoreCase("stop"))

{
cout.println("Bye");
break;
}
System. out.print("Client : "+s+"\n");
System.out.print("Server : ");
s=stdin.readLine();
cout.println(s);
}
ss.close();
sk.close();
cin.close();
cout.close();
stdin.close();
}
}