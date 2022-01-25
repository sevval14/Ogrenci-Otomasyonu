import java.io.*;
import java.util.Scanner;
public class LinkedList  {
    Node head=null;
    Integer id;
    String name;
    Integer mat;
    Integer data;
    Integer avg;
    Scanner scanner = new Scanner(System.in);


    public void add() throws FileNotFoundException{
        if(head==null){
            String path = "C:\\Users\\sevva\\OneDrive\\DATA HOMEWORK\\src\\students.txt";
            File dosya = new File(path);
            Scanner giris = new Scanner(dosya);
            while (giris.hasNext()) {
                id = giris.nextInt();
                name = giris.next();
                mat = giris.nextInt();
                data = giris.nextInt();
                Node number =new Node(id,name,mat,data);

                if(head==null){
                    head=number;
                }else{
                    Node iterator=head;
                    while(iterator.next!=null){
                        iterator=iterator.next;
                    }
                    iterator.next=number;
                }
            }
            display();
        }else{
            display();
        }


    }
    public int matAvg(){
        if(head==null){
            System.out.println("List is empty");
        }else{
            Node iterator=head;
            int toplam =0;
            int x=0;
            while(iterator!=null){
                toplam+=iterator.mat;
                x++;
                iterator=iterator.next;
            }
            System.out.println("Mat Average : " + toplam/x);
            return toplam/x;
        }

        return 0;
    }
    public void mindata( ){
        if(head==null){
            System.out.println("List is empty");
        }else{
            Node iterator=head;
            Node previous=head;
            while(iterator!=null){
                if(iterator.data.compareTo(previous.data)==-1){
                    previous=iterator;
                }
                iterator=iterator.next;
            }
            System.out.println("The student with the lowest grade : " +  previous.name + " Grade : " + previous.data);

        }


    }
    public Node littleData(Node headstartt){
        if(head==null){
            System.out.println("List is empty");
        }else{
            Node iterator=headstartt;
            Node previous=headstartt;
            while(iterator!=null){
                if(iterator.data.compareTo(previous.data)==-1){
                    previous=iterator;
                }
                iterator=iterator.next;
            }
            return previous;
        }
        return  null;

    }
    public void selectSortd(){
        Node iterator=head;
        Node previous=head;
        System.out.println("Name\tData Grade");
        while(iterator!=null){
            previous=littleData(iterator);
            int temp=previous.avg;
            String temp1=previous.name;
            previous.name=iterator.name;
            iterator.name=temp1;
            int temp2=previous.id;
            previous.id=iterator.id;
            iterator.id=temp2;
            int temp3=previous.mat;
            previous.mat=iterator.mat;
            iterator.mat=temp3;
            int temp4=previous.data;
            previous.data=iterator.data;
            iterator.data=temp4;
            previous.avg=iterator.avg;
            iterator.avg=temp;
            System.out.println(temp1 + " " + temp4);
            iterator=iterator.next;
        }

    }
    public Node findMin(Node headStart){
        if(headStart!=null){
            Node iterator=headStart;
            Node minNode=headStart;
            while(iterator!=null){
                if(iterator.avg.compareTo(minNode.avg)==-1){
                    minNode=iterator;
                }
                iterator=iterator.next;
            }

            return minNode;
        }
        return null;
    }
    public void selectSort(){
        Node iterator=head;
        Node previous=head;
        System.out.println("Name\tAverage");
        while(iterator!=null){
           previous=findMin(iterator);
            int temp=previous.avg;
            String temp1=previous.name;
            previous.name=iterator.name;
            iterator.name=temp1;
            int temp2=previous.id;
            previous.id=iterator.id;
            iterator.id=temp2;
            int temp3=previous.mat;
            previous.mat=iterator.mat;
            iterator.mat=temp3;
            int temp4=previous.data;
            previous.data=iterator.data;
            iterator.data=temp4;
            previous.avg=iterator.avg;
            iterator.avg=temp;
            System.out.println(temp1 + " " + temp);
            iterator=iterator.next;
        }

    }
    public void count(){
        if(head==null){
            System.out.println("List is empty");
        }else{
            Node iterator=head;
            int x=0;
            System.out.println("\nStudents");
            System.out.println("------------");
            while(iterator!=null){
                x++;
                System.out.println(iterator.name);
                iterator=iterator.next;
            }
            System.out.println("Total number of students : " + x );
        }
    }
    public void pass(){
        if(head==null){
            System.out.println("List is empty");
        }else{
            Node iterator=head;
            Node previous=head;
            int toplam =0;
            int toplam2 =0;
            int x=0;
            while(iterator!=null){
                toplam+=iterator.mat;
                toplam2+=iterator.data;
                x++;
                iterator=iterator.next;
            }
            iterator=head;
            int a =toplam/x;
            System.out.println("----STUDENTS PASSİNG MATH----");
            while(iterator!=null){
                if(a<=iterator.mat){
                    System.out.println(iterator.name );
                }
                iterator=iterator.next;
            }
            int y = toplam2/x;
            previous=head;
            System.out.println("----STUDENTS PASSİNG DATA----");
            while(previous!=null){
                if(y<=previous.data){
                    System.out.println(previous.name );
                }
                previous=previous.next;
            }
            iterator=head;
            previous=head;
            System.out.println("----STUDENTS PASSİNG THE CLASS----");
            while(iterator!=null){
                if(a<=iterator.mat && y<=previous.data){
                    System.out.println(iterator.name );
                }
                iterator=iterator.next;
                previous=previous.next;
            }
        }

    }
    public void delete(){
        if(head==null){
            System.out.println("List is empty");
        }else{
            System.out.println("Enter the number of the student you want to delete : ");
            int number =scanner.nextInt();
            System.out.println("           ");
            Node iterator=head;
            Node previous=head;
            while(iterator!=null){
                iterator=iterator.next;
            }
            if(head==iterator && head.id.compareTo(number)==0){
                System.out.println(number + " student number has been deleted .");
                head=null;
                iterator=null;
            }else if(head!=iterator && head.id.compareTo(number)==0){
                System.out.println(number + " student number has been deleted .");
                head=head.next;

            }else{
                iterator=head;
                while (iterator!=null){
                    if(iterator.id.compareTo(number)==0){
                        System.out.println(number + " student number has been deleted .");
                        previous.next=iterator.next;
                    }
                    previous=iterator;
                    iterator=iterator.next;
                }

            }

            display();

        }
    }
    public void addList(){
        System.out.println("Enter the number of the student you want to add : ");
        int num=scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the name of the student you want to add : ");
        String nam =scanner.nextLine();
        System.out.println("Enter the math grade of the student you want to add : ");
        int math=scanner.nextInt();
        System.out.println("Enter the data grade of the student you want to add : ");
        int dat=scanner.nextInt();
        File file = new File("C:\\Users\\sevva\\OneDrive\\DATA HOMEWORK\\src\\students.txt");
        Node eleman = new Node(num,nam,math,dat);
        if(head==null){
            System.out.println(nam + " added to the list");
            head=eleman;
        }else{
            Node iterator=head;
            while(iterator.next!=null){
                iterator=iterator.next;
            }
            System.out.println(nam + " added to the list");
            iterator.next=eleman;

        }
        display();
    }
    public int display(){
        Node iterator=head;
        System.out.println("\nNumber\tName\tMathGarde\tDataGrade");
        while(iterator!=null){
            System.out.println(iterator.id + "  " + iterator.name + "  " + iterator.mat + "  " + iterator.data );
            iterator=iterator.next;
        }
        return 0;
    }







}
