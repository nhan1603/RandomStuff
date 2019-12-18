package simulation;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.sun.org.apache.bcel.internal.generic.INEG;
import com.sun.org.apache.xml.internal.serializer.ElemDesc;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import javafx.scene.chart.AreaChart;


public class NewBijection {
	static int firsttwo =  0;
	static int firstone =  0;
	static int greatest =  0;
	static int greatestposi = 0;
	static boolean checkk = true;
	static boolean shouldSwap(char str[], int start, int curr) { 
        for (int i = start; i < curr; i++) { 
            if (str[i] == str[curr]) { 
                return false; 
            } 
        } 
        return true; 
    } 
	
	private void findPermutations(char str[], int index, int n) { 
        if (index >= n) { 
        	System.out.println(str);
        	String src = new String(str);
        	Bijection(src);
            return; 
        } 
  
        for (int i = index; i < n; i++) { 
  
            // Proceed further for str[i] only if it  
            // doesn't match with any of the characters  
            // after str[index]  
            boolean check = shouldSwap(str, index, i); 
            if (check) { 
                swap(str, index, i); 
                findPermutations(str, index + 1, n); 
                swap(str, index, i); 
            } 
        } 
    } 
  
	private int firstnumber(String str, int number, int fromm) {
		char[] src = str.toCharArray();
        int leng = src.length;
		int[] inte = new int[leng];
		for (int i=0;i<leng;i++) {
			inte[i] = Character.getNumericValue(src[i]);
		}
		for (int i=fromm;i<leng;i++) {
			if (inte[i] >= number) {
				return i;
			}
		}
		return leng;
	}

	static void swap(char[] str, int i, int j) { 
        char c = str[i]; 
        str[i] = str[j]; 
        str[j] = c; 
    } 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = JOptionPane.showInputDialog("Input Major");
        
        int n = str.length(); 
        char[] src = str.toCharArray();
        NewBijection testBijection = new NewBijection();
        testBijection.findPermutations(src, 0, n); 
        // equidistributions result
        if (!checkk) {
        	System.out.println("Not equidistributed");
        } else {
        	System.out.println("Equidistributed");
        }
	}
    private void Bijection(String str) {
    	int Major = 0;
    	char[] src = str.toCharArray();
        int leng = src.length;
		int[] inte = new int[leng];
		boolean[] danhso = new boolean[leng];
		for (int i=0;i<leng;i++) {
			inte[i] = Character.getNumericValue(src[i]);
			danhso[i] = false;
		}
		/// Create bijection for Mak String
		String makString = new String();
		firstone = 0;
		firsttwo = 0;
		greatest = inte[0];
		greatestposi = 0;
		String tempString = new String();
		String tempString2 = new String();
		ArrayList<String> listStrings = new ArrayList<String>();
		for (int i=0;i<leng-1;i++) {
			if ((inte[i] > inte[i+1])&&(danhso[i]== false)) { // increase by n
				if (tempString.length() == 0) {
					listStrings.add(tempString2);
					tempString2 = new String();
					tempString =  Integer.toString(inte[i]) + Integer.toString(inte[i+1]);
					danhso[i] = true;
					danhso[i+1] = true;
				} else {
					listStrings.add(tempString);
					tempString = new String();
					tempString =  Integer.toString(inte[i]) + Integer.toString(inte[i+1]);
					danhso[i] = true;
					danhso[i+1] = true;
				}
			} else if ((inte[i] > inte[i+1])&&(danhso[i]== true)) { 
				tempString = tempString + inte[i+1];
				danhso[i+1] = true;
			} else if ((inte[i] <= inte[i+1]) && (danhso[i]== false)) {
				if((tempString.length() != 0)) {
					listStrings.add(tempString);
					tempString = new String();
				}
				if (i < leng-2) {
					tempString2 = tempString2 + inte[i];
					danhso[i] = true;
				} else {
					tempString2 = tempString2 + Integer.toString(inte[i]) + Integer.toString(inte[i+1]);
					danhso[i] = true;
					danhso[i+1] = true;
				}
			} else if((inte[i] <= inte[i+1]) && (danhso[i]== true) &&(i==leng-2)) {
				if((tempString.length() != 0)) {
					listStrings.add(tempString);
					tempString = new String();
				}
				tempString2 = tempString2 + Integer.toString(inte[i+1]);
				danhso[i+1] = true;
			}
		}
		
		if(tempString.length() > 0) {
			listStrings.add(tempString);
			tempString = new String();
		}
		if(tempString2.length() > 0) {
			listStrings.add(tempString2);
			tempString2 = new String();
		}
		
	    String[] atrStrings = new String[listStrings.size()];
	    atrStrings = listStrings.toArray(atrStrings);
		
	    for (int i = atrStrings.length-1;i>=0;i--) {
	    	makString = makString + atrStrings[i];
	    }
	    
	    System.out.println(makString);
	    
		for (int i=0;i<leng-2;i++) {
			for (int j=i+1;j<leng-1;j++) {
				if ((inte[i]< inte[j+1])&&(inte[j]>inte[j+1])) {
					Major +=1;
				}
			}
		} //1-32
		
		for (int i=0;i<leng-2;i++) {
			for (int j=i+1;j<leng-1;j++) {
				if ((inte[i] == inte[j+1])&&(inte[j]>inte[j+1])) {
					Major +=1;
				}
			}
		} //1-21
		
		for (int i=0;i<leng-2;i++) {
			for (int j=i+1;j<leng-1;j++) {
				if ((inte[i] > inte[j+1])&&(inte[j]>inte[i])) {
					Major +=1;
				}
			}
		} //2-31
		
		for (int i=0;i<leng-2;i++) {
			for (int j=i+1;j<leng-1;j++) {
				if ((inte[i] > inte[j+1])&&(inte[j]==inte[i])) {
					Major +=1;
				}
			} 
		} //2-21
		
		for (int i=0;i<leng-2;i++) {
			for (int j=i+1;j<leng-1;j++) {
				if ((inte[i] > inte[j])&&(inte[j]>inte[j+1])) {
					Major +=1;
				}
			}
		} //3-21
		
		for (int j=0;j<leng-1;j++) {
			if (inte[j] > inte[j+1]){
				Major +=1;
			}
		} //21
		System.out.println("Major : " + str + " " + Major);
		
		int[] inte2 = new int[leng];
		
		char[] src2 = makString.toCharArray();

		for (int i=0;i<leng;i++) {
			inte2[i] = Character.getNumericValue(src2[i]);
		}
		int Mak =0;
		for (int i=0;i<leng-2;i++) {
			for (int j=i+1;j<leng-1;j++) {
				if ((inte2[i]< inte2[j+1])&&(inte2[j]>inte2[j+1])) {
					Mak +=1;
				}
			}
		} //1-32
		
//		for (int i=0;i<leng-2;i++) {
//			for (int j=i+1;j<leng-1;j++) {
//				if ((inte[i]< inte[j])&&(inte[i]==inte[j+1])) {
//					Mak +=1;
//				}
//			}
//		} //1-21
		
		for (int i=0;i<leng-2;i++) {
			for (int j=i+2;j<leng;j++) {
				if ((inte2[i] > inte2[j])&&(inte2[j]>inte2[i+1])) {
					Mak +=1;
				}
			}
		} //31-2
		
		for (int i=0;i<leng-2;i++) {
			for (int j=i+2;j<leng;j++) {
				if ((inte2[i] == inte2[j])&&(inte2[j]>inte2[i+1])) {
					Mak +=1;
				}
			}
		} //21-2
		
		
		for (int i=0;i<leng-2;i++) {
			for (int j=i+2;j<leng;j++) {
				if ((inte2[i] > inte2[j])&&(inte2[j]==inte2[i+1])) {
					Mak +=1;
				}
			}
		} //21-1
		
		
		// done 132 and 321 and 312
		for (int i=0;i<leng-2;i++) {
			for (int j=i+2;j<leng;j++) {
				if ((inte2[i] > inte2[i+1])&&(inte2[i+1]>inte2[j])) {
					Mak +=1;
				}
			}
		} //32-1
		
		
		for (int j=0;j<leng-1;j++) {
			if (inte2[j] > inte2[j+1]){
				Mak +=1;
			}
		} //21
		System.out.println("Mak : "+makString + " " + Mak);
		if (Mak !=  Major) {
			checkk = false;		}
	}

}
