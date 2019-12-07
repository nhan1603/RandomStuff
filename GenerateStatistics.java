package simulation;

import javax.swing.JOptionPane;


public class GenerateStatistics {
	static int firsttwo =  0;
	static int firstone =  0;
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
		String str = JOptionPane.showInputDialog("Input String");
        System.out.println("Start");
        int n = str.length(); 
        char[] src = str.toCharArray();
        GenerateStatistics testBijection = new GenerateStatistics();
        testBijection.findPermutations(src, 0, n); 
	}
    private void Bijection(String str) {
		// TODO Auto-generated method stub
    	char[] src2 = str.toCharArray();
        int leng = src2.length;
		int[] inte2 = new int[leng];
		for (int i=0;i<leng;i++) {
			inte2[i] = Character.getNumericValue(src2[i]);
		}
		
		

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
		System.out.println("Mak : "+str + " " + Mak);

	}

}
