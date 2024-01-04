package RunnerPackage;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Listener implements IRetryAnalyzer{

	
	private static final int MAX_retrycount =  10;
	private int retrycount = 0;
	@Override
	public boolean retry(ITestResult result) {
		
		if(retrycount < MAX_retrycount) {
			
			retrycount ++;
			
			System.out.println(result.getName());
			
		}
		return false;
	}

}
