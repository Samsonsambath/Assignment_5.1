package mapreduce.assignment5.task1;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class TotalUnitsSoldByEachCompanyPartitioner extends Partitioner<Text, IntWritable> {

	private static final String AF = "ABCDEF";
	private static final String GL = "GHIJKL";
	private static final String MR = "MNOPQR";
	
	@Override
	public int getPartition(Text key, IntWritable value, int arg2) {
	
		String k = key.toString().toUpperCase().substring(0, 1);
		if ( AF.contains(k) ) 
		{		
				return 0;
		}
		else if ( GL.contains(k))
		{
			return 1;
		}
		else if ( MR.contains(k))
		{
				return 2;
		}
		else
		{
			return 3;
		}
	
	}

}
