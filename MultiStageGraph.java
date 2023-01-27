// Mutli-Stage graph using Backward Approach.

import java.util.Scanner;
public class MultiStageGraph {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.println("\n---Multi-Stage Graph For Backward Approach---\n");
		System.out.println("Enter the number of vertex: ");
		int n = sc.nextInt();
		int cost[][] = new int[n+1][n+1];

        // Cost Matrix From the graph.
		System.out.println("Enter the cost matrix: ");
		for(int i=1;i<=n;i++)
			for(int j=1;j<=n;j++)
				cost[i][j] = sc.nextInt();
		sc.close();
		
		int i, j, c;
        int s[] = new int[2*n];
        int p[] = new int[2*n];
        int temp[] = new int[2*n];
        for (i = 0; i < n; i++) {
            s[i] = 0;
            temp[i] = 0;
            p[i] = 0;
        }
        // Backward Approach
        for (j = 1; j <= n; j++) {
            c = 0;
            for (i = 1; i <= n; i++) {
                if (cost[i][j] != 0 && cost[i][j] != 9999) {
                    if (c == 0) {
                        s[j] = s[i] + cost[i][j];
                        p[j] = i;
                        c = 1;
                    } else {
                        temp[j] = s[i] + cost[i][j];
                        if (temp[j] < s[j]) {
                            s[j] = s[i] + cost[i][j];
                            p[j] = i;
                        }
                    }
                }
            }
        }  
        // Deatails for source, node and parent.        
        System.out.println("\nSource  Cost   Parent");
        for (i = 1; i <= n; i++) {
            System.out.print("\n  " + i);
            System.out.print(" \t   " + s[i]);
            System.out.print(" \t   " + p[i]);
        }
        System.out.println();
        // For Find Optimal Path.
        System.out.println("\n\nOptimal Path:\n\t");
        i = p[n];
        System.out.print( n + "-->" + i);
        while (i != 1) {
            i = p[i];
            System.out.print("-->" + i);
        }
		
		sc.close();

	}

}
