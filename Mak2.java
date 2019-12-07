package simulation;

import javax.swing.JOptionPane;

public class Mak2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int Mak = 0;
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
					Mak +=1;
				}
			}
		} //1-32 ( small entries that is smaller than Pn if Pn is decent bottom )
		
		
		for (int i=0;i<leng-2;i++) {
			for (int j=i+2;j<leng;j++) {
				if ((inte[i] > inte[j])&&(inte[j]>inte[i+1])) {
					Mak +=1;
				}
			}
		} //31-2 ( decent top greater than Pn)
		
		// done 132 and 321 and 312
		for (int i=0;i<leng-2;i++) {
			for (int j=i+2;j<leng;j++) {
				if ((inte[i] > inte[i+1])&&(inte[i+1]>inte[j])) {
					Mak +=1;
				}
			}
		} //32-1 ( decent top greater than Pn)
		
		
		for (int j=0;j<leng-1;j++) {
			if (inte[j] > inte[j+1]){
				Mak +=1;
			}
		} //21 (Pn itself)]
		
		System.out.println(str + " " + Mak);
	}

}
