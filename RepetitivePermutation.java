package simulation;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class RepetitivePermutation {
		static int calculate = 0;
		static List<Integer> major = new ArrayList<Integer>();
		static List<Integer> inverse = new ArrayList<Integer>();
		static List<Integer> mak = new ArrayList<Integer>();
		static List<Integer> mad = new ArrayList<Integer>();
		static int max =0;
		static int max2 =0;
		static int max3 =0;
		static int max4 =0;
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
	        RepetitivePermutation rpPermutation = new RepetitivePermutation();
	        rpPermutation.findPermutations(src, 0, n); 
	        System.out.println("Total permutation = " + calculate);
	        
	        int[] count =  new int[max+1];
			for (int i:count) {
				i= 0;
			}
			major.forEach(e->{
				System.out.print(e+ " ");
				count[e] = count[e]+1;
			});
			System.out.println();
			System.out.println("Major occurence");
			for (int i=0;i<max+1;i++) {
				System.out.println(i+ " "+count[i]);
			}
			
			System.out.println();
			System.out.println("Inverse occurence");
			int[] count2 =  new int[max2+1];
			for (int i:count2) {
				i= 0;
			}
			inverse.forEach(e->{
				System.out.print(e+ " ");
				count2[e] = count2[e]+1;
			});
			System.out.println();
			for (int i=0;i<max2+1;i++) {
				System.out.println(i+ " "+count2[i]);
			}
			
			int[] count3 =  new int[max3+1];
			for (int i:count3) {
				i= 0;
			}
			System.out.println();
			mak.forEach(e->{
				System.out.print(e+ " ");
				count3[e] = count3[e]+1;
			});
			System.out.println();
			System.out.println("Mak occurence");
			for (int i=0;i<max3+1;i++) {
				System.out.println(i+ " "+count3[i]);
			}
			
			int[] count4 =  new int[max4+1];
			for (int i:count4) {
				i= 0;
			}
			System.out.println();
			mad.forEach(e->{
				System.out.print(e+ " ");
				count4[e] = count4[e]+1;
			});
			System.out.println();
			System.out.println("Mad occurence");
			for (int i=0;i<max4+1;i++) {
				System.out.println(i+ " "+count4[i]);
			}
	        
	    } 
	    public void addMajor(String src) {
			int Major = 0;
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
					}
				}
			}
			
			for (int i=0;i<leng-2;i++) {
				for (int j=i+1;j<leng-1;j++) {
					if ((inte[i] > inte[j+1])&&(inte[j]>inte[i])) {
						Major +=1;
					}
				}
			}
			
			for (int i=0;i<leng-2;i++) {
				for (int j=i+1;j<leng-1;j++) {
					if ((inte[i] > inte[j])&&(inte[j]>inte[j+1])) {
						Major +=1;
					}
				}
			}
			
			for (int j=0;j<leng-1;j++) {
				if (inte[j] > inte[j+1]){
					Major +=1;
				}
			}
			
			if (Major >= max) {
				max = Major;
			}
			major.add(Major);
		}
		

		public void addInverse(String src) {
			int Inverse = 0;
			char[] convert = src.toCharArray();
			int leng = convert.length;
			int[] inte = new int[leng];
			for (int i=0;i<leng;i++) {
				inte[i] = Character.getNumericValue(convert[i]);
			}
			for (int i=0;i<leng-1;i++) {
				for (int j=i+1;j<leng;j++) {
					if (inte[i]> inte[j]) {
						Inverse++;
					}
				}
			}
			if (Inverse >= max2) {
				max2 = Inverse;
			}
			inverse.add(Inverse);
		}
		
		public void addMak(String src) {
			int Mak = 0;
			char[] convert = src.toCharArray();
			int leng = convert.length;
			int[] inte = new int[leng];
			for (int i=0;i<leng;i++) {
				inte[i] = Character.getNumericValue(convert[i]);
			}
			for (int i=0;i<leng-2;i++) {
				for (int j=i+1;j<leng-1;j++) {
					if ((inte[i]< inte[j])&&(inte[i]>inte[j+1])) {
						Mak +=1;
					}
				}
			}
			
			for (int i=0;i<leng-2;i++) {
				for (int j=i+2;j<leng;j++) {
					if ((inte[i] > inte[i+1])&&(inte[i+1]>inte[j])) {
						Mak +=1;
					}
				}
			}
			
			for (int i=0;i<leng-2;i++) {
				for (int j=i+1;j<leng-1;j++) {
					if ((inte[i] < inte[j+1])&&(inte[j]>inte[j+1])) {
						Mak +=1;
					}
				}
			}
			
			for (int j=0;j<leng-1;j++) {
				if (inte[j] > inte[j+1]){
					Mak +=1;
				}
			}
			
			if (Mak >= max3) {
				max3 = Mak;
			}
			mak.add(Mak);
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
				for (int j=i+2;j<leng;j++) {
					if ((inte[i] > inte[j])&&(inte[i+1]<inte[j])) {
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
