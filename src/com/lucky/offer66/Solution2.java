package com.lucky.offer66;
/**
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.
 * 则经过替换之后的字符串为We%20Are%20Happy。
 * @author Allen
 *
 */
public class Solution2 {
	public String replaceSpace(StringBuffer str) {
		StringBuffer s = new StringBuffer();
		char [] c =str.toString().toCharArray();
		int index=0;
        while(index<c.length){
            if(c[index]==' '){
            	s.append("%20");
            	index++;
            }else{
            	s.append(c[index]);
            	index++;
            }
        }
        return s.toString();
    }
}
