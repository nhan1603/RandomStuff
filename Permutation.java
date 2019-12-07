package simulation;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.sun.jndi.url.iiopname.iiopnameURLContextFactory;


//Java program to print all permutations of a 
//given string. 
public class Permutation { 
	static List<Integer> major = new ArrayList<Integer>();
	static List<Integer> inverse = new ArrayList<Integer>();
	static int max =0;
	static int max2 =0;
	public static void main(String[] args) 
	{ 
		String str = JOptionPane.showInputDialog("Input word");
		int n = str.length(); 
		Permutation permutation = new Permutation(); 
		permutation.permute(str, 0, n - 1); 
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
	
	public void addMajor(String src) {
		int Major = 0;
		char[] convert = src.toCharArray();
		int leng = convert.length;
		int[] inte = new int[leng];
		for (int i=0;i<leng;i++) {
			inte[i] = Character.getNumericValue(convert[i]);
		}
		for (int i=0;i<leng-1;i++) {
			if (inte[i] > inte[i+1]) {
				Major = Major + i + 1 ;
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
} 

