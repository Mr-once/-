package game.day1;
public class paixu {

    public static void main(String[] args) {
        int[] a = new int[10];

        for (int i = 0; i < 10; i++) {
            // Random random=new Random();
            a[i] = (int) (Math.random() * 100);
            System.out.print(a[i] + ",");
        }
        System.out.println("排序后");
        // a= bubble(a);
        // a=select(a);
//        a = insert(a);
       // a=shell(a,a.length);

        guibing(a,0,a.length-1);
        // fast(a,0,a.length-1);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
    }

    }
//归并排序:先采用递归法,将数组分为单个的数组,这样就可以认为是有序的,然后,将两两数组有序合并起来
    private static void  guibing(int[] a, int i, int i1 ) {
        if (i<i1) {
            int k = (i + i1) / 2;
            guibing(a, i, k);
            guibing(a, k+1 , i1);
            bing(a,i,k,i1);
        }


    }

    private static void bing(int[] a, int i, int k, int i1) {
        int[] p=new int[a.length];
        int low=i;int hight=i1;
        int m=k; int j=k+1;
        int b=0;
        while (low<=m&&j<=hight){
            if (a[low]>=a[j]){
                p[b++]=a[j++];
            }else p[b++]=a[low++];
        }
        while (low<=m){
            p[b++]=a[low++];
        }
        while (j<=hight){
            p[b++]=a[j++];
        }

       for ( low=0;low<b;low++){
           a[i+low]=p[low];
       }

    }
//    快速排序:采用分治法,先选择一个基准数,先i=0,i++从后往前遍历
    //发现比基准数小的数就交换位置,然后j=length-1,j--从前往后遍历,
    // 发现比基准数大的就交换位置,直到i=j;这时,基准数左边的
    //都比他小,右边的都比他大,利用递归,左右两边循环上述步骤,
    //直到每个数组内只剩一个数,就算是排序完成.

    private static void fast(int[] arr, int i, int length) {

        if (i<length) {
           int p= fast_to(arr, i, length);
            fast(arr, i, p-1);
            fast(arr, p + 1, length);
        }

    }

    private static int fast_to(int[] arr, int i, int length) {
       int k=arr[i];
            while (i<length){
                while (i<length&&arr[length]>k){
                    length--;
                }
                int h=arr[length];
                arr[length]=arr[i];
                arr[i]=h;
                while (i<length&&arr[i]<k){
                    i++;
                }
                int m=arr[i];
                arr[i]=arr[length];
                arr[length]=m;
            }

        return i;

    }

    //    插入排序:从1个开始,循环到最后一个,每一轮里面,
    //都假设它前面的数都是排序好了的,它与前面的数进行比较,
// 比他大的数都往后移,最后它插入到比他小的数后.时间复杂度最坏为O[n^2],最好为O[n],平均复杂度为O[n^2]
    private static int[] insert(int[] arr) {
        for (int i=1;i<arr.length;i++) {
            if (arr[i] < arr[i - 1]) {
                int j = i - 1;
                int k = arr[i];
                for (; j >= 0&&k < arr[j]; j--) {

                        arr[j + 1] = arr[j];

                }
                arr[j + 1] = k;
            }
        }
            return arr;
    }
//    希尔排序:插入排序的改版,设置一个增量r=r/3+1,利用增量将数组进行分组,
// 每一组直接进行插入排序,直到r=1时全部再进行一次直接插入排序,这样做是因为
    //直接插入排序在元素基本有序的情况下（接近最好情况），效率是很高的，
// 最好时间复杂度为O[n],最坏为O[n^r](1<r<2),平均复杂度为O[nlogn]
    private static int[] shell(int[] arr, int length) {
        int r=length;
        do {
            r = r / 3 + 1;
            for (int i = r; i < length; i++) {
                if (arr[i] < arr[i - r]) {
                    int j = i - r;
                    int k = arr[i];
                    for (; j >= 0 && k < arr[j]; j = j - r) {
                        arr[j + r] = arr[j];
                    }
                    arr[j + r] = k;
                }
            }
            }while (r>1);
        return arr;
    }
    //选择排序:从0个开始,循环到最后一个,每一轮里面,
// 设定它为最小值,用其他数来跟它比较,若是有比它小的,记下下标,
    //用小的继续比较,最后才进行交换,最坏时间复杂度为O[n^2],最好时间复杂度为O[n^2];平均复杂度为O[n^2]
    private static int[] select(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (min != i) {
                int k = arr[i];
                arr[i] = arr[min];
                arr[min] = k;
            }
        }
        return arr;
    }

    //冒泡排序:从0个开始,循环到最后一个,每一轮里面,
// 数组从后往前,不断比较,小的数往前交换,这样一轮过后,最小的数就在最前面,
// 如果,发现有一趟没有进行过交换,那么就说明已经全部排好序,提前结束循环,排序结束;
    //最坏时间复杂度O[n^2],最好时间复杂度O[n],平均复杂度为O[n^2]
    private static int[] bubble(int[] arr) {
        boolean b = true;
        for (int i = 0; i < arr.length && b; i++) {
            b = false;
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    int k = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = k;
                    b = true;
                }
            }
        }
        return arr;
    }
}