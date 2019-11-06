package calculadora;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.util.Scanner;
import java.util.*;
/**
 *
 * @author cmarc
 */
public class Calculadora {
    
    

    private String checkExp(String eq)
    {
        int val1 = 0;
        int val2 = 0;
        double exp;
        int counter1 = 1;
        int counter2 = 1;
      
        String exp1 = "Math.pow(";
        StringBuilder sb = new StringBuilder();
        
        if(eq.contains("^"))
        {
            int ind = eq.indexOf("^");
            if(Character.isDigit(ind - 1))
            {
                while(Character.isDigit(ind - counter1))
                        {
                            counter1++;
                        }
                val1 = Integer.valueOf(eq.substring(ind - counter1));
            }
            
               if(Character.isDigit(ind + 1))
            {
                while(Character.isDigit(ind + counter2))
                        {
                            counter2++;
                        }
                val2 = Integer.valueOf(eq.substring(ind + counter2));
            }
               
               if(val1 != 0 && val2 != 0) 
               {
                   exp = Math.pow((double)val1, (double)val2);
                   sb.append(eq.substring(0, ind - counter1));
                   sb.append(exp);
                   sb.append(eq.substring(eq.indexOf(Double.toString(exp)),eq.length()));
               }
               System.out.println(sb.toString());
               eq = sb.toString();
               return eq;
                   
               
            
        }
        
            
       //2^2     eq = eq.substring(, counter1)
        
        return eq;
    }
    
    //This method solves the math equation given. Uses ScriptEngineManager.
    private String solve() throws ScriptException   
    {
           
        ScriptEngineManager calc = new ScriptEngineManager();
        ScriptEngine eng = calc.getEngineByName("JavaScript");
        
        while(true)
        {
        System.out.println("0");
        Scanner scn = new Scanner(System.in);
        String equation = scn.nextLine();
        if(equation.contains("^"))
        {
            equation = checkExp(equation);
        }
        System.out.println("Result: " + eng.eval(equation));
        }

        
    }
    
    public void run() throws ScriptException
    {
        try
        {
            this.solve();
        }
        catch(Exception e)
        {
            System.out.println("ERROR");
        }
        
    }
    
    
    public static void main(String[] args) throws ScriptException{
        try
        {
        
        Calculadora calc = new Calculadora();
        calc.run();
        }
        catch(Exception e)
        {
            System.out.println("ERROR");
        }
        
    }
    
}
