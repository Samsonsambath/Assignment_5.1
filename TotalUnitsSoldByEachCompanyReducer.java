package mapreduce.assignment5.task2;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class TotalUnitsSoldByEachCompanyReducer extends Reducer<Text, IntWritable, Text, IntWritable>
{	
	private IntWritable total = new IntWritable();
	private Integer minValue = Integer.MIN_VALUE;
	
	@Override
	public void reduce(Text key, Iterable<IntWritable> values,Context context) throws IOException, InterruptedException
	{	
		Integer count = 0;
		for ( IntWritable value : values ) 
		{	if(value.get()>minValue){
			count+=value.get();
		}
		}
		total.set(count);
		context.write(key, total);
	}
}
