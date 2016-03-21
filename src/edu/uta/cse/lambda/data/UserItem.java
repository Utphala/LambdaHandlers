package edu.uta.cse.lambda.data;

import lombok.Data;

@Data
public class UserItem {
    private String userid;
    private String passwdHash;
    private OwnerInfo info;
}
