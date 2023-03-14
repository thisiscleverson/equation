import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int [] values = askNumber();
        int delta = calculeDelta(values);

        if(delta < 0){
            System.out.println("a equação não possui resultados reais");
        }else if(delta == 0){
            int[] resultsCalculeBaskara = calculeBaskara(values[0], values[1], delta);
            System.out.println("Results: ");
            System.out.println("x: " + resultsCalculeBaskara[0]);
        }else if(delta > 0){
            int[] resultsCalculeBaskara = calculeBaskara(values[0], values[1], delta);
            System.out.println("Results: ");
            System.out.println("x': " + resultsCalculeBaskara[0]);
            System.out.println("x'': " + resultsCalculeBaskara[1]);
        }

    }

    static int[] askNumber(){
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Digite o valor de A: ");
            int valuesA = scanner.nextInt();
            System.out.print("Digite o valor de B: ");
            int valuesB = scanner.nextInt();
            System.out.print("Digite o valor de C: ");
            int valuesC = scanner.nextInt();
            System.out.println();

            int [] values = new int[3];
            values[0] = valuesA;
            values[1] = valuesB;
            values[2] = valuesC;

            return values;
        }catch(Exception error){
            throw error;
        }
    }

    static int calculePower(int base, int power){
        if(power == 0){
            return 1;
        }else if(power == 1){
            return base;
        }else{
            int rememberBase = base;
            for(int i=1; i<power; i++){
                base = base * rememberBase;
            }
            return base;
        }
    }

    static int calculeDelta(int values[]){
        int resultsPower = calculePower(values[1], 2);
        int delta = resultsPower - 4 * values[0] * values[2]; // values [0] --> A and values [2] --> C
        return delta;
    }

    /**
     * @param valuesA
     * @param valuesB
     * @param delta
     * @return
     */
    static int[] calculeBaskara(int valuesA, int valuesB, int delta){
        int[] resultsBaskara = new int[2];

        // root equal to Zero
        if(delta == 0){
            resultsBaskara[0] = (-valuesB) / 2* valuesA;
        }else if(delta > 0){ // root bigger then zero
            // x'
            resultsBaskara[0] = (int) ((-valuesB + Math.sqrt(delta)) / 2* valuesA);
            // x''
            resultsBaskara[1] = (int) ((-valuesB - Math.sqrt(delta)) / 2* valuesA);
        }

        return resultsBaskara;
    }
}
