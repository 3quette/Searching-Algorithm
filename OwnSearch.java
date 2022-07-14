public class OwnSearch {
    String arr[]={"86","99","83","66"};
    int n=arr.length;
    String key="66";
    int i;
    int[] array=new int[n] ;
    int[] odd = new int[n];
    int[] even = new int[n];
    int kee=Integer.parseInt(key);
    public void check(){
        if(kee%2==0){
        sortEven(); 
        }
        else{
        sortOdd();
        }
    }
    public void evenSearch(){
        for(i=0;i<n;i++){
            array[i] = Integer.parseInt(arr[i]);
            if(array[i]%2==0){
                even[i]=array[i];
            }
        }
        for(i=0;i<n;i++){ 
            if(even[i]==kee){
                System.out.println("Key Found in even : "+even[i]);
            }
        }
    }
    public void oddSearch(){
        for(i=0;i<n;i++){
            array[i] = Integer.parseInt(arr[i]);
            if(array[i]%2==1){
                odd[i]=array[i];
            }
        }
        for(i=0;i<n;i++){
            if(odd[i]==kee){
                System.out.println("Key Found in odd : "+odd[i]);
            }
        }
    }
    public static void main(String[] args) {
        OwnSearch O=new OwnSearch();
        O.check();
    }    
}