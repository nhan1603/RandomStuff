package simulation;



import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;



public class NewBijection3 {
	
	static boolean checkk = true;
	static List<String> makk = new ArrayList<String>();
	static List<String> maj = new ArrayList<String>();
	static int count= 0;
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
        NewBijection3 testBijection = new NewBijection3();
        testBijection.findPermutations(src, 0, n); 
        // equidistributions result
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
    	char[] src = str.toCharArray();
        int leng = src.length;
		int[] inte = new int[leng];
		boolean[] danhso = new boolean[leng];
		for (int i=0;i<leng;i++) {
			inte[i] = Character.getNumericValue(src[i]);
			danhso[i] = false;
		}
		String subString = str;
		/// Create bijection for Mak String
		String makString = new String();
		int ii = 0;
		while (ii<str.length()-1){
			if((str.charAt(ii)=='2')&&(str.charAt(ii+1)=='1')) {
				str = str.substring(0,ii) + "9" + str.substring(ii,ii+2) + "9" + str.substring(ii+2);
				ii+=2;
			}
			if((str.charAt(ii)=='1')&&(str.charAt(ii+1)=='2')) {
				str = str.substring(0,ii+1) + "9" + str.substring(ii+1);
				ii++;
			}
			ii++;
		}
		String[] array = str.split("9");
		List<String> list = new ArrayList<String>();
		for (String ha : array) {
			if (ha.length() > 0) {
				list.add(ha);
			}
		}
		String[] array2 = list.toArray(new String[list.size()]);
		for (int k=0;k<array2.length;k++) {
			if (array2[k].contains("2")) {
				makString = array2[k] + makString;
			}
		}
		for (int k=0;k<array2.length;k++) {
			if (!array2[k].contains("2")) {
				int countt = 0;
				for (int h = k;h>=0;h--) {
					if (array2[h].equals("21")) {
						countt ++;
					}
				}
				if (countt ==0) {
					makString = array2[k] + makString;
				} else {
					for (int h=0;h<makString.length()-1;h++) {
						if ((makString.charAt(h)=='2')&&((makString.charAt(h+1)=='1'))) {
							countt--;
						}
						if (countt==0) {
							makString = makString.substring(0,h+2) + array2[k] + makString.substring(h+2);
							countt--;
						}
					}
				}
				
			}
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
		System.out.println("Major : " + subString + " " + Major);
		maj.add(subString);
		int[] inte2 = new int[makString.length()];
		
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
		
		for (int i=0;i<leng-2;i++) {
			for (int j=i+1;j<leng-1;j++) {
				if ((inte2[i]< inte2[j])&&(inte2[i]==inte2[j+1])) {
					Mak +=1;
				}
			}
		} //1-21
		
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
		
		
//		for (int i=0;i<leng-2;i++) {
//			for (int j=i+2;j<leng;j++) {
//				if ((inte2[i] > inte2[j])&&(inte2[j]==inte2[i+1])) {
//					Mak +=1;
//				}
//			}
//		} //21-1
		
		
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
