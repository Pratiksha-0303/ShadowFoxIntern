import java.util.Scanner;
public class shadowcalculator{
        public static void main(String[] args){
            double num1,num2;
            Scanner sc=new Scanner(System.in);
            int choice=-1;
            do{
                System.out.println("\n=========================");
                System.out.println("     SIMPLE CALCULATOR     ");
                System.out.println("=========================");
                System.out.println("---Arithmetic Operations--- ");
                System.out.println("1.Addition");
                System.out.println("2.Subtraction");
                System.out.println("3.Multiplication");
                System.out.println("4.Division");
                System.out.println("5.Modulus");
                System.out.println("6.Square Root");
                System.out.println("7.Power");
                System.out.println("8.Temperature Conversion");
                System.out.println("9.Currency Conversion");
                System.out.println("0.Exit");
                System.out.println("Enter your choice:");
                try{
                choice=sc.nextInt();
                }
                catch(Exception e){
                    System.out.println("Invalid input! Please enter a number.");
                    sc.next();
                    continue;
                }
                if(choice>=1&& choice<=9){
                switch(choice){
                case 1:System.out.println("Addition of 2 numbers");
                       System.out.println("Enter first number");
                       num1=sc.nextDouble();
                       System.out.println("Enter second number ");
                       num2=sc.nextDouble();
                       System.out.println("👉 Result = "+(num1+num2));
                       break;
                case 2:System.out.println("Subtraction of 2 numbers");
                       System.out.println("Enter first number");
                       num1=sc.nextDouble();
                       System.out.println("Enter second number ");
                       num2=sc.nextDouble();
                       System.out.println("👉 Result = "+(num1-num2));
                       break;
                case 3:System.out.println("Multiplication of 2 numbers");
                       System.out.println("Enter first number");
                       num1=sc.nextDouble();
                       System.out.println("Enter second number ");
                       num2=sc.nextDouble();
                       System.out.println("👉 Result = "+(num1*num2));
                       break;
                case 4:System.out.println("Division of 2 numbers");
                       System.out.println("Enter first number");
                       num1=sc.nextDouble();
                       System.out.println("Enter second number ");
                       num2=sc.nextDouble();
                       if(num2==0){
                             System.out.println("❌ Error: Division by zero!");
                        }
                       else{
                             System.out.println("👉 Result = "+(num1/num2));
                        }
                       break;
                case 5:System.out.println("Modulus of 2 numbers");
                       System.out.println("Enter first number");
                       num1=sc.nextDouble();
                       System.out.println("Enter second number ");
                       num2=sc.nextDouble();
                       if(num2==0){
                             System.out.println("❌ Error: Cannot mod by zero!");
                        }  
                       else{
                             System.out.println("👉 Result = "+(num1%num2));
                        }
                       break;
                case 6:System.out.println("Square Root");
                       System.out.println("Enter a number");
                       double num=sc.nextDouble();
                       if(num<0){
                        System.out.println("❌ Cannot find Square root of negative number");
                       }
                       else{
                       System.out.println("👉 Result = "+Math.sqrt(num));
                       }
                       break;
                case 7:System.out.println("Exponential");
                       System.out.println("Enter the base");
                       double base=sc.nextDouble();
                       System.out.println("Enter exponent");
                       double exp=sc.nextDouble();
                       System.out.println("👉 Result = "+Math.pow(base,exp));
                       break;
                case 8:System.out.println("1.Celsius to Fahrenheit");
                       System.out.println("2.Fahrenheit to Celsius");
                       int t=sc.nextInt();
                       if(t==1){
                            System.out.println("Enter celsius");
                            double c=sc.nextDouble();
                            double f=((c*9/5)+32);
                            System.out.println("Fahrenheit = "+f);
                        }
                       else if(t==2){
                            System.out.println("Enter Fahrenheit");
                            double f=sc.nextDouble();
                            double c=((f-32)*5/9);
                            System.out.println("Celsius = "+c);
                        }
                       else{
                            System.out.println("❌ Invalid Choice");
                        }
                        break;
                case 9:System.out.println("1.Convert INR to USD");
                       System.out.println("2.Convert USD to INR");
                       int cur=sc.nextInt();
                       if(cur==1){
                            System.out.println("Enter INR: ");
                            double inr=sc.nextDouble();
                            double usd=(inr/83.0);
                            System.out.println("USD=$"+usd);
                        }
                       else if(cur==2){
                            System.out.println("Enter USD:");
                            double usd=sc.nextDouble();
                            double inr=(usd*83.0);
                            System.out.println("INR=Rs."+inr);
                        }
                       else{
                            System.out.println("❌ Invalid Choice");
                        }
                       break;
                   }
               }
            else if(choice!=0){
                  System.out.println("❌ Invalid Choice");
            }
        }
        while(choice!=0);
                    
            System.out.println("Exiting Calculator...");
                    sc.close();
            }
        }
