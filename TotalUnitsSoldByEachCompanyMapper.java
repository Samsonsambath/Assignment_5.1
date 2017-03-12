package mapreduce.assignment5.task2;

import java.io.IOException;
import java.util.regex.Pattern;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class TotalUnitsSoldByEachCompanyMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	public void map(LongWritable Key, Text Value, Context context) throws IOException, InterruptedException {
		String[] lineArray = Value.toString().split(Pattern.quote("|"));
		if (!lineArray[0].equals("NA")) {
			Text company_Name = new Text(lineArray[0]);
			IntWritable count = new IntWritable(1);
			context.write(company_Name, count);
		}
	}

}
