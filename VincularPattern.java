package simulation;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class VincularPattern {
	static List<Integer> major = new ArrayList<Integer>();
	static List<Integer> inverse = new ArrayList<Integer>();
	static List<Integer> mak = new ArrayList<Integer>();
	static List<Integer> mad = new ArrayList<Integer>();
	static int max =0;
	static int max2 =0;
	static int max3 =0;
	static int max4 =0;
	public static void main(String[] args) 
	{ 
		String str = JOptionPane.showInputDialog("Input word");
		int n = str.length(); 
		VincularPattern vincularPattern = new VincularPattern(); 
		vincularPattern.permute(str, 0, n - 1); 
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

	/** 
	* permutation function 
	* @param str string to calculate permutation for 
	* @param l starting index 
	* @param r end index 
	*/
	private void permute(String str, int l, int r) 
	{ 
		if (l == r) {
			//Get a permutation which is str
			System.out.println(str);
			addMajor(str);
			addInverse(str);
			addMad(str);
			addMak(str);
		}
		else { 
			for (int i = l; i <= r; i++) { 
				str = swap(str, l, i); 
				permute(str, l + 1, r); 
				str = swap(str, l, i); 
			} 
		} 
	} 

	/** 
	* Swap Characters at position 
	* @param a string value 
	* @param i position 1 
	* @param j position 2 
	* @return swapped string 
	*/
	public String swap(String a, int i, int j) 
	{ 
		char temp; 
		char[] charArray = a.toCharArray(); 
		temp = charArray[i]; 
		charArray[i] = charArray[j]; 
		charArray[j] = temp; 
		return String.valueOf(charArray); 
	} 
	
	public int calculateVincular(String src, int a,int b,int c, int[] adjacent) {
		
		return 0;
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
			for (int j=i+2;j<leng;j++) {
				if ((inte[i] > inte[j])&&(inte[j]>inte[i+1])) {
					Mak +=1;
				}
			}
		}  // 31-2
		
		for (int i=0;i<leng-2;i++) {
			for (int j=i+2;j<leng;j++) {
				if ((inte[i] > inte[i+1])&&(inte[i+1]>inte[j])) {
					Mak +=1;
				}
			}
		} // 32-1
		
		for (int i=0;i<leng-2;i++) {
			for (int j=i+1;j<leng-1;j++) {
				if ((inte[i] < inte[j+1])&&(inte[j]>inte[j+1])) {
					Mak +=1;
				}
			}
		} //1-32
		
		for (int j=0;j<leng-1;j++) {
			if (inte[j] > inte[j+1]){
				Mak +=1;
			}
		} //21
		
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
