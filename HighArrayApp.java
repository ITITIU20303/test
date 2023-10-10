// highArray.java
// demonstrates array class with high-level interface
// to run this program: C>java HighArrayApp
////////////////////////////////////////////////////////////////

class HighArray {
   private long[] a;                 // ref to array a
   private int nElems;               // number of data items
   
   public HighArray(int max) {
      a = new long[max];                 // create the array
      nElems = 0;                        // no items yet
   }
   
   public boolean find(long searchKey) {
      int j;
      for(j=0; j<nElems; j++)
         if(a[j] == searchKey)
            break;
      if(j == nElems)
         return false;
      else
         return true;
   }
   
   public void insert(long value) {
      a[nElems] = value;
      nElems++;
   }
   
   public boolean delete(long value) {
      int j;
      for(j=0; j<nElems; j++)
         if( value == a[j] )
            break;
      if(j==nElems)
         return false;
      else {
         for(int k=j; k<nElems; k++)
            a[k] = a[k+1];
         nElems--;
         return true;
         }
   }

   public void display() {
      for(int j=0; j<nElems; j++)
         System.out.print(a[j] + " ");
      System.out.println("");
   }

   public long getMax() {
      if(nElems == 0) {
         return -1;
      } else {
         long max = a[0];
         for(int i = 0; i < nElems; i++) {
            if(max < a[i]) {
               max = a[i];
            }
         }  
         return max;
      }
   }

   public void noDups() {
      for(int i = 0; i < nElems; i++) {
         long hold = a[i];
         while(delete(hold));
         insert(hold);
      }
   }
} 

class HighArrayApp {
   public static void main(String[] args) {
      int maxSize = 100;
      HighArray arr; 
      arr = new HighArray(maxSize);

      arr.insert(77);               
      arr.insert(99);
      arr.insert(44);
      arr.insert(55);
      arr.insert(22);
      arr.insert(88);
      arr.insert(11);
      arr.insert(00);
      arr.insert(66);
      arr.insert(33);

      arr.display();

      int searchKey = 35;
      if(arr.find(searchKey))
         System.out.println("Found " + searchKey);
      else
         System.out.println("Can't find " + searchKey);

      arr.delete(00);
      arr.delete(55);
      arr.delete(99);

      arr.display();

      System.out.println("The value of the highest key in the array is: " + arr.getMax());

      arr.insert(44);
      arr.insert(56);
      arr.insert(77);
      arr.insert(34);
      arr.insert(99);
      arr.insert(33);
      
      arr.display();
      arr.noDups();
      arr.display();
   }
}