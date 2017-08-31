package com.beosbank.jbdevg.jbdatagrid;

import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

public class StreamsDemo {

	public static void main(String[] args) {

		List<Integer> datas= Lists.newArrayList(1,2,3,4,5);
		//Limit
		datas.stream().limit(3).forEach(System.out::println);
		System.out.println("StreamsDemo.main()");
		//Map
		datas.stream().map(i->i*2).forEach(System.out::println);;
		System.out.println("StreamsDemo.main()");

		//filter
	   List<Integer> datas2 = datas.stream().filter(i->i%2==0).collect(Collectors.toList());
	   System.out.println(datas2);
	   
		System.out.println("StreamsDemo.main()");

	Double average =  datas.stream().filter(i->i%2==0).collect(Collectors.averagingDouble(i->i));
	System.out.println(average);
	}
	
	
}
