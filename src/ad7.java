public class ad7 {
    public static void main(String[] args)
    {
        int[] in = new int[]{3,5,6,14,18,19};
        int[] indac = new int[]{9,2,12,3,7,1};
        //System.out.printf("Inversionen: " + merge(in,0,2,5));
        System.out.printf("Inversions: " + dac(indac));
        return;
    }

    static int dac(int[] a)
    {
        return dac(a,0,a.length-1);
    }
    static int dac(int[] a, int i, int j)
    {
        if(j-i>1)
        {
            int im = dac(a, i, (i + j) / 2) + dac(a, (i + j) / 2 + 1, j);
            return im + merge(a, i, (i + j) / 2, j);
        }
        else
            return  merge(a,i,(i+j)/2,j);
    }
    static int merge(int[] a, int i, int h, int j)
    {
        System.out.println("merge" + i + ", " + h + ", " + j );
        int inversions=0;
        int i1=i, i2=h+1;
        int tmp[] = new int[j-i+1];
        int index=0;
        while(i1<=h && i2<=j)//tatsächliches mergen bis einer der Abschnitte leer ist
        {
            if(a[i1]<a[i2])
            {
                tmp[index] = a[i1];
                i1++;
            }
            else
            {
                tmp[index]=a[i2];
                i2++;
                inversions+=h-i1+1;
            }
            index++;
        }
        while(i1<=h)
        {
            tmp[index] = a[i1];
            i1++;
            index++;
            //inversions +=j-h-1;
        }
        while(i2<=j)
        {
            tmp[index] = a[i2];
            i2++;
            index++;
        }
        for(int ind=0;ind<=j-i;ind++)
            a[i+ind]=tmp[ind];
        return  inversions;
    }
}
