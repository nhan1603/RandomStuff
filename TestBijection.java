package simulation;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;



public class TestBijection {
	static int firsttwo =  0;
	static int firstone =  0;
	static List<String> makk = new ArrayList<String>();
	static List<String> maj = new ArrayList<String>();
	static boolean checkk = true;
	static boolean checkk2 = true;
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
        TestBijection testBijection = new TestBijection();
        testBijection.findPermutations(src, 0, n); 
        if (!checkk) {
        	System.out.println("Not equidistributed");
        } else {
        	System.out.println("Equidistributed");
        }
        if (makk.size() == maj.size()) {
        	System.out.println("true");
        } else {
        	System.out.println("false");
        }
	}
    private void Bijection(String str) {
    	int Major = 0;
		// TODO Auto-generated method stub
    	char[] src = str.toCharArray();
        int leng = src.length;
		int[] inte = new int[leng];
		for (int i=0;i<leng;i++) {
			inte[i] = Character.getNumericValue(src[i]);
		}
		String makString = new String();
		makString = makString + inte[0];
		firsttwo = -1;
		firstone = -1;
		if (inte[0] == 1) {
			firstone = 0;
		} else if (inte[0] == 2) {
			firsttwo = 0;
		}
		for (int i=1;i<leng;i++) {
			if (inte[i] == 1) {
				if (inte[i-1] == 1) {
					makString = inte[i] + makString; //true here
					firstone = 0;
					if (firsttwo != -1) {
						firsttwo ++;
					}
				} else if (inte[i-1] == 2) {
					if (firstone == -1) {
						makString = makString.substring(0,1) + inte[i] + makString.substring(1,makString.length());
						firstone = 1;
					} else if (firsttwo == i-1) {
						makString = Integer.toString(inte[i-1]) + Integer.toString(inte[i]) + makString.substring(0,makString.length()-1);
						firstone = 1;
						firsttwo = 0;
					} else {
						makString =  makString.charAt(firsttwo)+ Integer.toString(inte[i]) + makString.substring(0, firsttwo) + makString.substring(firsttwo+1,makString.length());
						firsttwo = 0;
						firstone = 1;
					}
				}
			} else if (inte[i] == 2) {
				if (inte[i-1] == 1) {
					if (firsttwo == -1) {
						makString = makString + inte[i];
						firsttwo = i;
					}else {
						makString = makString.substring(0, firsttwo+1) + inte[i] + makString.substring(firsttwo+1,makString.length());
					}
				} else if (inte[i-1] == 2) {
					makString = makString.substring(0, firsttwo+1) + inte[i] + makString.substring(firsttwo+1,makString.length());	       
				}
			}
			//System.out.println(makString);
		}
		
		
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
		maj.add(str);
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
		if (!makk.contains(makString)) {
			makk.add(makString);
		}
		if (Mak !=  Major) {
			checkk = false;		}
	}

}
