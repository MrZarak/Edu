import linked.MyBestOneLinkedList;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        ArrayList<String> arrayList = new ArrayList<>();
        {
            arrayList.add("b");
            arrayList.remove(0);
            arrayList.add("c");
            arrayList.add("a");
            arrayList.add("b");
            arrayList.add("c");
            arrayList.add("d");
            arrayList.add("e");
            arrayList.add("f");
            arrayList.clear();
            arrayList.add("c");
            arrayList.add("a");
            arrayList.add("b");
            arrayList.add("c");
            arrayList.add("d");
            arrayList.add("e");
            arrayList.add("f");
            arrayList.add("g");
            arrayList.remove(5);
            arrayList.add("d");
            arrayList.add("d");
            arrayList.add("d");
            arrayList.add("d");
            arrayList.remove("e");
            arrayList.add("e");
            arrayList.add(0, "e");
            arrayList.add(0, "e");
            arrayList.add(0, "e");
            arrayList.remove(0);
            for (String s : arrayList) {
                System.out.print(s);
            }
            System.out.println(Arrays.toString(arrayList.toArray(new String[0])));
        }

        MyBestOneLinkedList<String> bestOneLinkedList = new MyBestOneLinkedList<>();
        {
            bestOneLinkedList.add("b");
            bestOneLinkedList.remove(0);
            bestOneLinkedList.add("c");
            bestOneLinkedList.add("a");
            bestOneLinkedList.add("b");
            bestOneLinkedList.add("c");
            bestOneLinkedList.add("d");
            bestOneLinkedList.add("e");
            bestOneLinkedList.add("f");
            bestOneLinkedList.clear();
            bestOneLinkedList.add("c");
            bestOneLinkedList.add("a");
            bestOneLinkedList.add("b");
            bestOneLinkedList.add("c");
            bestOneLinkedList.add("d");
            bestOneLinkedList.add("e");
            bestOneLinkedList.add("f");
            bestOneLinkedList.add("g");
            bestOneLinkedList.remove(5);
            bestOneLinkedList.add("d");
            bestOneLinkedList.add("d");
            bestOneLinkedList.add("d");
            bestOneLinkedList.add("d");
            bestOneLinkedList.remove("e");
            bestOneLinkedList.add("e");
            bestOneLinkedList.add(0, "e");
            bestOneLinkedList.add(0, "e");
            bestOneLinkedList.add(0, "e");
            bestOneLinkedList.remove(0);
            for (String s : bestOneLinkedList) {
                System.out.print(s);
            }
            System.out.println(Arrays.toString(bestOneLinkedList.toArray(new String[0])));
        }

        MyBestArrayList<String> bestArrayList = new MyBestArrayList<>();
        {
            bestArrayList.add("b");
            bestArrayList.remove(0);
            bestArrayList.add("c");
            bestArrayList.add("a");
            bestArrayList.add("b");
            bestArrayList.add("c");
            bestArrayList.add("d");
            bestArrayList.add("e");
            bestArrayList.add("f");
            bestArrayList.clear();
            bestArrayList.add("c");
            bestArrayList.add("a");
            bestArrayList.add("b");
            bestArrayList.add("c");
            bestArrayList.add("d");
            bestArrayList.add("e");
            bestArrayList.add("f");
            bestArrayList.add("g");
            bestArrayList.remove(5);
            bestArrayList.add("d");
            bestArrayList.add("d");
            bestArrayList.add("d");
            bestArrayList.add("d");
            bestArrayList.remove("e");
            bestArrayList.add("e");
            bestArrayList.add(0, "e");
            bestArrayList.add(0, "e");
            bestArrayList.add(0, "e");
            bestArrayList.remove(0);
            for (String s : bestArrayList) {
                System.out.print(s);
            }
        }

        System.out.println(Arrays.toString(bestArrayList.toArray(new String[0])));
    }
}
