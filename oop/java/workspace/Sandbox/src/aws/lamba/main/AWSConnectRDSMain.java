package aws.lamba.main;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

/*
 * RDS Console instance: https://us-east-1.console.aws.amazon.com/rds/home?region=us-east-1#databases:
 * PWD for database-1: Givyrz&0427
 * You can setup a Lambda connection once you have you DB setup
 */
public class AWSConnectRDSMain implements RequestHandler<Object, String> {
    @Override
    public String handleRequest(Object input, Context context) {
        return "Hello, world!";
    }
}
