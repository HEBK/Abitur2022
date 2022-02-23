package de.cr4zyfl1x.abiprep.crypto;

public class RSA {

    public void calculateKeys(int p, int q)
    {
        // Phi(N)
        int phiN = (p-1) * (q-1);

        // n
        int n = p * q;

        // e
        int e = 2;
        while (ggT(e, phiN) != 1) {
            e++;
        }

        // d
        int d = euklidAlgorithm(e, phiN)[1];
        d = (d < 0) ? phiN + d : d;

        // Ausgabe
        System.out.println("Private Key: (e = "+ e +", n = " + n +")");
        System.out.println("Public Key:  (d = "+ d +", n = " + n +")");
    }

    public int[] euklidAlgorithm(int e, int phiN)
    {
        if (phiN == 0) return new int[]{e, 1, 0};

        int[] values = euklidAlgorithm(phiN, e % phiN);
        int d = values[0];
        int t = values[2];
        int s = values[1] - (e / phiN) * values[2];
        return new int[]{d, t, s};
    }

    public int ggT(int a, int b)
    {
        while (b !=0) {
            if (a >b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        return a;
    }

    public long sqm(long base, long exp)
    {
        // Basis^0 -> 1
        if (exp == 0) return 1;

        // Basis^1 -> Basis
        if (exp == 1) return base;


        if (exp % 2 != 0) {
            return base * sqm(base * base, (exp-1)/2);
        }

        // Bases ^2 -> Exponent /2 (Nur bei geraden Exponenten!)
        else {
            return sqm(base * base, exp / 2);
        }
    }

    public long encrypt(long message, long n, long e)
    {
        // C = m^e mod n
        return sqm(message, e) % n;
    }

    public long decrypt(long encrypted, long n, long d)
    {
        return sqm(encrypted, d) % n;
    }
}
