package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
 
    public static void main(String[] args) throws IOException {
       
        Scanner sc= new Scanner(System.in);
        Socket socket = new Socket ("169.254.35.172",2015);
        
        InputStream it;
        InputStreamReader ent;
        BufferedReader entrada;
        it= socket.getInputStream();
        ent=new InputStreamReader(it);
        entrada= new BufferedReader(ent);
        
        OutputStream ot;
        OutputStreamWriter s;
        PrintWriter salida;
        ot= socket.getOutputStream();
        s= new OutputStreamWriter(ot);
        salida= new PrintWriter(s,true);
        
        for(;;){
            System.out.println("Digite numero");
            System.out.println("-1 para terminar");
            String dato = sc.nextLine();
            salida.println(""+dato);
            String m = entrada.readLine();
            if(m==null){
                break;
            }
            System.out.println(m);                     
        }
        socket.close();       
    }   
}
