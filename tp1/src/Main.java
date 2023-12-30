
public class Main {
    public static void main(String[] args) {

        BankAccount account = new BankAccount(206, "John", 1);

        System.out.printf("Account Number: %d\n",account.getAccountNumber());
        System.out.printf("Account Holder Name: %s\n",account.getAccountHolderName());
        System.out.printf("Account Balance: $%d\n",account.getBalance());

        account.deposit(1000);
        account.withdraw(1001);

        //---------------------------------------------------

        Instructor MrFlen = new Instructor(417, "Flen", "Fouleni");
        Instructor MrFalten = new Instructor(714, "Falten", "Falteni");
        MrFlen.showInfo();
        MrFalten.showInfo();
        Course math = new Course(1, "Mathematics", MrFlen);
        Course physics = new Course(2, "Physics", MrFalten);
        math.showInfo();
        physics.showInfo();
        Student john = new Student(123, "John", "Doe");
        john.enroll(math);
        john.enroll(physics);
        john.showInfo();

        //--------------------------------------------------

        CustomArrayList arr = new CustomArrayList(5);
        System.out.println(arr.isEmpty());
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);

        arr.print();
        arr.add(4,3);
        arr.print();
        arr.remove(3);
        arr.print();


        System.out.println(arr.find(3));
        System.out.println(arr.find(5));
        System.out.println(arr.isIn(1));
        System.out.println(arr.isIn(5));
        System.out.println(arr.get(2));
        System.out.println(arr.get(4));

    }
}