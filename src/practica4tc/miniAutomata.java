package practica4tc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class miniAutomata {
    
    private int q, t;
    private List<String[]> automata = new ArrayList<>();
    private final Scanner scan = new Scanner(System.in);;
    
    public miniAutomata(){
        writeInstructions();
        getDimensions();
        getAutomata();
        automata = equivalentClasses(automata);
        printAutomata(automata);
    }
    
    public void writeInstructions(){
        System.out.println("Instrucciones:"
                + "\n1.-Introduce un automata de la siguiente manera:"
                + "\n\tQ\tQ(1)\tQ(2)\t...Q(n)"
                + "\n\tA\tB\tC\t...N"
                + "\n\tB\tD\tE\t...M"
                + "\nDonde:"
                + "\n\tQ: Estado actual"
                + "\n\tQ(1): Primera transición"
                + "\n\tQ(n): N-ésima transición"
                + "\n2.-Separa los estados y las transiciones con un ESPACIO"
                + "\n3.-Para agregar un nuevo estado presiona ENTER");
    }
    
    public void getDimensions(){
        System.out.print("\nNúmero de estados: ");
        q = Integer.parseInt(scan.nextLine());
        System.out.println("");
    }
    
    public void getAutomata(){
        System.out.println("Por favor ingresa el autómata\n");
        
        String linea = "";       
        for(int i=0; i<q ; i++){
            String edo[];
            linea = scan.nextLine();
            edo = linea.split(" ");
            automata.add(edo);
        }
    }
    
    public void printAutomata(List<String[]> a){
        System.out.println("\nAUTOMATA REDUCIDO");
        
        System.out.print("Q");
        for(int i=0;i<automata.size()-1;i++){
            System.out.print("\tQ("+(i)+")");
        }
        System.out.println("");
        
        for(String fila[]: a){
            for(int i=0;i<fila.length;i++){
                System.out.print(fila[i]+"\t");
            }
            System.out.println("");
        }
    }
    
    public List<String[]> equivalentClasses(List<String[]> auto){        
        for(int i=0;i<auto.size();i++){
            for(int j=0;j<auto.size();j++){
                if(areEquals(auto.get(i), auto.get(j))){
                    String old = auto.get(j)[0], nw = auto.get(i)[0];
                    for(int k=0;k<auto.size();k++){
                        for(int l=0;l<auto.get(k).length;l++)
                            if(auto.get(k)[l].equals(old))
                                auto.get(k)[l] = nw;
                    }
                    auto.remove(j);
                    equivalentClasses(auto);
                }
            }
        }
        
        return auto;
    }

    
    public boolean areEquals(String[] a, String[] b){
        boolean theyAre=true;
        
        if(a[0].equals(b[0]))
            return false;
        
        for(int i=1;i<a.length;i++){
            if(!a[i].equals(b[i]))
                theyAre = false;
        }
        
        
        return theyAre;
    }
}
