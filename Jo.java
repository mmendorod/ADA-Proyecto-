// Programa para encontrar el máximo beneficio
// secuencia de trabajo de una matriz dada
// de puestos de trabajo con plazos y beneficios
import java.util.*; 

class Jo  
{ 

	// Cada trabajo tiene un ID único,
	// beneficio y plazo
    char id; 
    int deadline, profit; 
  
    // Constructor
    public Jo() {} 
  
    public Jo(char id, int deadline, int profit) 
    { 
        this.id = id; 
        this.deadline = deadline; 
        this.profit = profit; 
    } 
  

 // Función para programar los trabajos toma 2
 // Array de argumentos y no de trabajos a programar 
    void printJobScheduling(ArrayList<Job> arr, int t) 
    { 
        // Length del array 
        int n = arr.size(); 
     // Ordenar todos los trabajos según
     // orden decreciente de ganancia
        Collections.sort(arr, 
                         (a, b) -> b.profit - a.profit); 
  
     // Para realizar un seguimiento de los espacios de tiempo libre 
        boolean result[] = new boolean[t]; 

     // Para almacenar el resultado (Secuencia de trabajos)
        char jo[] = new char[t]; 
  
     // Itere a través de todos los trabajos dados
        for (int i = 0; i < n; i++)  
        { 
        	// Encuentra un espacio libre para este trabajo
            // (Tenga en cuenta que partimos del
            // último espacio posible)
            for (int j 
                 = Math.min(t - 1, arr.get(i).deadline - 1); 
                 j >= 0; j--) { 

            	// Espacio libre encontrado
                if (result[j] == false)  
                { 
                    result[j] = true; 
                    jo[j] = arr.get(i).id; 
                    break; 
                } 
            } 
        } 
  
        // imprimir secuencia
        for (char jb : jo)  
        { 
            System.out.print(jb + " "); 
        } 
        System.out.println(); 
    } 
  
 // Código del controlador
    public static void main(String args[]) 
    { 
        ArrayList<Job> arr = new ArrayList<Job>(); 
  
        arr.add(new Job('a', 2, 50)); 
        arr.add(new Job('b', 1, 15)); 
        arr.add(new Job('c', 2, 10)); 
        arr.add(new Job('d', 1, 10)); 
        arr.add(new Job('e', 3, 15)); 
        
     // Llamada de función
        System.out.println("Lo siguiente es maximo "
                           + "secuencia de importancia de tareas"); 
  
        Job job = new Job(); 

     // Función de llamada
        job.printJobScheduling(arr, 3); 
    } 
} 
  