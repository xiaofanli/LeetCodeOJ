package nju.ics.lixiaofan.algorithm;
/*
There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?
 */
public class Candy {
    public static int candy(int[] ratings) {
    	if(ratings.length == 0)
    		return 0;
        int candy = 1, prev = 1, desc = 0, peak = 1;
        for(int i = 1;i < ratings.length;i++){
        	if(ratings[i] > ratings[i-1]){
        		candy += ++prev;
        		desc = 0;
        		peak = prev;
        	}
        	else if(ratings[i] < ratings[i-1]){
        		desc++;
        		prev = 1;
        		candy += desc;
        		if(desc >= peak){
        			peak++;
        			candy++;
        		}
        	}
        	else{
        		candy += 1;
        		desc = 0;
        		peak = prev = 1;
        	}
//        	System.out.println(i + "\t" + candy);
        }
       return candy;
    }
}
