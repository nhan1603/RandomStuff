package simulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

public class GroupPermutation {
	static int calculate = 0;
	static Map<String,List<String>> major = new HashMap<String,List<String>>();
	static Map<String,List<String>> inverse = new HashMap<String,List<String>>();
	static Map<String,List<String>> mak = new HashMap<String,List<String>>();
	static List<Integer> mad = new ArrayList<Integer>();
	//static Map<Integer,List<String>> mad = new HashMap<Integer,List<String>>();
	static int max =0;
	static int max2 =0;
	static int max3 =0;
	static int max4 =0;
	static boolean check = true;
// Returns true if str[curr] does not matches with any of the  
// characters after str[start]  
    static boolean shouldSwap(char str[], int start, int curr) { 
        for (int i = start; i < curr; i++) { 
            if (str[i] == str[curr]) { 
                return false; 
            } 
        } 
        return true; 
    } 
  
// Prints all distinct permutations in str[0..n-1]  
    private void findPermutations(char str[], int index, int n) { 
        if (index >= n) { 
            System.out.println(str); 
            String src = new String(str);
            addMajor(src);
			addInverse(src);
			addMad(src);
			addMak(src);
            calculate +=1;
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
  
    // Driver code 
    public static void main(String[] args) { 
  
        String str = JOptionPane.showInputDialog("Input String");
        int n = str.length(); 
        char[] src = str.toCharArray();
        GroupPermutation GroupPermutation = new GroupPermutation();
        GroupPermutation.findPermutations(src, 0, n); 
        System.out.println("Total permutation = " + calculate);
        
		System.out.println();
		System.out.println("Major occurence");
		major.entrySet().forEach(entry->{
		    System.out.println(entry.getKey() + " " + entry.getValue());  
		 });
		
		System.out.println();
		System.out.println("Inverse occurence");
		inverse.entrySet().forEach(entry->{
		    System.out.println(entry.getKey() + " " + entry.getValue());  
		 });
		System.out.println();
		System.out.println("Mak occurence");
		mak.entrySet().forEach(entry->{
		    System.out.println(entry.getKey() + " " + entry.getValue());  
		 });
//		mad.forEach(e->{
//			System.out.print(e+ " ");
//			count4[e] = count4[e]+1;
//		});
//		System.out.println();
//		System.out.println("Mad occurence");
//		for (int i=0;i<max4+1;i++) {
//			System.out.println(i+ " "+count4[i]);
//		}
		
		if (!check) {
			System.out.println("Not equidistributed");
		} else {
			System.out.println("Equidistributed");
		}
        
    } 
    public void addMajor(String src) {
		int Major = 0;
		List<String> prtLs = new ArrayList<String>();
		char[] convert = src.toCharArray();
		int leng = convert.length;
		int[] inte = new int[leng];
		for (int i=0;i<leng;i++) {
			inte[i] = Character.getNumericValue(convert[i]);
		}
		for (int i=0;i<leng-2;i++) {
			for (int j=i+1;j<leng-1;j++) {
				if ((inte[i]< inte[j+1])&&(inte[j]>inte[j+1])) {
					Major +=1;
					prtLs.add("1-32");
				}
			}
		}
		
		for (int i=0;i<leng-2;i++) {
			for (int j=i+1;j<leng-1;j++) {
				if ((inte[i] == inte[j+1])&&(inte[j]>inte[j+1])) {
					Major +=1;
					prtLs.add("1-21");
				}
			}
		}
		
		for (int i=0;i<leng-2;i++) {
			for (int j=i+1;j<leng-1;j++) {
				if ((inte[i] > inte[j+1])&&(inte[j]>inte[i])) {
					Major +=1;
					prtLs.add("2-31");
				}
			}
		}
		
		for (int i=0;i<leng-2;i++) {
			for (int j=i+1;j<leng-1;j++) {
				if ((inte[i] > inte[j+1])&&(inte[j]==inte[i])) {
					Major +=1;
					prtLs.add("2-21");
				}
			}
		}
		
		for (int i=0;i<leng-2;i++) {
			for (int j=i+1;j<leng-1;j++) {
				if ((inte[i] > inte[j])&&(inte[j]>inte[j+1])) {
					Major +=1;
					prtLs.add("3-21");
				}
			}
		}
		
		for (int j=0;j<leng-1;j++) {
			if (inte[j] > inte[j+1]){
				Major +=1;
				prtLs.add("21");
			}
		}
		
		if (Major >= max) {
			max = Major;
		}
		major.put(Major+" => "+src, prtLs);
	}
	

	public void addInverse(String src) {
		int Inverse = 0;
		char[] convert = src.toCharArray();
		List<String> prtLs = new ArrayList<String>();
		int leng = convert.length;
		int[] inte = new int[leng];
		for (int i=0;i<leng;i++) {
			inte[i] = Character.getNumericValue(convert[i]);
		}
		/*for (int i=0;i<leng-1;i++) {
			for (int j=i+1;j<leng;j++) {
				if (inte[i]>= inte[j]) {
					Inverse++;
				}
			}
		}*/
		
		
		for (int i=0;i<leng-2;i++) {
			for (int j=i+2;j<leng;j++) {
				if ((inte[i] == inte[i+1])&&(inte[i]>inte[j])) {
					Inverse +=1;
					prtLs.add("22-1");
				}
			}
		} //22-1
		
		for (int i=0;i<leng-2;i++) {
			for (int j=i+2;j<leng;j++) {
				if ((inte[i] < inte[i+1])&&(inte[i]>inte[j])) {
					Inverse +=1;
					prtLs.add("23-1");
				}
			}
		} //23-1
		
		for (int i=0;i<leng-2;i++) {
			for (int j=i+2;j<leng;j++) {
				if ((inte[i] > inte[i+1])&&(inte[i+1]>inte[j])) {
					Inverse +=1;
					prtLs.add("32-1");
				}
			}
		} //32-1
		
		for (int i=0;i<leng-2;i++) {
			for (int j=i+2;j<leng;j++) {
				if ((inte[i] > inte[i+1])&&(inte[i+1]==inte[j])) {
					Inverse +=1;
					prtLs.add("21-1");
				}
			}
		} //21-1
		
		for (int i=0;i<leng-2;i++) {
			for (int j=i+2;j<leng;j++) {
				if ((inte[i] > inte[j])&&(inte[i+1]<inte[j])) {
					Inverse +=1;
					prtLs.add("31-2");
				}
			}
		} // 31-2
		
		for (int j=0;j<leng-1;j++) {
			if (inte[j] > inte[j+1]){
				Inverse +=1;
				prtLs.add("21");
			} 
		} // 21
		
		if (Inverse >= max2) {
			max2 = Inverse;
		}
		inverse.put(Inverse + " ==> " +src,prtLs);
	}
	
	public void addMak(String src) {
		int Mak = 0;
		char[] convert = src.toCharArray();
		List<String> prtLs = new ArrayList<String>();
		int leng = convert.length;
		int[] inte = new int[leng];
		for (int i=0;i<leng;i++) {
			inte[i] = Character.getNumericValue(convert[i]);
		}
		for (int i=0;i<leng-2;i++) {
			for (int j=i+1;j<leng-1;j++) {
				if ((inte[i]< inte[j+1])&&(inte[j]>inte[j+1])) {
					Mak +=1;
					prtLs.add("1-32");
				}
			}
		} //1-32
		
		for (int i=0;i<leng-2;i++) {
			for (int j=i+1;j<leng-1;j++) {
				if ((inte[i]< inte[j])&&(inte[i]==inte[j+1])) {
					Mak +=1;
					prtLs.add("1-21");
				}
			}
		} //1-21
		
		for (int i=0;i<leng-2;i++) {
			for (int j=i+2;j<leng;j++) {
				if ((inte[i] > inte[j])&&(inte[j]>inte[i+1])) {
					Mak +=1;
					prtLs.add("31-2");
				}
			}
		} //31-2
		
		for (int i=0;i<leng-2;i++) {
			for (int j=i+2;j<leng;j++) {
				if ((inte[i] == inte[j])&&(inte[j]>inte[i+1])) {
					Mak +=1;
					prtLs.add("21-2");
				}
			}
		} //21-2
		
		// done 132 and 321 and 312
		for (int i=0;i<leng-2;i++) {
			for (int j=i+2;j<leng;j++) {
				if ((inte[i] > inte[i+1])&&(inte[i+1]>inte[j])) {
					Mak +=1;
					prtLs.add("32-1");
				}
			}
		} //32-1
		


		
		for (int j=0;j<leng-1;j++) {
			if (inte[j] > inte[j+1]){
				Mak +=1;
				prtLs.add("21");
			}
		} //21
		
		if (Mak >= max3) {
			max3 = Mak;
		}
		mak.put(Mak+ " ==> " + src,prtLs);
	}
	
	public void addMad(String src) {
		int Mad = 0;
		char[] convert = src.toCharArray();
		int leng = convert.length;
		int[] inte = new int[leng];
		for (int i=0;i<leng;i++) {
			inte[i] = Character.getNumericValue(convert[i]);
		}
		
		for (int i=0;i<leng-2;i++) {
			for (int j=i+1;j<leng-1;j++) {
				if ((inte[i]< inte[j])&&(inte[i]>inte[j+1])) {
					Mad +=1;
				}
			}
		}
		
		for (int i=0;i<leng-2;i++) {
			for (int j=i+1;j<leng-1;j++) {
				if ((inte[i]< inte[j])&&(inte[i]>inte[j+1])) {
					Mad +=1;
				}
			}
		}
		
		for (int i=0;i<leng-2;i++) {
			for (int j=i+1;j<leng-1;j++) {
				if ((inte[i]< inte[j])&&(inte[i]==inte[j+1])) {
					Mad +=1;
				}
			}
		}
		
		for (int i=0;i<leng-2;i++) {
			for (int j=i+1;j<leng-1;j++) {
				if ((inte[i] == inte[j])&&(inte[i]>inte[j+1])) {
					Mad +=1;
				}
			}
		}
		
		for (int i=0;i<leng-2;i++) {
			for (int j=i+1;j<leng-1;j++) {
				if ((inte[i]< inte[j])&&(inte[i]==inte[j+1])) {
					Mad +=1;
				}
			}
		}
		
		for (int i=0;i<leng-2;i++) {
			for (int j=i+1;j<leng-1;j++) {
				if ((inte[i] == inte[j])&&(inte[i]>inte[j+1])) {
					Mad +=1;
				}
			}
		}
		
		for (int i=0;i<leng-2;i++) {
			for (int j=i+2;j<leng;j++) {
				if ((inte[i] > inte[j])&&(inte[i+1]<inte[j])) {
					Mad +=1;
				}
			}
		}
		
		for (int i=0;i<leng-2;i++) {
			for (int j=i+2;j<leng;j++) {
				if ((inte[i] > inte[j])&&(inte[i+1]==inte[j])) {
					Mad +=1;
				}
			}
		}
		
		for (int j=0;j<leng-1;j++) {
			if (inte[j] > inte[j+1]){
				Mad +=1;
			}
		}
		
		if (Mad >= max4) {
			max4 = Mad;
		}
		mad.add(Mad);
	}
}
