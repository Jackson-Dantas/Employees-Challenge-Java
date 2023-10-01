import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

        /*
        Uma empresa possui funcionários próprios e terceirizados.
        Para cada funcionário, deseja-se registrar nome, horas
        trabalhadas e valor por hora. Funcionários terceirizado
        possuem ainda uma despesa adicional.
        O pagamento dos funcionários corresponde ao valor da hora
        multiplicado pelas horas trabalhadas, sendo que os
        funcionários terceirizados ainda recebem um bônus
        correspondente a 110% de sua despesa adicional.
        Fazer um programa para ler os dados de N funcionários (N
        fornecido pelo usuário) e armazená-los em uma lista. Depois
        de ler todos os dados, mostrar nome e pagamento de cada
        funcionário na mesma ordem em que foram digitados.
        Construa o programa conforme projeto ao lado.
        */

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        ArrayList <Employee> employees = new ArrayList<>();


        System.out.print("Enter the number of employees: ");
        int n = sc.nextInt();
        sc.nextLine();//consome linha

        for (int i = 1; i <= n; i++) {

            System.out.printf("Employee #%d data: %n", i);
            System.out.print("Outsourced (y/n)? ");
            String answer = sc.next();


            switch (answer){

                case "n" -> {

                    System.out.print("Name: ");
                    String name = sc.next();

                    System.out.print("Hours: ");
                    Integer hours = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Value per hour: ");
                    Double valuePerHour = sc.nextDouble();

                    employees.add(new Employee(name, hours, valuePerHour));
                }

                case "y" -> {

                    System.out.print("Name: ");
                    String name = sc.next();

                    System.out.print("Hours: ");
                    Integer hours = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Value per hour: ");
                    Double valuePerHour = sc.nextDouble();

                    System.out.print("Additional charge: ");
                    Double additionalCharge = sc.nextDouble();

                    //POLYPHORM allow us UpCasting the subClass OutsourcedEmploye to SuperClass Employe
                    employees.add(new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge));
                    /*
                    * Notice employees is ArrayList of Objects of SuperClass Employee, but with upCasting can store
                    * an object of subClass OutsourcedEmploye, the subClass have the method payment() behavior different
                    * of its superClass methods Employee
                    */

                }
            }
        }

        System.out.println("PAYMENTS: ");
        for (Employee employe: employees) {

            System.out.printf("%s - $%.2f %n", employe.getName(), employe.payment());
        }

    }
}