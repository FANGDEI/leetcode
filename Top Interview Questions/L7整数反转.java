import java.math.BigInteger;

class L7整数反转 {
    public int reverse(int x) {
        String s = String.valueOf(x);
        String ans = "";
        if (x < 0) {
            ans+='-';
            for (int i = s.length() - 1; i > 0; i--) {
                if (i==s.length()-1&&s.charAt(i) == '0') {
                    continue;
                    }
                ans += s.charAt(i);

            }
        } else if (x == 0) {
            return 0;
        } else {
            for (int i = s.length() - 1; i >= 0; i--) {
                if (i==s.length()-1&&s.charAt(i) == '0') {
                    continue;
                }
                ans += s.charAt(i);
            }
        }
        String hp="";
        if(ans.length()>11&&ans.charAt(0)=='-'){
            return 0;
        }
        if(ans.length()>10&&ans.charAt(0)!='-'){
            return 0;
        }
        int p=10-ans.length();
        if(ans.charAt(0)=='-'){
            p=11-ans.length();
        }
        while(p>0){
            hp+=0;
            p--;
        }
        if(ans.charAt(0)=='-'){
            hp+=ans.substring(1);
        }else{
            hp+=ans;
        }
        String max="2147483647";
        System.out.println(max+" "+hp);
        for(int i=0;i<10;i++){

            if(max.charAt(i)<hp.charAt(i)){

                return  0;
            }else if(max.charAt(i)>hp.charAt(i)){
                break;
            }
        }

        return  Integer.parseInt(ans);
    }
}