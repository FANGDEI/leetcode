import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P1025反转链表 {
    class node {
        String address;
        int data;
        String next;

        public node(String address, int data, String next) {
            this.address = address;
            this.data = data;
            this.next = next;
        }
    }

    public class Main {
        public void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String[] basis = sc.nextLine().split(" ");
            List<node> list1 = new ArrayList<>();
            List<node> ans = new ArrayList<>();
            List<node> list = new ArrayList<>();
            for (int i = 0; i < Integer.parseInt(basis[1]); i++) {
                String[] s = sc.nextLine().split(" ");
                if (s[0].equals(basis[0])) {
                    list.add(new node(s[0], Integer.parseInt(s[1]), s[2]));
                }
                list1.add(new node(s[0], Integer.parseInt(s[1]), s[2]));

            }
            node hp = list.get(0);
            while (!hp.next.equals("-1")) {
                for (node node : list1) {
                    if (node.address.equals(hp.next) && !node.address.equals("-1")) {
                        list.add(node);
                        hp = node;
                    }
                }
                if (hp.next.equals("-1")) {
                    break;
                }
            }
            basis[1] = String.valueOf(list.size());
            if (Integer.parseInt(basis[2]) == 0) {
                for (node node : list) {
                    System.out.println(node.address + " " + node.data + " " + node.next);
                }
                return;
            }
            int yu = Integer.parseInt(basis[1]) % Integer.parseInt(basis[2]);
            int num = Integer.parseInt(basis[1]) / Integer.parseInt(basis[2]);
            int last = -1;
            for (int i = 0; i < num; i++) {
                for (int j = Integer.parseInt(basis[2]) - 1; j >= 0; j--) {
                    if (last != -1 && j == Integer.parseInt(basis[2]) - 1) {
                        node hph = ans.remove(last);
                        hph.next = list.get(i * Integer.parseInt(basis[2]) + j).address;
//                    System.out.print(hph.next);
                        ans.add(hph);
                    }
                    if (j != 0) {
                        node hph = list.get(i * Integer.parseInt(basis[2]) + j);
                        hph.next = list.get(i * Integer.parseInt(basis[2]) + j - 1).address;
                        ans.add(hph);
                    }
                    if (j == 0) {
                        ans.add(list.get(i * Integer.parseInt(basis[2]) + j));
                        last = ans.size() - 1;
                    }
                }
            }
            if (yu != 0) {
                node hph = ans.remove(last);
                hph.next = list.get(Integer.parseInt(basis[1]) - yu).address;
                ans.add(hph);
            }
            for (int i = Integer.parseInt(basis[1]) - yu; i < Integer.parseInt(basis[1]); i++) {
                ans.add(list.get(i));
            }
            last = ans.size() - 1;
            node hph = ans.remove(last);
            hph.next = "-1";
            ans.add(hph);
            for (node node : ans) {
                System.out.println(node.address + " " + node.data + " " + node.next);
            }
        }
    }

}
