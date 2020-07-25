package com.corejava;
import java.util.ArrayList;
import java.util.List;
public class Question1 
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		String temp="";
	
		for(int i=0;i<args.length;i++)
		{
			for(int j=1;j<(args.length-i);j++)
			{
				if(args[j-1].length() > args[j].length())
				{
					temp=args[j-1];
					args[j-1]=args[j];
					args[j]=temp;
				}
				
			}
		}
		for(int i=0;i<args.length;i++)
		{
			System.out.println(args[i]);
		}

	}

}
