package shangguigu.hashtable;

import java.util.Scanner;

/**
 * @author: Kate Fu
 * @create: 2021-12-23 21:58
 */
public class HashTableDemo {
    public static void main(String[] args) {
        HashTable table = new HashTable(7);
        String key="";
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("add: add an employee");
            System.out.println("list: show all employees");
            System.out.println("find: find an employee by id");
            System.out.println("exit: exit program");

            key = scanner.next();
            switch (key){
                case "add":
                    System.out.println("input id:");
                    int id = scanner.nextInt();
                    System.out.println("input name");
                    String name = scanner.next();
                    Emp e = new Emp(id, name);
                    table.add(e);
                    break;
                case "list":
                    table.showAllList();
                    break;
                case "find":
                    System.out.println("input id:");
                    int id1 = scanner.nextInt();
                    table.findEmpById(id1);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}

class Emp{
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class EmpLinkedList{
    private Emp head;
    public void add(Emp emp){
        if(head==null){
            head = emp;
            return;
        }
        Emp curEmp = head;
        while(true){
            if(curEmp.next==null){
                break;
            }
            curEmp = curEmp.next;
        }
        curEmp.next = emp;
    }

    public void showList(int no){
        if(head==null){
            System.out.println("the list["+no+"] is empty!");
            return;
        }
        Emp curEmp = head;
        while(true){
            System.out.printf("=>id =%d name=%s\t",curEmp.id, curEmp.name);
            if(curEmp.next==null) break;
            curEmp = curEmp.next;
        }
    }

    public Emp findEmpById(int id){
        if(head==null){
            System.out.println("the list is empty!");
        }
        Emp curEmp = head;
        while(true){
            if(curEmp.id == id){
                break;
            }
            if(curEmp.next==null){
                curEmp = null;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }
}

class HashTable{
    private EmpLinkedList[] empListArray;
    private int size;
    public HashTable(int size){
        this.size = size;
        empListArray = new EmpLinkedList[size];
        for(int i=0; i<empListArray.length; i++){
            empListArray[i] = new EmpLinkedList();
        }
    }
    public void add(Emp emp){
        int empListNo = hashFun(emp.id);
        empListArray[empListNo].add(emp);

    }
    public int hashFun(int id){
        return id%size;
    }
    public void showAllList(){
        for(int i=0; i<size; i++){
            empListArray[i].showList(i);
        }
    }
    public void findEmpById(int id){
        int empListNo = hashFun(id);
        Emp emp = empListArray[empListNo].findEmpById(id);
        if(emp!=null){
            System.out.printf("Found Emp[id=%d] in No.[%d] list\n", id, empListNo);
        }else{
            System.out.println("Id not found");
        }
    }
}