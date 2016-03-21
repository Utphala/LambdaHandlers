package edu.uta.cse.lambda;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.model.ListTablesResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import edu.uta.cse.lambda.requests.RequestLogin;
import edu.uta.cse.lambda.response.LoginResponse;

public class LoginHandler  implements RequestHandler<RequestLogin, LoginResponse> {
    private static final String ACCESS_KEY = "<ReadFromRunTime>";
    private static final String SECRET_KEY = "<ReadFromRunTime>";
    
    @Override
    public LoginResponse handleRequest(RequestLogin userInfo, Context context) {
        if(userInfo == null || context == null) {
            return null;
        }
        AmazonDynamoDBClient client = new AmazonDynamoDBClient(new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY));
        
        //client.getItem(new GetItemRequest().withTableName("users"))
        
        ListTablesResult response = client.listTables();
        response.getTableNames().stream().forEach(e->System.out.println(e));
//        
//        LambdaLogger logger = context.getLogger();
//        
        return null;
    }
    
    public static void main(String[] args) {
        AmazonDynamoDBClient client = new AmazonDynamoDBClient(new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY));
        ListTablesResult response = client.listTables();
        response.getTableNames().stream().forEach(e->System.out.println(e));
    }
}
