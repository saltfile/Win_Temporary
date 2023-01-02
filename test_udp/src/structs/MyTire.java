package structs;


import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class TireNode{
    //分支
    public TireNode[] slot = new TireNode[26];

    //本节点的值
    public char cal;

    //单词：数量 > 0 表示一个单词
    public boolean isWord;
    //前驱
    public int prefix;
    //单词：具体的一个单词字符串
    public String word;
    // 解释：单词的注释说明
    public String explain;
}

class Tire_Tree{
    public static TireNode arr = new TireNode();


    public void insert(String word,String explain){
        TireNode p = arr;

        for (int i = 0;i < word.length();i++){
            int sub = word.charAt(i) - 'a';

            if (p.slot[sub] == null){
                p.slot[sub] = new TireNode();
            }
            p = p.slot[sub];
            p.cal = word.charAt(i);
            p.prefix++;
        }
        p.explain = explain;
        p.isWord = true;
    }


    public String ExactFind(String word){
        TireNode p = arr;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            int sub = word.charAt(i)-'a';

            if (sub > p.slot.length||p.slot[sub] == null )
                return "查无此单词";

            builder.append(word.charAt(i));
            p = p.slot[sub];
        }


        if(p.isWord)
            return p.explain;
        else
            return "这个单词不全";
    }

    public List<String> FuzzySearch(String word){
        TireNode p = arr;

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            int sub = word.charAt(i)-'a';

            if (sub > p.slot.length||p.slot[sub] == null )
                return Collections.emptyList();

            builder.append(word.charAt(i));
            p = p.slot[sub];
        }


        ArrayList<String> res = new ArrayList<>();
        if (p.prefix != 0) {
            for (int i = 0; i < p.slot.length; i++) {
                if (p.slot[i] != null) {
                    char c = (char) (i + 'a');
                    ergodic(p,String.valueOf(builder)+c,res);
                }
            }
        }
        return res;

    }


    private void ergodic(TireNode p,String word,List<String> list){
        if (p.isWord){
            p.word = word;
            list.add(word+"->"+p.explain);
        }else {
            if (p.prefix == 0)return;
        }

        for (int i = 0; i < p.slot.length; i++) {
            char c = (char) ('a' + i);
            if (p.slot[i] != null) {
                ergodic(p.slot[i], word + c, list);
            }
        }
    }





    public List<String> FuzzySearch(String word,int limit){
        TireNode p = arr;

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            int sub = word.charAt(i)-'a';

            if (sub > p.slot.length||p.slot[sub] == null )
                return Collections.emptyList();

            builder.append(word.charAt(i));
            p = p.slot[sub];
        }


        ArrayList<String> res = new ArrayList<>();
        if (p.prefix != 0) {

            for (int i = 0; i < p.slot.length; i++) {
                if (p.slot[i] != null) {
                    char c = (char) (i + 'a');

                    ergodic(p,String.valueOf(builder)+c,res,limit);

                    if (res.size() == limit)return res;

                    int sum = res.size()-limit;

                    if (sum > 0){
                        for (int j = sum-1; j >= 0; j--) {
                            res.remove(limit+j);
                        }
                        return res;
                    }
                }
            }
        }
        return res;
    }


    private void ergodic(TireNode p,String word,List<String> list,int limit){
        if (p.isWord){
            p.word = word;
            list.add(word+"->"+p.explain);
            if (list.size() >= limit)return;
        }

        for (int i = 0; i < p.slot.length; i++) {
            char c = (char) ('a' + i);
            if (p.slot[i] != null) {
                ergodic(p.slot[i], word + c, list);
            }
        }
    }












}





public class MyTire {


    public static void main(String[] args) {
        Tire_Tree trie = new Tire_Tree();
        trie.insert("bat","大厂");
        trie.insert("batch", "批量");
        trie.insert("bitch", "彪子");
        trie.insert("battle", "战斗");
        System.out.println(trie.ExactFind("bsdas"));
        System.out.println(trie.ExactFind("batch"));
        System.out.println(trie.ExactFind("batc"));


        System.out.println(trie.FuzzySearch("ba"));
        System.out.println(trie.FuzzySearch("ba",2));




    }


}
