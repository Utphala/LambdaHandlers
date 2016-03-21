package edu.uta.cse.lambda.data;

public enum PermitType {
    FACULTY("Faculty"), 
    STUDENT("Student"), 
    VISITOR("Visitor"),
    DISABLED("Disabled");

    private final String value;
    PermitType(String value) {
        this.value = value;
    }
}
