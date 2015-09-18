package nju.ics.lixiaofan.algorithm;
/*
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.
 */
public class GasStation {
	public static void main(String[] args) {

	}
	
	public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] remain = new int[gas.length];
        int totalAmount = 0;
        for(int i = 0;i < gas.length;i++){
        	remain[i] = gas[i] - cost[i];
        	totalAmount += remain[i];
        }
        if(totalAmount < 0)
        	return -1;

        int index, i = 0;
        boolean aloop = false;
        while(!aloop){
        	if(remain[i] >= 0){
        		index = i;
        		i++;
        		if(i == remain.length){
        			i = 0;
        			aloop = true;
        		}
        		while(remain[index] + remain[i] >= 0){
        			remain[index] += remain[i];
        			remain[i] = 0;
        			i++;
            		if(i == remain.length){
            			i = 0;
            			aloop = true;
            		}
        			if(index == i)
        				return index;
        		}
        	}
        	else{
        		i++;
        		if(i == remain.length){
        			i = 0;
        			aloop = true;
        		}
        	}
        }      
		return -1;
    }
}
