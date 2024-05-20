package com.blog.utils;

public class BlogAppConstants {

    /*
        RESPONSE CODES
     */
    public static final Integer CODE_CREATED = 201;
    public static final Integer CODE_SUCCESS = 200;
    public static final  Integer CODE_BAD_REQUEST = 400;
    public static final Integer CODE_UNAUTHORIZED = 401;
    public static final Integer CODE_FORBIDDEN = 403;
    public static final Integer CODE_NOT_FOUND = 404;
    public static final Integer CODE_INTERNAL_SERVER_ERROR = 500;
    public static final Integer CODE_BAD_GATEWAY = 502;

    /*
        RESPONSE STATUS
     */
    public static final String STATUS_CREATED = "created";
    public static final String STATUS_SUCCESS = "success";
    public static final String STATUS_FAILED = "failed";

    /*
        CUSTOM RESPONSE/EXCEPTION  MESSAGES
     */
    public static final String INVALID_REQUEST_BODY = "Invalid Request Body";
    public static final String USER_NOT_FOUND = "User not found";
    public static final String USER_CREATED = "User registered Successfully";
    public static final String USER_UPDATED = "User updated Successfully";
    public static final String USER_FETCHED = "Users fetched Successfully";
    public static final String USER_DELETED = "User deleted Successfully";


    public static final String ROLE_NOT_FOUND = "Role not found";
    public static final String ROLE_CREATED = "Role created Successfully";
    public static final String ROLE_UPDATED = "Role updated Successfully";
    public static final String ROLE_FETCHED = "Roles fetched Successfully";
    public static final String ROLE_DELETED = "Role deleted Successfully";


    public static final String CATEGORY_NOT_FOUND = "Category not found";
    public static final String CATEGORY_CREATED = "Category created Successfully";
    public static final String CATEGORY_UPDATED = "Category updated Successfully";
    public static final String CATEGORY_FETCHED = "Categories fetched Successfully";
    public static final String CATEGORY_DELETED = "Category deleted Successfully";

    /*
            USER ROLES
     */

    public static final String ROLE_ADMIN= "ADMIN";
    public static final String ROLE_READER = "READER";

    public static final String PAGE_NUMBER = "0";
    public static final String PAGE_SIZE= "10";
    public static final String SORT_BY = "postId";
    public static final String SORT_DIR = "asc";
    public static final Integer USER = 1;
    public static final Integer ADMIN = 0;







}
