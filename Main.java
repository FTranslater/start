import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Integer k=0;
        for (char element : s.toCharArray()){
            if ((element=='+') | (element=='-') | (element=='*') | (element=='/')){
                k++;
            }
        }
        if(k!=1){
            System.out.println("неправильное колличество действий");
            System.exit(0);
        }
        if (s.contains("+")) {
            String[] values= s.split("\\+");
            Integer[] numbers=solve(values);
            Integer result= numbers[0]+numbers[1];
            switch (numbers[2]){
                case 0:
                    System.out.print("="+result);
                    break;
                case 1:
                    translation(result);
                    break;
                case 2:
                    System.out.println("числа в разных системах счисления");
            }

        }
        if (s.contains("-")) {
            String[] values= s.split("-");
            Integer[] numbers=solve(values);
            Integer result= numbers[0]-numbers[1];
            switch (numbers[2]){
                case 0:
                    System.out.print("="+result);
                    break;
                case 1:
                    if(result<0){
                        System.out.println("число отрицательное");
                    }
                    else{
                        translation(result);
                    }
                    break;
                case 2:
                    System.out.println("числа в разных системах счисления");
            }
        }
        if (s.contains("*")) {
            String[] values= s.split("\\*");
            Integer[] numbers=solve(values);
            Integer result= numbers[0]*numbers[1];
            switch (numbers[2]){
                case 0:
                    System.out.print("="+result);
                    break;
                case 1:
                    if(result<0){
                        System.out.println("число отрицательное");
                    }
                    else{
                        translation(result);
                    }
                    break;
                case 2:
                    System.out.println("числа в разных системах счисления");
            }
        }
        if (s.contains("/")) {
            String[] values= s.split("/");
            Integer[] numbers=solve(values);
            Integer result= numbers[0]/numbers[1];
            switch (numbers[2]){
                case 0:
                    System.out.print("="+result);
                    break;
                case 1:
                        translation(result);
                    break;
                case 2:
                    System.out.println("числа в разных системах счисления");
            }
        }

    }
    static Integer[] solve(String[] values){
        Integer a=-1;
        Integer b=-1;
        Integer k1=0;
        Integer k2=0;
        try{
            a=Integer.parseInt(values[0]);
        }
        catch (NumberFormatException e1){
            k1=1;
            for(rim r : rim.values()) {
                if (r.getIcon().equals(values[0])) {
                    a = r.getValue();
                }
            }
        }
        try{
            b= Integer.parseInt(values[1]);
        }
        catch (NumberFormatException e2){
            k2=1;
            for(rim r : rim.values()) {
                if (r.getIcon().equals(values[1])) {
                    b = r.getValue();
                }
            }
        }
        if(k1+k2==1){
            Integer[] h = {a, b, 2};
            return h;
        }
        else{
            if (k1+k2==2) {
                Integer[] h = {a, b, 1};
                return h;
            }
            else{
                Integer[] h = {a, b, 0};
                return h;
            }
        }
    }
    static void translation(Integer a){
        String[] rome= {"C","XC","L","XL","X","IX","V","IV","I"};
        Integer[] arabic={100,90,50,40,10,9,5,4,1};
        StringBuilder result=new StringBuilder("=");
        while (a > 0) {
            for(int i=0;i<9;i++){
                if (a-arabic[i]>=0){
                    result.append(rome[i]);
                    a=a-arabic[i];
                    break;
                }
            }
        }
        System.out.print(result);
    }
}

