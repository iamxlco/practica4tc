package practica4tc;

import java.util.Scanner;

public final class miniAutomata {
    
    private int q, t;
    private String[][] automata;
    private final Scanner scan = new Scanner(System.in);;
    
    public miniAutomata(){
        writeInstructions();
        getDimensions();
        getAutomata();
        printAutomata(automata);
    }
    
    public void writeInstructions(){
        System.out.println("Instrucciones:"
                + "\n1.-Introduce un estado de la siguiente manera:"
                + "\n\tQ\tQ(1)\tQ(2)\t...Q(n)"
                + "\nDonde:"
                + "\n\tQ: Estado actual"
                + "\n\tQ(1): Primera transición"
                + "\n\tQ(n): N-ésima transición"
                + "\n2.-Separa los estados y las transiciones con un ESPACIO"
                + "\n3.-Para agregar un nuevo estado presiona ENTER");
    }
    
    public void getDimensions(){
        System.out.print("\nIntroduce el número de estados: ");
        q = Integer.parseInt(scan.nextLine());
        System.out.print("\nIntroduce el número de transiciones: ");
        t = Integer.parseInt(scan.nextLine());
        System.out.println("");
        
        automata = new String[q][t+1];
    }
    
    public void getAutomata(){
        System.out.println("Por favor ingresa el autómata");
        
        String linea = "";       
        for(int i=0; i<q ; i++){
            String edo[];
            linea = scan.nextLine();
            edo = linea.split(" ");
            automata[i] = edo;
        }
    }
    
    public void printAutomata(String[][] a){
        System.out.print("Q");
        for(int i=0;i<t;i++){
            System.out.print("\tQ("+(i+1)+")");
        }
        System.out.println("");
        for(int i=0;i<q;i++){
            System.out.print(a[i][0]);
            for(int j=1;j<=t;j++){
                System.out.print("\t"+a[i][j]+"");
            }
            System.out.println("");
        }
    }
    
}
