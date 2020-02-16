package simulation_of_first_presentation;

import java.util.Scanner;

import javax.swing.JOptionPane;


public class NhanHamilton {
	public int mindistance = 1000;
	public int minroad[];
	public int totaldistance;
	public int subop[] = new int[1000];
	public int optimall[] = new int[1000];
	public int x[];
	public int index ;
	public boolean free[];
	public static double times[];
	public int hamil[];
	public int prior[];
	public int trace[] = new int [1000];
	public static int n;
	public static int pri;
	public static int[][] graph;
	
	public void PrintResult()
    {
        System.out.print("\nPath : ");
        int V = hamil.length;
        int vv = prior.length;
        int distance = 0;
        for (int i = 0; i < vv; i++) {
        	System.out.print(prior[i] +" ");
        }
        for (int i = 1; i < V; i++) {
        	 System.out.print(hamil[i] +" ");
        }
        
        for (int i = 1; i < V; i++) {
        	distance = distance + graph[hamil[i-1]][hamil[i]];
       }
        for (int i = 1; i < vv; i++) {
        	distance = distance + graph[prior[i-1]][prior[i]];
       }
        System.out.print("Distance = "+ distance);
        System.out.println();
    } 
	public void setup() {
		free = new boolean[n];
		prior = new int[times.length];
		hamil = new int[n - pri +2];
		x = new int[n+1];
        for (int i=0;i<n;i++) {
        	free[i] = true;
        }
        prior[0] = 0;
        free[0] = false;
        x[0] = 0;
	}
	public void setup2() {
		minroad = new int[n+1];
		free = new boolean[n];
		x = new int[n+1];
        for (int i=0;i<n;i++) {
        	free[i] = true;
        }
        free[0] = false;
        x[0] = 0;
	}
	
	public int timenow() {
		int vv = prior.length;
		int kk =0;
		for (int i=0;i<vv;i++) {
			if  (free[i] == false) {
				kk++;
			}
		}
		int time1 =0;
		if (kk == 1) {
			return 0;
		}
		if (kk == 2) {
			return graph[prior[0]][prior[1]];
		}
		else if (kk > 2) {
			for (int i=0;i<kk-1;i++) {
				if  (free[i] == false) {
					time1 = time1 + graph[prior[i]][prior[i+1]];
				}
			}
		}
		return time1;
	}
	public void attempt3(int i) {
		int j;
		for (j=0;j<n;j++) {
			if ((free[j]) && (graph[x[i-1]][j]>0)) {
				x[i] = j;
				if (i<n-1) {
					free[j] = false;
					attempt3(i+1);
					free[j] = true;
				}
				else if (i==n-1) {
					if (graph[j][x[0]] > 0) {
						System.out.print("\nPath : ");
				        int V = x.length;
				        int distance = 0;
				        for (int ii = 0; ii < V; ii++) {
				        	 System.out.print(x[ii] +" ");
				        }
				        for (int ii = 1; ii < V; ii++) {
				        	distance = distance + graph[x[ii]][x[ii-1]];
				       }
				        System.out.print("Distance = "+ distance);
				        if (distance < mindistance) {
				        	mindistance = distance;
				        	for (int ii = 0; ii < V; ii++) {
					        	 minroad[ii] = x[ii];
					        }
				        }
				        
				        System.out.println();
				        for (int ii=0;ii<1000;ii++) {
				        	optimall[ii] = 0;
				        	subop[ii] =0;
				        }
				        index =1;
				        subop[0] =0;
				        for (int ii = 1; ii < V; ii++) {
				        	optimization(x[ii-1],x[ii]);
				        }
				        if (totaldistance < distance) {
				        	System.out.print("Optimization : ");
					        for (int ii=0;ii<index;ii++) {
					        	System.out.print(" " + subop[ii] );
					        }
					        System.out.println(" Distance = " + totaldistance);
				        } else {
				        	System.out.println("Already the shortest possible path of this path");
				        }
				        
					}
				}
			}
		}
	}
	public void attempt(int i) {
		//Using Halminton
		int j;
		boolean check = false;
		for (j=pri-1;j<n;j++) {
			if ((free[j]) && (graph[hamil[i-1]][j]>0)) {
				check = true;
				hamil[i] = j;
				if (i<n-pri) {
					free[j] = false;
					attempt(i+1);
					free[j] = true;
				}
				else if (i==n-pri) {
					if (graph[j][hamil[0]] > 0) {
						System.out.print("\nPath : ");
						int V = hamil.length;
				        int vv = prior.length;
				        totaldistance = 0;
				        
				        int distance = 0;
				        for (int ii = 0; ii < vv; ii++) {
				        	System.out.print(prior[ii] +" ");
				        }
				        for (int ii = 1; ii < V; ii++) {
				        	 System.out.print(hamil[ii] +" ");
				        }
				        
				        for (int ii = 1; ii < V; ii++) {
				        	distance = distance + graph[hamil[ii-1]][hamil[ii]];
				       }
				        for (int ii = 1; ii < vv; ii++) {
				        	distance = distance + graph[prior[ii-1]][prior[ii]];
				       }
				        System.out.print("Distance = "+ distance);
				        System.out.println();
				        
				        for (int ii=0;ii<1000;ii++) {
				        	optimall[ii] = 0;
				        	subop[ii] =0;
				        }
				        index =1;
				        subop[0] =0;
				        for (int ii = 1; ii < vv; ii++) {
				        	optimization(prior[ii-1],prior[ii]);
				        }
				        for (int ii = 1; ii < V; ii++) {
				        	optimization(hamil[ii-1],hamil[ii]);
				        }
				        /*for (int ii =0;ii<index;ii++) {
				        	optimall[ii] = subop[index -ii-1];
				        }*/
				        if (totaldistance < distance) {
				        	System.out.print("Optimization : ");
					        for (int ii=0;ii<index;ii++) {
					        	System.out.print(" " + subop[ii] );
					        }
					        System.out.println(" Distance = " + totaldistance);
				        } else {
				        	System.out.println("Already the shortest possible path of this path");
				        }
					}
				}
			}
		}
		if (!check ) {
			System.out.print("\nPath : ");
			int V = hamil.length;
	        int vv = prior.length;
	        totaldistance = 0;
	        
	        int distance = 0;
	        for (int ii = 0; ii < vv; ii++) {
	        	System.out.print(prior[ii] +" ");
	        }
	        for (int ii = 1; ii < V; ii++) {
	        	 System.out.print(hamil[ii] +" ");
	        }
	        
	        for (int ii = 1; ii < V; ii++) {
	        	distance = distance + graph[hamil[ii-1]][hamil[ii]];
	       }
	        for (int ii = 1; ii < vv; ii++) {
	        	distance = distance + graph[prior[ii-1]][prior[ii]];
	       }
	        System.out.print("Distance = "+ distance);
	        System.out.println();
	        
	        for (int ii=0;ii<1000;ii++) {
	        	optimall[ii] = 0;
	        	subop[ii] =0;
	        }
	        index =1;
	        subop[0] =0;
	        for (int ii = 1; ii < vv; ii++) {
	        	optimization(prior[ii-1],prior[ii]);
	        }
	        for (int ii = 1; ii < V; ii++) {
	        	optimization(hamil[ii-1],hamil[ii]);
	        }
	        /*for (int ii =0;ii<index;ii++) {
	        	optimall[ii] = subop[index -ii-1];
	        }*/
	        if (totaldistance < distance) {
	        	System.out.print("Optimization : ");
		        for (int ii=0;ii<index;ii++) {
		        	System.out.print(" " + subop[ii] );
		        }
		        System.out.println(" Distance = " + totaldistance);
	        } else {
	        	System.out.println("Already the shortest possible path of this path");
	        }
		}
	}
	public void attempt2(int i) {
		//Using Halminton
		int j;	
		for (j=0;j<pri;j++) {
			if ((free[j]) && (graph[prior[i-1]][j]>0) && (times[j] >= timenow() + graph[prior[i-1]][j]) ) {
				prior[i] = j;
				if (i<pri-1) {
					free[j] = false;
					attempt2(i+1);
					free[j] = true;
				}
				else if (i==pri-1) {
					hamil[0] = prior[i];
					free[prior[i]] = false;
					attempt(1);
					free[prior[pri-1]] = true;
				}
			}
		}
	}
	public void optimization(int fp, int lp) {
		//Using Ford-Bellman algorithm
		int size = n;
		int length[] = new int[n];
		for (int i=0;i<n;i++) {
			length[i] = 10000;
		}
		length[fp] =0;
		boolean stop;
		int u,v,countloop;
		for ( countloop = 0;countloop < size-1;countloop++) {
			stop = true;
			for (u=0;u< size ; u++) {
				for (v=0;v<size;v++) {
					if ((length[v] > length[u] + graph[u][v]) && (graph[u][v]>0)) {
						length[v] = length[u] + graph[u][v];
						trace[v] = u;
						stop = false;
					}
					/*if (stop) {
						break;
					}*/
				}
			}
		}
		if (length[lp] == 10000) {
			System.out.println("No path");
		}
		else {
			
			//System.out.print("Distance = " + length[lp] + " ");
			int llp = lp;
			int ffp = fp;
			totaldistance = totaldistance + length[lp];
			int tempo[] = new int[n];
			for (int i=0;i<n;i++) {
				tempo[i] =0;
			}
			int k=0;
			while (llp != ffp ) {
				tempo[k] = llp;
				llp = trace[llp];
				k++;
			}
			for (int i=0;i<k;i++) {
					subop[index] = tempo[k-i-1];
					index++;
			}
		}
	}
	public static void main (String[] args) 
    {
		NhanHamilton nhanHamilton = new NhanHamilton();
        Scanner scan = new Scanner(System.in);
        int V;
        int[][] graph1;
        System.out.println("HamiltonianCycle Algorithm Test\n");
        String a = JOptionPane.showInputDialog("Do you need time constrain? Y/N");
        switch (a) {
		case "Y":
			System.out.println("Enter number of vertices\n");
	        V = scan.nextInt();
	        n = V;
	       
	        System.out.println("\nEnter amout of time contrains ( priority list)\n");
	        int hh = scan.nextInt();
	        pri = hh;
	        times = new double[hh];
	        times[0] =100;
	        for (int i=1;i<hh ;i++) {
	        	times[i] = scan.nextDouble();
	        }
	        System.out.println("Enter speed you want");
	        int speed = scan.nextInt();
	        for (int i=1;i<hh ;i++) {
	        	times[i] = times[i]*speed;
	        }
	        System.out.println("\nEnter road matrix\n");
	        graph1 = new int[V][V];
	        graph = new int[V][V];
	        for (int i = 0; i < V; i++)
	            for (int j = 0; j < V; j++)
	                graph1[i][j] = scan.nextInt();
	        graph = graph1;
	        nhanHamilton.setup();
	        nhanHamilton.attempt2(1);
			break;
		case "N":
			System.out.println("Enter number of vertices\n");
	        V = scan.nextInt();
	        n = V;
	        /** get graph **/
	        System.out.println("\nEnter road matrix\n");
	        graph1 = new int[V][V];
	        graph = new int[V][V];
	        for (int i = 0; i < V; i++)
	            for (int j = 0; j < V; j++)
	                graph1[i][j] = scan.nextInt();
	        graph = graph1;
	        nhanHamilton.setup2();
	        nhanHamilton.attempt3(1);
	        nhanHamilton.printmin();
		default:
			break;
		}
        scan.close();
    }
	public void printmin() {
		System.out.print("\nMin Path : ");
        int V = minroad.length;
        for (int ii = 0; ii < V; ii++) {
        	 System.out.print(minroad[ii] +" ");
        }
        System.out.println("Distance = "+ mindistance);
        for (int ii=0;ii<1000;ii++) {
        	optimall[ii] = 0;
        	subop[ii] =0;
        }
        index =1;
        subop[0] =0;
        for (int ii = 1; ii < V; ii++) {
        	optimization(minroad[ii-1],minroad[ii]);
        }
        if (totaldistance < mindistance) {
        	System.out.print("Optimization : ");
	        for (int ii=0;ii<index;ii++) {
	        	System.out.print(" " + subop[ii] );
	        }
	        System.out.println(" Distance = " + totaldistance);
        } else {
        	System.out.println("Already the shortest possible path of this path");
        }
        System.out.println();
	}
}
