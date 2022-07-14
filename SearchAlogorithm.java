import java.io.File;
import java.util.Scanner;
import java.util.Stack;

public class SearchAlogorithm {
    //LinkedList
    class Names{
        String data;
        Names next;

        Names(String data){
            this.data=data;
            this.next=null;
        }
    }
    Names name_head=null;
    Names name_tail=null;
    int[] arr = new int[20];
    int front = 0;
    int rear = 0;
    int length = arr.length;
    String name="";
    int input;

public void Name_Insert(String data){
        Names nlist=new Names(data);
         if(name_head==null){
             name_head=nlist;
             name_tail=nlist;
         }
         else{
             name_tail.next=nlist;
             name_tail=nlist;
             }
        }        
public void Menu(){
    SearchAlogorithm Namelist =new SearchAlogorithm(); 
    int i=0;
    String array[]=new String[20];
    Scanner s=new Scanner(System.in);
    try {
          File F = new File("Database.txt");
          Scanner S = new Scanner(F);  
          while (S.hasNextLine()) {
            String info = S.nextLine();
            array[i]=info;
            i++;
            Namelist.Name_Insert(info); 
          }
          S.close();
          System.out.println("ID_NAME MARKS");
          for(i=0;i<array.length;i++){
            System.out.println(array[i]);
          }
            while(input!=4){
                System.out.println();
                System.out.println("1. Search Highest Marks And Lowest Marks");
                System.out.println("2. Search by Marks");
                System.out.println("3. Search by Names");
                System.out.println("4. Exit");
                input = s.nextInt();
                if(input==1){
                    highestMarks(array);
                }
                if(input==2){
                    System.out.println("Enter marks you would like to search?: ");
                    int marks=s.nextInt();
                    Namelist.Select_marks(marks,Namelist);
                }
                if(input==3){
                    reverse(array);
                }
        }
          s.close();
        } catch (Exception e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
       }
    public void Select_marks(int key,SearchAlogorithm Namelist){
        Names current=name_head;
        while(current!=null){
        String details= current.data;
            for(int i=0;i<=details.length()-1;i++){
                if(details.charAt(i)==' '){
                    i++;
                    for(int j=i+1;j<=details.length()-1;j++){
                    String con1=Character.toString(details.charAt(i));
                    String con2=Character.toString(details.charAt(j));
                    con1=con1.concat(con2);
                    int value=Integer.parseInt(con1);
                    Namelist.check(key,value,current.data);
                }
            }
        }
        current=current.next;
        }
    }
    public void check(int key,int value,String current){
        if(key%2==0){
            evenSearch(key,value,current);
        }
        else{
            oddSearch(key,value,current);
        }
    }
    public void evenSearch(int key,int value,String current){
            if(value%2==0){
            if(value==key){
                System.out.println("Marks Found: "+current);
            }
            }
    }
    public void oddSearch(int key,int value,String current){
        if(value%2!=0){
            if(value==key){
                System.out.println("Marks Found : "+current);
            }
        }
    }
    //Stack
    public void reverse(String array[]){
        Stack<String> marks =new Stack<String> ();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter name you want to search");
        String key = s.nextLine();
        for(int i=array.length-1;i>=0;i--){
            marks.push(array[i]);
        }
        while(!marks.isEmpty()){
            String temp= marks.peek();
            marks.pop();
            for(int i=0;i<=temp.length()-1;i++){
                char c=temp.charAt(i);
                if(c!='_' && !Character.isDigit(c) && c!=' '){
                    name=name+Character.toString(c);
                }
            }
            nameSearch(name,temp,key);
            name="";
        }
    }
    public void nameSearch(String name,String temp,String key){
        String key1 = key.toUpperCase();
        String name1 = name.toUpperCase();
        if(name1.equals(key1)){
            System.out.println("Name Found : "+temp);
        }
    }
    //Queue
    public boolean IsEmpty(){
        if(front==rear){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean IsFull(){
        if(length==rear){
            return true;
        }
        else{
            return false;
        }
    }
    public void enqueue(int numb){
        if(IsFull()==true){
            return;
        }
        else{
            arr[rear]=numb;
            rear++;
        }
    }
    
    public void dequeue(){
        if(IsEmpty()==true){
            return;
        }
        else{
            for (int i = 0; i < rear - 1; i++) { 
                arr[i] = arr[i + 1]; 
            } 
            if(rear<length){
                arr[rear]= 0;
                rear--;
            }
        }
    }
    public int peek(){
        if(IsEmpty()==true){
            return 0;
        }
        else{
            int p = arr[0];
            return p;
        }
    }
    public void display(){
        if(IsEmpty()==true){
            return;
        }
        for (int i = front; i < rear; i++) { 
            System.out.println(arr[i]+" "); 
        } 
    }
    public void highestMarks(String array[]){
        SearchAlogorithm q = new SearchAlogorithm();
        SearchAlogorithm q2 = new SearchAlogorithm();
        SearchAlogorithm q3 = new SearchAlogorithm();
        int max=0;
        for(int k=0;k<array.length;k++){
            String arr1 = array[k];
                for(int i=0;i<=arr1.length()-1;i++){
                    if(arr1.charAt(i)==' '){
                        i++;
                        for(int j=i+1;j<=arr1.length()-1;j++){
                        String con1=Character.toString(arr1.charAt(i));
                        String con2=Character.toString(arr1.charAt(j));
                        con1=con1.concat(con2);
                        int value=Integer.parseInt(con1);
                        q.enqueue(value);
                        q2.enqueue(value);
                        q3.enqueue(value);
                    }
                }
            }
        }
        lowestMarks(q,q2);
        q3.dequeue();
        max=q.peek(); 
        for(int i=0;i<q.rear;i++){
            if(q3.peek()>max){ 
                max=q3.peek(); 
                q3.dequeue();
            }
            else{
                q3.dequeue();
            }
        }
        System.out.println("Maximum Marks"+max);
    }
    public void lowestMarks(SearchAlogorithm q,SearchAlogorithm q2){
        q2.dequeue();
        int min=q.peek(); 
        for(int i=0;i<q.rear;i++){
            if(q2.peek()<min){ 
                min=q2.peek(); 
                q2.dequeue();
            }
            else {
                q2.dequeue();
            }
        }
        System.out.println("Minimum Marks"+min);
    }
       public static void main(String[] args) {
           SearchAlogorithm s=new SearchAlogorithm();
           s.Menu();
       }
}