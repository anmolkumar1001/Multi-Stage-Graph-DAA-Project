// Mutli-Stage graph using Forward Approach.

import java.util.Scanner;
public class MultiStageGraph1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.println("\n---Multi-Stage Graph For Forward Approach---\n");
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
        // Forward Approach
        for (i = n; i >= 1; i--) {
            c = 0;
            for (j = 1; j <= n; j++) {
                if (cost[i][j] != 0 && cost[i][j] != 9999) {
                    if (c == 0) {
                        s[i] = s[j] + cost[i][j];
                        p[i] = j;
                        c = 1;
                    } else {
                        temp[i] = s[j] + cost[i][j];
                        if (temp[i] < s[i]) {
                            s[i] = s[j] + cost[i][j];
                            p[i] = j;
                        }
                    }
                }
            }
        }

        // Details For Source, Cost and Parent.
        System.out.println("\nSource  Cost  Parent");
        for (i = n; i >= 1; i--) {
            System.out.print("\n  " + i);
            System.out.print(" \t   " + s[i]);
            System.out.print(" \t   " + p[i]);
        }
        System.out.println();

        // For Finding Optimal Path.
        System.out.println("\n\nOptimal Path:\n\t");
        i = p[1];
        System.out.print("1-->" + i);
        while (i != n) {
            i = p[i];
            System.out.print("-->" + i);
        }
		
		sc.close();

	}

}
