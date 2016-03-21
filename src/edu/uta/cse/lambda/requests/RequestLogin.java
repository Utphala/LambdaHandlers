package edu.uta.cse.lambda.requests;

import lombok.Data;

@Data
public class RequestLogin {
    private String userid;
    private String password;
}
