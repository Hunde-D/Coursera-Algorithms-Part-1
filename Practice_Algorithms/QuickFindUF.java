package Practice_Algorithms;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickFindUF {

    private int[] id;

    //set id of each object to itself
    public QuickFindUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    //check whether p and q are in the same component
    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    //change all entries with id[p] to id[q]
    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++)
            if (id[i] == pid) id[i] = qid;
        }

    public static void main(String[] args) {
        int size = StdIn.readInt();
        QuickFindUF quickFindUF = new QuickFindUF(size);
        while(!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            StdOut.println(quickFindUF.connected(p,q));
            if(!quickFindUF.connected(p,q)) {
                quickFindUF.union(p,q);
            }
        }
        for (int i = 0; i < size; i++) {
            StdOut.println("Index "+i+":     ID: " + quickFindUF.id[i]);
        }
    }


}
