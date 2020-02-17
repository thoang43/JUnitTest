import java.io.*;
import java.util.*;
import java.lang.*;
class TwoDimRaggedArrayUtility
{
   
   //pass in a file and return a two dimensional ragged 
   public static double[][] readFile(File file)
   {
       double[][] raggedArr=new double[6][];
       String line;
       int i=0;
       try
       {
           //open file
           BufferedReader br=new BufferedReader(new FileReader(file));      
           //read  file
           while((line=br.readLine())!=null)
           {
               String[] temp=line.split(" ");
               int size=temp.length;
               raggedArr[i]=new double[size];
               //covert into doubles
               for(int j=0;j<size;j++)
               {
                   raggedArr[i][j]= Double.parseDouble(temp[j]);
               }
               i++;
           }
           br.close();
       }
       catch(Exception ep)
       {
           ep.printStackTrace();
       }
       return raggedArr;
   }
   
   //pass in  two dimensional ragged array of doubles  and writes the ragged array into a file.
   public static void writeToFile(double[][] raggedArr,File file)
   {

       try
       {
           
           BufferedWriter br=new BufferedWriter(new FileWriter(file));
           //read  array and print 
           for(int i=0;i<raggedArr.length;i++)
           {
               for(int j=0;j<raggedArr[i].length;j++)
               {
                   br.write(raggedArr[i][j]+" ");
               }
               br.newLine();
           }
           br.close();
       }
       catch(Exception ep)
       {
           ep.printStackTrace();
       }

   }
   //definition of the method getTotal method
   
   public static double getTotal(double[][] raggedArr)
   {
       double total=0;
       //find the sum of the values of the 2D array
       for(int i=0;i<raggedArr.length;i++)
       {
           for(int j=0;j<raggedArr[i].length;j++)
           {
               total += raggedArr[i][j];
           }
       }
       return total;
   }
   //getAverage method 
   
   public static double getAverage(double[][] raggedArr)
   {
       double total=0;
       int numOfElements=0;
       
       for(int i=0;i<raggedArr.length;i++)
       {
           for(int j=0;j<raggedArr[i].length;j++)
           {
               total += raggedArr[i][j];
               numOfElements += 1;
           }
       }
       //return  average
       return new Double(total/numOfElements);
   }
   // method getRowTotal method
  
   public static double getRowTotal(double[][] raggedArr,int rowIndex)
   {
       double total=0;
       for(int j=0;j<raggedArr[rowIndex].length;j++)
       {
           total += raggedArr[rowIndex][j];

       }
       return total;
   }
   //getColumnTotal method
  
   public static double getColumnTotal(double[][] raggedArr,int colIndex)
   {
       double total=0;
       for(int i=0;i<raggedArr.length;i++)
       {
           if(colIndex<=raggedArr[i].length-1)
               total += raggedArr[i][colIndex];
       }
       return total;
   }
   // getHighestInRow method
   
   public static double getHighestInRow(double[][] raggedArr,int rowIndex)
   {
       double highest=raggedArr[rowIndex][0];
       for(int j=0;j<raggedArr[rowIndex].length;j++)
       {
           if(raggedArr[rowIndex][j]>highest)
               highest= raggedArr[rowIndex][j];

       }
       return highest;
   }
   // GetHighestInRowIndex method
   public static int getHighestInRowIndex(double[][] data, int rowIndex) {
       int HighestRowindex = 0;
       for (int i = 0; i < data[rowIndex].length; ++i) {
           if (data[rowIndex][i] > data[rowIndex][HighestRowindex ]) {
        	   HighestRowindex  = i;
           }
       }
       return HighestRowindex ;

  }
   //method getLowestInRow method 
   
   public static double getLowestInRow(double[][] raggedArr,int rowIndex)
   {
       double lowest=raggedArr[rowIndex][0];
       for(int j=0;j<raggedArr[rowIndex].length;j++)
       {
           if(raggedArr[rowIndex][j]<lowest)
               lowest= raggedArr[rowIndex][j];

       }
       return lowest;
       
   }
   // GetLowestInRowIndex method
       public static int getLowestInRowIndex(double[][] data, int rowIndex)
       {
    	   int LowestRowindex = 0;
           for (int i = 0; i < data[rowIndex].length; ++i) {
               if (data[rowIndex][i] < data[rowIndex][LowestRowindex ]) {
            	   LowestRowindex  = i;
               }
           }
           return LowestRowindex ;
   }
   // getHighestInColumn method
   
   public static double getHighestInColumn(double[][] raggedArr,int colIndex)
   {
       double highest=raggedArr[0][colIndex];
       for(int i=0;i<raggedArr.length;i++)
       {
           if(colIndex<=raggedArr[i].length-1)
           {               
               if(raggedArr[i][colIndex]>highest)
                   highest= raggedArr[i][colIndex];
           }

       }
       return highest;  
   }
   // getHighestInColumnIndex method
   public static int getHighestInColumnIndex(double data[][], int colIndex){
       int HighestColumnIndex = 0;
       for(int i=0; i<data.length; i++){
           if(data[i].length>colIndex){
               if(data[i][colIndex]>data[HighestColumnIndex][colIndex])
            	   HighestColumnIndex = i; }
       }return HighestColumnIndex;
   
   
   }
   //getLowestInColumn method
   
   public static double getLowestInColumn(double[][] raggedArr,int colIndex)
   {
       double lowest=raggedArr[0][colIndex];
       for(int i=0;i<raggedArr.length;i++)
       {
           if(colIndex<=raggedArr[i].length-1)
               if(raggedArr[i][colIndex]<lowest)
                   lowest= raggedArr[i][colIndex];

       }
       return lowest; 
       
   }
   // GetLowestInColumnIndex method
   public static int getLowestInColumnIndex(double data[][], int colIndex){
       int lowestColumnIndex  = 0;
       for(int i=0; i<data.length; i++){
           if(data[i].length>colIndex){
               if(data[i][colIndex]<data[lowestColumnIndex ][colIndex])
            	   lowestColumnIndex  = i;
           }
       }
       return lowestColumnIndex ;
   }
   // getHighestInArray method
   
   public static double getHighestInArray(double[][] raggedArr)
   {
       double highest=raggedArr[0][0];
       for(int i=0;i<raggedArr.length;i++)
       {
           for(int j=0;j<raggedArr[i].length;j++)
           {
               if(raggedArr[i][j]>highest)
                   highest= raggedArr[i][j];

           }
       }
       return highest;
   }
   //getLowestInArray method 
   
   public static double getLowestInArray(double[][] raggedArr)
   {
       double lowest=raggedArr[0][0];
       for(int i=0;i<raggedArr.length;i++)
       {
           for(int j=0;j<raggedArr[i].length;j++)
           {
               if(raggedArr[i][j]<lowest)
                   lowest= raggedArr[i][j];

           }
       }
       return lowest;
   }
}