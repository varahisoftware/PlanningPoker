package app

/**
 * class RequestURL holds a list of RequestURI which are allowed as stateless URI and don't need
 */
class RequestURL {

    private RequestURL() {}

    static List statelessURL_List = [
            "/User/LoginForm",
            "/User/Login",
            "/favicon.ico",
            "/error"
    ]
}
