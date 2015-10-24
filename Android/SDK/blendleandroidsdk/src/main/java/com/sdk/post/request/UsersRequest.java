package com.sdk.post.request;

public class UsersRequest {
    final String email;
    final String first_name;
    final String last_name;
    final String password;
    final boolean nrc_email_share;
    final String country;

    public UsersRequest(String email, String firstName, String lastName, String password, String locale) {
        this.email = email;
        this.first_name = firstName;
        this.last_name = lastName;
        this.password = password;
        this.nrc_email_share = false;
        this.country = locale;
    }
}
