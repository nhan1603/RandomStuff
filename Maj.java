package simulation;

import javax.swing.JOptionPane;

public class Maj {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int Major = 0;
		String str = JOptionPane.showInputDialog("Input String");
        int n = str.length(); 
        char[] src = str.toCharArray();
        int leng = src.length;
		int[] inte = new int[leng];
		for (int i=0;i<leng;i++) {
			inte[i] = Character.getNumericValue(src[i]);
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
	}
}
