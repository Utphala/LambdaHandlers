package edu.uta.cse.lambda.data;

import lombok.Data;

@Data
public class OwnerInfo {
    private String name;
    private String regNum;
    private String email;
    private String phoneNum;
    private String address;
    private PermitType type;
    private Role role;
}
