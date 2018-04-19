package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Chat {
    
    
    public static void main(String[] args) throws IOException {
        Scanner sc;
        sc= new Scanner(System.in);
        Socket cliente = null;
        ServerSocket ss;
        ss= new ServerSocket(2015);
        cliente = ss.accept();
        
        
        InputStream it;
        InputStreamReader e1;
        BufferedReader entrada;
        it= cliente.getInputStream();
        e1= new InputStreamReader(it);
        entrada = new BufferedReader(e1);
        
        OutputStream ot;
        OutputStreamWriter s;
        PrintWriter salida;
        ot=cliente.getOutputStream();
        s = new OutputStreamWriter(ot);
        salida = new PrintWriter(s, true);
        
        String mensaje;
        double n;
        for (int i = 0; i < 10; i++) {
            mensaje = entrada.readLine();
            System.out.println("Digite p para determinar si es primo o no primo: "+ mensaje);
            System.out.println("Otra letra para lg");
            String op = sc.nextLine();
            
            n=Double.parseDouble(mensaje);
            if(n<0)
                break;
            if(op.charAt(0)== 'p'){
                int con=0;
                for (int j = 0; j <= n; j++) {
                    if((n%j)==0){
                        con ++;
                    }
                    
                }
                if (con <= 2){
                    salida.println("es primo " + n);
                }
                else{
                    salida.println("no es primo " + n);
                }
                
                
            }
            else {
                n= Math.log(n)/Math.log(2);
                salida.println("lg"+n);
            }
            
        }
        entrada.close();
        salida.close();
        cliente.close();
        
                
        
    }
    
    
}
