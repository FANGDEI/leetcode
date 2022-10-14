public class L5最长回文子串 {
    public  String longestPalindrome(String s) {
        String hp="";
        for(int i=0;i<s.length()-1;i++){
            hp+=s.charAt(i);
            hp+='#';
        }
        System.out.println(hp);
        String ans="",res="";
        for(int i=0;i<hp.length();i++){
            res="";
            res+=hp.charAt(i);
            for(int j=0;i+j<hp.length()&&i-j>=0;j++){
                if(hp.charAt(i+j)==hp.charAt(i-j)){
                    res=hp.charAt(i+j)+res+hp.charAt(i+j);
                }else{
                    break;
                }
            }
            String[] sm=res.split("#");
            res="";
            for(int p=0;p<sm.length;p++){
                res+=sm[p];
            }
            System.out.println(res);
            if(res.length()>ans.length()){
                ans=res;
            }
        }
        return ans;
    }
}
